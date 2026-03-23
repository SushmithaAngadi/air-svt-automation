package com.resideo.utils.ipcontroller;

import java.time.Duration;
import java.util.function.Function;

import org.json.JSONObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.IOP_StateUtils;
import com.resideo.system.utils.ResilientSleep;
import com.resideo.utils.api.common.ApiCommonUtil;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.IP_controllerMetaData;
import com.resideo.utils.stat.cattgrpccommands.IP_controllerMetaData.requestType;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

public class IpControllerUtils {

	public static enum IOP_Controller_AddressBit {
		FIND_AUTO_CONNECTED_PORT("FIND_ME"), TURNOFF_ALL_BUT_NOT_INTERNET_PORT("RELAYALL_OFF_EXCLUDE_INTERNET"),
		TURNOFF_ALL_INCLUDE_INTERNET_PORT("RELAYALL_OFF"), TURN_ON_IP_FINDER_ONLY("IP_CONTROLLER_ON"),
		TURN_OFF_IP_FINDER_ONLY("IP_CONTROLLER_OFF"), TURN_ON_INTERNET_SWITCH_ONLY("INTERNET_CONTROLLER_ON"),
		TURN_OFF_INTERNET_SWITCH_ONLY("INTERNET_CONTROLLER_OFF"), WATCH_DOG_RESET("WATCH_DOG"),
		ROUTER_RELAY_APPEND("_ON");

		private String constantType;

		IOP_Controller_AddressBit(String constantType) {
			this.constantType = constantType;
		}

		public String getConstantType() {
			return constantType;
		}
	};

