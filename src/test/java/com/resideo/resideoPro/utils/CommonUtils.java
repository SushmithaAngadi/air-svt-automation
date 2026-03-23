package com.resideo.utils.resideo_app;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

public class CommonUtils {

	public static boolean connectWithDeviceWifiInAndroid(TestCases testCase, String WifiName,
			String expectedStringAfterWifiConnect) {

		boolean flag = false;
		boolean isDeviceConnected = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + WifiName + "')]//*[contains(@content-desc,'Settings')]", testCase,
					2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + WifiName + "']", testCase,
					2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else {
				Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

				int x = (int) (dimens.getWidth() * 0.5);
				int endY = (int) (dimens.getHeight() * 0.2);
				int startY = (int) (dimens.getHeight() * 0.75);

				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofSeconds(1));
				fWait.withTimeout(Duration.ofMinutes(3));

				try {
					Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {

							if (MobileUtils.isMobElementExists("xpath", "//*[contains(@content-desc,'" + WifiName
									+ "')]//*[contains(@content-desc,'Settings')]", testCase, 1))
								return true;
							else if (MobileUtils.isMobElementExists("XPATH",
									"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + WifiName
											+ "']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("xpath", "//*[@text='" + WifiName + "']",
									testCase, 2)) {
								Keyword.ReportStep_Pass(testCase, "Required broadcasting device found");

								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='" + WifiName + "']");

								return true;

							} else if (MobileUtils.isMobElementExists("xpath",
									"//*[@text='Add network' or @text='Add Network']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='Add network' or @text='Add Network']");

								if (MobileUtils.isMobElementExists("xpath",
										"//*[@text='Enter the SSID' or @text='Enter the ssid']", testCase, 2)) {
									MobileUtils.setValueToElement(testCase, "xpath",
											"//*[@text='Enter the SSID' or @text='Enter the ssid']", "" + WifiName,
											WifiName + " Neteowrk is added.");

									MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='SAVE' or @text='Save']");

								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Unable to find text box to enter SSID");
								}
								return true;
							} else {
								testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
								return false;
							}
						}
					});

					isDeviceConnected = success;
				} catch (org.openqa.selenium.TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to time out : 180 seconds" + e.getLocalizedMessage());
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to : " + e.getMessage());
				}
			}

			if ((isDeviceConnected && MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + WifiName + "')]//*[contains(@content-desc,'Settings')]", testCase,
					8))
					|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH",
							"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + WifiName + "']",
							testCase))) {
				int i = 5;
				do {
					MobileUtils.pressBackButton(testCase);

					if (MobileUtils.isMobElementExists("xpath",
							"//*[contains(@text,'" + expectedStringAfterWifiConnect + "')]", testCase, 2)) {
						flag = true;
						break;
					}

					i--;
				} while (i >= 0);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to connect Stat Wifi");
				flag = false;
			}

		}

		if (flag) {
			Keyword.ReportStep_Pass(testCase, "Succcessfully connected to WIFI, Wifi Name is " + WifiName);
		}
		return flag;

	}

	public static boolean connectWithDeviceWifiInIOS(TestCases testCase, String WifiName,
			String BundleIdReturnBackfromWifi) {
		boolean flag = false;
		testCase.getMobileDriver().activateApp("com.apple.Preferences");
		if (MobileUtils.isMobElementExists("NAME", "Wi-Fi", testCase, 2)) {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Wi-Fi",
					"Clicked on WIFI Settings in iOS Preference Settings Screen");
			if (flag) {
				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());

				fWait.pollingEvery(Duration.ofSeconds(3));
				fWait.withTimeout(Duration.ofSeconds(30));
				try {
					Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {
							try {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name,'" + WifiName + ", Unsecured Network, Unsecure network')]",
										testCase, 1)
										|| MobileUtils.isMobElementExists("XPATH",
												"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
														+ WifiName + "']",
												testCase, 1)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully COnnected to Thermostat wifi");
									testCase.getMobileDriver().activateApp(BundleIdReturnBackfromWifi);
									Keyword.ReportStep_Pass(testCase,
											"Application Switched back to Honeywell Home Aplicaition");
									return true;
								} else if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + WifiName
												+ "')]",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "NAME", WifiName,
											"sucessfully clicked on Thermostat Wi-Fi");
									return false;
								} else {
									return false;
								}

							} catch (Exception e) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"failed due to : " + e.getMessage());
								return false;
							}
						}
					});
					if (success)
						flag = true;
					else
						flag = false;

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Wifi Option not available from iOS Setting");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Wifi Option not available from iOS Setting");
			flag = false;
		}

		return flag;
	}

	public static String getCoordinatesForParticularUDID(TestCases testCase, TestCaseInputs inputs, String forNeed) {
		String coordinate = null;
		String deviceID = inputs.getInputValue("TARGET_DEVICENAME").toString();
		System.out.println(deviceID);
		if (deviceID.contains("00008110-001578C03A79801E")) {
			if (forNeed.contains("More Option")) {
//				coordinate = "215_373";
				coordinate = "224_392";
			} else if (forNeed.contains("To Address")) {
				coordinate = "218_228";
			} else if (forNeed.contains("Send")) {
				coordinate = "335_167";
			}
//			00008101-00116561362B001E
		}else if(deviceID.contains("00008101-00116561362B001E")){
			if (forNeed.contains("More Option")) {
//				coordinate = "215_373";
				coordinate = "230_409";
			} else if (forNeed.contains("To Address")) {
				coordinate = "211_235";
			} else if (forNeed.contains("Send")) {
				coordinate = "336_167";
			}
		} else if (deviceID.contains("fadfb72db7fb6d1e6499696d1b57e4d24fad7679")) {
            if (forNeed.contains("More Option")) {
                coordinate = "220_197";
            } else if (forNeed.contains("To Address")) {
                coordinate = "206_206";
            } else if (forNeed.contains("Send")) {
                coordinate = "371_144";
            }
		} else if (deviceID.contains("2866ff7fc6b36e6dcdfad12899b8356d778c160f")) {
			if (forNeed.contains("More Option")) {
				coordinate = "200_264";
			} else if (forNeed.contains("To Address")) {
				coordinate = "206_206";
			} else if (forNeed.contains("Send")) {
				coordinate = "371_144";
			}
		}else if (deviceID.contains("3e0849a554b005cbecd9d72e7adee86f5d150878")) {
			if (forNeed.contains("More Option")) {
				coordinate = "219_341";
			} else if (forNeed.contains("To Address")) {
				coordinate = "200_230";
			} else if (forNeed.contains("Send")) {
				coordinate = "338_165";
			}
		}else if(deviceID.contains("00008101-00116561362B001E")) {
			if (forNeed.contains("More Option")) {
				coordinate = "223_409";
			} else if (forNeed.contains("To Address")) {
				coordinate = "230_230";
			} else if (forNeed.contains("Send")) {
				coordinate = "337_170";
			}
		}else if(deviceID.contains("00008030-000C49C11A7B402E")) {
			if (forNeed.contains("More Option")) {
				coordinate = "223_409";
			} else if (forNeed.contains("To Address")) {
				coordinate = "230_230";
			} else if (forNeed.contains("Send")) {
				coordinate = "337_170";
			}
		}
		return coordinate;
	}

}
