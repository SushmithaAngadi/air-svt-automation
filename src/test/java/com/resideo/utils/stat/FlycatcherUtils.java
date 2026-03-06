package com.resideo.utils.stat;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.AlertmessageData;
import com.resideo.utils.stat.cattgrpccommands.ISUResponseMsg;
import com.resideo.utils.stat.cattgrpccommands.ISU_Settings;

public class FlycatcherUtils {

//	public static boolean setISU(TestCases testCase, String isuType, String isuVal) {
//		boolean flag = false;
//		try {
//			if (isuVal.matches("\\d*")) {
//				flag = StatCommands.getInstance().cattCommandsStub
//						.flycatcherSetISU(FlycatcherIsuMsg.newBuilder().setIsu(IsuItem.valueOf(isuType.toUpperCase()))
//								.setFloatIsuVal(Float.parseFloat(isuVal)).build())
//						.getBoolVal();
//				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + isuType + "' is set to : '" + isuVal + "'");
//			} else {
//
//				List<Descriptors.EnumValueDescriptor> enumValues = IsuValue.getDescriptor().getValues();
//				System.out.println(enumValues);
//				boolean isuValSet = false;
//				for (Descriptors.EnumValueDescriptor val : enumValues) {
//					if (val.getName().toUpperCase().equals(isuVal.toUpperCase())) {
//						StatCommands.getInstance().cattCommandsStub
//								.flycatcherSetISU(FlycatcherIsuMsg.newBuilder().setIsu(IsuItem.valueOf(isuType.toUpperCase()))
//										.setEnumIsuVal(IsuValue.valueOf(val)).build());
//						isuValSet = true;
//						Keyword.ReportStep_Pass(testCase, "Stat Isu '" + isuType + "' is set to : '" + isuVal + "'");
//						break;
//					}
//				}
//
//				if (!isuValSet) {
//					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
//							"Stat Isu '" + isuType + "' is not able to set to : '" + isuVal + "'");
//					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
//							"ISU Val : " + isuVal + " is UNIMPLEMENTED");
//					flag = false;
//				} else
//					flag = isuValSet;
//			}
//		} catch (Exception e) {
//			flag = false;
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Failed to set isu configuration. ISU : " + isuType + ", Value : " + isuVal);
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
//		}
//		return flag;
//	}
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

	public static boolean verifyISU(TestCases testCase, String isuType, String isuVal) {
		boolean flag = false;
		try {
			flag = StatCommands.getInstance().cattCommandsStub.verifyISUToDevices(ISU_Settings.newBuilder()
					.setISUType(isuType.toUpperCase()).setISUValue(isuVal.toUpperCase()).build()).getBoolVal();

			if (!flag) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Stat Isu '" + isuType + "' is failed to verify for : '" + isuVal + "'");
			} else {
				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + isuType + "' is verified for : '" + isuVal + "'");
			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to verify ISU : " + isuType + ", Value : " + isuVal);
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

	public static boolean setFlycathcer_Alert(TestCases testCase, String alertType, String alertValue) {
		boolean flag = false;
		try {
			flag = StatCommands.getInstance().cattCommandsStub.setAlertDevices(AlertmessageData.newBuilder()
					.setState(com.resideo.utils.stat.cattgrpccommands.AlertmessageData.ISUDevice.FLYCATHCER_TRADE)
					.setAlertKey(alertType).setAlertValue(alertValue).build()).getBoolVal();
			if (!flag) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Stat Isu '" + alertType + "' is not able to set to : '" + alertValue + "'");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"ISU Val : " + alertValue + " is UNIMPLEMENTED");
				flag = false;
			} else
				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + alertType + "' is set to : '" + alertValue + "'");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set isu configuration. ISU : " + alertType + ", Value : " + alertValue);
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}

	public static boolean verifyFlycathcer_Alert(TestCases testCase, String alertType, String alertValue) {
		boolean flag = false;
		try {
			flag = StatCommands.getInstance().cattCommandsStub.verifyAlertDevices(AlertmessageData.newBuilder()
					.setState(com.resideo.utils.stat.cattgrpccommands.AlertmessageData.ISUDevice.FLYCATHCER_TRADE)
					.setAlertKey(alertType).setAlertValue(alertValue).build()).getBoolVal();
			if (!flag) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Stat Isu '" + alertType + "' is not able to set to : '" + alertValue + "'");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"ISU Val : " + alertValue + " is UNIMPLEMENTED");
				flag = false;
			} else
				Keyword.ReportStep_Pass(testCase, "Stat Isu '" + alertType + "' is set to : '" + alertValue + "'");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to set isu configuration. ISU : " + alertType + ", Value : " + alertValue);
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}
}
