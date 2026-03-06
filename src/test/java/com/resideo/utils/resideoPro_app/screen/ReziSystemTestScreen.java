package com.resideo.utils.resideoPro_app.screen;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

public class ReziSystemTestScreen extends MobileScreens {

	private static final String screenName = "ReziSystemTestScreen";

	public ReziSystemTestScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean chooseSystemTestTab(String tabName) {
		boolean flag = false;
		String chooseSystemTestTabName = chooseSystemTestTabName(tabName);
		switch (chooseSystemTestTabName) {
		case "HEAT": {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticsHeatButton");
			break;
		}
		case "COOL": {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticsCoolButton");
			break;
		}
		case "EM": {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticsEMButton");
			break;
		}
		case "FAN": {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticFanButton");
			break;
		}
		case "IAQ": {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticsIAQButton");
			break;
		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected Tab is not present, User expect tab is " + tabName);
			flag = false;
			break;
		}
		}
		if (flag) {
			Keyword.ReportStep_Pass(testCase, "Successfully clicked on " + tabName);
		}
		return flag;
	}

	public String chooseSystemTestTabName(String tabName) {
		String exactName = null;
		if (tabName.toUpperCase().contains("FAN")) {
			exactName = "FAN";
		} else if (tabName.toUpperCase().contains("COMPRESSOR COOL") || tabName.toUpperCase().contains("COOL")) {
			exactName = "COOL";
		} else if (tabName.toUpperCase().contains("COMPRESSOR HEAT") || tabName.toUpperCase().contains("HEAT")
				|| tabName.toUpperCase().contains("BACKUP HEAT")) {
			exactName = "HEAT";
		} else if (tabName.toUpperCase().contains("EMERGENCY HEAT")) {
			exactName = "EM";
		} else if (tabName.toUpperCase().contains("IAQ")) {
			exactName = "IAQ";
		} else {
			exactName = null;
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected Tab Name is not present, User expect tab is " + tabName);
		}
		return exactName;
	}

	public boolean clickOnDiagnosticsHeatButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.view.View[contains(@content-desc,'Heat\n" + "Tab')]");
		} else {
			if(MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeStaticText[contains(@name,'Heat\n" + "Tab')]", testCase,2)) {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'Heat\n" + "Tab')]");
			}else {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeOther[contains(@name,'Heat\n" + "Tab')]");	
			}
		}
	}

	public boolean clickOnDiagnosticsCoolButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.view.View[contains(@content-desc,'Cool\n" + "Tab')]");
		} else {
			if(MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeStaticText[contains(@name,'Cool\n" + "Tab')]", testCase,2)) {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'Cool\n" + "Tab')]");
			}else {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeOther[contains(@name,'Cool\n" + "Tab')]");	
			}
		}
	}

	public boolean clickOnDiagnosticsIAQButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.view.View[contains(@content-desc,'IAQ\n" + "Tab')]");
		} else {
			if(MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeStaticText[contains(@name,'IAQ\n" + "Tab')]", testCase,2)) {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'IAQ\n" + "Tab')]");
			}else {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeOther[contains(@name,'IAQ\n" + "Tab')]");	
			}
		}
	}

	public boolean clickOnDiagnosticsEMButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.view.View[contains(@content-desc,'Em\n" + "Tab')]");
		} else {
			if(MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeStaticText[contains(@name,'Em\n" + "Tab')]", testCase,2)) {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'Em\n" + "Tab')]");
			}else {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeOther[contains(@name,'Em\n" + "Tab')]");	
			}
		}
	}

	public boolean clickOnDiagnosticFanButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.view.View[contains(@content-desc,'Fan\n" + "Tab')]");
		} else {
			
			if(MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeStaticText[contains(@name,'Fan\n" + "Tab')]", testCase,2)) {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'Fan\n" + "Tab')]");
			}else {
				return MobileUtils.clickOnElement(testCase, "XPATH",
						"//XCUIElementTypeOther[contains(@name,'Fan\n" + "Tab')]");	
			}
		}
	}

	public boolean clickOnCompressorHeatStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorHeatStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Compressor Heat\n" + "Stage 1')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Compressor Heat\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnCompressorHeatStage2SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorHeatStage2SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Compressor Heat\n" + "Stage 2')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Compressor Heat\n" + "Stage 2')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnBackUpHeatStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Backup Heat\n" + "Stage 1')]/android.widget.Switch");
			//*[contains(@content-desc,'Backup Heat Stage 1')]/android.widget.Switch
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Backup Heat\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}
//	"Backup Heat\r\n"
//	+ "Stage 1"

	public boolean clickOnCompressorCoolStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorCoolStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Compressor Cool\n" + "Stage 1')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Compressor Cool\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnCompressorCoolStage2SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorCoolStage2SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Compressor Cool\n" + "Stage 2')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Compressor Cool\n" + "Stage 2')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnEmergencyHeatStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Emergency Heat\n" + "Stage 1')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Emergency Heat\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnFanSwitchOnOff() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSwitchOnOff");
	}

	public boolean clickOnVentilationSwitchOnOff() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationSwitchOnOff");
	}

	public boolean clickOnHeatStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Heat\n" + "Stage 1')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Heat\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnHeatStage2SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatStage2SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Heat\n" + "Stage 2')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Heat\n" + "Stage 2')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnCoolStage1SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CoolStage1SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Cool\n" + "Stage 1')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Cool\n" + "Stage 1')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnCoolStage2SwitchOnOff() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "CoolStage2SwitchOnOff");
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@content-desc,'Cool\n" + "Stage 2')]/android.widget.Switch");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'Cool\n" + "Stage 2')]/following-sibling::XCUIElementTypeSwitch");
		}
	}

	public boolean clickOnDoneButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
	}

