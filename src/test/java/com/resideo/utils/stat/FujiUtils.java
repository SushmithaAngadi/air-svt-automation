package com.resideo.utils.stat;

import java.util.HashMap;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.AlertmessageData;
import com.resideo.utils.stat.cattgrpccommands.ISUResponseMsg;
import com.resideo.utils.stat.cattgrpccommands.ISU_Settings;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset_FJ;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

public class FujiUtils {
	
	private static long statAlertTriggeredTime = 0;
	
	public static long getStatTimeUTC() {
        return statAlertTriggeredTime;
    }
	
	public static boolean setISU(TestCases testCase, String isuType, String isuVal) {
		boolean flag = false;
		try {
			flag = StatCommands.getInstance().cattCommandsStub.setISUToDevices(ISU_Settings.newBuilder()
					.setISUType(isuType.toUpperCase()).setISUValue(isuVal.toUpperCase()).build()).getBoolVal();
			if (!flag) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Stat Isu '" + isuType + "' is not able to set to : '" + isuVal + "'");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"ISU Val : " + isuVal + " is UNIMPLEMENTED");
				flag = false;
			} else
				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + isuType + "' is set to : '" + isuVal + "'");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set isu configuration. ISU : " + isuType + ", Value : " + isuVal);
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}
	
	public static float getMaxMin_TempValue(String isu) {

		if (isu.contains("ISU_MAX_HEAT_SP")) {
			ISUResponseMsg StatHeatMaxSP = StatCommands.getInstance().cattCommandsStub
					.getISUToDevices(ISU_Settings.newBuilder().setISUType("ISU_MAX_HEAT_SP").build());
			return StatHeatMaxSP.getFloatIsuVal();
		} else if (isu.contains("ISU_MIN_HEAT_SP")) {
			ISUResponseMsg StatHeatMinSP = StatCommands.getInstance().cattCommandsStub
					.getISUToDevices(ISU_Settings.newBuilder().setISUType("ISU_MIN_HEAT_SP").build());
			return StatHeatMinSP.getFloatIsuVal();
		} else if (isu.contains("ISU_MAX_COOL_SP")) {
			ISUResponseMsg StatCoolMaxSP = StatCommands.getInstance().cattCommandsStub
					.getISUToDevices(ISU_Settings.newBuilder().setISUType("ISU_MAX_COOL_SP").build());
			return StatCoolMaxSP.getFloatIsuVal();
		} else if (isu.contains("ISU_MIN_COOL_SP")) {
			ISUResponseMsg StatCoolMinSP = StatCommands.getInstance().cattCommandsStub
					.getISUToDevices(ISU_Settings.newBuilder().setISUType("ISU_MIN_COOL_SP").build());
			return StatCoolMinSP.getFloatIsuVal();
		} else {
			return 0;
		}

	}

	public static boolean setFuji_Alert(TestCases testCase, String alertType, String alertValue) {
		boolean flag = false;
		try {
			flag = StatCommands.getInstance().cattCommandsStub.setAlertDevices(AlertmessageData.newBuilder()
					.setState(com.resideo.utils.stat.cattgrpccommands.AlertmessageData.ISUDevice.FUJI)
					.setAlertKey(alertType).setAlertValue(alertValue).build()).getBoolVal();
			if (!flag) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Stat Isu '" + alertType + "' is not able to set to : '" + alertValue + "'");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"ISU Val : " + alertValue + " is UNIMPLEMENTED");
				flag = false;
			} else {
				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + alertType + "' is set to : '" + alertValue + "'");
				statAlertTriggeredTime = Long.parseLong(
	                    StatCommands.getInstance().cattCommandsStub
	                            .getEpochTime(String_Msg.newBuilder().build()).getStrVal());
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set isu configuration. ISU : " + alertType + ", Value : " + alertValue);
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}

	public static boolean setPreConditionISU(TestCases testCase, String feature) {
		boolean flag = false;
		String isuType = null, isuVal = null;

		try {
			Multimap<String, String> hashMap = LinkedHashMultimap.create();
			if (feature.contains("DEFAULT")) {
				hashMap.put("ISU_TEMP_FORMAT", "ISU_125_TEMP_FORMAT__F");
				hashMap.put("ISU_HEAT_SYSTEM_TYPE_1", "ISU_200_HEAT_SYSTEM_TYPE_1__CONVENTIONAL");
				hashMap.put("ISU_HEAT_EQUIP_TYPE_1", "ISU_205_HEAT_EQUIP_TYPE_1__HIGH_EFFICIENCY_GAS_FORCED_AIR");
				hashMap.put("ISU_COOL_STAGES", "1");
				hashMap.put("ISU_HEAT_STAGES", "1");
				hashMap.put("ISU_AUTO_CHANGEOVER", "ISU_300_ISU_AUTO_CHANGEOVER__AUTOMATIC");
				hashMap.put("ISU_AUTO_DIFFERENTIAL", "ISU_303_AUTO_DIFFERENTIAL_0");
				hashMap.put("ISU_CPH_COOLS2", "3");
				hashMap.put("ISU_CPH_HEATS2", "3");
				hashMap.put("ISU_FAN_LOCKOUT_AFTER_COOL_CALL", "ISU_360_LOCKOUT_FAN_AFTER_COOL_CALL_OFF");
				hashMap.put("ISU_MIN_CMPR_OFF", "ISU_387_MIN_CMPR_OFF__OFF");
				hashMap.put("ISU_AIR_ENABLE", "ISU_425_AIR_ENABLE__YES");
				hashMap.put("ISU_MAX_COOL_SP", "90");
				hashMap.put("ISU_MAX_HEAT_SP", "90");
				hashMap.put("ISU_MIN_COOL_SP", "50");
				hashMap.put("ISU_MIN_HEAT_SP", "50");
				hashMap.put("ISU_KEYPAD_LOCKOUT", "ISU_435_KEYPAD_LOCKOUT__DISABLED");
				hashMap.put("ISU_CLOCK_FORMAT", "ISU_1410_CLOCK_FORMAT_12HR");
				hashMap.put("ISU_TEMP_OFFSET", "ISU_1420_TEMP_OFFSET__0");
			} 

			for (HashMap.Entry<String, String> isu : hashMap.entries()) {
				isuType = isu.getKey().toUpperCase();
				isuVal = isu.getValue().toUpperCase();
				flag = StatCommands.getInstance().cattCommandsStub
						.setISUToDevices(ISU_Settings.newBuilder().setISUType(isuType).setISUValue(isuVal).build())
						.getBoolVal();
				if (!flag) {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Stat Isu '" + isuType + "' is not able to set to : '" + isuVal + "'");
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"ISU Val : " + isuVal + " is UNIMPLEMENTED");
					flag = false;
				} else
					Keyword.ReportStep_Pass(testCase, "Stat Isu '" + isuType + "' is set to : '" + isuVal + "'");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set isu configuration. ISU : " + isuType + ", Value : " + isuVal);
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}
	
	public static String verifyTempScale(TestCases testCase) {
		String getTempScale = null;
		ISUResponseMsg TempScale = StatCommands.getInstance().cattCommandsStub
				.getISUToDevices(ISU_Settings.newBuilder().setISUType("ISU_TEMP_FORMAT").build());

		if (TempScale.getByteIsuVal() == 0) {
			getTempScale = "Fahrenheit".toUpperCase();
		} else {
			getTempScale = "Celsius".toUpperCase();
		}
		return getTempScale;

	}

	public static boolean runPerticularAATCommand(String aatCommand) {
		boolean flag=false;
		if(aatCommand.contains("DEFAULT NVM") || aatCommand.contains("AAT_SYSTEM_RESET_DEFAULT_NVM")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_SYSTEM_RESET_DEFAULT_NVM).build())
					.getBoolVal();
		}else if(aatCommand.contains("RESET PRESERVE NVM") || aatCommand.contains("AAT_SYSTEM_RESET_PRESERVE_NVM")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_SYSTEM_RESET_PRESERVE_NVM).build())
					.getBoolVal();
		}else if(aatCommand.contains("WATCHDOG REST PRESERVE NVM") || aatCommand.contains("AAT_WATCHDOG_RESET_PRESERVE_NVM")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_WATCHDOG_RESET_PRESERVE_NVM).build())
					.getBoolVal();
		}else if(aatCommand.contains("WATCHDOG RESET RADIO") || aatCommand.contains("AAT_WATCHDOG_RESET_RADIO")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_WATCHDOG_RESET_RADIO).build())
					.getBoolVal();
		}else if((aatCommand.contains("FACTORY RESET") && aatCommand.contains("WITHOUT WIFI") )  || aatCommand.contains("AAT_FACTORY_RESET_TSTAT")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_FACTORY_RESET_TSTAT).build())
					.getBoolVal();
		}else if(aatCommand.contains("FACTORY RESET") || aatCommand.contains("AAT_FACTORY_RESET")) {
			flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
					Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_FACTORY_RESET).build())
					.getBoolVal();
		}
		return flag;
	}
	


}