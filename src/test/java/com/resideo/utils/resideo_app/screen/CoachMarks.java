package com.resideo.utils.resideo_app.screen;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;

public class CoachMarks extends MobileScreens {

	private static final String screenName = "CoachMark";

	public CoachMarks(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isNextButtonVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NextButton", timeOut, false);
	}

	public boolean clickOnNextButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
	}

	public boolean isDoneButtonVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DoneButton", timeOut, false);
	}

	public boolean clickOnDoneButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
	}

	public boolean closeRebatesPopup() {
		if (MobileUtils.clickOnElement(objectDefinition, testCase, "CloseRebatePuppop")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "RebateCloseMessage", 1)) {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "RebatePopUpOkButton");
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean isGotitButtonVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "GotItButton", timeOut, false);
	}

	public String getCoachMarkHeaderText() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "CoachMarkHeader").getText();
	}

	public String getCoachMarkDescription() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "CoachMarkDescription").getText();
	}

	public boolean clickOnGotitButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "GotItButton");
	}

	public boolean closeAllPopup() {
		boolean flag = false;

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(2));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				String pageSource = testCase.getMobileDriver().getPageSource();

				if (pageSource.contains("Enjoying Honeywell Home")
						&& pageSource.contains("Tap a star to rate it on the App Store")) {
					MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
					return false;
				} else if (pageSource.contains("Weather and Geofencing are now available on the Dashboard")) {
					MobileUtils.clickOnElement(testCase, "ID", "btn_positive_got_it");
					return false;
				} else if (pageSource.contains(
						"Tapping an item will take you to more detailed information, such as the weather forecast")) {
					MobileUtils.clickOnElement(testCase, "ID", "btn_positive_got_it");
					return false;
				} else if (pageSource.contains("Rebates Available")) {
					closeRebatesPopup();
					return true;
//				}else if () {
//					closeRebatesPopup();
//					return false;
				} else {

					return false;
				}

			}
		});

		return isEventReceived;
	}

	public boolean closeAllPopUp() {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());

		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(2));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				String pageSource = testCase.getMobileDriver().getPageSource();

				if(pageSource.contains("Status Area")||pageSource.contains("")||pageSource.contains("")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
					return false;
				}else if ( pageSource.contains("Tap for More")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
					return false;
				}else if(pageSource.contains("Rebates Available")) {
					closeRebatesPopup();
					return false;
				}else {
					return false;
				}
				
				
			}
		});

		return false;
	}

}

















