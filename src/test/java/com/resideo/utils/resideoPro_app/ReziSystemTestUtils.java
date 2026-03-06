package com.resideo.utils.resideoPro_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.CommonUtils;
import com.resideo.utils.resideoPro_app.screen.ReziSystemTestScreen;
import com.resideo.utils.stat.SystemTestStatRelayUtils;

public class ReziSystemTestUtils {

	public static boolean isSystemTestConfigurable(TestCases testCase) {
		boolean flag = false;

		return flag;
	}

	public static boolean extraSystemTest(TestCases testCase, String installerTest,
			String[] strRelays, String relayname) {
		return systemTestCheckForSwitch(testCase, installerTest, "", strRelays, relayname);
	}

	@SuppressWarnings("unchecked")
	public static boolean systemTestCheckForSwitch(TestCases testCase, String installerTest, String StageValue,
			String[] strRelays, String relayname) {
		System.out.println();
		boolean flag = false;
		ReziSystemTestScreen sysScreen = new ReziSystemTestScreen(testCase);
		switch (installerTest) {
		case "COOL": {
			flag = sysScreen.clickOnDiagnosticsCoolButton();
			switch (StageValue) {

			case "1": {
				if (sysScreen.isCoolStage1Switch()) {
					flag = flag && sysScreen.clickOnCoolStage1SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON",50);
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			case "2": {
				if (sysScreen.isCoolStage2Switch()) {
					flag = flag && sysScreen.clickOnCoolStage2SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected stage not present, user expected stage is " + StageValue);
				break;
			}
			}
			break;

		}
		case "HEAT": {
			flag = sysScreen.clickOnDiagnosticsHeatButton();

			switch (StageValue) {
			case "1": {
				if (sysScreen.isHeatStage1Switch()) {
					flag = flag && sysScreen.clickOnHeatStage1SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			case "2": {
				if (sysScreen.isHeatStage2Switch()) {
					flag = flag && sysScreen.clickOnHeatStage2SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected stage not present, user expected stage is " + StageValue);
				break;
			}

			}
			break;

		}
		case "BACKUP HEAT": {
			flag = sysScreen.clickOnDiagnosticsHeatButton();
			switch (StageValue) {

			case "1": {
				if (sysScreen.isBackUpHeatStage1Switch()) {
					flag = flag && sysScreen.clickOnBackUpHeatStage1SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}

			default: {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected stage not present, user expected stage is " + StageValue);
				break;
			}

			}
			break;

		}

		case "EMERGENCY HEAT": {
			flag = sysScreen.clickOnDiagnosticsEMButton();
			if (sysScreen.isEmergencyHeatStage1Switch()) {
				flag = flag && sysScreen.clickOnEmergencyHeatStage1SwitchOnOff();
				flag = flag
						&& SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays), "ON");
				Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest + ", stage "
						+ StageValue + " , Following Relay turned on " + relayname + " .");
				break;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed Installer test against "
						+ installerTest + ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
				flag = false;
				break;
			}
		}

		case "COMPRESSOR HEAT": {
			flag = sysScreen.clickOnDiagnosticsHeatButton();
			switch (StageValue) {

			case "1": {
				if (sysScreen.isCompressorHeatStage1Switch()) {
					flag = flag && sysScreen.clickOnCompressorHeatStage1SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			case "2": {
				if (sysScreen.isCompressorHeatStage2Switch()) {
					flag = flag && sysScreen.clickOnCompressorHeatStage2SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected stage not present, user expected stage is " + StageValue);
				break;
			}

			}
			break;

		}
		case "COMPRESSOR COOL": {
			flag = sysScreen.clickOnDiagnosticsCoolButton();
			switch (StageValue) {

			case "1": {
				if (sysScreen.isCompressorCoolStage1Switch()) {
					flag = flag && sysScreen.clickOnCompressorCoolStage1SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			case "2": {
				if (sysScreen.isCompressorCoolStage2Switch()) {
					flag = flag && sysScreen.clickOnCompressorCoolStage2SwitchOnOff();
					flag = flag && SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays),
							"ON");
					Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
							+ ", stage " + StageValue + " , Following Relay turned on " + relayname + " .");
					break;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed Installer test against " + installerTest + ", stage " + StageValue
									+ " , Following Relay turned on " + relayname + " .");
					flag = false;
					break;
				}
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected stage not present, user expected stage is " + StageValue);
				break;
			}

			}
			break;

		}
		case "FAN": {
			flag = sysScreen.clickOnDiagnosticFanButton();
			if (sysScreen.isFanSwitch()) {
				flag = flag && sysScreen.clickOnFanSwitchOnOff();
				flag = flag
						&& SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays), "ON");
				Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
						+ ",  Following Relay turned on " + relayname + " .");
				break;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed Installer test against "
						+ installerTest + ", Following Relay turned on " + relayname + " .");
				flag = false;
				break;
			}
		}
		case "IAQ": {
			flag = sysScreen.clickOnDiagnosticsIAQButton();
			if (sysScreen.isVentilationSwitch()) {
				flag = flag && sysScreen.clickOnVentilationSwitchOnOff();
				flag = flag
						&& SystemTestStatRelayUtils.verifyRelays(testCase, CommonUtils.getRelayArray(strRelays), "ON");
				Keyword.ReportStep_Pass(testCase, "Successfully Installer test against " + installerTest
						+ ",  Following Relay turned on " + relayname + " .");
				break;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed Installer test against "
						+ installerTest + ", Following Relay turned on " + relayname + " .");
				flag = false;
				break;
			}

		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Expected Test not present, user expected test is " + installerTest);
			break;

		}

		}

		return flag;
	}

}
