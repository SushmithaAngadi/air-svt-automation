package com.resideo.utils.resideo_app.screen;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.CommonUtils;

import org.openqa.selenium.WebElement;
import com.resideo.utils.W3CTouchActions;

public class HomeKitScreen extends MobileScreens {

	private static final String screenName = "HomeKitScreen";

	public HomeKitScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isAddIconVisible() {
		return MobileUtils.isMobElementExists("XPATH", "//*[@name='Home.NavBar.Add' or @name='Add']", testCase, 10);
	}

	public boolean isHomeKitScreen(int timeOut) {
		return MobileUtils.isMobElementExists("NAME", "Tab Bar", testCase, timeOut)
				&& MobileUtils.isMobElementExists("XPATH", "//*[@name='Home.Tab.Automation' or @name ='Automation']",
						testCase, timeOut)
				&& !MobileUtils.isMobElementExists("NAME", "Settings", testCase, timeOut);
	}

	public boolean isProgressVisible() {
		return MobileUtils.isMobElementExists("NAME", "In progress", testCase, 1);
	}

	public boolean isConnectingToThermostatCardVisible() {
		return MobileUtils.isMobElementExists("NAME", "Connecting to Thermostat", testCase);
	}

	public boolean isConnectingToThermostatCardVisible(int timeout) {
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(timeout));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();

