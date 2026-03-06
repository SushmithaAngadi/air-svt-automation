package com.resideo.utils.resideoPro_app.screen;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.collect.ImmutableMap;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomAndroidDriver;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg.PairingPinMode;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.appium.java_client.android.AndroidDriver;

public class ReziDIYScreen extends MobileScreens {

	private static final String screenName = "ReziDIYScreen";

	public ReziDIYScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean clickOnReisdeoProloginButton() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginToResideoProNonProd", 10)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "LoginToResideoProNonProd");
		} else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginToResideoProProdcution", 10)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "LoginToResideoProProdcution");
		} else {
			Keyword.ReportStep_Fail(testCase, 0,
					"Testcase failed the element is not matching with definition, pls check the login screen");
			return false;
		}
	}

	public boolean setEmailAddressInLogin(String userName) {
		return MobileUtils.setValueToElement(objectDefinition, testCase, "SIgnEmailTextBox", userName);
	}

	public boolean setSignPassword(String password) {
		return MobileUtils.setValueToElement(objectDefinition, testCase, "SignPasswordTextBox", password);
	}

	public boolean clickOnSignINButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
		} else {
			if (MobileUtils.isMobElementExists("name", "Done", testCase, 2)) {
				MobileUtils.clickOnElement(testCase, "name", "Done");
				return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
			} else {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
			}
		}
	}

	public boolean clickOnHomeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeButton");
	}

	public boolean clickOnCustomersButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CustomersButton");
	}

	public boolean clickOnSupportButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SupportButton");
	}

	public boolean clickOnSetupSettingsButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SetupSettingsButton");
	}

	public boolean clickOnSetupProductButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SetupProductButton");
	}

	public boolean clickOnT5T6Thermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T5T6Thermostat");
	}

	public boolean clickOnT9T10Thermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T9T10Thermostat");
	}

	public boolean clickOnAllowWhileUsingTheAppButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AllowWhileUsingTheAppButton");
	}

	public boolean clickOnAllowOnlyThisTimeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AllowOnlyThisTimeButton");
	}

	public boolean clickOnDenyLocationAccessButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DenyLocationAccessButton");
	}

	public boolean clickOnNextButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
	}

	public boolean clickOnFinishButton(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FinishButton", message);
	}

	public boolean clickOnPreviousButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "PreviousButton");
	}

	public boolean clickOnBackButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackButton");
	}

	public boolean clickOnCancelButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButton");
	}

	public boolean clickOnYesButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
	}

	public boolean clickOnNoButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
	}

	public boolean clickOnOpenWIFISettingsButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OpenWIFISettingsButton");
	}

	public boolean clickOnOkButton(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OkButton", message);
	}

	public boolean clickOnOkButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OkButton");
	}

	public String getFullMacId() {
		String_Msg macId = StatCommands.getInstance().cattCommandsStub
				.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build());
		String FullMacId = macId.getStrVal().toString();
		String DerivedMacID = "";
		String concat = "";
		try {
			if (FullMacId.length() % 2 == 0) {
				String[] split = FullMacId.split(String.format("(?<=\\G.{%1$d})", 2));
				for (int i = 0; i < split.length; i++) {
					if (i < split.length - 1) {
						concat = split[i].concat(":");
					} else {
						concat = split[i];
					}
					DerivedMacID = DerivedMacID + concat;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Mac ID from GRPC Server :" + FullMacId);
			}
			SystemState.getStatus().macIDName(DerivedMacID);
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured " + e.getLocalizedMessage() + "Thermostat full macid = " + FullMacId);
		}
		return DerivedMacID;

	}

	public String getjasperThermostatNameForWifiConnect() {
		String StatName = null;
		String initialname = null;
		try {
			initialname = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal();

			String macID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();

			String[] initialna = initialname.split(" ");

			String initialLetter = initialna[0].substring(0, 1).toUpperCase();
			String remLetter = initialna[0].substring(1).toLowerCase();
			String substring = macID.substring(6, 12);
			StatName = initialLetter + remLetter + " " + substring;
			Keyword.ReportStep_Pass(testCase, "Broadcasted Thermostat Wi-Fi name is " + StatName);
			System.out.println(StatName);
			SystemState.getStatus().setTstatName(StatName);
		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Message shown in Thermostat " + initialname);
		}
		return StatName;
	}

	public String getMacIDSubstring() {
		String macID = StatCommands.getInstance().cattCommandsStub
				.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();
		return macID.substring(6, 12);

	}

	public String getResideoProMacId_ble() {
		String macID = StatCommands.getInstance().cattCommandsStub
				.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();

		String finalMac = "";
		String[] arrayMacID = macID.split("(?<=\\G.{2})");

		for (int i = 0; i < arrayMacID.length; i++) {
			if (i == 0) {
				finalMac = finalMac + arrayMacID[i];
//			} else if (i > array.length) {
//				String string = array[i];
//				System.out.println(string);
//				de = de + array[i];
			} else {
				finalMac = finalMac + ":" + arrayMacID[i];
			}
		}

		System.out.println(finalMac);

		return finalMac;
//		return macID.substring(6, 12);

	}

	public boolean clickOnParticularDiscoveredDevice(String macname) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@content-desc,'" + macname + "')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + macname + "')]");
		}
	}

	public String getDeviceName() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.getMobElement(testCase, "XPATH",
					"//android.view.View[@content-desc='Discovered Devices']/following-sibling::android.view.View//android.widget.ImageView")
					.getAttribute("content-desc").toUpperCase().contains("LYRIC")) {
				return "Lyric";
			} else if (MobileUtils.getMobElement(testCase, "XPATH",
					"//android.view.View[@content-desc='Discovered Devices']/following-sibling::android.view.View//android.widget.ImageView")
					.getAttribute("content-desc").toUpperCase().contains("TSTAT")) {
				return "Tstat";
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Lyric or Tstat not availble in List");
				return null;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Need to implement for IOS");
			return null;
		}
	}

	public boolean SelectBLEDevicefromBluetooth() {
////		String shortMacIdName = getjasperThermostatNameForWifiConnect();
////		String fullMacId = getFullMacId();
////		String MacID = getMacIDSubstring();
		String MacID = getResideoProMacId_ble();
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(3));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (isSearchingForBluetoothDeviceSpining()) {
							return false;
//						} else if (isBLEDeviceIsPresent(getDeviceName() + " " + MacID)) {
////							return true;
						} else if (isBLEDeviceIsPresent(MacID)) {
							return true;
						} else {
							System.out.println("Searching device .....");
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to login or might need to check the app flow");
						return false;
					}
				}
			});

			if (success) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "SucessFully Identificed stat maci ID in discovered Devices screen");
			} else {
				flag = false;
			}

		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Ble not able to identify exact mac ID");
			flag = false;
		}
