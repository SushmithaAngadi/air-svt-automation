package com.resideo.utils.resideo_app.screen;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

import java.time.Duration;

import com.resideo.utils.W3CTouchActions;

public class ActivityLogsScreen extends MobileScreens {

	private static final String screenName = "ActivityLogs";

	// Locator values used in the methods
	public static final String ACTIVITYLOGSCROLLUPICON = "icon_arch";
	public static final String ACTIVITYLOGSCROLLDOWNICON = "icon_arrow_up";

	public ActivityLogsScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isOpenActivityLogsIconVisible() throws Exception {
		boolean flag = true;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollUp")) {
			return MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollUp");
		} else {
			try {
				// WebElement activityLogUpElement = null;
				CustomDriver driver = testCase.getMobileDriver();
				if (driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON)).isEnabled()) {
					return flag;
				}
			} catch (NoSuchElementException e) {
				flag = false;
				throw new Exception(e + "Activity log scroll up icon is not displayed");
			}
		}
		return flag;
	}

	public boolean clickOnOpenActivityLogsIcon() throws Exception {
		boolean flag = true;
		WebElement activityArrow = null;
		WebElement panelState = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			activityArrow = MobileUtils.getMobElement(objectDefinition, testCase, "AcitvityLogScrollUp");
			panelState = MobileUtils.getMobElement(objectDefinition, testCase, "PanelState");
//			action = action.press(activityArrow).moveTo(panelState).release().perform();
			W3CTouchActions.swipe(testCase.getMobileDriver(), activityArrow.getLocation().getX(), activityArrow.getLocation().getY(), panelState.getLocation().getX(), panelState.getLocation().getY(), Duration.ofMillis(500));
			Keyword.ReportStep_Pass(testCase, "Successfully opened activity logs");
		} else {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollUp")) {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "AcitvityLogScrollUp");
			} else {
				try {
					// WebElement activityLogUpElement = null;
					CustomDriver driver = testCase.getMobileDriver();
					if (driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON)).isEnabled()) {
						//driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON)).click();
//						action.tap(driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON))).release().perform();
						W3CTouchActions.tap(testCase.getMobileDriver(), driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON)).getLocation().getX(), driver.findElement(By.name(ACTIVITYLOGSCROLLUPICON)).getLocation().getY());
						
						Keyword.ReportStep_Pass(testCase, "Successfully opened activity logs");
					}
				} catch (NoSuchElementException e) {

					throw new Exception(e + "Activity log scroll up icon is not displayed");
				}
			}
		}
		return flag;
	}

	public boolean isCloseActivityLogsIconVisible() throws Exception {
		boolean flag = true;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollDown")) {
			return MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollDown");
		} else {
			try {
				// WebElement activityLogDownElement = null;
				CustomDriver driver = testCase.getMobileDriver();
				if (driver.findElement(By.name(ACTIVITYLOGSCROLLDOWNICON)).isEnabled()) {
					return flag;
				}
			} catch (NoSuchElementException e) {
				flag = false;
				throw new Exception(e + "Activity log scroll down icon is not displayed");
			}
		}
		return flag;
	}

	public boolean clickOnCloseActivityLogsIcon() throws Exception {
		boolean flag = true;
		WebElement activityDay = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			activityDay = MobileUtils.getMobElement(objectDefinition, testCase, "AcitvityLogScrollDown");
//			action = action.press(activityDay).moveTo(activityDay.getLocation().getX(), 300).release().perform();
			W3CTouchActions.swipe(testCase.getMobileDriver(), activityDay.getLocation().getX(), activityDay.getLocation().getY(), activityDay.getLocation().getX(), 300, Duration.ofMillis(500));
			Keyword.ReportStep_Pass(testCase, "Successfully closed activity logs");
		} else {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AcitvityLogScrollDown")) {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "AcitvityLogScrollDown");
			} else {
				try {
					// WebElement activityLogDownElement = null;
					CustomDriver driver = testCase.getMobileDriver();
					if (driver.findElement(By.name(ACTIVITYLOGSCROLLDOWNICON)).isEnabled()) {
						activityDay = driver.findElement(By.name(ACTIVITYLOGSCROLLDOWNICON));
//						action.press(activityDay).moveTo(activityDay.getLocation().getX(), 300).release().perform();
						W3CTouchActions.swipe(testCase.getMobileDriver(), activityDay.getLocation().getX(), activityDay.getLocation().getY(), activityDay.getLocation().getX(), 300, Duration.ofMillis(500));
						Keyword.ReportStep_Pass(testCase, "Successfully closed activity logs");
					}
				} catch (NoSuchElementException e) {
					flag = false;
					throw new Exception(e + "Activity log scroll down icon is not displayed");
				}
			}
		}
		return flag;
	}

	public boolean isActivityHistoryTitleVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ActivityHistoryTitle", timeOut);
	}
	
	public List<WebElement> getActivityLogsTitle() 
	{
		return MobileUtils.getMobElements(objectDefinition, testCase, "ActivityLogsHeader");
	}
	
	public List<WebElement> getActivityLogsDescription() 
	{
		return MobileUtils.getMobElements(objectDefinition, testCase, "ActivityLogDescription");
	}
	
	public List<WebElement> getActivityLogsTime() 
	{
		return MobileUtils.getMobElements(objectDefinition, testCase, "ActivityLogTime");
	}
	
	public boolean isBackButtonVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackArrow", timeOut);
	}
	
	public boolean clickOnBackButton() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackArrow");
	}
	
	public boolean isCancelButtonVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CancelButton", timeOut);
	}
	
	public boolean clickOnCancelButton() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButton");
	}
	
	public boolean isSelectAllButtonVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectAllButton", timeOut);
	}
	
	public boolean clickOnSelectAllButton() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SelectAllButton");
	}
	
	public boolean isDeleteButtonVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeleteButton", timeOut);
	}
	
	public boolean clickOnDeleteButton() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteButton");
	}
	
	public boolean isEditButtonVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EditHistory", timeOut);
	}
	
	public boolean clickOnEditButton() 
	{
		return MobileUtils.clickOnElement(objectDefinition, testCase, "EditHistory");
	}
	
	
	public boolean isNoMessagesLableVisible(int timeOut) 
	{
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NoMessagesLable", timeOut);
	}
	
}
