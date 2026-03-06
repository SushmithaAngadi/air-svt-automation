package com.resideo.suiteExecutor;

import org.json.JSONObject;

import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteUtils;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.utils.api.common.ApiCommonUtil;
import com.resideo.utils.networkresolution.NetworkInfo;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

public class ClonedSuiteExecutor {

//	public static void main(String[] commandLineArguments) throws Exception {
//		String dhcp_GatewayIP = NetworkInfo.getDHCP_GatewayIP();
//		System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.WEB_APP, "WEB_URL", dhcp_GatewayIP));
//
//		commandLineArguments = new String[] {
//				"--requirementfilename", "Requirement_file.txt", "--useXCUITest", "true", "--appToInstall",
//				"Android:6.2.0,IOS:6.2.0", };
//		try {
//
//			/*
//			 * New Variables added for Project Specific
//			 */
//			HomeUtils.setDeatilsToProjectSpecific_featureUpdate();
//			SuiteUtils suiteUtils = SuiteUtils.getTestSuite(commandLineArguments);
//			suiteUtils.executeSuite();
//			System.out.println("scrip end");
//		} catch (Exception e) {
//			System.exit(1);
//		}
//		System.exit(1);
//	}

	public static void main(String[] commandLineArguments_1) throws Exception {

		String[] routerRequirmentFile = new String[] { "Asus_RTAC68U.txt", "netgear_AC1750.txt", "tplink_AX1500.txt", };
//		String[] routerRequirmentFile = new String[] { "netgear_AC1750.txt", "tplink_AX1500.txt", };
//		String[] routerRequirmentFile = new String[] { "netgear_AC1750.txt" };
		for (int i = 0; i < routerRequirmentFile.length; i++) {
			try {
				if (routerRequirmentFile[i].toUpperCase().contains("ASUS")) {
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//							.getBoolVal());
//					Thread.sleep(10000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build())
//							.getBoolVal());
//					Thread.sleep(90000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//							.getBoolVal());
//					Thread.sleep(30000);
					
					
					JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
					JSONObject json = get_RouterDetails.getJSONObject("asus").getJSONObject("RTAC68U");
					ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
					String[] commandLineArguments = new String[] { "--requirementfilename", "Requirement_file_Asus_RTAC68U.txt",
							"--useXCUITest", "true", "--appToInstall", "Android:6.2.0,IOS:6.2.0", };
					try {
						/*
						 * New Variables added for Project Specific
						 */
						HomeUtils.setDeatilsToProjectSpecific_featureUpdate();
						SuiteUtils suiteUtils = SuiteUtils.getTestSuite(commandLineArguments);
						suiteUtils.executeSuite();
						System.out.println("scrip end");
						System.gc();
//						SuiteUtils.setSuite();
					} catch (Exception e) {
						System.exit(1);
					}

				} else if (routerRequirmentFile[i].toUpperCase().contains("NETGEAR")) {
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//							.getBoolVal());
//					Thread.sleep(10000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY3ON").build())
//							.getBoolVal());
//					Thread.sleep(100000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//							.getBoolVal());
//					Thread.sleep(40000);
					
					JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
					JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("AC1750");
					ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
					String[] commandLineArguments = new String[] { "--requirementfilename", "Requirement_file_netgear_AC1750.txt",
							"--useXCUITest", "true", "--appToInstall", "Android:6.2.0,IOS:6.2.0", };
					try {
						/*
						 * New Variables added for Project Specific
						 */
						HomeUtils.setDeatilsToProjectSpecific_featureUpdate();
						SuiteUtils suiteUtils = SuiteUtils.getTestSuite(commandLineArguments);
						suiteUtils.executeSuite();
						System.out.println("scrip end");
//						SuiteUtils.setSuite();
						System.gc();
					} catch (Exception e) {
						System.exit(1);
					}
				} else if (routerRequirmentFile[i].toUpperCase().contains("TPLINK")) {
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//							.getBoolVal());
//					Thread.sleep(10000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY4ON").build())
//							.getBoolVal());
//					Thread.sleep(90000);
//					System.out.println(StatCommands.getInstance().cattCommandsStub
//							.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//							.getBoolVal());
//					Thread.sleep(30000);
					
					JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
					JSONObject json = get_RouterDetails.getJSONObject("tplink").getJSONObject("AX1500");
					ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
					String[] commandLineArguments = new String[] { "--requirementfilename", "Requirement_file_tplink_AX1500.txt",
							"--useXCUITest", "true", "--appToInstall", "Android:6.2.0,IOS:6.2.0", };
					try {
						/*
						 * New Variables added for Project Specific
						 */
						HomeUtils.setDeatilsToProjectSpecific_featureUpdate();
						SuiteUtils suiteUtils = SuiteUtils.getTestSuite(commandLineArguments);
						suiteUtils.executeSuite();
						System.out.println("scrip end");
//						SuiteUtils.setSuite();
						System.gc();
					} catch (Exception e) {
						System.exit(1);
					}

				}
			} catch (Exception e) {
				System.exit(1);
			}
		}
		System.exit(1);
	}

}
