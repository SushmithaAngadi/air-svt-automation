package com.resideo.utils.resideo_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.featureidentity.FeatureFileMapper;
import com.resideo.commons.report.FailType;
import com.resideo.commons.thermostat.ThermostatAsset;
import com.resideo.system.utils.SerialInterfaceArduino;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.mqtt.MqttClientController;
import com.resideo.utils.stat.mqtt.MqttManager;
import com.resideo.utils.stat.mqtt.MqttSerialController;

public class HomeUtils {

	private static String macID;
	private static String deviceName;
	private static String BROKER_URL;

	public static String getBrokerUrl() {
		if (BROKER_URL == null) {
			throw new RuntimeException(" BROKER_URL has not been initialized. Check ProjectSpecific.properties.");
		}
		return BROKER_URL;
	}
	
	public static String getMacID() {
		return macID;
	}

	public static String getdeviceName() {
		return deviceName;
	}

	public static void printLogforSteps(TestCases testCase, boolean status, String message) {
		if (status) {
			Keyword.ReportStep_Pass(testCase, message + " Status is >>>" + status);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, message + " Status is >>>" + status);
		}

	}

	public static boolean setDeatilsToProjectSpecific_featureUpdate() {
		boolean flag = false;
		String model_Name = null;
		String mac_ID = null;
		try {

			String isMqttorGRPCorJIRA = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"MQTT_OR_GRPC");

			SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "RESIDEO_HOME_LOCAL_APK",
					System.getProperty("user.dir").replace("\\", "/")
							+ "/src/test/resources/MobileAPP/firstAlert.apk");
			SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "RESIDEO_HOME_LOCAL_IPA",
					System.getProperty("user.dir").replace("\\", "/")
							+ "/src/test/resources/MobileAPP/firstAlert.ipa");
			SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "RESIDEO_PRO_LOCAL_APK",
					System.getProperty("user.dir").replace("\\", "/")
							+ "/src/test/resources/MobileAPP/resideoPro.apk");


			if (isMqttorGRPCorJIRA.toUpperCase().contains("MQTT")) {
				String isSerialorPaho = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
						"MQTT_APPROACH");
				if (isSerialorPaho.toUpperCase().contains("SERIAL")) {
					if (MqttSerialController.connectToMqttPort()) {
						mac_ID = MqttSerialController.getDeviceInformation("MACID");
					}
					MqttManager.setIsSerialMethod(true);
				} else if (isSerialorPaho.toUpperCase().contains("PAHO")) {
					try {
						BROKER_URL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MQTT_BROKER_URL");
						System.out.println("BROKER_URL initialized: " + BROKER_URL);
						mac_ID = MqttManager.getMacId();
					} catch (Exception e) {
						System.out.println("Error initializing BROKER_URL: " + e.getMessage());
						BROKER_URL = null;
					}
					MqttClientController.startMQTTClient();
					MqttManager.setIsSerialMethod(false);
					flag = true;
				}
				// model_Name = null;
				//MqttManager.getModelNumber();
				if (model_Name == null || model_Name.isEmpty())
					model_Name = "GLENEAGLES";
			} else {
				mac_ID = StatCommands.getInstance().cattCommandsStub
						.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
				int length = mac_ID.toCharArray().length;
				if (length > 12) {
					int first = length - 12;
					String substring = mac_ID.substring(first, length);
					macID = substring;
				} else {
					macID = mac_ID;
				}

				model_Name = StatCommands.getInstance().cattCommandsStub
						.getDeviceInformation(String_Msg.newBuilder().setStrVal("MODEL_NAME").build()).getStrVal();
			}
			if (mac_ID != null) {
				int length = mac_ID.toCharArray().length;
				if (length > 12) {
					int first = length - 12;
					String substring = mac_ID.substring(first, length);
					macID = substring;
				} else {
					macID = mac_ID;
				}
				System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID", mac_ID));
			}
			
			String deviceModelName = ThermostatAsset.getDeviceModelName(model_Name.trim());
			String deviceModelName_SpecifiFeature = ThermostatAsset.getDeviceModelName_SpecifiFeature(model_Name);
			if (isMqttorGRPCorJIRA.toUpperCase().contains("JIRA")) {
				FeatureFileMapper.setProjectFolderName("JiraTestCases");
			} else {
				FeatureFileMapper.setProjectFolderName(deviceModelName_SpecifiFeature);
			}
			if (deviceModelName == null) {
				System.out.println("Device model name is not available");
				System.exit(0);
			} else {
				deviceName = deviceModelName;
			}
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST",
					deviceModelName));
			if (!deviceModelName.toUpperCase().contains("DENALI") && !deviceModelName.toUpperCase().contains("GLENEAGLES")) {
				String wifi_Version = StatCommands.getInstance().cattCommandsStub
						.getDeviceInformation(String_Msg.newBuilder().setStrVal("WIFI_VERSION").build()).getStrVal();
				System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
						"STAT_WIFI_BLE_VERSION", wifi_Version));
				String collection_Version = StatCommands.getInstance().cattCommandsStub
						.getDeviceInformation(String_Msg.newBuilder().setStrVal("COLLECTION_VERSION").build())
						.getStrVal();
				System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
						"STAT_COLLECTION_VERSION", collection_Version));
			}
			String deviceCountryNeedtoInstall = ThermostatAsset.getDeviceCountryNeedtoInstall(deviceModelName);
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"CHOOSE_COUNTRY_DEVICE_NEED_TO_INSTALL", deviceCountryNeedtoInstall));
			if(SerialInterfaceArduino.checkIsArdinoConnected()) {
				System.out.println("Arduino is Connected");
			}else {
				System.out.println("Arduino is Not Connected");
			}
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				String deviceUndertest = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
						"DEVICE_UNDER_TEST");
				String specifiFeature = ThermostatAsset.getDeviceModelTypeName_SpecifiFeature(deviceUndertest);
				FeatureFileMapper.setProjectFolderName(specifiFeature);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		return flag;
	}

	public static void setRouterEmpty() {
		try {
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME", ""));
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL", ""));
		} catch (Exception e) {
		}
	}

}