//	
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//		
//	}

	public String getCurrentTempereature() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "TemperatureFromAPPSystemTest")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "TemperatureFromAPPSystemTest")
					.getAttribute("value");
		}
	}

	public String getCompressorHeatStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatStage1SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getCompressorHeatStage2SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatStage2SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatStage2SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getBackUpHeatStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatStage1SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getCompressorCoolStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage1SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getCompressorCoolStage2SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage2SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage2SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getEmergencyHeatStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "EmergencyHeatStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "EmergencyHeatStage1SwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getFanSwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "FanSwitchOnOff").getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "FanSwitchOnOff").getAttribute("value");
		}
	}

	public String getVentilationSwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "VentilationSwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "VentilationSwitchOnOff")
					.getAttribute("value");
		}
	}

	public String getHeatStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "HeatStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "HeatStage1SwitchOnOff").getAttribute("value");
		}
	}

	public String getHeatStage2SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "HeatStage2SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "HeatStage2SwitchOnOff").getAttribute("value");
		}
	}

	public String getCoolStage1SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CoolStage1SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CoolStage1SwitchOnOff").getAttribute("value");
		}
	}

	public String getCoolStage2SwitchOnOff() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CoolStage2SwitchOnOff")
					.getAttribute("checked");
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "CoolStage2SwitchOnOff").getAttribute("value");
		}
	}

//	public String get() {
//		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
//			return MobileUtils.getMobElement(objectDefinition, testCase, "").getText();
//		} else {
//			return MobileUtils.getMobElement(objectDefinition, testCase, "")
//					.getAttribute("value");
//		}
//	}

	public boolean isDiagnosticsHeatButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DiagnosticsHeatButton");
	}

	public boolean isDiagnosticsCoolButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DiagnosticsCoolButton");
	}

	public boolean isDiagnosticsIAQButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DiagnosticsIAQButton");
	}

	public boolean isDiagnosticsEMButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DiagnosticsEMButton");
	}

	public boolean isDiagnosticFanButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DiagnosticFanButton");
	}

	public boolean isCompressorHeatStage1Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@content-desc,'Compressor Heat\n" + "Stage 1')]", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Compressor Heat\n" + "Stage 1')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatStage1Switch");
	}

	public boolean isCompressorHeatStage2Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@content-desc,'Compressor Heat\n" + "Stage 2')]", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Compressor Heat\n" + "Stage 2')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatStage2Switch");
	}

	public boolean isBackUpHeatStage1Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'Backup Heat\n" + "Stage 1')]",
					testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Backup Heat\n" + "Stage 1')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackUpHeatStage1Switch");
	}

	public boolean isCompressorCoolStage1Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@content-desc,'Compressor Cool\n" + "Stage 1')]", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Compressor Cool\n" + "Stage 1')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCoolStage1Switch");
	}

	public boolean isCompressorCoolStage2Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@content-desc,'Compressor Cool\n" + "Stage 2')]", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Compressor Cool\n" + "Stage 2')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCoolStage2Switch");
	}

	public boolean isEmergencyHeatStage1Switch() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@content-desc,'Emergency Heat\n" + "Stage 1')]", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Emergency Heat\n" + "Stage 1')]",
					testCase);
		}
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatStage1Switch");
	}

	public boolean isFanSwitch() {

		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanSwitch");
	}

	public boolean isVentilationSwitch() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationSwitch");
	}

//	public boolean isHeatStage1Switch() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatStage1Switch");
//	}

	public boolean isHeatStage1Switch() {

		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Heat\n" + "Stage 1", testCase);
	}

	public boolean isHeatStage2Switch() {
		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Heat\n" + "Stage 2", testCase);
	}

	public boolean isCoolStage1Switch() {
		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Cool\n" + "Stage 1", testCase);
	}

	public boolean isCoolStage2Switch() {
		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Cool\n" + "Stage 2", testCase);
	}

	public boolean isTemperatureFromAPPSystemTest() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "TemperatureFromAPPSystemTest");
	}
//
//public boolean is() {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//}

	public boolean is() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}

}