////		flag = clickOnParticularDiscoveredDevice(getDeviceName() + " " + MacID);
		flag = clickOnParticularDiscoveredDevice(MacID);
		if (flag) {
			try {
				Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {

					public Boolean apply(CustomDriver driver) {
						try {
							if (isConnectingToThermostatSpinning()) {
								return false;
							} else if (isErrorOccuredDuringBLEDeviceConnecting()) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to connect with Thermostat BLE ");
								SystemState.getStatus().isBleErrorConnectingtoThermostat(true);
								clickOnOkButton();
								return true;
							} else if (isSecurityCodeScreen()) {
								return true;
							} else {
								return false;
							}
						} catch (StaleElementReferenceException e) {
							Keyword.ReportStep_Pass(testCase,
									"Stale element reference exceotion, skipping for retry..");
							return false;
						} catch (TimeoutException e) {
							Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
							return false;
						} catch (StackOverflowError e) {
							Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
							return false;
						} catch (NoSuchElementException e) {
							Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
							return false;
						} catch (Exception e) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Ble not able to identify exact mac ID");
							return false;
						}
					}
				});

				if (success && !SystemState.getStatus().isBleErrorConnectingtoThermostat()) {
					flag = true;
					Keyword.ReportStep_Pass(testCase,
							"SucessFully Identificed stat maci ID in discovered Devices screen");
				} else {
					flag = false;
				}

			} catch (StaleElementReferenceException e) {
				Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
				flag = false;
			} catch (TimeoutException e) {
				Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
				flag = false;
			} catch (StackOverflowError e) {
				Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
				flag = false;
			} catch (NoSuchElementException e) {
				Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
				flag = false;
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Ble not able to identify exact mac ID");
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean isInitialPairingSuccess() {
		boolean flag = false;
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(3));
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {

				public Boolean apply(CustomDriver driver) {
					try {
						if (isConnectingToThermostatSpinning()) {
							return false;
						} else if (isErrorOccuredDuringBLEDeviceConnecting()) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to connect with Thermostat BLE ");
							SystemState.getStatus().isBleErrorConnectingtoThermostat(true);
							clickOnOkButton();
							return true;
						} else if (isSecurityCodeScreen()) {
							return true;
						} else {
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exception, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Security Code screen issue");
						return false;
					}
				}
			});

			if (success && !SystemState.getStatus().isBleErrorConnectingtoThermostat()) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "SucessFully Identificed stat maci ID in discovered Devices screen");
			} else {
				flag = false;
			}

		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exception, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to login or might need to check the app flow");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			flag = false;
		}
		return flag;
	}
	
	public boolean isInitialPairingSuccess(Duration duration) {
		boolean flag = false;
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofMillis(500));
			fWait.withTimeout(duration);
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {

				public Boolean apply(CustomDriver driver) {
					try {
						if (isConnectingToThermostatSpinning()) {
							return false;
						} else if (isErrorOccuredDuringBLEDeviceConnecting()) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to connect with Thermostat BLE ");
							SystemState.getStatus().isBleErrorConnectingtoThermostat(true);
							return true;
						} else if (isSecurityCodeScreen(1)) {
							return true;
						} else {
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exception, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase,"Exception Occured "+e.getMessage());
						return false;
					}
				}
			});

			if (success && !SystemState.getStatus().isBleErrorConnectingtoThermostat()) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "SucessFully Identificed stat maci ID in discovered Devices screen");
			} else {
				flag = false;
			}

		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exception, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase,"Exception Occured "+e.getMessage());
			flag = false;
		}
		SystemState.getStatus().isBleErrorConnectingtoThermostat(false);
		return flag;
	}

	public boolean clickOnDiagnostics() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "Diagnostics",
				"Sucessfully clicked on Diagnostics");
	}

	public boolean clickOnCustomerInfo() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CustomerInfo",
				"Sucessfully clicked on Customer Info");
	}

	public boolean clickOnAdvanceSettings() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AdvanceSettings",
				"Sucessfully clicked on Advenced Settings");
	}

	public boolean clickOnAddCustomerButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddCustomerButton",
				"Sucessfully clicked on Customer Button");
	}

	public String getValueinCyclePerHourStage() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "GetCyclePerHourValue")
					.getAttribute("content-desc").replace("°", "");
		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Need to implement for IOS");
			return MobileUtils.getMobElement(objectDefinition, testCase, "GetCyclePerHourValue").getAttribute("label")
					.replace("°", "");
		}
	}

	public boolean clickOnCyclePerHourStageIncreaseButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CyclePerHourStageIncreaseButton");
	}

	public boolean ClickOnDecreaseDownButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DecreaseDownButton");
	}

	public boolean ClickOnIncreaseUpButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "IncreaseUpButton");
	}

	public boolean clickOnCyclePerHourStageDecreaseButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CyclePerHourStageDecreaseButton");
	}

	public boolean set4_DigitPin() {
		boolean flag = false;

		String deviceNeedToInstall = null;
		char[] pinFromThermostat = null;
		try {
			deviceNeedToInstall = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in set4_DigitPin() due to " + e.getMessage());
			flag = false;
		}
		if (isSecurityCodeScreen()) {
			pinFromThermostat = getPinFromThermostat(deviceNeedToInstall);
			List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase,
					"SecurityCode4DigitPin");
			for (int i = 0; i < mobElements.size(); i++) {
				Actions a = new Actions(testCase.getMobileDriver());
		        a.sendKeys(String.valueOf(pinFromThermostat[i]));
		        a.perform();
				flag = true;
			}
		}
		if (flag) {
			flag = clickOnOkButton();
			SystemState.getStatus().pairingStartTime(System.currentTimeMillis() / 1000);
			Keyword.ReportStep_Pass(testCase,"Pairing completed, current time stamp is "+SystemState.getStatus().pairingStartTime());
			Keyword.ReportStep_Pass(testCase,
					"Sucessfully set pin into mobile the 4Digit pins are <<< " + pinFromThermostat[0]
							+ pinFromThermostat[1] + pinFromThermostat[2] + pinFromThermostat[3] + " >>>");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enter pin in APP");
		}
		return flag;
	}
	
	public void sendKeyToSecurity(char[] pinFromThermostat) {
		try {
			List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase,
					"SecurityCode4DigitPin");
			for (int i = 0; i < mobElements.size(); i++) {
				mobElements.get(i).click();
//				testCase.getMobileDriver().executeScript("mobile: performEditorAction", ImmutableMap.of("action", String.valueOf(pinFromThermostat[i])));
//			
				Actions a = new Actions(testCase.getMobileDriver());
		        a.sendKeys(String.valueOf(pinFromThermostat[i]));
		        a.perform();
//		    	flag = true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

//	public char[] getPinFromThermostat() {
//		String pin = "";
//		int i = 5;
//		do {
////			pin = StatCommands.getInstance().cattCommandsStub
////					.getPairingPin(PairingPinMsg.newBuilder().setPinMode(PairingPinMode.RADIO).build()).getStrVal();
//			pin = StatCommands.getInstance().cattCommandsStub.getPairingPin(PairingPinMsg.newBuilder().build())
//					.getStrVal();
//
//			if (i <= 0)
//				break;
//
//			i--;
//
//		} while (pin.equals("") || pin.toUpperCase().contains("INVALID"));
//
//		SystemState.getStatus().setPreviousPin(pin);
//		return pin.toCharArray();
//	}

	public boolean clickOnDisconnectAndInviteButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DisconnectAndInviteButton");
	}

	
	public boolean isExpectedScreen(TestCases testCase, String expectedtext) {
		boolean flag = false;
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(1));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						String screename = getPageContain(pageSource);
						if (screename.toUpperCase().contains(expectedtext.toUpperCase())) {
							Keyword.ReportStep_Pass(testCase,
									"Expected screen appeared, Screen name is " + expectedtext);
							return true;
						} else {
//							System.out.println("Current status is " + screename);
							return false;
						}

					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to login or might need to check the app flow");
						return false;
					}
				}
			});
			if (isEventReceived) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to find expected screen");
				flag = false;
			}

		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to login or might need to check the app flow");
			flag = false;
		}
		return flag;
	}

	public String getPageContain(String src) {
		String screenName = null;
//		System.out.println(src);
		if (src.contains("Settings".toUpperCase()) && src.contains("AN360 Account".toUpperCase())
				&& src.contains("Resideo Pro Account".toUpperCase())
				&& src.contains("How to create an account".toUpperCase()) && !src.contains(
						"NAME=\"SETTINGS\" LABEL=\"SETTINGS\" ENABLED=\"TRUE\" VISIBLE=\"FALSE\"".toUpperCase())) {
			screenName = "main screen";
		} else if (src.contains("Email".toUpperCase()) && src.contains("Password".toUpperCase())
				&& src.contains("SIGN IN".toUpperCase()) && src.contains("Forgot password".toUpperCase())) {

			screenName = "sign in screen";

		} else if (src.contains("Hello".toUpperCase()) && src.contains("Send Feedback".toUpperCase())
				&& src.contains("Settings".toUpperCase()) && src.contains("Set Up Product".toUpperCase())
				&& src.contains("Customers".toUpperCase())) {

			screenName = "dashboard";

		} else if (src.contains("Set Up Product".toUpperCase()) && src.contains("Thermostat".toUpperCase())
				&& src.contains("Pro Security Panel".toUpperCase())) {
			screenName = "product list";
		} else if (src.contains("Log Out".toUpperCase()) && src.contains("Version".toUpperCase())
				&& src.contains("Send Logs".toUpperCase())) {
			screenName = "settings";
		} else {
			screenName = "unknown";
		}

		return screenName;
	}

	public char[] getPinFromThermostat(String deviceModel) {
		String pin = "";
		String finalPin = "";
		int total = 10;
		String Counter = "";
		String previousPin = SystemState.getStatus().getPreviousPin();
		for (int i = 0; i <= total; i++) {

			if (deviceModel.contains("JASPER")) {
				pin = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.Numbers).build())
						.getStrVal().toString().trim().toUpperCase().replace(" ", "").trim();
			} else {
				pin = StatCommands.getInstance().cattCommandsStub
						.getPairingPin(PairingPinMsg.newBuilder().setPinMode(PairingPinMode.RADIO).build()).getStrVal();
			}

