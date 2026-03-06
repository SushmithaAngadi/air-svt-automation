package com.resideo.utils.resideoPro_app.screen;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

import com.resideo.utils.W3CTouchActions;

public class CustomerInfoScreen extends MobileScreens {

	private static final String screenName = "ReziCustomerScreen";

	public CustomerInfoScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean setCustomerNameinSearchBox(String customerName) {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomerSearchButton")) {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "CustomerSearchButton");
			flag = flag && MobileUtils.setValueToElement(objectDefinition, testCase, "CustomerSearchButton",
					customerName, "Search Customer name in Search box, Custormer mail id is : " + customerName);
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Customer Search Button not visible");
		}

		return flag;
	}

	public boolean clickOnCustomerNameInList(String customerName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'record not found')]", testCase,
					10)) {
				Keyword.ReportStep_Pass(testCase,
						"Customer name not available in Search list. Will try to create a customer profile");
				return false;
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + customerName + "')]",
						testCase, 10)) {
					return MobileUtils.clickOnElement(testCase, "XPATH",
							"//*[contains(@content-desc,'" + customerName + "')]");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find customer mail in list, waited time 10 seconds");
					return false;
				}
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'record not found')]", testCase, 10)) {

				Keyword.ReportStep_Pass(testCase,
						"Customer name not available in Search list. Will try to create a customer profile");
				return false;
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + customerName + "')]", testCase,
						10)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + customerName + "')]");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find customer mail in list, waited time 10 seconds");
					return false;
				}
			}
		}
	}

	public boolean clickOnHomeLocationFromLocationList() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeLocation");
	}

	public boolean clickOnNextButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
	}

	public boolean clickOnDoneButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
	}

	public boolean clickOnAddCustomerButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddCustomerButton");
	}

	public boolean setCustomerEmail(String txt) {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "EmailTextBox", 1)) {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "EmailTextBox")) {
				if (MobileUtils.setValueToElement(objectDefinition, testCase, "EmailTextBox", txt,
						"customer email is " + txt)) {
					flag = hideKeyboard();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to enter email in text box");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on email text box");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, " customer email text box not visible");
		}
		return flag;
	}

	public boolean setCustomerFirstName(String txt) {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FirstNameTextBox", 1)) {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "FirstNameTextBox")) {
				if (MobileUtils.setValueToElement(objectDefinition, testCase, "FirstNameTextBox", txt,
						"customer first name , entered text is " + txt)) {
					flag = hideKeyboard();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to enter first name in text box");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on first name text box");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer first name text box not visible");
		}
		return flag;
	}

	public boolean setCustomerLastName(String txt) {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LastNameTextBox", 1)) {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "LastNameTextBox")) {
				if (MobileUtils.setValueToElement(objectDefinition, testCase, "LastNameTextBox", txt,
						"customer last name is " + txt)) {
					flag = hideKeyboard();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to enter last name in text box");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on last name text box");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer last name text box not visible");
		}
		return flag;
	}

	public boolean enterTextInbox(String definitionName, String textBoxContent) {
		if (MobileUtils.clickOnElement(objectDefinition, testCase, definitionName)) {
			if (MobileUtils.setValueToElement(objectDefinition, testCase, definitionName, textBoxContent,
					"customer Location name is " + textBoxContent)) {
				return hideKeyboard();
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to enter " + textBoxContent + " in text box");
				return false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to click on " + textBoxContent + " text box");
			return false;
		}
	}

	public boolean setlocationName() {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LocationNameTextBox", 1)) {
			flag = enterTextInbox("LocationNameTextBox", "Home");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"customer Location name text box not visible");
		}
		return flag;
	}

	public boolean setAddress() {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AddressTextBox", 1)) {
			flag = enterTextInbox("AddressTextBox", "7b building primerose");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"customer Location name text box not visible");
		}
		return flag;
	}

	public boolean setCity() {
		boolean flag = false;

		for (int i = 0; i < 3; i++) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CityTextBox", 1)) {
				flag = true;
				break;
			} else {
				flag = false;
				scrollScreen();
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer city name text box not visible");
			}
		}
		if (flag) {
			flag = enterTextInbox("CityTextBox", "Newyork");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer city name text box not visible");
		}

		return flag;
	}

	public boolean setState_province() {
		boolean flag = false;

		for (int i = 0; i < 3; i++) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "StateProvinceTextBox", 1)) {
				flag = true;
				break;
			} else {
				flag = false;
				scrollScreen();
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer city name text box not visible");
			}
		}
		if (flag) {
			flag = enterTextInbox("StateProvinceTextBox", "Ny");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer state name text box not visible");
		}

		return flag;
	}

	public boolean setPostalCode() {
		boolean flag = false;

		for (int i = 0; i < 3; i++) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ZipCode", 1)) {
				flag = true;
				break;
			} else {
				flag = false;
				scrollScreen();
			}
		}
		if (flag) {
			flag = enterTextInbox("ZipCode", "10001");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"customer zipcode name text box not visible");
		}

		return flag;
	}

	public void scrollScreen() {
		Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
		int x = (int) (dimens.getWidth() * 0.5);
		int endY = (int) (dimens.getHeight() * 0.2);
		int startY = (int) (dimens.getHeight() * 0.75);
//		for (int i = 0; i <= 3; i++) {
		W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(4000));
//		}
	}

	public boolean hideKeyboard() {
//		System.out.println(testCase.getMobileDriver().getPageSource());
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			MobileUtils.hideKeyboard(testCase.getMobileDriver(), "Keyboard Hideed for Android");
			return true;
		} else {
//			if (MobileUtils.isMobElementExists("label", "Done", testCase, 1)) {
//				return MobileUtils.clickOnElement(testCase, "label", "Done");
//			} else if (MobileUtils.isMobElementExists("label", "done", testCase, 1)) {
//				return MobileUtils.clickOnElement(testCase, "label", "done");
//			} else if (MobileUtils.isMobElementExists("label", "DONE", testCase, 1)) {
//				return MobileUtils.clickOnElement(testCase, "label", "DONE");
//			}else
//				
			if (MobileUtils.isMobElementExists("name", "Done", testCase, 1)) {
				return MobileUtils.clickOnElement(testCase, "name", "Done");
			} else if (MobileUtils.isMobElementExists("name", "done", testCase, 1)) {
				return MobileUtils.clickOnElement(testCase, "name", "done");
			} else if (MobileUtils.isMobElementExists("name", "DONE", testCase, 1)) {
				return MobileUtils.clickOnElement(testCase, "name", "DONE");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to hide keyboard in iOS");
				return false;
			}
		}
	}

	public boolean setPhoneNumberTextBox(String txt) {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "PhoneNumberTextBox", 1)) {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "PhoneNumberTextBox")) {
				if (MobileUtils.setValueToElement(objectDefinition, testCase, "PhoneNumberTextBox", txt,
						"phone number is " + txt)) {
					flag = hideKeyboard();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able phone number to enter in text box");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on phone number text box");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"customer phone number  text box not visible");
		}
		return flag;
	}

//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}

	public boolean isSuccessScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSuccessScreen", timeOut);
	}

	public boolean isSelectLocationScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSelectLocationScreen", timeOut);
	}

	public boolean isVerifyInfoScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsVerifyInfoScreen", timeOut);
	}

	public boolean isRecentCustomers(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isRecentCustomers", timeOut);
	}

	public boolean isAddCustomerButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AddCustomerButton", timeOut);
	}

	public boolean isNewCustomerScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NewCustomerScreen", timeOut);
	}

	public boolean isNewLocationScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NewLocationScreen", timeOut);
	}

//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}
//	
//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	}

}
