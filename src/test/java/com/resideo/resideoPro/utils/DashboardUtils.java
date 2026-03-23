package com.resideo.utils.resideo_app;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.screen.LoginScreen;

public class DashboardUtils {
	public static boolean closeAppLaunchPopups(TestCases testCase) {
		boolean flag = false;
		LoginScreen login = new LoginScreen(testCase);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(2));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						String presentScreenName = login.getPresentScreenName();
						String pageSource = testCase.getMobileDriver().getPageSource();
						if (presentScreenName.contains("intialscreen")) {
							SystemState.getStatus().setLoggedIn(false);
							return true;
						} else if (presentScreenName.contains("dashboard")) {
							SystemState.getStatus().setLoggedIn(true);
							SystemState.getStatus().setDashBoardScreenVisible(true);

							if ((pageSource.contains("XCUIElementTypeCell"))
									|| (presentScreenName.contains("dashboard_withdevice_addnewdevice")))
								SystemState.getStatus().setDeviceShownOnDashboard(true);
							else
								SystemState.getStatus().setDeviceShownOnDashboard(false);

							if (pageSource.contains("dashboard_add_device")
									|| presentScreenName.contains("dashboard_withdevice_addnewdevice"))
								SystemState.getStatus().setAddNewDeviceButtonVisible(true);
							else if(pageSource.contains("rebates_available")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@resource-id='com.resideo.android.lyric:id/close_btn']");
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@resource-id='android:id/button1']");
							}
							else
								SystemState.getStatus().setAddNewDeviceButtonVisible(false);
							return true;
						} else if ((pageSource.contains("value=\"Add New Device\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) ||(pageSource.contains("name=\"Add New Device\"")
										&& testCase.getPlatform().toUpperCase().contains("IOS")) ) {
							SystemState.getStatus().setAddNewDeviceScreenVisible(true);
							SystemState.getStatus().setLoggedIn(true);

							return true;
						} else if (pageSource.contains("com.resideo.android.lyric:id/btn_positive_got_it")) {
							MobileUtils.clickOnElement(testCase, "id", "btn_positive_got_it");
							return false;
						} else if (pageSource.contains("com.android.packageinstaller:id/permission_allow_button")) {
							MobileUtils.clickOnElement(testCase, "id",
									"com.android.packageinstaller:id/permission_allow_button");
							return false;
						} else if (pageSource.contains("name=\"OK\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "OK");
							return false;
						} else if (pageSource.contains("name=\"Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Allow");
							return false;
						} else if (pageSource.contains("name=\"Always Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Always Allow");
							return false;
						} else if (pageSource.contains("name=\"Next\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Next");
							return false;
						} else if (pageSource.contains("name=\"Done\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Done");
							return false;
						} else if (pageSource.contains("btn_close")) {
							MobileUtils.clickOnElement(testCase, "id", "btn_close");
							return false;
						} else if (pageSource.contains("text=\"Ignore\"") || pageSource.contains("name=\"Ignore\"")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='Ignore']");
							else
								MobileUtils.clickOnElement(testCase, "name", "Ignore");

							return false;
						} else if (pageSource.contains("com.resideo.android.lyric:id/rebates_available")) {
							MobileUtils.clickOnElement(testCase, "XPATH",
									"//*[@resource-id='com.resideo.android.lyric:id/close_btn']");
							return false;
						}

						////////////////////////// ios Not
						////////////////////////// nOW/////////////////////////////////////
						else if (pageSource.contains("text=\"Not Now\"") || pageSource.contains("name=\"Not Now\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not Now");

							return false;
						} else if (pageSource.contains("text=\"Not now\"") || pageSource.contains("name=\"Not now\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not now");

							return false;
						} else if (pageSource.contains("text=\"NOT NOW\"") || pageSource.contains("name=\"NOT NOW\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "NOT NOW");

							return false;

							/////////////// passcode///////////////
						} else if (pageSource.contains("Please enter your Honeywell Home App passcode")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"(//XCUIElementTypeSecureTextField)[1]", "1470");
								if (MobileUtils.isMobElementExists("NAME", "Invalid Passcode", testCase))
									MobileUtils.clickOnElement(testCase, "NAME", "Forgot?");

								return false;
							} else {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
//								if (MobileUtils.isMobElementExists("ID", "security_pin_forgot_pin_tv", testCase))
//									MobileUtils.clickOnElement(testCase, "ID", "security_pin_forgot_pin_tv");
								return false;
							}

						}else if (pageSource.contains("Validation Error")) {
						 MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
						 Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Honeywell Home App PassCode validation Error Occured");
						 return false;
						}

						else if (pageSource.contains("Create a Passcode")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"(//XCUIElementTypeSecureTextField)[1]", "1470");
								if (MobileUtils.isMobElementExists("NAME", "Verify Passcode", testCase))
									MobileUtils.setValueToElement(testCase, "XPATH",
											"(//XCUIElementTypeSecureTextField)[1]", "1470");
								return false;
							} else {
//								MobileUtils.setValueToElement(testCase, "XPATH", "//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", testCase))
									MobileUtils.setValueToElement(testCase, "XPATH",
											"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
								return false;
							}
						} else if (pageSource.contains("Add Fingerprint Unlock")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='NO']");
							return false;
						}
						///////////////////////////////////////////////////////////////
						else if (pageSource.contains("hh_intro_skip_textview")) {
							MobileUtils.clickOnElement(testCase, "id", "hh_intro_skip_textview");
							return false;
						} else if (pageSource.contains("text=\"Honeywell Unexpectedly Quit\"")
								|| pageSource.contains("Honeywell Unexpectedly Quit")
								|| pageSource.contains("SEND REPORT") || pageSource.contains("DON'TSEND")
								|| pageSource.contains("ALWAYS SEND") || pageSource.contains("text=\"Always Send\"")
								|| pageSource.contains("text=\"ALWAYS SEND\"")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"App crashed due to 'Honeywell Unexpectedly Quit'");
							MobileUtils.clickOnElement(testCase, "xpath",
									"//*[@text='ALWAYS SEND' or @text='Always Send']");
							return false;
						} else {
//							if (testCase.getPlatform().toUpperCase().contains("IOS"))
//								((CustomIOSDriver) testCase.getMobileDriver()).switchTo().alert().dismiss();

							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			});

			if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "App Popups are closed");
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Login To Lyric : Closing App Popups failed");
			}

		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups Timed out while loading. Wait time : 2 minutes");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups error Occured : " + e.getMessage());
		}

		return flag;
	}

