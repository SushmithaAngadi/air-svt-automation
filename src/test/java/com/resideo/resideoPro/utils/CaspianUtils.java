package com.resideo.utils.resideo_app;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.relay.RelayConfiguration;
import com.resideo.utils.resideo_app.screen.CaspianScreen;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.stat.StatCommonCommandUtils;

public class CaspianUtils {

	public static boolean dataSyncProcessAndStatus(TestCases testCase, int UserTimeout) {
		boolean flag = false;
		CaspianScreen caspian = new CaspianScreen(testCase);
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(UserTimeout));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource();
						String status = caspian.getDeviceStatusFromDashboard();
						System.out.println("status from dashboard is " + status);
						if (pageSource.contains("text=\"Not Now\"") || pageSource.contains("Not Now")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not Now");
							SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard(true);
							return false;
						} else if (status!=null && status.toUpperCase().contains("CLOUD CONNECTION ERROR".toUpperCase())) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Data Sync Error, Message in Dashboard is " + status.toUpperCase());
							SystemState.getStatus().isCaspainCloudSynError(true);
							return true;
						} else if (status!=null && status.toUpperCase().contains("SYNCING WITH VALVE")) {
							System.out.println("Data Syncing......");
							return false;
						} else if (status!=null && status.toUpperCase().contains("COULD NOT OPEN")) {
							Keyword.ReportStep_Pass(testCase, "Data Sync completed but Valve couldn't Open");
							SystemState.getStatus().isCaspianCouldNtOpen(true);
							return true;
						} else if (status!=null && status.toUpperCase().contains("OFFLINE SINCE")) {
							Keyword.ReportStep_Pass(testCase, "Data Sync completed but Device is in Offline state");
							SystemState.getStatus().isCaspianOfflineSince(true);
							return true;
						} else if (status!=null && status.toUpperCase().contains("SINCE")) {
							Keyword.ReportStep_Pass(testCase, "Data Sync completed, Device is in Online");
							SystemState.getStatus().isCaspianOnlineSince(true);
							return true;
						} else {
							System.out.println("none of the above");
							return false;
						}

					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + UserTimeout
										+ " minutes");
						return false;
					}
				}

			});

			if (success && SystemState.getStatus().isCaspainCloudSynError()) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Device Status is " + caspian.getDeviceStatusFromDashboard() + ":: Device Messsage is "
								+ caspian.getDeviceMessageFromDashboard() + " . ");
				flag = false;
			} else if (success && (SystemState.getStatus().isCaspianCouldNtOpen()
					|| SystemState.getStatus().isCaspianOfflineSince()
					|| SystemState.getStatus().isCaspianOnlineSince())) {
				Keyword.ReportStep_Pass(testCase, "Device Status is " + caspian.getDeviceStatusFromDashboard()
						+ ":: Device Messsage is " + caspian.getDeviceMessageFromDashboard() + " . ");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"None of the Above check the screenshot");
				flag = false;
			}

		} catch (

		TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + UserTimeout
							+ " minutes");
			return false;
		}

		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard() == false) {
				if (MobileUtils.isMobElementExists("name", "Not Now", testCase, 10)) {
					MobileUtils.clickOnElement(testCase, "name", "Not Now");
					Keyword.ReportStep_Pass(testCase, "Not Now Button popup showed After some delay");
				}
			}
		}

		return flag;

	}

	public static boolean deleteCaspianDeviceFromAccount(TestCases testCase) {
		boolean flag = false;
		CaspianScreen caspianSc = new CaspianScreen(testCase);
		if (caspianSc.isExactDevicePresent()) {
			flag = caspianSc.clickOnExactDeviceName();
		}
		if (caspianSc.isGetStartedScreen()) {
			flag = caspianSc.clickOnGetStartedScreen();
			if (caspianSc.isMaintenanceCycleScreen()) {
				flag = caspianSc.clickOnNextButton();
			}
		}
//		System.out.println(testCase.getMobileDriver().getPageSource());
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (caspianSc.isPrimarycardSettingsButton(7)) {
				flag = caspianSc.clickonSettingButton();
				flag = flag && caspianSc.clickonValveconfigurationButton();
				flag = flag && caspianSc.clickOnDeleteValveButton();
				if (caspianSc.isDeleteValvePopUp()) {
					flag = flag && caspianSc.clickOnDeleteValvePopupButton();
				} else {
					flag = flag && caspianSc.clickOnDeleteValveButton();
					if (caspianSc.isDeleteValvePopUp()) {
						flag = flag && caspianSc.clickOnDeleteValvePopupButton();
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Delete Popup Screen timeout, retried 2 time with 30 second timeout");
						flag = false;
					}
				}
				flag = flag && caspianSc.isDashboardScreen();
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navigate from Primary card to configuration screen, Issue in setting elements");
				flag = false;
			}
		} else {

			if (caspianSc.isPrimarycardSettingsButton(2)) {
				flag = caspianSc.clickonSettingButton();
			} else if (MobileUtils.isMobElementExists("NAME", "action_settings", testCase, 2)) {
				flag = MobileUtils.clickOnElement(testCase, "NAME", "action_settings");
			} else if (MobileUtils.isMobElementExists("NAME", "Settings", testCase, 2)) {
				flag = MobileUtils.clickOnElement(testCase, "NAME", "Settings");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Element identification failed : /n , " + testCase.getMobileDriver().getPageSource());
				flag = false;
			}
			flag = flag && caspianSc.clickonValveconfigurationButton();
			flag = flag && caspianSc.clickOnDeleteValveButton();
			if (caspianSc.isDeleteValvePopUp()) {
				flag = flag && caspianSc.clickOnDeleteValvePopupButton();
			} else {
				flag = flag && caspianSc.clickOnDeleteValveButton();
				if (caspianSc.isDeleteValvePopUp()) {
					flag = flag && caspianSc.clickOnDeleteValvePopupButton();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Delete Popup Screen timeout, retried 2 time with 30 second timeout");
					flag = false;
				}

			}
			flag = flag && caspianSc.isDashboardScreen();
		}
		return flag;
	}

	public static boolean ConnectWithCapianWIFI(TestCases testCase, DIYScreen diy, String methodType) {
		boolean flag = false;
		String deviceName = SystemState.getStatus().getTstatName();
		if (diy.isUseWifiInsteadBtn()) {
			if (diy.clickOnUseWifiInsteadBtn()) {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					if (diy.isOpenWiFiSettingBtn(3)) {
						flag = diy.clickOnOpenWiFiSettingBtn();
						flag = CommonUtils.connectWithDeviceWifiInAndroid(testCase, deviceName, "Connect to the valve");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Open WIfi Settings button Not availble");
						flag = false;
					}
				} else {
					flag = CommonUtils.connectWithDeviceWifiInIOS(testCase, deviceName,
							"com.resideo.acs.lyric.enterprise");
				}
				if (flag && diy.isConnectToValveScreen()) {
					if (methodType.toUpperCase().contains("CATT")) {
						flag = StatCommonCommandUtils.caspianValveButtonCommand(testCase, "SHORT");
					} else {
						flag = RelayConfiguration.CaspianCommandControl(testCase, "CONNECT");
					}
					flag = flag && diy.clickOnNextButton("Clicked On Connect to valve next Button");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to Valve screen Not availble");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"not able to click on Wifi instead button");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Wifi instead Button not visible In Current screen");
			flag = false;

		}

		return flag;
	}

