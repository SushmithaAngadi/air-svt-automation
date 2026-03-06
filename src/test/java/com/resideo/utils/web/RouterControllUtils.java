package com.resideo.utils.web;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.WebObjectLocators;
import com.resideo.system.utils.CommonUtils;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.web.screens.RouterScreen;

public class RouterControllUtils {

	public static boolean controllBandwidth(TestCases testCase) {
		boolean flag = false;
		flag = launchBrowser(testCase);
		RouterScreen router = new RouterScreen(testCase);
		flag = router.switchframe();
		flag = router.clickOnBandwidthTab();
		flag = router.switchToDefaultFrame();
		flag = router.switchToBodyContent();
		flag = router.clearValueInDownloadBandwidth();
		flag = router.setDownloadBandwidth(SystemState.getStatus().getRandomLowBandwidth());
		flag = router.enable_disableBandwidthCheckBox("Enable");
		flag = router.clickOnSaveButton();
		flag = CommonUtils.waituntilTimeComplete(testCase);
		flag = router.enable_disableBandwidthCheckBox("Disable");
		flag = router.clickOnSaveButton();
		return flag;
	}

	public static void controllRouterOn_Off(TestCases testCase) {
		boolean flag = false;
		RouterScreen router = new RouterScreen(testCase);
		flag = router.clickOnBandwidthTab();
		flag = router.setDownloadBandwidth("1000");
		System.out.println(flag);

	}

//	public static boolean LoginintoRouter(TestCases testCase, String AuthenticationEnable, String password) {
//		boolean flag = false;
//		if (AuthenticationEnable.toUpperCase().contains("NO")) {
//			RouterScreen router = new RouterScreen(testCase);
//			flag = router.isPasswordTBEnable();
//			flag = router.setValueinPasswordTB(password);
//			flag = router.clickOnSubmitBtn();
//			Keyword.ReportStep_Pass(testCase, "Successfully login into the router Settings");
//		} else {
//			flag = false;
//		}
//
//		return flag;
//	}
	public static boolean isYour_ConnectionIsPrivate(TestCases testCase, String url) {
		if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
				"//*[contains(text(),'connection is not private')]")) {

			if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_ID, "details-button")) {
				WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_ID, "details-button");

				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//a[contains(text(),'" + url + "')]")) {
					WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//a[contains(text(),'" + url + "')]");
					return true;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public static boolean LoginintoRouter(TestCases testCase, String userName, String password) throws Exception {
		boolean flag = false;
		RouterScreen router = new RouterScreen(testCase);
		String routerName = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME").toUpperCase();
		if (!isLogedIn(testCase, routerName)) {
			if (router.clickOnLoginBtn(routerName)) {
				if (router.setCommonValueinUserNameTB(userName, routerName)) {
					if (router.setCommonValueinPasswordTB(password, routerName)) {
						if (router.clickOnSubmitBtn(routerName)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfully login into the router Settings");
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to enter the password");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to enter the UserName");
					flag = false;
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to login");
			}
		} else {
			flag = true;
		}
		return flag;
	}

	public static boolean launchBrowser(TestCases testCase) {
		boolean flag = false;

		if (testCase.getMobileDriver() != null) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps Keep Mobile App Move to thread pool</b>");
			CommonUtils.getStatus().setThreadClass(testCase);
			if (testCase.getMobileDriver() != null) {
				com.resideo.utils.web.KeepAppActive threadClass = CommonUtils.getStatus().getThreadClass(testCase);
				CommonUtils.getStatus().setIsMobileThread(true);
				threadClass.start();
				Keyword.ReportStep_Pass(testCase, "<b>Thread Run started for Mobile Side </b>");
			} else {
				Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps </b>");
			}
		}
		try {
			String weburl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			String userName = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "USERNAME");
			String password = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "PASSWORD");
			flag = HHWebUtils.launchBrowser_LocalDriver(testCase, "chrome");
			String iswindowPopupUauthentication = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION,
					"ISWEB_AUTHENTICATION_POPUPHANDLE");
			if (iswindowPopupUauthentication.toUpperCase().equals("TRUE")) {
				flag = flag && WebUtils.navigateToURL(testCase, "http://" + userName + ":" + password + "@" + weburl);
			} else {
				flag = WebUtils.navigateToURL(testCase, weburl);
				flag = flag && RouterControllUtils.LoginintoRouter(testCase, "NO", password);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public static void setRouterModel(TestCases testCase) throws Exception {
		String rootData = testCase.getWebDriver().getPageSource().toUpperCase();
//		String rootTitle = testCase.getWebDriver().getTitle();
		String router_Model = null;
		if (rootData.contains("TP LINK") || rootData.contains("TP-LINK")) {
			if (rootData.contains("AX1500 Wi-Fi 6 Router".toUpperCase())) {
				router_Model = "AX1500";
			} else if (rootData.contains("AX1800 Wi-Fi 6 Router".toUpperCase())) {
				router_Model = "AX1800";
			}

		} else if (rootData.contains("NETGEAR")) {
			if (rootData.contains("")) {

			}

		} else if (rootData.contains("D-LINK")) {
			if (rootData.contains("Model Name: DIR-1750".toUpperCase())) {
				router_Model = "DIR-1750".toUpperCase();
			}

		} else if (rootData.contains("BELKIN")) {

		} else if (rootData.contains("CISCO")) {

		} else if (rootData.contains("INTELINET")) {
			if (rootData.contains("3G Wireless 150N Router".toUpperCase())) {
				router_Model = "3G Wireless 150N Router".toUpperCase();
			}
		} else {
			router_Model = null;
		}
		if (router_Model != null) {
			SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL", router_Model);
		}
	}

	public static boolean isLogedIn(TestCases testCase, String routerName) {
		try {
			switch (routerName) {
			case "BELKIN":
				if (WebUtils.switchBackToDefaultContext(testCase)
						&& WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "topFrame")) {
					FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
					fwait.pollingEvery(Duration.ofSeconds(2));
					fwait.withTimeout(Duration.ofSeconds(60));
					fwait.ignoring(TimeoutException.class);
					fwait.ignoring(StaleElementReferenceException.class);
					Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
						@Override
						public Boolean apply(WebDriver driver) {
							if ((driver.getPageSource()).toUpperCase().contains("400 BAD REQUEST")) {
								System.out.println("400 Bad Request");
								driver.navigate().refresh();
								return false;
							} else {
								return true;
							}
						}
					});
					if (success) {
						if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[text()='Logout']")) {
							return true;
						} else if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
								"//*[text()='Login']")) {
							return false;
						}
					}
				}
			case "AIRLIVE":
				if (WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "main")) {
					if (!WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='PS']")) {
						return true;
					}
				}
				return false;
			case "CENTURYLINK":
				if (!WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[text()='Login']")) {
					return true;
				}
				return false;
			case "DLINK":
				if (!WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@id='logIn_btn']")) {
					return true;
				}
				return false;
			default:
				return false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception occurred due to " + e.getMessage());
			return false;
		}
	}

}