package com.resideo.utils.resideo_app.screen;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

public class ThermostatSettingsScreen extends MobileScreens {

	private static final String screenName = "ThermostatSettings";

	public ThermostatSettingsScreen(TestCases testCase) {
		super(testCase, screenName);
	}
	
//	public boolean clickOnTempAlertsRadioBtn()
//	{
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch");
//	}
//	
//	public boolean clickOnHumidAlertsRadioBtn()
//	{
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch");
//	}
	
	
//	public boolean isTempAlertsRadioBtnEnabled(int timeout) 
//	{
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorTempEmailAlertText", timeout);
//	}
//	
//	public boolean isHumidAlertsRadioBtnEnabled(int timeout) 
//	{
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorHumidEmailAlertText", timeout);
//	}
	public boolean isTempAlertenabled() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils
					.getAttribute(testCase, "XPATH",
							"//android.widget.Switch[@content-desc='Indoor Temperature Alert']", "TEXT")
					.equalsIgnoreCase("on"))
				return true;
			else if (MobileUtils
					.getAttribute(testCase, "XPATH",
							"//android.widget.Switch[@content-desc='Indoor Temperature Alert']", "TEXT")
					.equalsIgnoreCase("OFF"))
				return false;
			else
				return false;
		}

		else {
			if (MobileUtils.getAttribute(testCase, "NAME", "TemperatureChange_toggle", "value").equalsIgnoreCase("1"))
				return true;
			else if (MobileUtils.getAttribute(testCase, "NAME", "TemperatureChange_toggle", "value")
					.equalsIgnoreCase("0"))
				return false;
			else
				return false;

		}
	}
	
	public String getAboveTempRangeValueC() {
		return MobileUtils.getAttribute(testCase, "XPATH",
				"(//*[@text='Above']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'C')]",
				"TEXT");
	}
	
	public String getBelowTempRangeValueC() {
		return MobileUtils.getAttribute(testCase, "XPATH",
				"(//*[@text='Below']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'C')]",
				"TEXT");
	}
	
	public String getAboveHumRangeValue() {
		return MobileUtils.getAttribute(testCase, "XPATH",
				"(//*[@text='Above']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'%')]",
				"TEXT");
	}
	
	

	public String getBelowHumRangeValue() {
		return MobileUtils.getAttribute(testCase, "XPATH",
				"(//*[@text='Below']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'%')]",
				"TEXT");
	}

	public String getBelowTempRangeValueF() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
		return MobileUtils.getAttribute(testCase, "XPATH",
				"(//*[@text='Below']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'F')]",
				"TEXT");
		}
		else {
			return MobileUtils.getAttribute(testCase, "XPATH","//*[@name='TemperatureChange']//XCUIElementTypePickerWheel[1]","value");
		}
	}
	public boolean isHumAlertenabled() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.getAttribute(testCase, "XPATH",
					"//android.widget.Switch[@content-desc='Indoor Humidity Alert']", "TEXT").equalsIgnoreCase("on"))
				return true;
			else if (MobileUtils.getAttribute(testCase, "XPATH",
					"//android.widget.Switch[@content-desc='Indoor Humidity Alert']", "TEXT").equalsIgnoreCase("OFF"))
				return false;
			else
				return false;
		} else {
			if (MobileUtils.getAttribute(testCase, "NAME", "HumidityChange_toggle", "value").equalsIgnoreCase("1"))
				return true;
			else if (MobileUtils.getAttribute(testCase, "NAME", "HumidityChange_toggle", "value").equalsIgnoreCase("0"))
				return false;
			else
				return false;

		}
	}
	public String getAboveTempRangeValueF() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
		return MobileUtils.getAttribute(testCase, "XPATH","(//*[@text='Above']/parent::android.widget.LinearLayout)/descendant::android.widget.TextView[contains(@text,'F')]",
				"TEXT");
		}
		else {
			return MobileUtils.getAttribute(testCase, "XPATH","//*[@name='TemperatureChange']//XCUIElementTypePickerWheel[2]","value");
		}
	}
	
	public boolean isTempAlertsRadioBtnVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch", timeout);
	}
	
	public boolean isHumidAlertsRadioBtnVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch", timeout);
	}
	
	public boolean isEnableEmailAlertTitleVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatEmailAlertSwitch", timeout);
	}
	
	public boolean clickOnManageAlertsIcon()
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ManageAlertsLabel");
	}
	
	public boolean isManageAlertIconVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ManageAlertsLabel", timeout);
	}
	
	public boolean isManageAlertTitleVisible(int timeout) 
	{
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "ManageAlertToolBarTitle", 5)) 
		{
			WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "ManageAlertToolBarTitle");
			
			if(ele != null) 
			{
				if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
				{
					if(ele.getText().equalsIgnoreCase("Manage Alerts"))
						return true;
					else 
					{						
						Keyword.ReportStep_Pass(testCase, "Current toolbar title is not 'Manage Alerts'. Displayed : " + ele.getText());
						return false;
					}
						
				}
				else 
				{
					if(ele.getAttribute("value").equalsIgnoreCase("Manage Alerts"))
						return true;
					else 
					{
						Keyword.ReportStep_Pass(testCase, "Current toolbar title is not 'Manage Alerts'. Displayed : " + ele.getText());
						return false;
					}
				}
			}
			else 
			{			
				Keyword.ReportStep_Pass(testCase, "Unable to find Manage Alert toolbar title lable. Returned null.");
				return false;
			}
		}
		else 
		{
			Keyword.ReportStep_Pass(testCase, "Unable to find Manage Alert toolbar title lable.");
			return false;
		}
		
			
	}
	
	public boolean isAlertRangeTitleVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "alert_title_layout", timeout);
	}
	
	public boolean isAlertRangeVisible(int timeout) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatTempAlertRange", timeout);
	}

	public boolean isThermostatSettingsHeaderTitleVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatSettingsHeaderTitle", timeOut);
	}

	public boolean isThermostatIndoorTempAlertSwitchEnabled() throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch").getText()
						.equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Thermostat Indoor Temperature Alert Switch");
		}
	}

	public boolean toggleThermostatIndoorTempAlertSwitch() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatIndoorTempAlertSwitch");
	}

	public boolean isThermostatIndoorTempAlertOptionVisible(String indoorTempAlertOption) {
		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorTempAlertTitle")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase,
						"ThermostatIndoorTempAlertTitle");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Temperature Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
					for (WebElement ele : listAlertTitles) {
						if (ele.getText().equalsIgnoreCase(indoorTempAlertOption)) {
							return flag;
						} else {
							flag = false;
						}
					}
				} else {
					if (listAlertTitles.get(0).getText().equalsIgnoreCase(indoorTempAlertOption)) {
						return flag;
					} else {
						flag = false;
					}
				}
			} else {
				flag = false;
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH",
					"//XCUIElementTypeStaticText[@value='" + indoorTempAlertOption + "']", testCase)
					&& MobileUtils
							.getMobElement(testCase, "XPATH",
									"//XCUIElementTypeStaticText[@value='" + indoorTempAlertOption + "']")
							.getAttribute("value").equalsIgnoreCase(indoorTempAlertOption)
					&& MobileUtils
							.getMobElement(testCase, "XPATH",
									"//XCUIElementTypeStaticText[@value='" + indoorTempAlertOption + "']")
							.getAttribute("visible").equalsIgnoreCase("true")) {
				return flag;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isThermostatTempAlertRangeVisible() {
		// return MobileUtils.isMobElementExists(objectDefinition, testCase,
		// "ThermostatTempAlertRange");

		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatTempAlertRange")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase, "ThermostatTempAlertRange");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Temperature Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
				} else {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Temperature Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
				}
			} else {
				flag = false;
			}
		} else {

			// iOS
		}
		return flag;
	}

	public boolean clickOnThermostatTempAlertRange() {
		// return MobileUtils.clickOnElement(objectDefinition, testCase,
		// "ThermostatTempAlertRange");

		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatAlertRange")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase, "ThermostatAlertRange");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Temperature Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
					Keyword.ReportStep_Pass(testCase, "Click On the Second Alert for this range element in the screen");
					listAlertTitles.get(0).click();
				} else {
					listAlertTitles.get(0).click();
				}
			} else {
				flag = false;
			}
		} else {

			// iOS
			List<WebElement> alertRangeList = new ArrayList<>();
			if(testCase.getPlatform().toUpperCase().contains("IOS"));
			{
				if(MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatTempAlertRange"))
				{
					alertRangeList = MobileUtils.getMobElements(objectDefinition, testCase, "ThermostatTempAlertRange");
					if (alertRangeList.size() > 1) {
						Keyword.ReportStep_Pass(testCase,
								"Total number of Temperature Alert for this range options displayed in the screen are: "
										+ alertRangeList.size());
						Keyword.ReportStep_Pass(testCase, "Click On the Second Alert for this range element in the screen");
						alertRangeList.get(0).click();
					} else {
						alertRangeList.get(0).click();
					}
				}
					else {
						flag = false;
					}
					
					
				}
			}
		return flag;
	}

	public boolean isThermostatIndoorTempAlertRangeOptionVisible(String indoorTempAlertRangeOption) {
		boolean flag = true;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_"
							+ indoorTempAlertRangeOption.toLowerCase() + "_text" + "\'" + "]",
					testCase)
					&& MobileUtils.getFieldValue(testCase, "XPATH",
							"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_"
									+ indoorTempAlertRangeOption.toLowerCase() + "_text" + "\'" + "]")
							.equalsIgnoreCase(indoorTempAlertRangeOption)) {
				return flag;
			} else {
				flag = false;
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypePicker[@name='TemperatureChange']", testCase)
					&& MobileUtils
							.getMobElement(testCase, "XPATH", "//XCUIElementTypePicker[@name='TemperatureChange']")
							.getAttribute("value").contains(indoorTempAlertRangeOption)) {
				return flag;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isBelowAboveTempAlertRangeOptionVisible(String indoorTempAlertRangeOption) {
		boolean flag = true;
		String expectedTempAlertRangeOption = indoorTempAlertRangeOption.contains(" ")
				? indoorTempAlertRangeOption.split(" ")[0]
				: indoorTempAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedTempAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				return flag;
			} else {
				flag = false;
			}
		} else {

			// iOS
			if (expectedTempAlertRangeOption.equals("Below")) {
				WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "TemperatureRangeOption");
				if (ele.getAttribute("value").contains(expectedTempAlertRangeOption)) {
					return flag;
				} else {
					flag = false;
				}
			} else if (expectedTempAlertRangeOption.equals("Above")) {
				WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "TemperatureRangeOption");
				if (ele.getAttribute("value").contains(expectedTempAlertRangeOption)) {
					return flag;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	public String getBelowAboveTempAlertRangeValue(String indoorTempAlertRangeOption) {
		String getTempAlertRangeValue = null;
		String expectedTempAlertRangeOption = indoorTempAlertRangeOption.contains(" ")
				? indoorTempAlertRangeOption.split(" ")[0]
				: indoorTempAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedTempAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				getTempAlertRangeValue = MobileUtils.getFieldValue(testCase, "XPATH",
						"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
								+ expectedTempAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
								+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
								+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]");

			}
		} else {

			// iOS
			if (expectedTempAlertRangeOption.equals("Below")) {
				WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "SelectBelowTempRangeValue");
				getTempAlertRangeValue = ele.getAttribute("value");
			} else if (expectedTempAlertRangeOption.equals("Above")) {
				WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "SelectAboveTempRangeValue");
				getTempAlertRangeValue = ele.getAttribute("value");
			}
		}
		return getTempAlertRangeValue;
	}

	public boolean clickOnBelowAboveTempAlertRangeOption(String indoorTempAlertRangeOption) {
		boolean flag = true;
		String expectedTempAlertRangeOption = indoorTempAlertRangeOption.contains(" ")
				? indoorTempAlertRangeOption.split(" ")[0]
				: indoorTempAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedTempAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				MobileUtils.clickOnElement(testCase, "XPATH",
						"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
								+ expectedTempAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
								+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
								+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]");
				return flag;
			} else {
				flag = false;
			}
		} else {

			// iOS
			if (expectedTempAlertRangeOption.equals("Below")) {
				if (MobileUtils.isMobElementExists("XPATH",
						"//XCUIElementTypePicker[@name='TemperatureChange']/XCUIElementTypePickerWheel[1]", testCase)) {
					MobileUtils.clickOnElement(testCase, "XPATH",
							"//XCUIElementTypePicker[@name='TemperatureChange']/XCUIElementTypePickerWheel[1]");
				} else {
					flag = false;
				}
			} else if (expectedTempAlertRangeOption.equals("Above")) {
				if (MobileUtils.isMobElementExists("XPATH",
						"//XCUIElementTypePicker[@name='TemperatureChange']/XCUIElementTypePickerWheel[2]", testCase)) {
					MobileUtils.clickOnElement(testCase, "XPATH",
							"//XCUIElementTypePicker[@name='TemperatureChange']/XCUIElementTypePickerWheel[2]");
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	public boolean setValueInBelowAboveTempRange(String indoorTempAlertRangeOption, String tempValue) {
		boolean flag = true;
		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (indoorTempAlertRangeOption.contains("Below")) {

			} else if (indoorTempAlertRangeOption.equals("Above")) {

			}
		}
		return flag;
	}

	public boolean isIndoorTempRangeValueVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorAboveBelowTemperatureRangeValue", 10);
	}

	public String getBelowTempRangeValue() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowTemperatureRangeValue").get(0)
				.getText();
	}

	public String getAboveTempRangeValue() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowTemperatureRangeValue").get(1)
				.getText();
	}
	

	public boolean clickOnBelowTempRangeValue() {
		MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowTemperatureRangeValue").get(0).click();
		return true;
	}

	public boolean clickOnAboveTempRangeValue() {
		MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowTemperatureRangeValue").get(1).click();
		return true;
	}
	
	public boolean isIndoorTempAlertLableVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorTempAlertLable", timeOut);
	}
	
	public boolean isIndoorHumAlertLableVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorHumidityAlertLable", timeOut);
	}

	public boolean isThermostatIndoorHumidityAlertSwitchEnabled() throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch")
						.getText().equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Thermostat Indoor Humidity Alert Switch");
		}
	}
	
	public boolean isEmailForAlertSwitchEnabled() 
	{
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatEmailAlertSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatEmailAlertSwitch")
						.getText().equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatEmailAlertSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Email Alert Switch is not visible.");
			return false;
		}
	}

	public boolean toggleThermostatIndoorHumidityAlertSwitch() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatIndoorHumidityAlertSwitch");
	}

	public boolean isThermostatIndoorHumidityAlertOptionVisible(String indoorHumidityAlertOption) {
		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatIndoorHumidityAlertTitle")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase,
						"ThermostatIndoorHumidityAlertTitle");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Alert for this range options displayed in the screen is: "
									+ listAlertTitles.size());
					for (WebElement ele : listAlertTitles) {
						if (ele.getText().equalsIgnoreCase(indoorHumidityAlertOption)) {
							return flag;
						} else {
							flag = false;
						}
					}
				} else {
					if (listAlertTitles.get(0).getText().equalsIgnoreCase(indoorHumidityAlertOption)) {
						return flag;
					} else {
						flag = false;
					}
				}
			} else {
				flag = false;
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH",
					"//XCUIElementTypeStaticText[@value='" + indoorHumidityAlertOption + "']", testCase)
					&& MobileUtils
							.getMobElement(testCase, "XPATH",
									"//XCUIElementTypeStaticText[@value='" + indoorHumidityAlertOption + "']")
							.getAttribute("value").equalsIgnoreCase(indoorHumidityAlertOption)
					&& MobileUtils
							.getMobElement(testCase, "XPATH",
									"//XCUIElementTypeStaticText[@value='" + indoorHumidityAlertOption + "']")
							.getAttribute("visible").equalsIgnoreCase("true")) {
				return flag;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	
	public String getAlertRangeFor(String alert) 
	{
		List<WebElement> alertRange = new ArrayList<>();
		
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatAlertRange")) 
		{
			alertRange = MobileUtils.getMobElements(objectDefinition, testCase, "ThermostatAlertRange");
			
			if(alertRange != null) 
			{
				if(alert.equalsIgnoreCase("Indoor Temperature")) 
				{
					if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
						return alertRange.get(0).getText();
					else
						return alertRange.get(0).getAttribute("value");
				}
				else if (alert.equalsIgnoreCase("Indoor Humidity")) 
				{
					if(testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						System.out.println(alertRange.get(0).getText());
						return alertRange.get(0).getText();
					}
					else
						return alertRange.get(1).getAttribute("value");					
				}
				else 
				{
					Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Invalid input for 'getAlertRangeFor'. Expected inputs : 'Indoor Temperature' OR 'Indoor Humidity'");
					return "NULL";
				}					
			}
			else 
			{
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Failed to read alert range. Returning NULL");
				return "NULL";
			}
		}
		else 
		{
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Unable to find Thermostat Alert Range Lable");
			return "NULL";
		}		
	} 

	public boolean isThermostatHumidityAlertRangeVisible() {
		// return MobileUtils.isMobElementExists(objectDefinition, testCase,
		// "ThermostatHumidityAlertRange");

		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatHumidityAlertRange")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase,
						"ThermostatHumidityAlertRange");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Humidity Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
				} else {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Humidity Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
				}
			} else {
				flag = false;
			}
		} else {

			// iOS
		}
		return flag;

	}

	public boolean clickOnThermostatHumidityAlertRange() {
		// return MobileUtils.clickOnElement(objectDefinition, testCase,
		// "ThermostatHumidityAlertRange");

		boolean flag = true;
		List<WebElement> listAlertTitles = new ArrayList<>();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatHumidityAlertRange")) {
				listAlertTitles = MobileUtils.getMobElements(objectDefinition, testCase,
						"ThermostatHumidityAlertRange");
				if (listAlertTitles.size() > 1) {
					Keyword.ReportStep_Pass(testCase,
							"Total number of Humidity Alert for this range options displayed in the screen are: "
									+ listAlertTitles.size());
					Keyword.ReportStep_Pass(testCase, "Click On the second Alert for this range element in the screen");
					listAlertTitles.get(1).click();
				} else {
					listAlertTitles.get(0).click();
				}
			} else {
				flag = false;
			}
		} else {

			// iOS
		}
		return flag;

	}

	public boolean isThermostatIndoorHumidityAlertRangeOptionVisible(String indoorTempAlertRangeOption) {
		boolean flag = true;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_"
							+ indoorTempAlertRangeOption.toLowerCase() + "_text" + "\'" + "]",
					testCase)
					&& MobileUtils.getFieldValue(testCase, "XPATH",
							"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_"
									+ indoorTempAlertRangeOption.toLowerCase() + "_text" + "\'" + "]")
							.equalsIgnoreCase(indoorTempAlertRangeOption)) {
				return flag;
			} else {
				flag = false;
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypePicker[@name='TemperatureChange']", testCase)
					&& MobileUtils
							.getMobElement(testCase, "XPATH", "//XCUIElementTypePicker[@name='TemperatureChange']")
							.getAttribute("value").contains(indoorTempAlertRangeOption)) {
				return flag;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isBelowAboveHumidityAlertRangeOptionVisible(String indoorHumidityAlertRangeOption) {
		boolean flag = true;
		String expectedHumidityAlertRangeOption = indoorHumidityAlertRangeOption.contains(" ")
				? indoorHumidityAlertRangeOption.split(" ")[0]
				: indoorHumidityAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedHumidityAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				return flag;
			} else {
				flag = false;
			}
		} else {

			// iOS
		}
		return flag;
	}

	public String getBelowAboveHumidityAlertRangeValue(String indoorHumidityAlertRangeOption) {
		String getHumidityAlertRangeValue = null;
		String expectedHumidityAlertRangeOption = indoorHumidityAlertRangeOption.contains(" ")
				? indoorHumidityAlertRangeOption.split(" ")[0]
				: indoorHumidityAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedHumidityAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				getHumidityAlertRangeValue = MobileUtils.getFieldValue(testCase, "XPATH",
						"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
								+ expectedHumidityAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
								+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
								+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]");

			}
		} else {

			// iOS
		}
		return getHumidityAlertRangeValue;
	}

	public boolean clickOnBelowAboveHumidityAlertRangeOption(String indoorHumidityAlertRangeOption) {
		boolean flag = true;
		String expectedHumidityAlertRangeOption = indoorHumidityAlertRangeOption.contains(" ")
				? indoorHumidityAlertRangeOption.split(" ")[0]
				: indoorHumidityAlertRangeOption;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
							+ expectedHumidityAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
							+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
							+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]",
					testCase)) {
				MobileUtils.clickOnElement(testCase, "XPATH",
						"//*[@resource-id=" + "\'" + "com.resideo.android.lyric:id/fragment_high_low_alert_setting_"
								+ expectedHumidityAlertRangeOption.toLowerCase() + "_spinner" + "\'" + "]"
								+ "/android.widget.LinearLayout/android.widget.TextView[@resource-id=" + "\'"
								+ "com.resideo.android.lyric:id/list_item_lyric_spinner_text'" + "]");
				return flag;
			} else {
				flag = false;
			}
		} else {

			// iOS
		}
		return flag;
	}

	public boolean isIndoorHumidityRangeValueVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorAboveBelowHumidityRangeValue", 10);
	}

	public String getBelowHumidityRangeValue() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowHumidityRangeValue").get(0)
				.getText();
	}

	public String getAboveHumidityRangeValue() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowHumidityRangeValue").get(1)
				.getText();
	}

	public boolean clickOnBelowHumidityRangeValue() {
		MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowHumidityRangeValue").get(0).click();
		return true;
	}

	public boolean clickOnAboveHumidityRangeValue() {
		MobileUtils.getMobElements(objectDefinition, testCase, "IndoorAboveBelowHumidityRangeValue").get(1).click();
		return true;
	}

	public boolean isBackButtonVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackButton", timeOut);
	}

	public boolean clickOnBackButton() {
		
		boolean flag = true;
		if(testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if( MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.ImageButton[@content-desc='Navigate Up']"))flag = true;
		}
		else {
		if( MobileUtils.clickOnElement(testCase, "NAME", "Back"))flag = true;
		else if(MobileUtils.clickOnElement(testCase, "NAME", "btn close normal"))flag = true;
		else if(MobileUtils.clickOnElement(testCase, "NAME", "BACK"))flag = true;
		else if(MobileUtils.clickOnElement(testCase, "NAME", "nav bar back"))flag = true;
		}
		return flag;
		
	}


	public boolean isActivityHistoryAlertTimeVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ActivityHistoryAlertTime");
	}

	public String getActivityHistoryAlertTime() {
		return MobileUtils.getFieldValue(objectDefinition, testCase, "ActivityHistoryAlertTime");
	}

	public boolean isActivityHistoryAlertTitleVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ActivityHistoryAlertTitle");
	}

	public List<WebElement> getActivityHistoryAlertTitlesList() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "ActivityHistoryAlertTitle");
	}

	public String getActivityHistoryAlertTitle() {
		return MobileUtils.getFieldValue(objectDefinition, testCase, "ActivityHistoryAlertTitle");
	}

	public boolean isActivityHistoryAlertMsgVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ActivityHistoryAlertMsg");
	}

	public List<WebElement> getActivityHistoryAlertMsgsList() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "ActivityHistoryAlertMsg");
	}

	public String getActivityHistoryAlertMsg() {
		return MobileUtils.getFieldValue(objectDefinition, testCase, "ActivityHistoryAlertMsg");
	}

	public boolean isThermostatConfigurationOptionVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatConfigurationOption");
	}
