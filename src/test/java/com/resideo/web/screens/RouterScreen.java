package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class RouterScreen extends WebScreens {

	private static final String screenName = "RouterScreen";

	public RouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean switchframe() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "bottomLeftFrame");
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean switchToBodyContent() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "mainFrame");
	}

	public boolean clearValueInDownloadBandwidth() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DownloadBandWidthTB");
	}

	public boolean clickOnBandwidthTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BandwidthTab");
	}

	public boolean setDownloadBandwidth(String bandwidthSize) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DownloadBandWidthTB", bandwidthSize);
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

	public boolean clickOnSaveButton() {
		return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH, "//input[@name='Save']");
	}

	public boolean clickOnSubmitBtn(String routerName) {
		try {
			switch (routerName) {
			case "BELKIN":
			case "UBEE":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@type='submit']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@type='submit']");
				}
				return false;
			case "CISCO":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "submit-login"))
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "submit-login");
				return false;
			case "TPLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='local-login-button']//*[@class='text button-text']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='local-login-button']//*[@class='text button-text']");
				}
				return false;
			case "AIRLIVE":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "_awa01_2_"))
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "_awa01_2_");
				return false;
			case "CENTURYLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "apply_btn"))
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "apply_btn");
				return false;
			case "DLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "logIn_btn"))
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "logIn_btn");
				return false;
			case "VERIZON":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@class='actiontec_button']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@class='actiontec_button']");
				}
				return false;
			case "WESTERNDIGITAL":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@value='Submit']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@value='Submit']");
				}
				return false;
			case "VIZIO":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@class='SW_BottomButton']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@class='SW_BottomButton']");
				}
				return false;
			default:
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "pcSub")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "pcSub");
				} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='local-login-button']//*[@class='text button-text']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='local-login-button']//*[@class='text button-text']");
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "exception occured due to " + e.getMessage());
			return false;
		}
	}

	public boolean setValueinPasswordTB(String password) {
		return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "pcPassword", password);
	}

	public boolean setCommonValueinPasswordTB(String password, String routerName) {
		try {
			switch (routerName) {
			case "BELKIN":
				if (WebUtils.switchBackToDefaultContext(testCase)) {
					if (WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "mainFrame")) {
						if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@type='password']")) {
							return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
									"//*[@type='password']", password);
						}
					}
				}
				return false;
			case "CISCO":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "adminPass"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "adminPass", password);
				else
					return false;
			case "TPLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='local-login-pwd']//input[@type='password']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='local-login-pwd']//input[@type='password']", password);
				} else {
					return false;
				}
			case "UBEE":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='loginPassword']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@name='loginPassword']", password);
				else
					return false;
			case "AIRLIVE":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='PS']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='PS']",
							password);
				else
					return false;
			case "CENTURYLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@id='admin_password']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='admin_password']", password);
				else
					return false;
			case "DLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='admin_Password']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@name='admin_Password']", password);
				else
					return false;
			case "VERIZON":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='passwd1']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='passwd1']",
							password);
				else
					return false;
			case "WESTERNDIGITAL":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@id='loginpwd']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@id='loginpwd']",
							password);
				else
					return false;
			case "VIZIO":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='www_password']"))
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@name='www_password']", password);
				else
					return false;
			default:
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "pcPassword")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "pcPassword", password);
				} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='local-login-pwd']//input[@type='password']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='local-login-pwd']//input[@type='password']", password);
				} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "adminPass")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "adminPass", password);
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "exception occured due to " + e.getMessage());
			return false;
		}
	}

	public boolean clickOnLoginBtn(String routerName) {
		try {
			switch (routerName) {
			case "BELKIN":
				if (WebUtils.switchBackToDefaultContext(testCase))
					if (WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "topFrame")) {
						if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[text()='Login']")) {
							return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
									"//*[text()='Login']");
						} else {
							return true;
						}
					} else {
						return false;
					}
			case "CENTURYLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[text()='Login']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[text()='Login']");
				} else {
					return false;
				}
			default:
				return true;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "exception occured due to " + e.getMessage());
			return false;
		}
	}

	public boolean setCommonValueinUserNameTB(String userName, String routerName) {
		try {
			switch (routerName) {
			case "UBEE":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='loginUsername']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='loginUsername']",
							userName);
				} else {
					return false;
				}
			case "CENTURYLINK":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='admin_username']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='admin_username']",
							userName);
				} else {
					return false;
				}
				
			case "VERIZON":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='user_name']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='user_name']",
							userName);
				} else {
					return false;
				}
			case "WESTERNDIGITAL":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@id='loginusr']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@id='loginusr']",
							userName);
				} else {
					return false;
				}
			case "VIZIO":
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='www_username']")) {
					return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH, "//*[@name='www_username']",
							userName);
				} else {
					return false;
				}
			default:
				return true;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "exception occured due to " + e.getMessage());
			return false;
		}
	}

}

//public boolean setCommonValueinPasswordTB(String password) {
//if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "pcPassword")) {
//	return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "pcPassword", password);
//} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
//		"//*[@id='local-login-pwd']//input[@type='password']", 2)) {
//	return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_XPATH,
//			"//*[@id='local-login-pwd']//input[@type='password']", password);
//} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "adminPass")) {
//	return WebUtils.setValueOnWebElement(testCase, WebObjectLocators.By_ID, "adminPass", password);
//} else {
//	return false;
//}
//}