package com.resideo.utils.web;

import java.util.HashMap;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.web.WebObject;
import com.resideo.commons.web.WebUtils;
import org.openqa.selenium.WebElement;

public class HHWebUtils {
	
	public static boolean launchBrowser_LocalDriver(TestCases testCase, String url) {
		try {
			boolean launched = WebUtils.launchBrowser(testCase);
			if (launched) {
				return WebUtils.navigateToURL(testCase, url);
			}
			return false;
		} catch (Exception e) {
			System.out.println("exception occur" + e.getMessage());
			return false;
		}
	}

	/**
	 * Clears a text field identified by name in fieldObjects.
	 * Bridge method replacing removed WebUtils.clearTextField.
	 */
	public static boolean clearTextField(HashMap<String, WebObject> fieldObjects, TestCases testCase, String name) {
		try {
			WebElement elem = WebUtils.getWebElement(testCase, fieldObjects, name);
			if (elem != null) {
				elem.clear();
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