//			System.out.println("Current Pin is " + pin);
//			System.out.println("Previous Pin is " + previousPin);
			if (pin.equals("") || pin.toUpperCase().contains("INVALID")) {

				System.out.println("Retry Pin, Pin is:: " + pin);
			} else if (!SystemState.getStatus().getPreviousPin().isEmpty() && previousPin.contains(pin)) {
				System.out.println("Same pin Found, Retry Pin, Pin is:: " + pin);
			} else {
				if (i == 4 || i == 8) {
					Counter = pin;
				} else if (Counter.contains(pin) && (!pin.isEmpty())) {
					finalPin = pin;
					System.out.println(finalPin);
					SystemState.getStatus().setPreviousPin(finalPin);
					break;
				}
			}
		}

		return finalPin.toCharArray();
	}

	public boolean clickOnConfiguration() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ConfigurationButton",
				"Sucessfully clicked on Configuration in Thermostat connected screen ");
	}

	public String getISUTitle() {
		String getattribute = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
			getattribute = "text";
		else
			getattribute = "label";

		return MobileUtils.getAttribute(testCase, objectDefinition, "", getattribute);

	}

	public boolean ISUOutDoorSensor(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorNo");
		}
		case "WIRED": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorWired");
		}
		case "INTERNET": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorInternet");
		}
		default:
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available in OutDoor Air Sensor, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}

	}

	public boolean ISUHeatingSystem(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "CONVENTIONAL FORCED AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalForcedAir");
		}
		case "HEAT PUMP": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPump");
		}
		case "BOILER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Boiler");
		}
		case "NONE COOL ONLY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneCoolOnly");
		}
		default:
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
	}

	public boolean ISUFuelSource(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "GAS STANDARD EFFICIENCY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasStandardEfficiency");
		}
		case "GAS HIGH EFFICIENCY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasHighEfficiency");
		}
		case "OIL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalOil");
		}
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalElectric");
		}
		case "HOT WATER FAN COIL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalHotWaterFanCoil");
		}
		case "AIR TO AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpAirToAir");
		}
		case "GEOTHERMAL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpGeothermal");
		}
		case "HOT WATER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerHotWater");
		}
		case "STEAM": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerSteam");
		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available For Fuel Source System, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
		}
	}

	public boolean setCyclePerHourForStage(String ISUValue, int maxLimit) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= maxLimit) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed " + String.valueOf(maxLimit)
								+ ", User entered value is : " + ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUIndoorSensor(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "NONE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensorNone");
		}
		case "INDOOR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensorInDoor");
		}
		default:
			return false;
		}
	}

	public boolean ISUIndoorSensorType(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "10K": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensor10K");
		}
		case "20K": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensor20K");
		}
		default:
			return false;
		}
	}

	public boolean ISUTemperatureSensorSelection(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "AVERAGE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorAverage");
		}
		case "THERMOSTAT ONLY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorThermostatOnly");
		}
		case "WIRED ONLY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorWiredOnly");
		}
		default:
			return false;
		}
	}

	public boolean ISUVentilationType(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NONE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypeNone");
		}
		case "ERV_HRV": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypeERVHRV");
		}
		case "PASSIVE(FAN ONLY)": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypePassiveFanOnly");
		}
		case "FRESH AIR DAMPER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentailationTypeFreshAirDamper");
		}
		default:
			return false;
		}
	}

	public boolean ISUCooling_HeatingStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NONE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "StageNone");
		}
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
		}
		default:
			return false;
		}

	}

	public boolean ISUCompressorStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
		}
		default:
			return false;
		}
	}

	public boolean ISUVentilationControlMethod(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ASHRAE 2010": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodASHRAE2010");
		}
		case "ASHRAE 2013": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodASHRAE2013");
		}
		case "PERCENT ON TIME": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodPercentOnTime");
		}

		default:
			return false;
		}
	}

	public boolean ISUVentilationFanControl(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "THERMOSTAT CONTROL FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationFanControlThermostatControlsFan");
		}
		case "EQUIPMENT CONTROL FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationFanControlEquipmentControlsFan");
		}
		default:
			return false;
		}
	}

	public boolean ISUSchedulingOptions(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO SCHEDULE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SchedulingOptionsNoschedule");
		}
		case "ALL DAYS SAME": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SchedulingOptionsAlldayssame");
		}
		case "MON TO FRI AND SAT TO SUN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SchedulingOptionsMondayToFridayAndSatToSun");
		}
		case "MON TO FRI AND SAT AND SUN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SchedulingOptionsMonToFriAndSatAndSUn");
		}
		case "INDIVIDUAL DAYS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SchedulingOptionsIndividualsDays");
		}
		default:
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
	}

	public boolean ISUNumberOfBedrooms(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 6) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUSizeOfHouse(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
			if ((Integer.valueOf(ISUValue) <= 5000) && (Integer.valueOf(ISUValue) >= 1000)
					&& (Integer.valueOf(ISUValue) % 100 == 0)) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUVentilationRate(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
			if ((Integer.valueOf(ISUValue) <= 350) && (Integer.valueOf(ISUValue) >= 30)
					&& (Integer.valueOf(ISUValue) % 5 == 0)) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinSecondTextFromUpandDownBetween());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUVentilationPriority(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "LOCKOUTS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationPriorityLockouts");
		}
		case "ASHRAE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationPriorityASHRAE");
		}
		default:
			return false;
		}
	}

	public boolean ISUVentilationLowTemperatureLockout(String ISUValue) {
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			return true;
		} else if (ISUValue.toUpperCase().contains("OFF")) {
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.NO_FAILURE, "NEED TO IMPLEMENT");
			return false;
		}
	}

	public boolean ISUVentilationHighTemperatureLockout(String ISUValue) {
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			return true;
		} else if (ISUValue.toUpperCase().contains("OFF")) {
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.NO_FAILURE, "NEED TO IMPLEMENT");
			return false;
		}
	}

	public boolean ISUVentilationHighDewPointLockout(String ISUValue) {
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			return true;
		} else if (ISUValue.toUpperCase().contains("OFF")) {
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.NO_FAILURE, "NEED TO IMPLEMENT");
			return false;
		}
	}

	public boolean ISUVentilationPercentOnTIme(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if ((Integer.valueOf(ISUValue) <= 100) && (Integer.valueOf(ISUValue) >= 10)
					&& (Integer.valueOf(ISUValue) % 10 == 0)) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUFanOperationInHeat(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "EQUIPMENT CONTROLS FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FanOperationinHeatEquipmentControlsFan");
		}
		case "THERMOSTAT CONTROLS FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FanOperationinHeatThermostatControlsFan");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUReversingValve(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "REVERSING VALVE O OB ON COOL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnCool");
		}
		case "REVERSING VALVE B OB ON HEAT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnHeat");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUAUXPerE_TerminalControl(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "DRIVE BOTH AUX AND E TOGETHER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxETerminalControlDriveBothAuxE");
		}
		case "AUX AND E ARE INDEPENDENT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxETerminalControlDriveAuxEIndependent");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUBackupHeat(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ELECTRIC FORCED":
		case "ELECTRIC FORCED AIR":
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatElectric");
		}
		case "STANDARD EFFICIENCY GAS FORCED AIR":
		case "GAS FORCED AIR":
		case "GAS STANDARD": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatGasOilForcedAir");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUBackUpHeatDroop(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage().replace("°", ""));
			if (Integer.valueOf(ISUValue) <= 15) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage().replace("°", ""));
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage().replace("°", ""));
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUBackUpHeatUpStageTimer(String ISUValue) {
		boolean flag = true;
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			flag = true;
			break;
		}
		case "DEFAULT": {
			flag = true;
			break;
		}
		default: {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.NO_FAILURE, "Need to implement scroll method for Selecting");
			break;
		}
		}
		return flag;
	}

	public boolean ISUCompressorLockout(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else if (ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase())) {
			flag = true;
		} else {
			if (ISUValue.toUpperCase().contains("OFF")) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else if ((Integer.valueOf(ISUValue) % 5 == 0) && (Integer.valueOf(ISUValue) <= 60)) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should be divisible by 5 and should not be exceed 60, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUOutdoorHeatLockout(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else if (ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase())) {
			flag = true;
		} else {
			if (ISUValue.toUpperCase().contains("OFF")) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else if ((Integer.valueOf(ISUValue) % 5 == 0) && (Integer.valueOf(ISUValue) <= 65)) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should be divisible by 5 and should not be exceed 65, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUBackUpHeatLockout(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else if (ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase())) {
			flag = true;
		} else {
			if (ISUValue.toUpperCase().contains("OFF")) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else if ((Integer.valueOf(ISUValue) % 5 == 0) && (Integer.valueOf(ISUValue) <= 65)) {
				while (!(ISUValue.toUpperCase().contains(getValueinCyclePerHourStage().toUpperCase()))) {
					flag = clickOnCyclePerHourStageIncreaseButton();
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should be divisible by 5 and should not be exceed 65, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUExternalFossilFuelKit(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "THERMOSTAT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ExternalFossilFuelKitThermostat");
		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ExternalFossilFuelKitBtton");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUCompressorCyclesPerHour_Stage(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 6) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUBackUpHeatCyclePerHour(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 12) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUEmergencyHeat(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatElectric");
		}
		case "GAS STANDARD": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatGasStandard");
		}
		case "GAS OR OIL-FORCED AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatGasOilForcedAir");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUBackUPHeatStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStages1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStages2");
		}
		case "NONE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStagesNone");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUEmergencyHeatCyclePerHour(String ISUValue, int maxLimit) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= maxLimit) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 6, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUMaximumCoolSetPoint(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 99 || Integer.valueOf(ISUValue) >= 50) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 50 to 99, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUMinimumCoolSetPoint(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 90 || Integer.valueOf(ISUValue) >= 50) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 50 to 90, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUMaximumHeatSetPoint(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 99 || Integer.valueOf(ISUValue) >= 50) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 50 to 90, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUMinimumHeatSetPoint(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 90 || Integer.valueOf(ISUValue) >= 40) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 40 to 90, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUTemperatureScale(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "FAHRENHEIT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureScaleFahrenheit");
		}
		case "CELSIUS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureScaleCelsius");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUSystemChangeOver(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "MANUAL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemChangeOverManual");
		}
		case "AUTOMATIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemChangeOverAutomatic");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUFinishWithHighCoolStage(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FinishWithHighCoolStageNo");
		}
		case "YES": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FinishWithHighCoolStageYes");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUFinishWithHighHeatStage(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FinishWithHighHeatStageNo");
		}
		case "YES": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FinishWithHighHeatStageYes");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUCompressorMinimumOffTime(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 5) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 5, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUExtendedFanRunTimeInCool(String ISUValue) {
		if (ISUValue.contains("DEFAULT")) {
			return true;
		} else {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "listButton")) {
				switch (ISUValue.toUpperCase()) {
				case "OFF": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInCoolOff");
				}
				case "90 SECONDS": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInCool90Seconds");
				}
				case "4 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInCool4Minutes");
				}
				case "7 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInCool7Minutes");
				}
				case "10 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInCool10Minutes");
				}

				default: {
					return false;
				}
				}
			} else {
				return false;
			}
		}
	}

	public boolean ISUExtendedFanRunTimeInHeat(String ISUValue) {
		if (ISUValue.contains("DEFAULT")) {
			return true;
		} else {
			if (MobileUtils.clickOnElement(objectDefinition, testCase, "listButton")) {
				switch (ISUValue.toUpperCase()) {
				case "OFF": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeatOff");
				}
				case "90 SECONDS": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeat90Seconds");
				}
				case "4 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeat4Minutes");
				}
				case "7 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeat7Minutes");
				}
				case "10 MINUTES": {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeat10Minutes");
				}

				default: {
					return false;
				}
				}
			} else {
				return false;
			}
		}
	}

	public boolean ISUAdaptiveIntelligentRecovery(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AdaptiveIntelligentRecoveryNo");
		}
		case "YES": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AdaptiveIntelligentRecoveryYes");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUNumberOfAirFilters(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilter1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilter2");
		}
		case "0": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilter0");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUHumidifierPadReplacementReminder(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HumdifierPadReplacementReminderOff");
		}
		case "6 MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase,
					"HumdifierPadReplacementReminder6CalenderMonths");
		}
		case "12 MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase,
					"HumdifierPadReplacementReminder12calendarMonths");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUUVBulbReplacementReminder(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVBulbReplacementReminderOff");
		}
		case "6 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVBulbReplacementReminder6CalenderMonths");
		}
		case "12 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVBulbReplacementReminder12calendarMonths");
		}
		case "24 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVBulbReplacementReminder24CalendarMonths");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUStagingControlHighCoolStage(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
		}
		case "YES": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUAutoChangeoverDifferential(String ISUValue) {
		boolean flag = false;
		String isuValue = ISUValue.toUpperCase();
		if (isuValue.contains("DEG")) {
			isuValue = isuValue.split("DEG")[0];
		}
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else if (!ISUValue.contains("DEFAULT")) {
			if (clickOnISUDropDownButton()) {
				if (Integer.valueOf(isuValue) >= 0 && Integer.valueOf(isuValue) <= 5) {
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						flag = MobileUtils.isMobElementExists("XPATH",
								"//android.view.View[contains(@content-desc,'" + isuValue + "')]", testCase, 3);
						flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
								"//android.view.View[contains(@content-desc,'" + isuValue + "')]");
					} else {
						flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + isuValue + "')]",
								testCase, 3);
						flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
								"//*[contains(@name,'" + isuValue + "')]");
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
							"User Entered ISU Value not applicable. its should not be exceed 0 to 5, User entered value is : "
									+ isuValue);
					flag = false;
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Need to development this scenario");
			System.out.println("Need to developemnt for this scenario");

		}
		return flag;
	}

	public boolean ISUStagingControlBackupHeatDifferential(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getInbetweenTextUpandDown());
			if (Integer.valueOf(ISUValue) <= 6 && Integer.valueOf(ISUValue) >= 0) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = ClickOnIncreaseUpButton();
						currentValue = Integer.valueOf(getInbetweenTextUpandDown());
					} else if (valueOf < currentValue) {
						flag = ClickOnDecreaseDownButton();
						currentValue = Integer.valueOf(getInbetweenTextUpandDown());
					}
				}
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 0,2 to 15, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean clickOnISUDropDownButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ISUDropDownButton");
	}