						if (MobileUtils.isMobElementExists("NAME", "Connecting to Bridge", testCase, 2)) {
							System.out.println("Connecting to Bridge visible ..... ");
							return true;
						} else if (MobileUtils.isMobElementExists("NAME", "Connecting to Thermostat", testCase, 2)) {
							System.out.println("Connecting to Thermostat visible ..... ");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Connecting')]",
								testCase, 2)) {
							System.out.println("Connecting to Thermostat visible ..... ");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'connecting')]",
								testCase, 2)) {
							System.out.println("Connecting to Thermostat visible ..... ");
							return true;
						} else if (pgsrc.contains("Thermostat Location".toUpperCase())
								&& pgsrc.contains("Identify".toUpperCase())) {
							System.out.println("Thermostat in Location...");
							return true;
						} else {
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase, "Exception raised due to " + e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived) {
				return true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to find connecting to thermostat after entering passcode");
				return false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to find connecting to thermostat after entering passcode, Exception occured due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean isThermostatNameScreen() {
		return MobileUtils.isMobElementExists("NAME", "Thermostat Name", testCase, 6);
	}

	public boolean isBridgeNameScreen() {
		return MobileUtils.isMobElementExists("NAME", "Bridge Name", testCase, 120);
	}

	public boolean isBridgeAddedtoHomeScreen() {
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Bridge Added to ')]", testCase, 6);
	}

	public boolean isThermostatAddedtoHomeScreen() {
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Thermostat Added to ')]", testCase, 15);
	}

	public boolean isT10PlusThermostatConnected() {
		return MobileUtils.isMobElementExists("XPATH",
				"//*[contains(@name,'T10 Plus Thermostat') or contains(@name,'T10 Thermostat')]", testCase, 15);
	}

	public boolean isThermostatNameisAvailableInAccessoryScreen(String tstatName) {
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@label,'-" + tstatName + "')]", testCase);
	}

	public boolean isSettingsScreen() {
		return MobileUtils.isMobElementExists("NAME", "Settings", testCase);
	}

	public boolean isEnterHomeKitSetupCode() {
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Setup Code')]", testCase, 4);
	}

	public boolean isThermostatLocation() {
		return MobileUtils.isMobElementExists("NAME", "Thermostat Location", testCase, 1);

	}

	public boolean isBridgeLocation() {
		return MobileUtils.isMobElementExists("NAME", "Bridge Location", testCase, 120);
	}

	public boolean isUnableToAddAccessory() {
		return MobileUtils.isMobElementExists("NAME", "Unable to Add Accessory", testCase, 1);
	}

	public boolean isRemoveBtnIsAvailable() {
		return MobileUtils.isMobElementExists("NAME", "Remove", testCase, 1);
	}

	public boolean isDeviceNamePresentInHomeKitHomeScreen(String deviceName, int timeOut) {
		return MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeCell[contains(@name,'" + deviceName + "')]",
				testCase, timeOut);
	}

	public boolean _CloseUncertifiedAccessoryPresent(String deviceName, int timeOut) {
		boolean flag = false;
		String pageSrc = testCase.getMobileDriver().getPageSource().toUpperCase();
		if (pageSrc.contains("UNCERTIFIED ACCESSORY")) {
			if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Add Anyway')]", testCase, timeOut)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'Add Anyway')]");
			} else if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@value,'Add Anyway')]", testCase,
					timeOut)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@value,'Add Anyway')]");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, testCase.getMobileDriver().getPageSource());
			}
		} else {
			flag = true;
		}
		return flag;
	}

	public boolean isSelectAnAccessorySearchScreen(int timeOut) {
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Select an Accessory to Add to ')]",
				testCase, timeOut);
	}

	public boolean isDeviceSettings(int timeOut) {
		if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@label='Settings']", testCase, timeOut)) {
			return true;
		} else {
			return MobileUtils.isMobElementExists("NAME", "Settings", testCase, timeOut);
		}
	}

	public boolean isRemoveAccessory(int timeOut) {
		return MobileUtils.isMobElementExists("NAME", "Remove Accessory", testCase, timeOut);
	}

	public boolean clickOnAddIcon() {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Home.NavBar.Add' or @name='Add']");
	}

	public boolean clickOnAddAccessory() {
		return MobileUtils.clickOnElement(testCase, "XPATH",
				"//*[@name='Home.AddAccessory' or @name ='Add Accessory']");
	}

	public boolean clickOnIDontHaveCodeTOScan() {
		return MobileUtils.clickOnElement(testCase, "NAME", "I Don’t Have a Code or Cannot Scan");
	}

	public boolean isIDontHaveCodeTOScan() {
		return MobileUtils.isMobElementExists("NAME", "I Don’t Have a Code or Cannot Scan", testCase, 2);
	}

	public boolean clickOnAddToApple_BridgepopUP() {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[contains(@name,'Add to')]");
	}

	public boolean isAddToApple_BridgepopUP() {
		return MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeTextView[@name='Bridge']", testCase, 15);
	}

	public boolean clickOnHyperlink_moreOption() {
		return MobileUtils.clickOnElement(testCase, "XPATH",
				"//XCUIElementTypeLink[contains(@name,'Scan code or hold')]");
	}

	public boolean isHyperlink_moreOption() {
		return MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeLink[contains(@name,'Scan code or hold')]",
				testCase, 2);
	}

	public boolean clickOnCoordinate(String coordinate) {
		String[] split = coordinate.split("_");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		return MobileUtils.clickOnCoordinate(testCase, x, y);
	}

	public boolean clickOnDeviceNameFromAccessoryScreen(String deviceName) {
		System.out.println("Device Name is " + deviceName);
		if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@label,'-" + deviceName + "')]", testCase, 20)) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@label,'-" + deviceName + "')]");
		} else {
			Keyword.ReportStep_Pass(testCase, " Device not available in Home App");
			return false;
		}
	}

	public boolean isAddAccessorytoNetwork() {
		return MobileUtils.isMobElementExists("NAME", "Add Accessory to Network?", testCase, 15);
	}

	public boolean clickOnAllowButton() {
		return MobileUtils.clickOnElement(testCase, "NAME", "Allow");
	}

	public boolean setValueHomeKitCode(String code) {
		if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeTextField", testCase, 3)) {
			return MobileUtils.setValueToElement(testCase, "XPATH", "//XCUIElementTypeTextField", code);
		} else {
			return MobileUtils.setValueToElement(testCase, "NAME", "Setup Code", code);
		}
	}

	public boolean clickOnContinue() {
		return MobileUtils.clickOnElement(testCase, "NAME", "Continue");
	}

	public boolean clickOnDone() {
		return MobileUtils.clickOnElement(testCase, "NAME", "Done");
	}

	public boolean clickOnSettings() {
		if (MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@label='Settings']")) {
			return true;
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Settings");
		}
	}

	public boolean clickonRemoveBridge() {
		if (MobileUtils.isMobElementExists("NAME", "Remove Bridge from Home", testCase)) {
			return MobileUtils.clickOnElement(testCase, "NAME", "Remove Bridge from Home");
		} else {
			Keyword.ReportStep_Fail(testCase, 0,
					"Not able to remove Bridge due to Delete popup not visible in Home APP");
			return false;
		}
	}

	public boolean clickOnRemoveAccessory() {
		boolean flag = false;

		WebElement mobElement1 = MobileUtils.getMobElement(testCase, "XPATH",
				"(//*[@name='Remove Accessory']/preceding-sibling::XCUIElementTypeOther)[1]");
		WebElement mobElement2 = MobileUtils.getMobElement(testCase, "XPATH",
				"(//*[@name='Remove Accessory']/preceding-sibling::XCUIElementTypeOther)[2]");
		if (mobElement1.isDisplayed()) {
			mobElement1.click();
			if (isRemoveBtnIsAvailable()) {
				flag = true;
			} else {
				mobElement2.click();
				if (isRemoveBtnIsAvailable()) {
					flag = true;

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Identificed sucessfully but element not in visible, stauts is" + mobElement1.isDisplayed()
									+ ", element 2 " + mobElement2.isDisplayed());
					flag = false;
				}

			}

		} else if (mobElement2.isDisplayed()) {
			mobElement2.click();
			if (isRemoveBtnIsAvailable()) {
				flag = true;
			} else {
				mobElement1.click();
				if (isRemoveBtnIsAvailable()) {
					flag = true;

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Identificed sucessfully but element not in visible, stauts is" + mobElement1.isDisplayed()
									+ ", element 2 " + mobElement2.isDisplayed());
					flag = false;
				}
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"not able to find Remove Accessory Icon from List");
		}
		return flag;
	}

	public boolean clickOnRemove() {
		return MobileUtils.clickOnElement(testCase, "NAME", "Remove");
	}

	public boolean clickOnUseCamera() {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Use Camera']");
	}

	public boolean waitForDeviceAvailableinAddAccessory(int timeout, String deviceName) {
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(timeout));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (isProgressVisible()) {
							System.out.println("Searching device in Add Accessory Screen .......");
							return false;
						} else if (isThermostatNameisAvailableInAccessoryScreen(deviceName)) {
							Keyword.ReportStep_Pass(testCase,
									"Tstat is Visible in Search Accessory screen, Device Name is TSTAT-" + deviceName);
							return true;
						} else {
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception raised due to " + e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived) {
				return true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to Find Device name in Search Thermostat Accessory Screen");
				return false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to Find Device name in Search Thermostat Accessory Screen, Exception occured due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean waitForThermostatLocationAndDeviceName(int timeout) {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(timeout));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					if (isProgressVisible()) {
						System.out.println("Loading for Location Screen ..... ");
						return false;
					} else if (isUnableToAddAccessory()) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Unable To Add Accessory");
						MobileUtils.clickOnElement(testCase, "NAME", "OK");
						return true;
					} else if (isThermostatLocation()) {
						Keyword.ReportStep_Pass(testCase, "Thermostat Location screen Visible");
						return true;
					} else if (isBridgeLocation()) {
						Keyword.ReportStep_Pass(testCase, "Bridge Location screen Visible");
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to " + e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived) {
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to navigate to Thermostat Location Screen");
			return false;
		}
	}

	// XCUIElementTypeCell[contains(@name,'Tstat-A122E2')]
	public boolean clickOnDeviceName(String deviceName) {
		return MobileUtils.clickOnElement(testCase, "XPATH",
				"//XCUIElementTypeCell[contains(@name,'" + deviceName + "')]");
	}

	@SuppressWarnings("rawtypes")
	public boolean doScrollUptoElementVisible(String locatorType, String locatorVal, int timeOut) {
		boolean flag = false;
		boolean platform = testCase.getPlatform().toUpperCase().contains("IOS");

		if (platform) {
			Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

			int x = (int) (dimens.getWidth() * 0.5);
			int endY = (int) (dimens.getHeight() * 0.2);
			int startY = (int) (dimens.getHeight() * 0.75);
			for (int i = 0; i <= 5; i++) {
				if (MobileUtils.isMobElementExists(locatorType, locatorVal, testCase, timeOut)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully Scroll to Expected Element");
					break;
				} else {
//                  testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
					W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
				}
			}
			if (flag) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to scroll to expected Device");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to scroll to expected Device");
			flag = false;
		}
		return flag;
	}

	public boolean clickOnRemoveAccessoryInHomeKit() {
		boolean flag = false;
		if (doScrollUptoElementVisible("XPATH",
				"(//*[@name='Remove Accessory']/preceding-sibling::XCUIElementTypeOther)[1]", 1)) {
			if (clickOnRemoveAccessory()) {
				if (MobileUtils.isMobElementExists("NAME", "Remove", testCase, 5)) {
					if (MobileUtils.clickOnElement(testCase, "NAME", "Remove")) {
						Keyword.ReportStep_Pass(testCase, "Successfully Clicked Remove Accessory");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"unable to click on Remove Button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Remove Device not showing in remove accessory screen");
					flag = false;
				}
			} else {

				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"unable to click on Remove Accessory Button");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find Remove Accessory button");
			flag = false;
		}
		return flag;
	}

	public boolean clickOnRemoveBridgeInHomeKit() {
		boolean flag = false;

		if (MobileUtils.isMobElementExists("NAME", "Bridge", testCase, 10)) {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Bridge");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find Bridge button");
			flag = false;
		}

		if (doScrollUptoElementVisible("NAME", "Remove Bridge from Home", 1)) {
			if (clickonRemoveBridge()) {
				if (MobileUtils.isMobElementExists("NAME", "Remove", testCase, 10)) {
					if (MobileUtils.clickOnElement(testCase, "NAME", "Remove")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully Clicked Remove Accessory");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Remove button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Remove Device not showing in remove accessory screen");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Remove Bridge button");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find Remove Bridge from home");
			flag = false;
		}
		return flag;
	}

	public String getSetPointCoordinates(int setpoints) {
		String setpoint = null;

		switch (setpoints) {
		case 60:
			setpoint = "50_367";
			break;
		case 63:
			setpoint = "80_321";
			break;
		case 65:
			setpoint = "107_300";
			break;
		case 68:
			setpoint = "160_278";
			break;
		case 70:
			setpoint = "197_275";
			break;
		case 73:
			setpoint = "250_289";
			break;
		case 75:
			setpoint = "280_309";
			break;
		case 78:
			setpoint = "315_353";
			break;
		case 80:
			setpoint = "329_387";
			break;
		case 83:
			setpoint = "335_440";
			break;
		case 85:
			setpoint = "324_477";
			break;
		case 88:
			setpoint = "293_525";
			break;
		case 50:
			setpoint = "96_540";
			break;
		case 51:
			setpoint = "81_523";
			break;
		case 52:
			setpoint = "69_510";
			break;
		case 53:
			setpoint = "58_493";
			break;
		case 54:
			setpoint = "47_477";
			break;
		case 55:
			setpoint = "44_458";
			break;
		case 56:
			setpoint = "40_442";
			break;
		case 57:
			setpoint = "38_421";
			break;
		case 58:
			setpoint = "40_407";
			break;
		case 59:
			setpoint = "43_385";
			break;
		case 61:
			setpoint = "61_351";
			break;

		case 62:
			setpoint = "67_335";
			break;

		case 64:
			setpoint = "93_309";
			break;

		case 66:
			setpoint = "126_289";
			break;

		case 67:
			setpoint = "142_284";
			break;

		case 69:
			setpoint = "178_276";
			break;
		case 71:
			setpoint = "213_277";
			break;

		case 72:
			setpoint = "234_281";
			break;

		case 74:
			setpoint = "266_298";
			break;

		case 76:
			setpoint = "293_322";
			break;

		case 77:
			setpoint = "306_335";
			break;

		case 79:
			setpoint = "326_370";
			break;

		case 81:
			setpoint = "335_403";
			break;

		case 82:
			setpoint = "335_422";
			break;

		case 84:
			setpoint = "330_458";
			break;

		case 86:
			setpoint = "315_493";
			break;

		case 87:
			setpoint = "305_510";
			break;
		case 89:
			setpoint = "305_510";
			break;
		case 90:
			setpoint = "305_510";
			break;
		default:
			setpoint = "233_283";
			break;
		}

		return setpoint;
	}

	public String getSetPointCoordinatesForParticularDevice(TestCaseInputs inputs, String setpoints) {
		String setpoint = null;
		if (inputs.getInputValue("TARGET_DEVICENAME").toString().contains("00008110-001578C03A79801E")) {
			switch (setpoints) {
			case "51":
				setpoint = "87_541";
				break;
			case "52":
				setpoint = "73_530";
				break;
			case "53":
				setpoint = "63_513";
				break;
			case "54":
				setpoint = "56_495";
				break;
			case "55":
				setpoint = "52_478";
				break;
			case "56":
				setpoint = "49_462";
				break;
			case "57":
				setpoint = "45_441";
				break;
			case "58":
				setpoint = "48_423";
				break;
			case "59":
				setpoint = "52_404";
				break;
			case "60":
				setpoint = "57_384";
				break;
			case "61":
				setpoint = "64_369";
				break;
			case "62":
				setpoint = "73_352";
				break;
			case "63":
				setpoint = "85_339";
				break;
			case "64":
				setpoint = "101_326";
				break;
			case "65":
				setpoint = "115_316";
				break;
			case "66":
				setpoint = "132_307";
				break;
			case "67":
				setpoint = "149_300";
				break;
			case "68":
				setpoint = "166_296";
				break;
			case "69":
				setpoint = "186_293";
				break;
			case "70":
				setpoint = "204_294";
				break;
			case "71":
				setpoint = "222_293";
				break;
			case "72":
				setpoint = "240_301";
				break;
			case "73":
				setpoint = "256_306";
				break;
			case "74":
				setpoint = "274_315";
				break;
			case "75":
				setpoint = "288_327";
				break;
			case "76":
				setpoint = "303_337";
				break;
			case "77":
				setpoint = "311_354";
				break;
			case "78":
				setpoint = "322_369";
				break;
			case "79":
				setpoint = "331_385";
				break;
			case "80":
				setpoint = "336_403";
				break;
			case "81":
				setpoint = "339_421";
				break;
			case "82":
				setpoint = "339_440";
				break;
			case "83":
				setpoint = "341_457";
				break;
			case "84":
				setpoint = "338_478";
				break;
			case "85":
				setpoint = "333_492";
				break;
			case "86":
				setpoint = "320_512";
				break;
			case "87":
				setpoint = "313_525";
				break;
			case "88":
				setpoint = "304_541";
				break;
			case "10.5":
				setpoint = "88_544";
				break;
			case "11.0":
				setpoint = "78_531";
				break;
			case "11.5":
				setpoint = "69_516";
				break;
			case "12.0":
				setpoint = "62_503";
				break;
			case "12.5":
				setpoint = "56_486";
				break;
			case "13.0":
				setpoint = "50_470";
				break;
			case "13.5":
				setpoint = "48_456";
				break;
			case "14.0":
				setpoint = "46_437";
				break;
			case "14.5":
				setpoint = "48_421";
				break;
			case "15.0":
				setpoint = "52_405";
				break;
			case "15.5":
				setpoint = "55_392";
				break;
			case "16.0":
				setpoint = "63_375";
				break;
			case "16.5":
				setpoint = "70_361";
				break;
			case "17.0":
				setpoint = "80_348";
				break;
			case "17.5":
				setpoint = "91_336";
				break;
			case "18.0":
				setpoint = "102_324";
				break;
			case "18.5":
				setpoint = "117_314";
				break;
			case "19.0":
				setpoint = "131_306";
				break;
			case "19.5":
				setpoint = "145_299";
				break;
			case "20.0":
				setpoint = "161_297";
				break;
			case "20.5":
				setpoint = "179_297";
				break;
			case "21.0":
				setpoint = "195_290";
				break;
			case "21.5":
				setpoint = "211_294";
				break;
			case "22.0":
				setpoint = "227_296";
				break;
			case "22.5":
				setpoint = "239_302";
				break;
			case "23.0":
				setpoint = "259_307";
				break;
			case "23.5":
				setpoint = "272_315";
				break;
			case "24.0":
				setpoint = "284_325";
				break;
			case "24.5":
				setpoint = "297_335";
				break;
			case "25.0":
				setpoint = "306_349";
				break;
			case "25.5":
				setpoint = "317_362";
				break;
			case "26.0":
				setpoint = "328_375";
				break;
			case "26.5":
				setpoint = "332_392";
				break;
			case "27.0":
				setpoint = "335_405";
				break;
			case "27.5":
				setpoint = "339_420";
				break;
			case "28.0":
				setpoint = "340_439";
				break;
			case "28.5":
				setpoint = "340_452";
				break;
			case "29.0":
				setpoint = "340_472";
				break;
			case "29.5":
				setpoint = "335_485";
				break;
			case "30.0":
				setpoint = "327_501";
				break;
			case "30.5":
				setpoint = "321_515";
				break;
			case "31.0":
				setpoint = "309_528";
				break;
			case "31.5":
				setpoint = "298_541";
				break;
			case "32.0":
				setpoint = "288_552";
				break;
			default:
				setpoint = "";
				break;
			}
		} else if (inputs.getInputValue("TARGET_DEVICENAME").toString()
				.contains("2866ff7fc6b36e6dcdfad12899b8356d778c160f")) {
			switch (setpoints) {
			case "50":
				setpoint = "114_491";
				break;
			case "51":
				setpoint = "99_479";
				break;
			case "52":
				setpoint = "89_464";
				break;
			case "53":
				setpoint = "77_448";
				break;
			case "54":
				setpoint = "68_432";
				break;
			case "55":
				setpoint = "64_413";
				break;
			case "56":
				setpoint = "59_396";
				break;
			case "57":
				setpoint = "59_377";
				break;
			case "58":
				setpoint = "59_358";
				break;
			case "59":
				setpoint = "64_340";
				break;
			case "60":
				setpoint = "69_323";
				break;
			case "61":
				setpoint = "77_304";
				break;
			case "62":
				setpoint = "86_290";
				break;
			case "63":
				setpoint = "97_274";
				break;
			case "64":
				setpoint = "114_260";
				break;
			case "65":
				setpoint = "129_252";
				break;
			case "66":
				setpoint = "146_243";
				break;
			case "67":
				setpoint = "163_236";
				break;
			case "68":
				setpoint = "180_230";
				break;
			case "69":
				setpoint = "197_231";
				break;
			case "70":
				setpoint = "218_229";
				break;
			case "71":
				setpoint = "235_235";
				break;
			case "72":
				setpoint = "255_236";
				break;
			case "73":
				setpoint = "270_243";
				break;
			case "74":
				setpoint = "285_253";
				break;
			case "75":
				setpoint = "299_265";
				break;
			case "76":
				setpoint = "315_277";
				break;
			case "77":
				setpoint = "325_289";
				break;
			case "78":
				setpoint = "336_307";
				break;
			case "79":
				setpoint = "341_323";
				break;
			case "80":
				setpoint = "349_338";
				break;
			case "81":
				setpoint = "351_359";
				break;
			case "82":
				setpoint = "357_377";
				break;
			case "83":
				setpoint = "354_396";
				break;
			case "84":
				setpoint = "349_413";
				break;
			case "85":
				setpoint = "341_430";
				break;
			case "86":
				setpoint = "33_448";
				break;
			case "87":
				setpoint = "324_461";
				break;
			case "88":
				setpoint = "315_479";
				break;
			case "89":
				setpoint = "315_479";
				break;
			case "90":
				setpoint = "315_479";
				break;
			default:
				setpoint = "315_479";
				break;
			}

		} else if (inputs.getInputValue("TARGET_DEVICENAME").toString()
				.contains("3e0849a554b005cbecd9d72e7adee86f5d150878")) {

			switch (setpoints) {
			case "50":
				setpoint = "96_540";
				break;
			case "51":
				setpoint = "81_523";
				break;
			case "52":
				setpoint = "69_510";
				break;
			case "53":
				setpoint = "58_493";
				break;
			case "54":
				setpoint = "47_477";
				break;
			case "55":
				setpoint = "44_458";
				break;
			case "56":
				setpoint = "40_442";
				break;
			case "57":
				setpoint = "38_421";
				break;
			case "58":
				setpoint = "40_407";
				break;
			case "59":
				setpoint = "43_385";
				break;
			case "60":
				setpoint = "50_367";
				break;
			case "61":
				setpoint = "61_351";
				break;
			case "62":
				setpoint = "67_335";
				break;
			case "63":
				setpoint = "80_321";
				break;
			case "64":
				setpoint = "93_309";
				break;
			case "65":
				setpoint = "107_300";
				break;
			case "66":
				setpoint = "126_289";
				break;
			case "67":
				setpoint = "142_284";
				break;
			case "68":
				setpoint = "160_278";
				break;
			case "69":
				setpoint = "178_276";
				break;
			case "70":
				setpoint = "197_275";
				break;
			case "71":
				setpoint = "213_277";
				break;
			case "72":
				setpoint = "234_281";
				break;
			case "73":
				setpoint = "250_289";
				break;
			case "74":
				setpoint = "266_298";
				break;
			case "75":
				setpoint = "280_309";
				break;
			case "76":
				setpoint = "293_322";
				break;
			case "77":
				setpoint = "306_335";
				break;
			case "78":
				setpoint = "315_353";
				break;
			case "79":
				setpoint = "326_370";
				break;
			case "80":
				setpoint = "329_387";
				break;
			case "81":
				setpoint = "335_403";
				break;
			case "82":
				setpoint = "335_422";
				break;
			case "83":
				setpoint = "335_440";
				break;
			case "84":
				setpoint = "330_458";
				break;
			case "85":
				setpoint = "324_477";
				break;
			case "86":
				setpoint = "315_493";
				break;
			case "87":
				setpoint = "305_510";
				break;
			case "88":
				setpoint = "293_525";
				break;
			case "89":
				setpoint = "305_510";
				break;
			case "90":
				setpoint = "305_510";
				break;
			default:
				setpoint = "233_283";
				break;
			}

		}
		return setpoint;
	}

	public boolean changeSetpointFromHomeKit(TestCaseInputs inputs, String setPoint) {
		boolean flag = false;
//		String gettempCoordinates = MobileUtils
//				.getMobElement(testCase, "XPATH",
//						"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]")
//				.getAttribute("name").replace("°", "");
//		System.out.println();
		String gettempCoordinates = null;
		if (MobileUtils.isMobElementExists("XPATH",
				"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]", testCase,
				2)) {
			gettempCoordinates = MobileUtils
					.getMobElement(testCase, "XPATH",
							"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]")
					.getAttribute("name").replace("°", "");
		} else {
			gettempCoordinates = MobileUtils.getMobElement(testCase, "XPATH",
					"(//*[@name='AccessoryControl.thermostat.Thermostat']/XCUIElementTypeStaticText)[2]")
					.getAttribute("name").replace("°", "");
		}
		String pressSetPointCoordinates = getSetPointCoordinatesForParticularDevice(inputs, gettempCoordinates);
		String[] presscoordinates = pressSetPointCoordinates.split("_");
		Integer xStartCoordinate = Integer.valueOf(presscoordinates[0]);
		Integer yStartCoordinate = Integer.valueOf(presscoordinates[1]);

		String MovesetPointCoordinates = getSetPointCoordinatesForParticularDevice(inputs, setPoint);
		String[] Movecoordinates = MovesetPointCoordinates.split("_");
		Integer xEndCoordinate = Integer.valueOf(Movecoordinates[0]);
		Integer yEndCoordinate = Integer.valueOf(Movecoordinates[1]);

		testCase.getMobileDriver().swipe(xStartCoordinate, yStartCoordinate, xEndCoordinate, yEndCoordinate);
		String currentTemp = MobileUtils
				.getMobElement(testCase, "XPATH",
						"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]")
				.getAttribute("name").replace("°", "");
		if (setPoint.contains(currentTemp)) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Setpoint changed to " + setPoint);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to change setpoint, requested temp is " + setPoint + ", Actual temp is " + currentTemp);
			flag = false;
		}
		return flag;

	}

	public boolean verifySetpointFromHomeKit(String mode, String setPoint) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(30));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					String currentTemp = null;

					if (MobileUtils.isMobElementExists("XPATH",
							"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]", testCase,
							2)) {
						currentTemp = MobileUtils
								.getMobElement(testCase, "XPATH",
										"(//*[@name='Target value']/preceding-sibling::XCUIElementTypeStaticText)[2]")
								.getAttribute("name");
					} else {
						currentTemp = MobileUtils.getMobElement(testCase, "XPATH",
								"(//*[@name='AccessoryControl.thermostat.Thermostat']/XCUIElementTypeStaticText)[2]")
								.getAttribute("name");
					}
					if (currentTemp.contains(setPoint)) {
						Keyword.ReportStep_Pass(testCase, "Setpoint changed to " + setPoint);
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to " + e.getStackTrace());
					return false;
				}
			}
		});
		if (isEventReceived) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Setpoint changed to " + setPoint);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to change setpoint, requested temp is " + setPoint);
			flag = false;
		}

		return flag;
	}

	public boolean changeModeFromHomeKit(String mode) {
		try {
			String osVersion = testCase.getTestCaseInputs().getInputValue(TestCaseInputs.OS_VERSION);
			float compareVersions = CommonUtils.compareVersions(osVersion,"16.9.9");
			if (compareVersions > 0) {
				mode = StringUtils.capitalize(mode.toLowerCase());
				try {
					if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + mode + "')]", testCase, 3)) {
						Keyword.ReportStep_Pass(testCase, "Already System mode on " + mode);
						return true;
					} else {
						if (!MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + mode + "')]", testCase,
								3)) {
							MobileUtils.getMobElement(testCase, "XPATH", "//XCUIElementTypePickerWheel").sendKeys(mode);
							Keyword.ReportStep_Pass(testCase, "From Home Kit System mode changed to " + mode);
							return true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change system mode to " + mode);
							return false;
						}
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to  " + e.getMessage());
					return false;
				}
			} else {
				try {
					if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + mode + "')]", testCase, 3)) {
						Keyword.ReportStep_Pass(testCase, "Already System mode on " + mode);
						return true;
					} else {
						if (!MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + mode + "')]", testCase,
								3)) {
							MobileUtils.getMobElement(testCase, "XPATH", "//XCUIElementTypePickerWheel").sendKeys(mode);
							Keyword.ReportStep_Pass(testCase, "From Home Kit System mode changed to " + mode);
							return true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change system mode to " + mode);
							return false;
						}
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to  " + e.getMessage());
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean verifyModeFromHomeKit(String mode) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(45));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					if (MobileUtils.isMobElementExists("XPATH",
							"//XCUIElementTypeOther[contains(@name,'" + mode.trim() + "')]", testCase, 1)) {
						return true;
					} else if (MobileUtils.isMobElementExists("XPATH",
							"//XCUIElementTypePickerWheel[contains(@value,'" + mode.trim() + "')]", testCase, 1)) {
						return true;
					} else if (MobileUtils.isMobElementExists("XPATH",
							"//XCUIElementTypePickerWheel[contains(@value,'" + mode.toUpperCase().trim() + "')]",
							testCase, 1)) {
						return true;
					} else if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypePickerWheel[contains(@value,'"
							+ StringUtils.capitalize(mode.toLowerCase().trim()) + "')]", testCase, 1)) {
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in verifyModeFromHomeKit() due to " + e.getMessage());
					return false;

				}

			}
		});
		if (isEventReceived) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "System Mode changed to " + mode);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"System mode not able to change, Expected mode is " + mode);
			flag = false;
		}
		return flag;
	}

	public boolean setDeviceName(String deviceName) {
		boolean flag = false;
		CustomDriver mobileDriver = testCase.getMobileDriver();
		WebElement findElement = mobileDriver.findElement(By.name("XCUIElementTypeTextField"));
		System.out.println(findElement.isDisplayed());

		if (findElement.isDisplayed()) {
			findElement.sendKeys(deviceName);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
