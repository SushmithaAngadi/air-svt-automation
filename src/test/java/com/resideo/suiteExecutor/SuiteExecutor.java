package com.resideo.suiteExecutor;

import java.util.Arrays;

import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteUtils;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.utils.resideo_app.HomeUtils;

public class SuiteExecutor {

	public static void main(String[] commandLineArguments) throws Exception {

//		System.out.println(StatCommands.getInstance().cattCommandsStub
//				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal("RELAYALL_OFF").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub
//				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1_ON").build()).getBoolVal());
//		
//		System.out.println(StatCommands.getInstance().cattCommandsStub
//				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal("IP_CONTROLLER_ON").build()).getBoolVal());
//		
//		System.out.println(StatCommands.getInstance().cattCommandsStub
//				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal("INTERNET_CONTROLLER_ON").build()).getBoolVal());
//		
//		System.out.println(StatCommands.getInstance().cattCommandsStub
//				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal("RELAYALL_OFF_EXCLUDE_INTERNET").build()).getBoolVal());

//		
//Boolean_Msg setSetpoint = StatCommands.getInstance().cattCommandsStub.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_HEAT).setVal(10).build());
//System.out.println(setSetpoint);
//		
//		
//		Homekit Test Plan ID is HTA-1635   "--xrayplanid","IOS:HTA-1635",
//		DIY IOS Plan Test ID is HTA-1635   "--xrayplanid","IOS:HTA-1638",
//		DIY Android Test Plan ID is HTA-1635   "--xrayplanid","IOS:HTA-1633",
//		DIY Android Test Plan ID is HTA-1635   "--xrayplanid","IOS:HTA-3055",
//		String dhcp_GatewayIP = NetworkInfo.getDHCP_GatewayIP();
//		System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.WEB_APP, "WEB_URL", dhcp_GatewayIP));

		commandLineArguments = new String[] {
//				"--publishresult", "true", 
//				"--jira_credentials", "c3ZfY29tZm9ydGF1dG9tYXRpb246RHJ0aWM3OF41QXFAWA==",
//				"--xrayplanid","IOS:HTA-1635",
//				"--requirementfilename","Requirement_file_ANDROID.txt",
//				"--requirementfilename","Requirement_file_HOMEKIT.txt",
//				"--requirementfilename","Requirement_file_iOS.txt",
//				"--requirementfilename", "Requirement_file_wifi.txt",
//				"--xrayplanid", "IOS:HTA-3055", 
				"--requirementfilename", "Requirement_file.txt",
				"--useXCUITest", "true", "--appToInstall", "Android:6.2.0,IOS:6.2.0", };
		
		if( SuiteConstants.getConstantValue(SuiteConstantTypes.RESULT_EMAIL_RECIPIENTS,
						"PublishResult").toUpperCase().contains("YES")) {
			commandLineArguments = Arrays.copyOf(commandLineArguments, commandLineArguments.length + 2);
			commandLineArguments[commandLineArguments.length - 2] = "--publishresult";
			commandLineArguments[commandLineArguments.length - 1] = "true";
		}
		try {

			/*
			 * New Variables added for Project Specific
			 */
//			HomeUtils.setRouterEmpty();
			HomeUtils.setDeatilsToProjectSpecific_featureUpdate();
			SuiteUtils suiteUtils = SuiteUtils.getTestSuite(commandLineArguments);
			suiteUtils.executeSuite();
			System.out.println("scrip end");
		} catch (Exception e) {
			System.err.println("Suite execution failed: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(1);
	}

}