//	public static boolean confirmWifiConfigurationIsCompletedInCaspianwithIdentification(TestCases testCase, DIYScreen diy) {
//		boolean flag = false;
//
//		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//		fWait.pollingEvery(Duration.ofSeconds(1));
//		fWait.withTimeout(Duration.ofMinutes(2));
//		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//			public Boolean apply(Boolean driver) {
//				try {
//					if(testCase.getPlatform().toUpperCase().contains("ANDROID") && diy.isWifiReconfigurationInAndroid()) {
//						Keyword.ReportStep_Pass(testCase, "Wifi Reconnected with Valve Wifi");
//						return false;
//					}else if (diy.isConnectingCaspainToWifi()) {
//						System.out.println("connecting to " + SystemState.getStatus().getTstatName() + " to Wi-Fi...");
//						return false;
//					}
//					if (diy.isRegisteringCaspianDeviceSpinner()) {
//						Keyword.ReportStep_Pass(testCase, "Shows Caspain Device Registering.....");
//						System.out.println("Showing Device Registering.....");
//						return true;
//					} else if (diy.isL5ValveConnectedWithWifiAndRegisteredSucessfully()) {
//						System.out.println("Registered Sucessfully...");
//						Keyword.ReportStep_Pass(testCase, "Registered Sucessfully........");
//						return true;
//					} else if (diy.isCommunicationErrorInCaspian()) {
//						SystemState.getStatus().isCommunicationError(true);
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Communication Error Is Appread");
//						return true;
//					} else {
//						System.out.println("Something new element find");
//						System.out.println(testCase.getMobileDriver().getPageSource());
//						return false;
//					}
//
//				} catch (TimeoutException e) {
//					e.printStackTrace();
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Connecting to Valve : Connecting to valve Timed out while loading. Wait time : 2 minutes");
//					return false;
//				}
//			}
//		});
//
//		if (SystemState.getStatus().isCommunicationError()) {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Communication Error Occured during wifi connection");
//			flag = false;
//		} else if (isEventReceived && !SystemState.getStatus().isCommunicationError()) {
//			flag = true;
//			Keyword.ReportStep_Pass(testCase, "Sucessfully Wifi Configuration completed");
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "During WIFI configuration Error Occured");
//		}
//		return flag;
//	}

	public static boolean confirmWifiConfigurationIsCompletedInCaspian(TestCases testCase, DIYScreen diy) {
		boolean flag = false;

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(2));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String source = testCase.getMobileDriver().getPageSource();
					if (source.contains("Connect to device")) {
						if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Connect']", testCase, 1)) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Connect']");
							return false;
						}
						return false;
					} else if (source.contains("Try again")) {
						MobileUtils.clickOnElement(testCase, "ID", "button2");
						return false;
					} else if (source.contains("Something came up")) {
						MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
						return false;
					} else if (source.contains("Couldn't connect. Check your network connection and try again.")) {
						MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
						return false;
					} else if (source.contains("SETTINGS")) {
						MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='SETTINGS']");
						diy.connectWithThermostatWifiOnAndroidWithAfterCredential(
								SystemState.getStatus().getTstatName(), "Connecting L5 Leak Protection Valve to Wi-Fi");
						return false;
					} else if (diy.isRegisteringCaspianDeviceSpinner()) {
						System.out.println("Showing Device Registering.....");
						return true;
					} else if (diy.isConnectingCaspainToWifi()) {
						System.out.println("Connecting L5 Wi-Fi Water Leak Shutoff Valve to Wi-Fi.....");
						return false;
					} else if (source.toUpperCase()
							.contains("Your L5 Wi-Fi Water Leak Shutoff Valve is now configured and added to your account"
									.toUpperCase())) {
						return true;
					} else if (source.toUpperCase().contains("Wi-Fi Network Error".toUpperCase())) {
						SystemState.getStatus().isWifiError(true);
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "WIfi Error Popup Occured");
						return true;

					} else if (source.toUpperCase().contains("Communication Error".toUpperCase())) {
						System.out.println("Communication Error..");
						SystemState.getStatus().isCommunicationError(true);
						return true;
					} else if (source.toUpperCase().contains("Registration Error".toUpperCase())) {
						System.out.println("Registration Error");
						SystemState.getStatus().setRegError(true);

						return true;
					} else {
//						System.out.println(source);
						return false;
					}
				} catch (TimeoutException e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connecting to Valve : Connecting to valve Timed out while loading. Wait time : 2 minutes");
					return false;
				}
			}
		});

		if (SystemState.getStatus().isCommunicationError()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Communication Error Occured during wifi connection");
			flag = false;
		} else if (isEventReceived && !SystemState.getStatus().isCommunicationError()
				&& !SystemState.getStatus().isWifiError() && !SystemState.getStatus().isRegError()) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Sucessfully Wifi Configuration completed");
		} else if (isEventReceived && SystemState.getStatus().isWifiError()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Wi-Fi Network Error Occured during wifi Configuration");
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().isRegError()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Registration Error Occured during Registration");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "During WIFI configuration Error Occured");
		}
		return flag;
	}

	public static boolean completeRegistrationInCaspian(TestCases testCase, DIYScreen diy) {
		boolean flag = false;

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(2));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String source = testCase.getMobileDriver().getPageSource();
					if (source.toUpperCase()
							.contains("Your L5 Wi-Fi Water Leak Shutoff Valve is now configured and added to your account"
									.toUpperCase())) {
						return true;
					} else if (source.toUpperCase().contains("Registration Error".toUpperCase())) {
						System.out.println("Registration Error");
						SystemState.getStatus().setRegError(true);
						return true;

					} else if (diy.isRegisteringCaspianDeviceSpinner()) {
						System.out.println("Showing Device Registering.....");
						return false;
					} else if (source.toUpperCase().contains("Communication Error".toUpperCase())) {
						System.out.println("Communication Error..");
						SystemState.getStatus().isCommunicationError(true);
						return true;
					} else {
//						System.out.println(source);
						return false;
					}
				} catch (TimeoutException e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connecting to Valve : Connecting to valve Timed out while loading. Wait time : 2 minutes");
					return false;
				}
			}
		});

		if (SystemState.getStatus().isRegError()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Registration Error ");
			flag = false;
		} else if (SystemState.getStatus().isCommunicationError()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Communication Error");
			flag = false;
		} else if (isEventReceived && !SystemState.getStatus().isRegError()) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Sucessfully Wifi Configuration completed");
		} else if (isEventReceived && !SystemState.getStatus().isCommunicationError()) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Sucessfully Wifi Configuration completed");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "During WIFI configuration Error Occured");
		}
		return flag;
	}

}
