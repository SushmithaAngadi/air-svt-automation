package com.resideo.utils.stat;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.IOP_StateUtils;
import com.resideo.system.utils.KeepAppActive;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;

public class WifiStatus_Thermostat {

	public static boolean getWifiConfigurationStatus(TestCases testCase, Duration withTimeOut, boolean iswifiConnected,
			String router_SSID_Name) {
		boolean flag = false;
		String router_IP_Address = IOP_StateUtils.getInstance().getIPAddress();
		KeepAppActive appActive = new KeepAppActive(testCase);
		try {
			appActive.start();
			boolean eventRec = false;
			try {
				FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
				fwait1.pollingEvery(Duration.ofSeconds(10));
				fwait1.withTimeout(withTimeOut);
//				fwait1.withTimeout(Duration.ofMinutes(2));
				boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean input) {
						try {
							String ipAddress = StatCommands.getInstance().cattCommandsStub
									.getDeviceInfo(
											DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
									.getStrVal();
							String WifiName = StatCommands.getInstance().cattCommandsStub
									.getDeviceInfo(
											DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build())
									.getStrVal();

							if (iswifiConnected) {
								if (ipAddress == null) {
									Keyword.ReportStep_Pass(testCase,
											"Wifi not connected, wait for sometime if thermostat try to connect to the wifi");
									return false;
								} else if (ipAddress.contains("invalid")) {
									if (WifiName == null || WifiName.isEmpty()) {
										Keyword.ReportStep_Pass(testCase, "WIFI not configured");
										return true;
									} else {
										Keyword.ReportStep_Pass(testCase,
												"WIFI IP is invalid, wifi name is not empty or null, WIfi name is "
														+ WifiName);
										return false;
									}
								} else if ((ipAddress.substring(0, 2).contains("0."))
										|| (ipAddress.substring(0, 1).contains("0"))) {
									Keyword.ReportStep_Pass(testCase,
											"Wifi not connected, wait for sometime if thermostat try to connect to the wifi. IP from device is "
													+ ipAddress);
									return false;
								} else if (ipAddress.substring(0, 3).contains("169")) {
									Keyword.ReportStep_Pass(testCase,
											"WIFI configured may be its in link local, IP address is " + ipAddress);
									return false;

								} else if (areFirstThreeSegmentsEqual(ipAddress, router_IP_Address)) {
									if (!ipAddress.substring(0, 3).contains("169")
											&& WifiName.contains(router_SSID_Name)) {
										Keyword.ReportStep_Pass(testCase,
												"WIFI configured, IP address is " + ipAddress);
										Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
										return true;
									} else if (WifiName.contains(router_SSID_Name)) {
										Keyword.ReportStep_Pass(testCase,
												"WIFI configured, IP address is " + ipAddress);
										Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
										Keyword.ReportStep_Pass(testCase, "Thermostat wifi is not in link local");
										return true;
									} else {
										return false;
									}
								} else {
									Keyword.ReportStep_Pass(testCase, "Current IP address is " + ipAddress);
									Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + WifiName);
									return false;
								}
							} else {
								if (ipAddress == null) {
									Keyword.ReportStep_Pass(testCase,
											"Wifi not connected, wait for sometime if thermostat try to connect to the wifi");
									return false;
								} else if (ipAddress.contains("invalid")) {
									Keyword.ReportStep_Pass(testCase, "Ip address is invalid from stat");
									return true;
								} else if ((ipAddress.substring(0, 2).contains("0."))
										|| (ipAddress.substring(0, 1).contains("0"))) {
									Keyword.ReportStep_Pass(testCase,
											"Wifi not connected, wait for sometime if thermostat try to connect to the wifi. IP from device is "
													+ ipAddress);
									return true;
								} else if (ipAddress.substring(0, 3).contains("169")) {
									Keyword.ReportStep_Pass(testCase,
											"WIFI configured may be its in link local, IP address is " + ipAddress);
									return true;
//								} else if (!ipAddress.substring(0, 3).contains("169")
//										&& WifiName.contains(router_SSID_Name)) {
//									Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
//									Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
//									return true;
								} else {
									Keyword.ReportStep_Pass(testCase, "Current IP address is " + ipAddress);
									Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + WifiName);
									return false;
								}
							}
						} catch (Exception e) {
							Keyword.ReportStep_Pass(testCase, "Failed to read IPV4 address...");
							return false;
						}
					}
				});
				if (!iswifiConnected) {
					if (isEventReceived1) {
						Keyword.ReportStep_Pass(testCase, "Thermostat disconnected with wifi, current ip address is "
								+ StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
										.getStrVal());
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to disconnect thermostat with router, current ip is "
										+ StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
												.getStrVal());
						flag = false;
					}
				} else {
					if (isEventReceived1) {
						Keyword.ReportStep_Pass(testCase, "Thermostat connected with wifi, current ip address is "
								+ StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
										.getStrVal());
						flag = true;
					} else {

						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to connect thermostat with router, current ip is "
										+ StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
												.getStrVal());
						flag = false;
					}
				}
			} catch (TimeoutException e) {
				if (!iswifiConnected) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Wifi not connected exactly with same network, WIFI ssid name is "
							+ StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
									DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build()).getStrVal()
							+ " current ip is "
							+ StatCommands.getInstance().cattCommandsStub
									.getDeviceInfo(
											DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
									.getStrVal());
					appActive.requestStop();
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to set Network configuration. Exception raised : " + e.getMessage());
					appActive.requestStop();
				}

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to set Network configuration. Exception raised : " + e.getMessage());
				appActive.requestStop();
			}
			if (appActive.isAlive())
				appActive.requestStop();
		} catch (

		Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to set network configuration");
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
			if (appActive.isAlive())
				appActive.requestStop();
		}
		return flag;

	}

	public static boolean areFirstThreeSegmentsEqual(String ip1, String ip2) {
		// Split IP addresses into segments
		String[] segments1 = ip1.split("\\.");
		String[] segments2 = ip2.split("\\.");

		// Check if both IP addresses have at least 3 segments
		if (segments1.length < 3 || segments2.length < 3) {
			throw new IllegalArgumentException("Invalid IP address format.");
		}

		// Compare the first three segments
		return segments1[0].equals(segments2[0]) && segments1[1].equals(segments2[1])
				&& segments1[2].equals(segments2[2]);
	}
}