/*
	public boolean selectOptionFromThermostatSettings(String option) throws Exception {
		switch (option) {
		case BaseStationSettingsScreen.THERMOSTATCONFIGURATION: {
			boolean flag = true;
			if (this.isThermostatConfigurationOptionVisible()) {
				Keyword.ReportStep_Pass(testCase, "Thermostat Configuration Visible @ 1");
				flag = flag & MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatConfigurationOption");
			} else {
				Keyword.ReportStep_Pass(testCase, "Thermostat Visible @ 2");
				flag = flag & LyricUtils.scrollToElementUsingExactAttributeValue(testCase,
						testCase.getPlatform().toUpperCase().contains("ANDROID") ? "text" : "value",
						BaseStationSettingsScreen.THERMOSTATCONFIGURATION);
				flag = flag & MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatConfigurationOption");
			}
			if (this.isThermostatConfigurationOptionVisible()) {
				Keyword.ReportStep_Pass(testCase, "Thermostat Visible @ 3");
				flag = flag & MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatConfigurationOption");
			}
			return flag;
		}
		default: {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				return MobileUtils.clickOnElement(testCase, "xpath",
						"//android.widget.TextView[@text='" + option + "']");
			} else {
				return MobileUtils.clickOnElement(testCase, "value", option);
			}
		}
		}
	}
*/
	public boolean clickOnThermostatConfigurationLabel() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatConfigurationButton");
	}

	public boolean isDeleteThermostatButtonVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeleteThermostatButton");
	}

	public boolean clickOnDeleteThermostatButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteThermostatButton");
	}

	public boolean isDeleteThermostatDevicePopupTitleVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeleteThermostatDevicePopupTitle");
	}

	public boolean isCancelButtonInDeleteThermostatDevicePopupVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CancelButtonInDeleteThermostatDevicePopup");
	}

	public boolean clickOnCancelButtonInDeleteThermostatDevice() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButtonInDeleteThermostatDevicePopup");
	}

	public boolean isOKButtonInDeleteThermostatDevicePopupVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OKButtonInDeleteThermostatDevicePopup");
	}

	public boolean clickOnOKButtonInDeleteThermostatDevice() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OKButtonInDeleteThermostatDevicePopup");
	}

	public boolean isSetFilterReminderLabelVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SetFilterReminderLabel", timeOut);
	}
	
	public boolean isSetFilterReminderTitleVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SetFilterReminderTitle", timeOut);
	}

	public boolean clickOnSetFilterReminderLabel() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SetFilterReminderLabel");
	}

	public boolean isThermostatSetFilterReminderSwitchEnabled() throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatSetFilterReminderSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatSetFilterReminderSwitch").getText()
						.equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatSetFilterReminderSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Set Filter Reminder Switch");
		}
	}

	public boolean toggleSetFilterReminderSwitch() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatSetFilterReminderSwitch");
	}

	public boolean isSetFilterReminderOptionsVisible(String setFilterReminderOptions) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//android.widget.TextView[@text='" + setFilterReminderOptions + "']", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPath",
					"//XCUIElementTypeStaticText[contains(@name, '_subTitle') and @value='" + setFilterReminderOptions
							+ "']",
					testCase);
		}
	}

	public boolean isThermostatFineTuneSwitchEnabled(TestCases testCase) throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatFineTuneSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatFineTuneSwitch").getText()
						.equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatFineTuneSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Set Fine Tune Switch");
		}
	}

	public boolean toggleThermostatFineTuneSwitch(TestCases testCase) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatFineTuneSwitch");
	}

	public boolean isThermostatAdaptiveRecoverySwitchEnabled(TestCases testCase) throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatAdaptiveRecoverySwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatAdaptiveRecoverySwitch").getText()
						.equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatAdaptiveRecoverySwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Adaptive Recovery Switch");
		}
	}

	public boolean toggleThermostatAdaptiveRecoverySwitch(TestCases testCase) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatAdaptiveRecoverySwitch");
	}

	public boolean isThermostatOptimiseSwitchEnabled(TestCases testCase) throws Exception {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatOptimiseSwitch", 20)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatOptimiseSwitch").getText()
						.equalsIgnoreCase("ON")) {
					return true;
				} else {
					return false;
				}
			} else {
				if (MobileUtils.getMobElement(objectDefinition, testCase, "ThermostatOptimiseSwitch")
						.getAttribute("value").equalsIgnoreCase("1")) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			throw new Exception("Could not find Set Fine Tune Switch");
		}
	}

	public boolean toggleThermostatOptimiseSwitch(TestCases testCase) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatOptimiseSwitch");
	}

	public boolean isThermostatAutoChangeOverSwitchEnabled(TestCases testCase, String fieldToBeVerified)
			throws Exception {
		boolean flag = true;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH",
					"//android.widget.Switch[@content-desc='" + fieldToBeVerified + "']", testCase)
					&& (MobileUtils
							.getMobElement(testCase, "XPATH",
									"//android.widget.Switch[@content-desc='" + fieldToBeVerified + "']")
							.getText().equalsIgnoreCase("ON"))) {
				return flag;
			} else {
				flag = false;
			}
		} else {
			
			//iOS
		}
		return flag;
	}
	
		public boolean isSettingsButtonVisible(int timeOut)  {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Settings", timeOut);
	}

	public boolean clickOnSettingsButton(){
		if(isSettingsButtonVisible(5)) 
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Settings");
		else
			return false;
	}

	public boolean isThermostatSettingsTitleVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SettingsToolbarTitle", 5, false);
	}

	public String getThermostatSettingsTitle() {

		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
			return MobileUtils.getMobElement(objectDefinition, testCase, "SettingsToolbarTitle").getText();
		else
			return MobileUtils.getMobElement(objectDefinition, testCase, "SettingsToolbarTitle").getAttribute("value");
	}

	public boolean isAIRVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AIR", 5, false);
	}

	public String getAIRTitle() {

		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))

			return MobileUtils.getMobElement(objectDefinition, testCase, "AIR").getText();
		else
			return MobileUtils.getMobElement(objectDefinition, testCase, "AIR").getAttribute("value");
	}


	public String getAIRSts() 
	{
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "AIRSts", 10)) 
		{
			if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
				return MobileUtils.getMobElement(objectDefinition, testCase, "AIRSts").getText();
			else 
			{
				String sts = MobileUtils.getMobElement(objectDefinition, testCase, "AIRSts").getAttribute("value").toString().trim();
				
				if(sts != null) 
				{
					if(sts.equals("1"))
						return "ON";
					else
						return "OFF";
				}
				else
					return null;
			}
		}
		else
			return null;
	}

	public String getAIRDesc() {
		String aRDesc = null;
		if(testCase.getPlatform().toUpperCase().contains("ANDROID"))  {

			boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase,"AIRDescription", 15);
			System.out.println("id"+ flag);

			WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "AIRDescription");
			aRDesc = ele.getText();
			System.out.println("Desc: "+ ele.getText());
		}
		return aRDesc;

	}

	public boolean isAIRToggleButtonVisible(int timeOut)  {
//		boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase, "AIRToggleButton");
//		System.out.println("button: " + flag);
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AIRToggleButton",5, false);
	}

	public boolean isAIRONSTSVisible(int timeOut)  {
		boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase, "AIRSts");
		System.out.println("ON: " + flag);
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AIRSts",5, false);
	}

	public boolean changeAIRStsToOn() 
	{
		String str = getAIRSts();
		
		if(str != null) 
		{
			if(str.trim().equalsIgnoreCase("OFF"))
				return MobileUtils.clickOnElement(objectDefinition, testCase, "AIRSts");
			else if(str.trim().equalsIgnoreCase("ON"))
				return true;
			else
				return false;
		}
		else
			return false;
		
//		if (isAIRToggleButtonVisible(5))
//		{
//
//		}
//		else
//			return false;		
	}

	public Boolean changeAIRStsToOff() {
		
		String str = getAIRSts();
		
		if(str != null) 
		{
			if(str.trim().equalsIgnoreCase("ON"))
				return MobileUtils.clickOnElement(objectDefinition, testCase, "AIRSts");
			else if(str.trim().equalsIgnoreCase("OFF"))
				return true;
			else
				return false;
		}
		else
			return false;
		
//		if (isAIRToggleButtonVisible(5))
//		{
//
//		}
//		else
//			return false;	
	}

	public boolean isACOVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ACO", 5, false);
	}

	public String getACOTitle() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))

			return MobileUtils.getMobElement(objectDefinition, testCase, "ACO").getText();
		else
			return MobileUtils.getMobElement(objectDefinition, testCase, "ACO").getAttribute("value");
	}


	public String getACOSts()
	{
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "ACOSts", 10)) 
		{
			if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
				return MobileUtils.getMobElement(objectDefinition, testCase, "ACOSts").getText();
			else 
			{
				String sts = MobileUtils.getMobElement(objectDefinition, testCase, "ACOSts").getAttribute("value").toString().trim();
				
				if(sts != null) 
				{
					if(sts.equals("1"))
						return "ON";
					else
						return "OFF";
				}
				else
					return null;
			}
		}
		else
			return null;
	}

	public String getACODesc() {
		String aCODesc = null;
		if(testCase.getPlatform().toUpperCase().contains("ANDROID"))  {

			boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase,"ACODescription", 15);
			System.out.println("id"+ flag);

			WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "ACODescription");
			aCODesc = ele.getText();
			System.out.println("Desc: "+ ele.getText());
		}
		return aCODesc;

	}

	public boolean isACOToggleButtonVisible(int timeOut)  {
		boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase, "ACOToggleButton");
		System.out.println("button: " + flag);
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ACOToggleButton",5, false);
	}


	public boolean changeACOStsToOn() 
	{

		if (isACOToggleButtonVisible(5))
		{
			String str = getACOSts();
			
			if(str != null) 
			{
				if(str.trim().equalsIgnoreCase("OFF"))
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ACOSts");
				else if(str.trim().equalsIgnoreCase("ON"))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;			
	}

	public Boolean changeACOStsToOff() {
		if (isACOToggleButtonVisible(5))
		{
			String str = getACOSts();
			
			if(str != null) 
			{
				if(str.trim().equalsIgnoreCase("ON"))
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ACOSts");
				else if(str.trim().equalsIgnoreCase("OFF"))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean isEMHeatVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EMHeat", 5);
	}

	public String getEMHeatTitle() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))

			return MobileUtils.getMobElement(objectDefinition, testCase, "EMHeat").getText();
		else
			return MobileUtils.getMobElement(objectDefinition, testCase, "EMHeat").getAttribute("value");
	}
	
	public String runningSystemMode() {
		String ModeRunning = null;
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "AutoSystemMode",1)) 
			ModeRunning= "AUTO";
		else if(MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatSystemMode",1)) 
			ModeRunning= "HEAT";
		else if(MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatSystemMode",1)) 
			ModeRunning= "EMERGENCYHEAT";
		else if(MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolSystemMode",1)) 
			ModeRunning= "COOL";
		else if(MobileUtils.isMobElementExists(objectDefinition, testCase, "OffSystemMode",1)) 
			ModeRunning= "OFF";
		
		return ModeRunning;
	}
	
	public List<WebElement> availableSystemMode() {
		return MobileUtils.getMobElements(objectDefinition, testCase, "ListSystemMode");
	}
	
	public String getEMHSts() 
	{
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "EMHeatSts", 5)) 
		{
			if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
				return MobileUtils.getMobElement(objectDefinition, testCase, "EMHeatSts").getText();
			else 
			{
				String sts = MobileUtils.getMobElement(objectDefinition, testCase, "EMHeatSts").getAttribute("value").toString().trim();
				
				if(sts != null) 
				{
					if(sts.equals("1"))
						return "ON";
					else
						return "OFF";
				}
				else
					return null;
			}							
		}			
		else
			return null;

	}

	public String getEMHDesc()
	{
		if(MobileUtils.isMobElementExists(objectDefinition, testCase, "EMHeatDescription",  5)) 
		{
			if(testCase.getPlatform().toUpperCase().contains("ANDROID"))
				return MobileUtils.getMobElement(objectDefinition, testCase, "EMHeatDescription").getText();
			else
				return MobileUtils.getMobElement(objectDefinition, testCase, "EMHeatDescription").getAttribute("value").trim();
		}
		else
			return null;
	}
	
	public boolean isEMHToggleButtonVisible(int timeOut)  {
		boolean flag = MobileUtils.isMobElementExists(objectDefinition, testCase, "EMHeatToggleButton");
		System.out.println("button: " + flag);
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EMHeatToggleButton",5, false);
	}
	
	public boolean changeEMHStsToOn() {

		if (isEMHToggleButtonVisible(5))
		{
			String str = getEMHSts();
			
			if(str != null) 
			{
				if(str.trim().equalsIgnoreCase("OFF"))
					return MobileUtils.clickOnElement(objectDefinition, testCase, "EMHeatSts");
				else if(str.trim().equalsIgnoreCase("ON"))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;		
	}

	public Boolean changeEMHStsToOff() {
		if (isEMHToggleButtonVisible(5))
		{
			String str = getEMHSts();
			
			if(str != null) 
			{
				if(str.trim().equalsIgnoreCase("ON"))
					return MobileUtils.clickOnElement(objectDefinition, testCase, "EMHeatSts");
				else if(str.trim().equalsIgnoreCase("OFF"))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
/*
	public boolean navigateToSettingsFromAnyScreen(String deviceName) 
	{
		boolean flag = true;
		Dashboard dBaord = new Dashboard(testCase);
		
		try 
		{
			if(dBaord.isGlobalDrawerButtonVisible()) 
			{
				Keyword.ReportStep_Pass(testCase, "Navigating to device primary card from dashboard");
				flag = flag & DashboardUtils.selectDeviceFromDashboard(testCase, deviceName);			
			}
			else 
			{
				Keyword.ReportStep_Pass(testCase, "Navigating to dashboard");
				flag = flag & DashboardUtils.navigateToDashboardFromAnyScreen(testCase);
				
				Keyword.ReportStep_Pass(testCase, "Navigating to device primary card from dashboard");
				flag = flag & DashboardUtils.selectDeviceFromDashboard(testCase, deviceName);
			}
			
			if(isSettingsButtonVisible(10)) 
			{
				flag = flag && clickOnSettingsButton();
				Keyword.ReportStep_Pass(testCase, "Already in settings page...");
			}
			else 
			{
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Settings button is not found.");
			}
			
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Navigate to Settings screen failed. Exception raised : " + e.getMessage());
		}
		
		return flag;
	}
*/
	public boolean iseditTempRangeVisible() {
		return (MobileUtils.isMobElementExists(objectDefinition, testCase, "BelowTempRangePickerF", 5)
				|| (MobileUtils.isMobElementExists(objectDefinition, testCase, "BelowTempRangePickerC", 5)));
	}

	public boolean clickBelowTemp() {
		return (MobileUtils.clickOnElement(objectDefinition, testCase, "BelowTempRangePickerF")
				|| (MobileUtils.clickOnElement(objectDefinition, testCase, "BelowTempRangePickerC")));
	}

	public boolean clickAboveTemp() {
		return (MobileUtils.clickOnElement(objectDefinition, testCase, "AboveTempRangePickerF")
				|| (MobileUtils.clickOnElement(objectDefinition, testCase, "AboveTempRangePickerC")));
	}

	public boolean iseditHumRangeVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BelowHumidityRangePicker", 5);
	}

	public boolean clickBelowHum() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BelowHumidityRangePicker");
	}

	public boolean clickAboveHum() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AboveHumidityRangePicker");
	}

	public boolean ClickOnAlertForThisRangeTemp() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AlertForThisRngTemp");
	}

	public boolean ClickOnAlertForThisRangeHum() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AlertForThisRngHum");
	}

	public boolean setTempAlertRangeValue(float below, float above, String tempscale) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (!iseditTempRangeVisible())
				ClickOnAlertForThisRangeTemp();

			if (tempscale.equalsIgnoreCase("F")) {
				if (clickBelowTemp()) {
					System.out.println((int)(below) + "°F");
					MobileUtils.scrollTo(testCase, (int)(below) + "°F");
					MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + (int)below + "°F']");
					if (clickAboveTemp())
						System.out.println((int)(above) + "°F");
					MobileUtils.scrollTo(testCase, (int)(above) + "°F");
					MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + (int)above + "°F']");
					return true;
				}
			} else if (tempscale.equalsIgnoreCase("C")) {
				if (clickBelowTemp()) {
					System.out.println(String.valueOf(below) + "°C");
					MobileUtils.scrollTo(testCase, String.valueOf(below) + "°C");
					MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + below + "°C");
					if (clickAboveTemp())
						System.out.println(String.valueOf(above) + "°C");
					MobileUtils.scrollTo(testCase, String.valueOf(above) + "°C");
					MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + above + "°C");
					return true;
				}
			}
		}
		return false;

	}

	public boolean setHumAlertRangeValue(int below, int above) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (!iseditHumRangeVisible())
				ClickOnAlertForThisRangeHum();

			if (clickBelowHum()) {
				System.out.println(String.valueOf(below) + "%");
				MobileUtils.scrollTo(testCase, String.valueOf(below) + "%");
				System.out.println("//*[@text='" +below + "%']");
				MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" +below + "%']");
				System.out.println("//*[@text='" +below + "%']");

				if (clickAboveHum())
					System.out.println(String.valueOf(above) + "%");
				MobileUtils.scrollTo(testCase, String.valueOf(above) + "%");
				MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + (int)above + "%']");
				return true;
			}
		} else {
			// iOS code
		}
		return false;
	}

}