//	public static boolean clickOnDeviceInDashboard(TestCases testCase, String deviceName) {
//		
//	}

//public static boolean isDatasyncCompletedCheckInDashboard(TestCases testCase) {
//	boolean flag = false;
//	DashboardScreen db = new DashboardScreen(testCase);
//String deviceName = SystemState.getStatus().getTstatName();
//	try {
//		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//		fWait.pollingEvery(Duration.ofSeconds(2));
//		fWait.withTimeout(Duration.ofMinutes(2));
//		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//			public Boolean apply(Boolean flag) {
//				try {
//					String getstatus = db.getDevicestatus(deviceName);
//					if(getstatus) {
//						
//					}
//					if(getstatus.toUpperCase().contains("OFFLINE")) {
//						
//					}else if(getstatus.toUpperCase().contains("TROUBLESHOOT")) {
//						
//					}else if(getstatus.contains("ERROR")) {
//						
//					}else if()
//					
//					
//					
//				}catch (Exception e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Excepton Occured due to "+e.getMessage());
//					return false;
//				}
//	
//	
//	
//	
//	return flag;
//}
	
	
//	public static boolean deleteCaspianValve(TestCases testCase) {
//		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//		fWait.pollingEvery(Duration.ofSeconds(2));
//		fWait.withTimeout(Duration.ofMinutes(2));
//		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//			public Boolean apply(Boolean flag) {
//				try {
//					String src = testCase.getMobileDriver().getPageSource();
//					if(src.toUpperCase().contains("Welcome to your new water valve".toUpperCase())) {
//					
//					}
//					
//				
//					
//				}catch (Exception e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Excepton Occured due to "+e.getMessage());
//					return false;
//				}
//			}
//		
//	});
//		
//		
//		
//	}

}