//	public boolean ISUDehumidifierFilterReplacementReminder(String ISUValue) {
//		switch (ISUValue.toUpperCase()) {
//		case "OFF": {
//			return MobileUtils.clickOnElement(objectDefinition, testCase, "CalenderOFF");
//		}
//		case "6 MONTHS": {
//			return MobileUtils.clickOnElement(objectDefinition, testCase, "6CalendarMonths");
//		}
//		case "12 MONTHS": {
//			return MobileUtils.clickOnElement(objectDefinition, testCase, "12CalendarMonths");
//		}
//		default: {
//			return false;
//		}
//		}
//	}
	public boolean clickOnInviteCustomerSkip() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "InviteCustomerSkip");
	}

	public boolean clickOnInviteCustomerLater() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "InviteCustomerLater");
	}

	public boolean clickOnInviteCustomerNow() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "InviteCustomerNow");
	}

	public boolean ISUDehumidifierFilterReplacementReminder(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else if (!ISUValue.contains("DEFAULT")) {
			flag = clickOnISUDropDownButton();
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = MobileUtils.isMobElementExists("accessibility id", getDropDownValuesByDefault(ISUValue),
						testCase);
				flag = flag && MobileUtils.clickOnElement(testCase, "accessibility id",
						getDropDownValuesByDefault(ISUValue));
			} else {
				flag = MobileUtils.isMobElementExists("accessibility id", getDropDownValuesByDefault(ISUValue),
						testCase);
				flag = flag && MobileUtils.clickOnElement(testCase, "accessibility id",
						getDropDownValuesByDefault(ISUValue));
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Need to development this scenario");
			System.out.println("Need to developemnt for this scenario");

		}
		return flag;
	}

	public String getValueinSecondTextFromUpandDownBetween() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "GetFirstUpAndDownValueInOtherWay")
					.getAttribute("content-desc");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Need to implement for IOS");
			return MobileUtils.getMobElement(objectDefinition, testCase, "GetFirstUpAndDownValueInOtherWay")
					.getAttribute("label");
		}

	}

	public boolean ISUVentilationCoreReminder(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 12 && Integer.valueOf(ISUValue) >= 0) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 0 to 12, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUVentilationFilterReminder(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 12 && Integer.valueOf(ISUValue) >= 0) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 0 to 12, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUNumberOfUVDevices(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "0": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVDevice0");
		}
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVDevice1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "UVDevice2");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUClockFormat(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "12 HOUR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "12HourFormat");
		}
		case "24 HOUR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "24HourFormat");
		}

		default: {
			return false;
		}
		}

	}

	public boolean ISUinActiveBacklightLevel(String ISUValue) {
		boolean flag = false;

		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			Integer valueOf = Integer.valueOf(ISUValue);
			Integer currentValue = Integer.valueOf(getValueinCyclePerHourStage());
			if (Integer.valueOf(ISUValue) <= 5 && Integer.valueOf(ISUValue) >= 0) {
				while (!(valueOf == currentValue)) {

					if (valueOf == currentValue) {
						flag = true;
						break;
					} else if (valueOf > currentValue) {
						flag = clickOnCyclePerHourStageIncreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					} else if (valueOf < currentValue) {
						flag = clickOnCyclePerHourStageDecreaseButton();
						currentValue = Integer.valueOf(getValueinCyclePerHourStage());
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"User Entered ISU Value not applicable. its should not be exceed 0 to 5, User entered value is : "
								+ ISUValue);
				flag = false;
			}
		}
		return flag;
	}

	public boolean ISUDayLightSavingTime(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOff");
		}
		case "ON": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOn");
		}

		default: {
			return false;
		}
		}

	}

	public boolean ISUTemperatureDisplayOffset(String ISUValue) {
		boolean flag = false;
//		System.out.println();
		try {
			if (ISUValue.toUpperCase().contains("DEFAULT")) {
				flag = true;
			} else {
				Float valueOf = Float.valueOf(ISUValue);
				Float currentValue = Float.valueOf(getValueinCyclePerHourStage());
				if (Float.valueOf(ISUValue) <= 6 && Float.valueOf(ISUValue) >= 0) {
					while (!(valueOf == currentValue)) {

						if (valueOf.equals(currentValue)) {
							flag = true;
							break;
						} else if (valueOf > currentValue) {
							flag = clickOnCyclePerHourStageIncreaseButton();
							currentValue = Float.valueOf(getValueinCyclePerHourStage());
						} else if (valueOf < currentValue) {
							flag = clickOnCyclePerHourStageDecreaseButton();
							currentValue = Float.valueOf(getValueinCyclePerHourStage());
						}
					}
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
							"User Entered ISU Value not applicable. its should not be exceed 0 to 6, User entered value is : "
									+ ISUValue);
					flag = false;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean ISUTemperatureDisplayOffset(String ISUValue) due to "
							+ e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean ISUAirFilterReplacementReminder(String ISUValue) {
		boolean flag = false;

		if (ISUValue.contains("DEFAULT")) {
			flag = true;
		} else {
			flag = clickOnISUDropDownButton();
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = MobileUtils.clickOnElement(testCase, "accessibility id", getDropDownValuesByDefault(ISUValue));
			} else {
				flag = MobileUtils.clickOnElement(testCase, "accessibility id", getDropDownValuesByDefault(ISUValue));
			}

//		if (ISUValue.toUpperCase().contains("DEFAULT")) {
//			flag = true;
//		} else if (!ISUValue.contains("DEFAULT")) {
//			if (clickOnISUDropDownButton()) {
//				if (Integer.valueOf(isuValue) <= 0 && Integer.valueOf(isuValue) >= 5) {
//					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
//						flag = MobileUtils.clickOnElement(testCase, "XPATH",
//								"//android.view.View[contains(@content-desc,'" + isuValue + "')]");
//					} else {
//						flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + isuValue + "')]");
//					}
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
//							"User Entered ISU Value not applicable. its should not be exceed 0 to 5, User entered value is : "
//									+ isuValue);
//					flag = false;
//				}
//			} else {
//				flag = false;
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Need to development this scenario");
//			System.out.println("Need to developemnt for this scenario");
//
//		}
		}
		return flag;
	}

	public boolean ISUVentialtorFilterCleaningReminder(String ISUValue) {
//		boolean flag = false;
		switch (ISUValue) {

		case "OFF": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "CalenderOFF");
		}
		case "3 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "3CalendarMonths");

		}
		case "6 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "6CalendarMonths");

		}
		case "9 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "9CalendarMonths");
		}
		case "12 CALENDAR MONTHS": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "12CalendarMonths");
		}

		default: {
			return false;
		}
		}