	public static boolean _Controller_IP_Monitor(TestCases testCase, String routerManufacturerName,
			String routerModel) {
		boolean flag = false;
		try {
			JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
			JSONObject json = get_RouterDetails.getJSONObject(routerManufacturerName).getJSONObject(routerModel);
			String relayName = "RELAY_" + json.getString("relay");
			if (routerManufacturerName.toLowerCase().contains("amped")) {
				if (sendCommandToController(IOP_Controller_AddressBit.TURNOFF_ALL_INCLUDE_INTERNET_PORT)) {
					System.out.println("Executing : TURNOFF_ALL_INCLUDE_INTERNET_PORT ");
					ResilientSleep.silentSleep(5000);
					if (sendCommandToController(
							relayName + IOP_Controller_AddressBit.ROUTER_RELAY_APPEND.getConstantType())) {
						System.out.println("Executing : ROUTER_RELAY_APPEND ");
						ResilientSleep.silentSleep(4000);
						for (int i = 0; i < 3; i++) {
							if (sendCommandToController(IOP_Controller_AddressBit.TURN_ON_IP_FINDER_ONLY)) {
								System.out.println("Executing : TURN_ON_IP_FINDER_ONLY ");
								ResilientSleep.silentSleep(4000);
								if (sendCommandToController(IOP_Controller_AddressBit.TURN_ON_INTERNET_SWITCH_ONLY)) {
									System.out.println("Executing : TURN_ON_INTERNET_SWITCH_ONLY ");
									if (getIPAddress_IPController(testCase, routerModel, 50)) {
										if (checkInternetConnection_on_IPAddress(testCase,
												IOP_StateUtils.getInstance().getIPAddress(), 30)) {
											flag = true;
											break;
										} else {
											if (sendCommandToController(
													IOP_Controller_AddressBit.TURN_ON_IP_FINDER_ONLY)) {
												if (sendCommandToController(
														IOP_Controller_AddressBit.TURN_OFF_INTERNET_SWITCH_ONLY)) {
													ResilientSleep.silentSleep(10000);
												} else {
													Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
															"Not able to turn OFF All Routers include internet Port and ip controller");
													flag = false;
												}
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
														"Not able to turn ON the router, router manufacturer name is "
																+ routerManufacturerName + " , router model "
																+ routerModel);
												flag = false;
											}
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
												"Not able to get the ip address of ipcontroller");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
											"Not able to turn on internet controller.");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Not able to get the IP address from the IP controller" + routerManufacturerName
												+ " , router model " + routerModel);
								flag = false;
							}
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to turn ON the router, router manufacturer name is " + routerManufacturerName
										+ " , router model " + routerModel);
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to turn OFF All Routers .");
					flag = false;
				}
			} else {
				for (int i = 0; i < 3; i++) {
					if (sendCommandToController(IOP_Controller_AddressBit.TURNOFF_ALL_INCLUDE_INTERNET_PORT)) {
						ResilientSleep.silentSleep(5000);
						sendCommandToController(IOP_Controller_AddressBit.TURN_ON_INTERNET_SWITCH_ONLY);
						ResilientSleep.silentSleep(5000);
						if (sendCommandToController(
								relayName + IOP_Controller_AddressBit.ROUTER_RELAY_APPEND.getConstantType())) {
							ResilientSleep.silentSleep(10000);
							if (sendCommandToController(IOP_Controller_AddressBit.TURN_ON_IP_FINDER_ONLY)) {
								if (getIP_CheckInternet_Connection(testCase, 300)) {
									Keyword.ReportStep_Pass(testCase, "Internet Detected and IP Assigned");
									flag = true;
									break;
								} else {
									if (sendCommandToController(
											IOP_Controller_AddressBit.TURNOFF_ALL_INCLUDE_INTERNET_PORT)) {
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
												"Not able to turn OFF All Routers include internet Port");
										flag = false;
									}
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Not able to turn ON the router, router manufacturer name is "
												+ routerManufacturerName + " , router model " + routerModel);
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to turn ON the router, router manufacturer name is "
											+ routerManufacturerName + " , router model " + routerModel);
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to turn OFF All Routers exclude internet Port");
						flag = false;
					}
				}
			}
			if (!flag) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Internet not present from this router " + routerModel);
				flag = false;
			}
			ApiCommonUtil.set_PropertiesData_Router(json, IOP_StateUtils.getInstance().getIPAddress());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}

	public static boolean sendCommandToController(IOP_Controller_AddressBit iop_controller_addressBit) {
		return StatCommands.getInstance().cattCommandsStub
				.changeWIFIIPCONTROLLERRelayStatus(
						String_Msg.newBuilder().setStrVal(iop_controller_addressBit.getConstantType()).build())
				.getBoolVal();
	}

	public static boolean sendCommandToController(String iop_controller_addressBit) {
		return StatCommands.getInstance().cattCommandsStub
				.changeWIFIIPCONTROLLERRelayStatus(String_Msg.newBuilder().setStrVal(iop_controller_addressBit).build())
				.getBoolVal();
	}

	public static boolean getIPAddress_IPController(TestCases testCase, String routerName, int MaxWaitTime_inSeconds) {
		boolean flag = false;
		try {
			String ip_exclude_list = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION,
					"EXCLUDE_IP");
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(MaxWaitTime_inSeconds));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						IP_controllerMetaData responseStatus = StatCommands.getInstance().cattCommandsStub
								.checkIOPConnectionRequestAndResponseStatus(IP_controllerMetaData.newBuilder()
										.setExcludeIpList(ip_exclude_list).setRequest(requestType.IP_INTERNET).build());
						String ipAddress = responseStatus.getIPAddress();
						if (routerName.toUpperCase().contains("AMPED")) {
							if (ipAddress.contains("192.168.3")) {
								Keyword.ReportStep_Pass(testCase, "IP Address is " + ipAddress);
								IOP_StateUtils.getInstance().setIpAddress(ipAddress);
								return true;
							} else {
								System.out.println("response is " + responseStatus.getIPAddress() + " , status is "
										+ responseStatus.getStatus() + " , is internet available status "
										+ responseStatus.getIsInternetAvailable());
								return false;
							}
						} else {
							if (ipAddress.contains("192.168")) {
								Keyword.ReportStep_Pass(testCase, "IP Address is " + ipAddress);
								IOP_StateUtils.getInstance().setIpAddress(ipAddress);
								return true;
							} else {
								System.out.println("response is " + responseStatus.getIPAddress() + " , status is "
										+ responseStatus.getStatus());
								return false;
							}
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Not able to find IP due to timeout");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to get IP address. Execption raised : " + e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Not able to find IPdue to timeout");
			return false;
		} catch (InterruptedException e) {
			Keyword.ReportStep_Pass(testCase, "Not able to find IP due to interrupted exception");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Execption raised : " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean checkInternetConnection_on_IPAddress(TestCases testCase, String ipAddress,
			int MaxWaitTime_inSeconds) {
		boolean flag = false;
		try {
			String ip_exclude_list = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION,
					"EXCLUDE_IP");
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofSeconds(MaxWaitTime_inSeconds));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						IP_controllerMetaData responseStatus = StatCommands.getInstance().cattCommandsStub
								.checkIOPConnectionRequestAndResponseStatus(IP_controllerMetaData.newBuilder()
										.setIPAddress(ipAddress).setExcludeIpList(ip_exclude_list)
										.setRequest(requestType.INTERNET_ONLY).build());
						boolean isInternetAvailable = responseStatus.getIsInternetAvailable();
						if (isInternetAvailable) {
							Keyword.ReportStep_Pass(testCase,
									"for this '" + ipAddress + "' IP Address internet avaialble");
							return true;
						} else {
							System.out
									.println("response is " + ipAddress + " , status is " + responseStatus.getStatus());
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Not able to find IP and internet connection");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to verify internet connection. Execption raised : " + e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Not able to find IP and internet connection due to timeout");
			return false;
		} catch (InterruptedException e) {
			Keyword.ReportStep_Pass(testCase,
					"Not able to find IP and internet connection due to interrupted exception");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Execption raised : " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean getIP_CheckInternet_Connection(TestCases testCase, int MaxWaitTime_inSeconds) {
		boolean flag = false;
		try {
			String ip_exclude_list = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION,
					"EXCLUDE_IP");
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(MaxWaitTime_inSeconds));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						IP_controllerMetaData responseStatus = StatCommands.getInstance().cattCommandsStub
								.checkIOPConnectionRequestAndResponseStatus(
										IP_controllerMetaData.newBuilder().setExcludeIpList(ip_exclude_list)
												.setRequest(requestType.INTERNET_ONLY).build());
						boolean isInternetAvailable = responseStatus.getIsInternetAvailable();
						if (isInternetAvailable && responseStatus.getFlag()) {
							Keyword.ReportStep_Pass(testCase,
									"for this '" + responseStatus.getIPAddress() + "' IP Address internet avaialble");
							IOP_StateUtils.getInstance().setIpAddress(responseStatus.getIPAddress());
							return true;
						} else {
							System.out.println("response is " + responseStatus.getIPAddress() + " , status is "
									+ responseStatus.getStatus());
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Not able to find IP and internet connection due to timeout");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to verify relays. Execption raised : " + e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Not able to find IP and internet connection due to timeout");
			return false;
		} catch (InterruptedException e) {
			Keyword.ReportStep_Pass(testCase,
					"Not able to find IP and internet connection due to interrupted exception");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Execption raised : " + e.getMessage());

			flag = false;
		}

		return flag;
	}

}