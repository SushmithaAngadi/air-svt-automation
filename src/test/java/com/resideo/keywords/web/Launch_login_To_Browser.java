package com.resideo.keywords.web;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebUtils;
import com.resideo.utils.web.HHWebUtils;
import com.resideo.utils.web.RouterControllUtils;
import com.resideo.utils.web.WebController;

import io.cucumber.java.en.Given;

public class Launch_login_To_Browser extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public Launch_login_To_Browser(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		WebController.initWifiRouterSettings();
		return flag;
	}

	@Given(value = "^Launch browser and login to the router$")
	@Override
	@KeywordStep(gherkins = "^Launch browser and login to the router$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				String weburl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
				String userName = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "USERNAME");
				String password = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "PASSWORD");
				flag = HHWebUtils.launchBrowser_LocalDriver(testCase, "chrome");
				String routerName = SuiteConstants
						.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME").toUpperCase();
				String routerModel = SuiteConstants
						.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
				if (routerName.equals("INTELLINET") || routerName.equals("ASUS") || routerName.equals("NETGEAR")
						|| routerName.equals("BUFFALO") || routerName.equals("AMPED")
						|| (routerName.equals("TPLINK") && routerModel.equals("TLWR740N"))
						|| (routerName.equals("CISCO") && routerModel.equals("WRT120N"))
						|| (routerName.equals("HAWKING"))) {
					flag = flag
							&& WebUtils.navigateToURL(testCase, "http://" + userName + ":" + password + "@" + weburl);
				} else {
					if (weburl.contains("http")) {
						flag = WebUtils.navigateToURL(testCase, weburl);
					} else {
						flag = WebUtils.navigateToURL(testCase, "http://" + weburl);
					}
					RouterControllUtils.isYour_ConnectionIsPrivate(testCase, weburl);
					flag = flag && RouterControllUtils.LoginintoRouter(testCase, userName, password);
				}
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}