//		return flag;
	}

	public String getDropDownValuesByDefault(String isuValue) {
		switch (isuValue.toUpperCase()) {

		case "OFF": {
			return "Off";
		}
		case "10 RUN TIME DAYS": {
			return "10 Run Time Days";

		}
		case "20 RUN TIME DAYS": {
			return "30 Run Time Days";

		}
		case "30 RUN TIME DAYS": {
			return "30 Run Time Days";
		}
		case "45 RUN TIME DAYS": {
			return "45 Run Time Days";
		}
		case "60 RUN TIME DAYS": {
			return "60 Run Time Days";
		}
		case "90 RUN TIME DAYS": {
			return "90 Run Time Days";
		}
		case "120 RUN TIME DAYS": {
			return "120 Run Time Days";
		}
		case "150 RUN TIME DAYS": {
			return "150 Run Time Days";
		}
		case "30 CALENDAR DAYS": {
			return "30 Calendar Days";
		}
		case "45 CALENDAR DAYS": {
			return "45 Calendar Days";
		}
		case "60 CALENDAR DAYS": {
			return "60 Calendar Days";
		}
		case "75 CALENDAR DAYS": {
			return "75 Calendar Days";
		}
		case "3 CALENDAR MONTHS": {
			return "3 Calendar Months";
		}
		case "4 CALENDAR MONTHS": {
			return "4 Calendar Months";
		}
		case "5 CALENDAR MONTHS": {
			return "5 Calendar Months";
		}
		case "6 CALENDAR MONTHS": {
			return "6 Calendar Months";
		}
		case "7 CALENDAR MONTHS": {
			return "7 Calendar Months";
		}
		case "8 CALENDAR MONTHS": {
			return "8 Calendar Months";
		}
		case "9 CALENDAR MONTHS": {
			return "9 Calendar Months";
		}
		case "10 CALENDAR MONTHS": {
			return "10 Calendar Months";
		}
		case "11 CALENDAR MONTHS": {
			return "11 Calendar Months";
		}
		case "12 CALENDAR MONTHS": {
			return "12 Calendar Months";
		}
		case "15 CALENDAR MONTHS": {
			return "15 Calendar Months";
		}
		case "24 CALENDAR MONTHS": {
			return "24 Calendar Months";
		}
//		case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}case "":{
//			
//		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not Developed Isuvalue");
			return null;
		}

		}
	}

	public String getInbetweenTextUpandDown() {
		String getText = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			getText = MobileUtils.getMobElement(objectDefinition, testCase, "InbetweenTextUpandDown")
					.getAttribute("text");
		} else {
			getText = MobileUtils.getMobElement(objectDefinition, testCase, "InbetweenTextUpandDown")
					.getAttribute("label");

		}
		if (getText.contains("°")) {
			getText = getText.replace("°", "");
		}
		return getText;
	}

	public boolean clickOnDisconnectButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DisconnectButton");
	}

	public boolean clickOnConnectedToThermostatVisible() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "isConnectedToThermostatVisible");
	}

	public boolean clickOnCheckCOnnectionButtonInNoInternetConnection() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CheckCOnnectionButtonInNoInternetConnection"); 
	}
	
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, ""); 
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, ""); 
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, ""); 
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, ""); 
//	}

	
	
	
	public boolean isRecentCustomers(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isRecentCustomers", timeOut);
	}
	
	public boolean isDayLightSavingTimescreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isDayLightSavingTimescreen", timeOut);
	}

	public boolean isTemperatureDisplayOffsetScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isTemperatureDisplayOffsetScreen", timeOut);
	}

	public boolean isIndoorTemperatureDisplayOffsetScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isIndoorTemperatureDisplayOffsetScreen",
				timeOut);
	}

	public boolean iSVentilationLowTemperatureLockoutScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationLowTemperatureLockoutScreen",
				timeOut);
	}

	public boolean iSVentilationHighTemperatureLockoutScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationHighTemperatureLockoutScreen",
				timeOut);
	}

	public boolean isVentilationHighDewPointLockout(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationHighDewPointLockoutScreen",
				timeOut);
	}

	public boolean isVentilationCoreReminderScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isVentilationCoreReminderScreen", timeOut);
	}

	public boolean isVentilationFilterCleaningReminderScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isVentilationFilterCleaningReminderScreen",
				timeOut);
	}

	public boolean isVentilationFilterReminderScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isVentilationFilterReminderScreen", timeOut);
	}

	public boolean isNumberOfUVDevicesScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isNumberOfUVDevicesScreen", timeOut);
	}

	public boolean isInavtiveBacklightLevelScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isInavtiveBacklightLevelScreen", timeOut);
	}

	public boolean isClockFormatScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isClockFormatScreen", timeOut);
	}

	public boolean IswelcomeToResideoPro(int Timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IswelcomeToResideoPro", Timeout);
	}

	public boolean isLoginEmailPasswordScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isLoginEmailPasswordScreen", 10);
	}

	public boolean isLoginToResideoPro() {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginToResideoProProdcution", 5)) {
			flag = true;
		} else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginToResideoProNonProd", 5)) {
			flag = true;
		}
		return flag;
	}

	public boolean isLocationAccessPopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "LocationAccessPopUp");
	}

	public boolean isT5T6Thermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "T5T6Thermostat");
	}

	public boolean isT9T10Thermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9T10Thermostat");
	}

	public boolean isStartSetupScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "StartSetupScreen");
	}

	public boolean isuseAppScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "useAppScreen");
	}

	public boolean isNetworkNameScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NetworkNameScreen");
	}

	public boolean isLongPressScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "LongPressScreen");
	}

	public boolean isBlueToothScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BlueToothScreen");
	}

	public boolean isSearchingForBluetoothDeviceSpining() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SearchingForBluetoothDeviceSpining", 1);
	}

	public boolean isConnectToThermostatWithWiFiScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectToThermostatWithWiFiScreen");
	}

	public boolean isBLEDeviceIsPresent(String macname) {
//		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'Tstat " + macname + "')]", testCase,
//				1);
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + macname + "')]", testCase,
					1);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + macname + "')]", testCase, 1);
		}
	}

	public boolean isConnectingToThermostatSpinning() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToThermostatSpinning", 1);
	}

	public boolean isConnectingToThermostatSpinning(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToThermostatSpinning", timeout);
	}
	
	public boolean isErrorOccuredDuringBLEDeviceConnecting() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ErrorOccuredDuringBLEDeviceConnecting", 1);
	}

	public boolean isSecurityCodeScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SecurityCodeScreen", 30);
	}

	public boolean isSecurityCodeScreen(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SecurityCodeScreen", timeout);
	}
	
	public boolean isSchedulingOptionsScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsSchedulingOptionsScreen", timeOut);
	}

	public boolean isConnectedScreenForISUBegin() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsConnectedScreenForISUBegin", 90);
	}

	public boolean is() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}

	public boolean isOutDoorSensorScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutDoorSensorScreen", timeOut);
	}

	public boolean isHeatingSystemScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingSystemScreen", timeOut);
	}

	public boolean isFuelSourceScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FuelSourceScreen", timeOut);
	}

	public boolean isCoolingStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolingStageScreen", timeOut);
	}

	public boolean isHeatingStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingStageScreen", timeOut);
	}

	public boolean isReversingValveScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ReversingValveScreen", timeOut);
	}

	public boolean isCompressorStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorStageScreen", timeOut);
	}

	public boolean isAuxETerminalControlScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AuxETerminalControlScreen", timeOut);
	}

	public boolean isBackUpHeatScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackUpHeatScreen", timeOut);
	}

	public boolean isEmergencyHeatScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatScreen", timeOut);
	}

	public boolean isExternalFossilFuelKitScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExternalFossilFuelKitScreen", timeOut);
	}

	public boolean isOutdoorHeatLockout(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutdoorHeatLockoutScreen", timeOut);
	}

	public boolean isBackupHatLockOutScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isBackupHatLockOutScreen", timeOut);
	}

	public boolean isCompressorCyclePerHourStage1Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage1Screen",
				timeOut);
	}

	public boolean isBackupHeatDroopScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatDroopScreen", timeOut);
	}

	public boolean isCompressorLockoutScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorLockoutScreen", timeOut);
	}

	public boolean isBackupHeatUpStageTimerScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatUpStageTimerScreen", timeOut);
	}

	public boolean isCompressorCyclePerHourStage2Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage2Screen",
				timeOut);
	}

	public boolean isFanOperationinHeatScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanOperationinHeatScreen", timeOut);
	}

	public boolean isBackupHeatCyclesPerHourScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatCyclesPerHourScreen", timeOut);
	}

	public boolean isIndoorSensorScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorSensorScreen", timeOut);
	}

	public boolean isIndoorSensorTypeScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorSensorTypeScreen", timeOut);
	}

	public boolean isTemperatureSensorSelectionScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "TemperatureSensorSelectionScreen", timeOut);
	}

	public boolean isVentilationTypeScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationTypeScreen", timeOut);
	}

	public boolean isVentilationControlMethodScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationControlMethodScreen", timeOut);
	}

	public boolean isVentilationFanControlScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationFanControlScreen", timeOut);
	}

	public boolean isNumberofBedroomScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NumberofBedroomScreen", timeOut);
	}

	public boolean isVentilationRateScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationRateScreen", timeOut);
	}

	public boolean isVentilationPriorityScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationPriorityScreen", timeOut);
	}

	public boolean isBackUpHeatStagesScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackUpHeatStagesScreen", timeOut);
	}

	public boolean isEmergencyHeatCyclesPerHourScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatCyclesPerHourScreen", timeOut);
	}

	public boolean isConfigurationSummary(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ISUConfigurationSummaryScreen", timeOut);
	}

	public boolean isConfigurationComplete(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsSuccessScreen", timeOut);
	}

	public boolean isEnsure24GHZNetworkPopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Ensure24GHZNetworkPopUp");
	}

	public boolean isChooseaNetworkToConnectyourThermostatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase,
				"ChooseaNetworkToConnectyourThermostatScreen");
	}

	public boolean isexpectedwifiNetworkPresent() {
		String wifiName = null;
		try {
			wifiName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
		} catch (Exception e) {
		}
		return MobileUtils.isMobElementExists("XPATH", "//android.widget.TextView[@text='" + wifiName + "']", testCase);
	}

	public boolean isThermostatLocationScreenVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}

	public boolean isCoolCyclesPerHourStage1Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage1Screen", timeOut);
	}

	public boolean isCoolCyclesPerHourStage2Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage2Screen", timeOut);
	}

	public boolean isHeatCyclePerHourStage1Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage1Screen", timeOut);
	}

	public boolean isHeatCyclePerHourStage2Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage2Screen", timeOut);
	}

	public boolean isDiagnostics() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Diagnostics");
	}

	public boolean isCustomerInfo() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomerInfo");
	}

	public boolean isCustomerListUpdated() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsCustomerListUpdated");
	}

	public boolean isAddCustomerButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AddCustomerButton", timeOut);
	}

	public boolean isTemperatureScaleScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isTemperatureScaleScreen", timeOut);
	}

	public boolean isSystemChangeOverScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSystemChangeOverScreen", timeOut);
	}

	public boolean isFinishWithHighCoolStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isFinishWithHighCoolStageScreen", timeOut);
	}

	public boolean isFinishWithHighHeatStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isFinishWithHighHeatStageScreen", timeOut);
	}

	public boolean isCompressorMinimumOffTimeScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isCompressorOffMinimumTimeScreen", timeOut);
	}

	public boolean isExtendedFanRunTimeInCoolScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isExtendedFanRunTimeInCoolScreen", timeOut);
	}

	public boolean isExtendedFanRunTimeInHeatScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isExtendedFanRunTimeInHeatScreen", timeOut);
	}

	public boolean isAdaptiveIntelligentRecoveryScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAdaptiveIntelligentRecoveryScreen",
				timeOut);
	}

	public boolean isMaximumCoolSetPointScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMaximumCoolSetPointScreen", timeOut);
	}

	public boolean isMinimumCoolSetPointScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMinimumCoolSetPointScreen", timeOut);
	}

	public boolean isMaximumHeatSetPointScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMaximumHeatSetPointScreen", timeOut);
	}

	public boolean isMinimumHeatSetPointScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMinimumHeatSetPointScreen", timeOut);
	}

	public boolean isNumberOfAirFiltersScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isNumberOfAirFiltersScreen", timeOut);
	}

	public boolean isHumdifierPadReplacementReminderScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isHumdifierPadReplacementReminderScreen",
				timeOut);
	}

	public boolean isDehumidifierFilterReplacementReminder(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isDehumidifierFilterReplacementReminder",
				timeOut);
	}

	public boolean isAutoChangeoverDifferentialScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAutoChangeoverDifferentialScreen",
				timeOut);
	}

	public boolean isStagingControlBackupHeatDifferential(int timeOut) {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "isFinishWithHighCoolStageScreen", timeOut)) {
			return true;
		} else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "isFinishWithHighHeatStageScreen",
				timeOut)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isStagingControlHighCoolStageScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "StagingControlHighCoolStageScreen", timeOut);
	}

	public boolean isAirFilterReplacementReminder(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAirFilterReplacementReminder", timeOut);
	}

	public boolean isUVBulbReplacementReminder(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isUVBulbReplacementReminder", timeOut);
	}

	public boolean isInviteCustomerPopUp(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsInviteCustomerPopUp", timeOut);
	}
//	public boolean () {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "", timeOut);
//}
//	public boolean () {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "", timeOut);
//}


	public boolean isDisconnectfromThermostatPopup(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DisconnectfromThermostatPopup", timeOut);
	}

	public boolean isDisconnectAndInviteButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DisconnectAndInviteButton", timeOut);
	}

	public boolean isNoInternetConnectioncreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NoInternetConnectioncreen",timeOut);
	}
	
	
	public boolean isConnectedToThermostatVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isConnectedToThermostatVisible", timeOut);
	}

	public boolean isDisconnectButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DisconnectButton", timeOut);
	}

	public boolean isOpenWIFISettingsButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OpenWIFISettingsButton", timeOut);
	}

	public boolean ConnectToWifiUsingAPMode_iOS() {
		boolean flag = false;
		String wifiname = SystemState.getStatus().getTstatName();
		if (isOpenWIFISettingsButton(4)) {
			testCase.getMobileDriver().activateApp("com.apple.Preferences");
			flag = MobileUtils.isMobElementExists("NAME", "Wi-Fi", testCase, 2);
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Connect to the Thermostat WIfi Network screen not visible");
		}
		flag = flag && MobileUtils.clickOnElement(testCase, "NAME", "Wi-Fi",
				"Clicked on WIFI Settings in iOS Preference Settings Screen");
		if (flag) {
			if (scrollToWifiName(10, wifiname)) {
				if (isInitialPairingSuccess()) {
					Keyword.ReportStep_Pass(testCase, "Thermostat pin Configuration initiated");
					return true;
					
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to see Thermostat security in  in App, Error occured please refer screenshot");
					return false;
				}
			} else {
//				scrollDown();
				DIYUtils.iOS_scrollTable_ToCell(testCase, "name", wifiname);
				flag = scrollToWifiName(10, wifiname);
				if (flag && isInitialPairingSuccess()) {
					Keyword.ReportStep_Pass(testCase, "Thermostat security pin Begins");
					return true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to see Thermostat Configure in App, Error occured please refer screenshot");
					return false;
				}
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect Thermostat with APMODE WIfi, Error occured please refer screenshot");
			return false;
		}

	}

	public boolean scrollToWifiName(int duration, String wifiname) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		try {
			String bundleID = SuiteConstants
					.getConstantValue(SuiteConstantTypes.MOBILE_APP, "RESIDEO_PRO_IOS_Bundle_ID").trim();
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofSeconds(duration));
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (MobileUtils.isMobElementExists("XPATH",
								"//XCUIElementTypeCell[contains(@name,'" + wifiname
										+ "')]/XCUIElementTypeOther/XCUIElementTypeImage[@name='selected']",
								testCase, 2)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name,'" + wifiname + ", Unsecured Network, Unsecure network')]",
										testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
												+ wifiname + "']",
										testCase, 1)) {
							Keyword.ReportStep_Pass(testCase, "Sucessfully COnnected to Thermostat wifi");
							testCase.getMobileDriver().activateApp(bundleID);
							Keyword.ReportStep_Pass(testCase,
									"Application Switched back to Resideo Pro Aplicaition");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH",
								"//XCUIElementTypeStaticText[contains(@name,'" + wifiname + "')]", testCase, 2)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + wifiname
												+ "')]",
										testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name ,'NETWORKS')]/following-sibling::*[contains(@name,'"
												+ wifiname + "')]",
										testCase, 1)) {
							MobileUtils.clickOnElement(testCase, "NAME", wifiname,
									"sucessfully clicked on Thermostat Wi-Fi");
							return false;
						} else {
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"failed due to : " + e.getMessage());
						return false;
					}
				}
			});
			flag = success;

		} catch (TimeoutException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean connectWithThermostatWifiOnAndroid(String DeviceName) {

		boolean flag = false;
		boolean isDeviceConnected = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + DeviceName + "')]//*[contains(@content-desc,'Settings')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName + "']",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;

			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;

			} else {
				Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

//				int x = (int) (dimens.getWidth() * 0.5);
//				int endY = (int) (dimens.getHeight() * 0.2);
//				int startY = (int) (dimens.getHeight() * 0.75);

				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofSeconds(1));
				fWait.withTimeout(Duration.ofMinutes(3));
				try {
					Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {

							if (MobileUtils.isMobElementExists("xpath", "//*[contains(@content-desc,'" + DeviceName
									+ "')]//*[contains(@content-desc,'Settings')]", testCase, 1))
								return true;
							else if (MobileUtils.isMobElementExists("XPATH",
									"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
											+ "']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH",
									"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
											+ ",Connected (no)']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("xpath", "//*[@text='" + DeviceName + "']",
									testCase, 1)) {
								Keyword.ReportStep_Pass(testCase, "Required broadcasting device found");
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='" + DeviceName + "']");
								return true;
							} else if (MobileUtils.isMobElementExists("xpath",
									"//*[@text='Add network' or @text='Add Network']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='Add network' or @text='Add Network']");

								if (MobileUtils.isMobElementExists("xpath",
										"//*[@text='Enter the SSID' or @text='Enter the ssid']", testCase, 2)) {
									MobileUtils.setValueToElement(testCase, "xpath",
											"//*[@text='Enter the SSID' or @text='Enter the ssid']", "" + DeviceName,
											DeviceName + " Neteowrk is added.");

									MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='SAVE' or @text='Save']");

								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Unable to find text box to enter SSID");
								}
								return true;
							} else if (isInitialPairingSuccess(Duration.ofSeconds(3))) {
								return true;
							} else {
//								testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
								return false;
							}
						}
					});

					isDeviceConnected = success;
				} catch (org.openqa.selenium.TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to time out : 180 seconds" + e.getLocalizedMessage());
					flag = false;
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to : " + e.getMessage());
					flag = false;
				}
			}
			if (isInitialPairingSuccess(Duration.ofSeconds(3))) {
				flag = true;
			} else {
				String page = testCase.getMobileDriver().getPageSource().toUpperCase();
				if ((isDeviceConnected
						&& MobileUtils.isMobElementExists("xpath",
								"//*[contains(@content-desc,'" + DeviceName
										+ "')]//*[contains(@content-desc,'Settings')]",
								testCase, 8))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH",
								"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
										+ "']",
								testCase, 8))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH",
								"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
										+ ",Connected (no')]",
								testCase, 8))
						|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
								+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
								testCase, 8))
						|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
								+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
								testCase, 2))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'"
								+ DeviceName
								+ "')]/following-sibling::android.widget.TextView[contains(@text,'Connected to device')]",
								testCase, 5))
						|| (page.contains("FORGET") && page.contains("DISCONNECT") && page.contains("SHARE")
								&& page.contains(DeviceName.toUpperCase()))) {
					int i = 5;
					do {
						MobileUtils.pressBackButton(testCase);

						if (isInitialPairingSuccess(Duration.ofSeconds(20))) {
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
		}
		if (flag) {
			Keyword.ReportStep_Pass(testCase, "Succcessfully connected to Thermostat WIFI, Wifi Name is " + DeviceName);
		}
		return flag;

	}

	public boolean isconfigureOnDeviceScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isConfigureOnDeviceScreen",timeOut);
	}
	
	public boolean isFindQR_Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isFindQrScanScreen",timeOut);
	}
	
	public boolean isScanQRCode_Screen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isScanQRCodeScreen",timeOut);
	}
	
	public boolean clickOnEnterMacManuallyButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "EnterMacManuallyButton");
	}

	public boolean isEnterMacAddressScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isEnterMacAddress", timeOut);
	}

	public boolean clickOnEnterMacManuallyTextBox() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "EnterMacManuallyTB");
	}

	public boolean enterMacIDManually(String macID) {
		return MobileUtils.setValueInPicker(testCase, objectDefinition, "EnterMacManuallyTB", macID);
	}

}
