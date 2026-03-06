//package com.resideo.keywords.wifi.integration;
//
//import java.util.ArrayList;
//
//import org.json.JSONObject;
//
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordException;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.SuiteConstants;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.api.common.ApiCommonUtil;
//import com.resideo.utils.networkresolution.NetworkInfo;
//import com.resideo.utils.stat.StatCommands;
//import com.resideo.utils.stat.cattgrpccommands.String_Msg;
//
//import io.cucumber.java.en.Given;
//
///*
// * @link
// * @notes : Relay table need to seperate from this class
// * #Valid : Change format string to json
// * @Event : Change Router time as per page load, use retry flow for reducing time consume.
// * 
// */
//
//public class Start_Wifi_Integration_Module2 extends Keyword {
//
//	private TestCases testCase;
//	ArrayList<String> exampleData;
//	public boolean flag = true;
//
//	public Start_Wifi_Integration_Module2(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
//		this.testCase = testCase;
//		this.exampleData = data;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() throws KeywordException {
//
//		return flag;
//	}
//
////	start wifi intigeration with switch and turn "on netgear" router and the model is ""
//
//	@Given(value = "^start wifi intigeration with switch and turn (.+) router and the model is (.+)$")
//	@Override
//	@KeywordStep(gherkins = "^start wifi intigeration with switch and turn (.+) router and the model is (.+)$")
//	public boolean keywordSteps() throws KeywordException {
//		String routerBrand = exampleData.get(0).toUpperCase();
//		String routerModel = exampleData.get(1).toUpperCase();
//
//		if (testCase.isTestSuccessful()) {
//			try {
//				if (routerBrand.contains("ASUS")) {
//					routerBrand = "ASUS";
//					if (routerModel.contains("RTAC68U")) {
//						routerModel = "RTAC68U";
//					}
//				} else if (routerBrand.contains("NETGEAR")) {
//					routerBrand = "NETGEAR";
//					if (routerModel.contains("AC1750")) {
//						routerModel = "AC1750";
//					} else if (routerModel.contains("R6250")) {
//						routerModel = "R6250";
//					} else if (routerModel.contains("WNDR3800CH")) {
//						routerModel = "WNDR3800CH";
//					} else if (routerModel.contains("R7000")) {
//						routerModel = "R7000";
//					} else if (routerModel.contains("RAX10")) {
//						routerModel = "RAX10";
//					}
//				} else if (routerBrand.contains("TPLINK")) {
//					routerBrand = "TPLINK";
//					if (routerModel.contains("AX1500")) {
//						routerModel = "AX1500";
//					}
//				} else if (routerBrand.contains("CISCO")) {
//					routerBrand = "CISCO";
//					if (routerModel.contains("EAB11")) {
//						routerModel = "EAB11";
//					} else if (routerModel.contains("WRT120N")) {
//						routerModel = "WRT120N";
//					}
//				} else if (routerBrand.contains("BELKIN")) {
//					routerBrand = "BELKIN";
//					if (routerModel.contains("F9K1102V1")) {
//						routerModel = "F9K1102V1";
//					}
//				} else if (routerBrand.contains("BUFFALO")) {
//					routerBrand = "BUFFALO";
//					if (routerModel.contains("WZR600DHCP")) {
//						routerModel = "WZR600DHCP";
//					}
//
//				} else if (routerBrand.contains("INTELLINET")) {
//					routerBrand = "INTELLINET";
//					if (routerModel.contains("150N3G")) {
//						routerModel = "150N3G";
//					}
//				} else if (routerBrand.contains("AMPED")) {
//					routerBrand = "AMPED";
//					if (routerModel.contains("R20000G")) {
//						routerModel = "R20000G";
//					} else if (routerModel.contains("RTA15")) {
//						routerModel = "RTA15";
//					}
//				} else if (routerBrand.contains("AIRLIVE")) {
//					routerBrand = "AIRLIVE";
//					if (routerModel.contains("WN220R")) {
//						routerModel = "WN220R";
//					}
//				} else if (routerBrand.contains("CENTURYLINK")) {
//					routerBrand = "CENTURYLINK";
//					if (routerModel.contains("ZYXELC3000Z")) {
//						routerModel = "ZYXELC3000Z";
//					}
//				} else if (routerBrand.contains("DLINK")) {
//					routerBrand = "DLINK";
//					if (routerModel.contains("824VUP")) {
//						routerModel = "824VUP";
//					} else if (routerModel.contains("DIR1750")) {
//						routerModel = "DIR1750";
//					} else if (routerModel.contains("DIR890L")) {
//						routerModel = "DIR890L";
//					}
//				} else if (routerBrand.contains("UBEE")) {
//					routerBrand = "UBEE";
//					if (routerModel.contains("EVW321B")) {
//						routerModel = "EVW321B";
//					}
//				} else if (routerBrand.contains("HAWKING")) {
//					routerBrand = "HAWKING";
//					if (routerModel.contains("HAW2R1300N")) {
//						routerModel = "HAW2R1300N";
//					} else if (routerModel.contains("HW2R1150M")) {
//						routerModel = "HW2R1150M";
//					}
//				} else if (routerBrand.contains("VIZIO")) {
//					routerBrand = "VIZIO";
//					if (routerModel.contains("XWR100")) {
//						routerModel = "XWR100";
//					}
//				}
//				String routerModelName = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "ROUTER_NAME");
//				if (!routerModelName.isEmpty() && routerModel.contains(routerModelName)) {
//					flag = true;
//					ReportStep_Pass(testCase, "Already router brand " + routerBrand + " and router model is "
//							+ routerModel + " is connected with system");
//				} else {
//					if (routerBrand.contains("ASUS")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build())
//								.getBoolVal());
//						Thread.sleep(100000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("asus").getJSONObject("RTAC68U");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("NETGEAR")) {
//						if (routerBrand.contains("AC1750")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY3ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(100000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("AC1750");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerBrand.contains("R6250")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY11ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(100000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("R6250");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerBrand.contains("WNDR3800CH")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(100000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("WNDR3800CH");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerBrand.contains("R7000")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY13ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(100000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("R7000");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerBrand.contains("RAX10")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY13ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(100000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("netgear").getJSONObject("RAX10");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else {
//							ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//									"Mentioned router name is not present in this list");
//							flag = false;
//						}
//
//					} else if (routerBrand.contains("TPLINK")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY4ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("tplink").getJSONObject("AX1500");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("CISCO")) {
//						if (routerModel.contains("EAB11")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY5ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("cisco").getJSONObject("EAB11");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerModel.contains("WRT120N")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY10ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("cisco").getJSONObject("WRT120N");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else {
//							ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//									"Mentioned router name is not present in this list");
//							flag = false;
//						}
//
//					} else if (routerBrand.contains("BELKIN")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY6ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("belkin").getJSONObject("F9K1102v1");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("BUFFALO")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY7ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("buffalo").getJSONObject("WZR600DHCP");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("INTELLINET")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY8ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("intellinet").getJSONObject("150N3G");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//
//					} else if (routerBrand.contains("AMPED")) {
//						if (routerModel.contains("R2000G")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY8ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("amped").getJSONObject("R20000G");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerBrand.contains("AMPED")) {
//							if (routerModel.contains("RTA15")) {
//								System.out
//										.println(StatCommands.getInstance().cattCommandsStub
//												.changeArduinoRelayStatus(
//														String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//												.getBoolVal());
//								Thread.sleep(10000);
//								System.out
//										.println(StatCommands.getInstance().cattCommandsStub
//												.changeArduinoRelayStatus(
//														String_Msg.newBuilder().setStrVal("RELAY10ON").build())
//												.getBoolVal());
//								Thread.sleep(150000);
//								System.out.println(StatCommands.getInstance().cattCommandsStub
//										.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//										.getBoolVal());
//								Thread.sleep(200000);
//								JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//								JSONObject json = get_RouterDetails.getJSONObject("amped").getJSONObject("RTA15");
//								ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//							}
//						}
//					} else if (routerBrand.contains("AIRLIVE")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY9ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("airlive").getJSONObject("WN220R");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("CENTURYLINK")) {
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//								.getBoolVal());
//						Thread.sleep(10000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY10ON").build())
//								.getBoolVal());
//						Thread.sleep(150000);
//						System.out.println(StatCommands.getInstance().cattCommandsStub
//								.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//								.getBoolVal());
//						Thread.sleep(200000);
//						JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//						JSONObject json = get_RouterDetails.getJSONObject("centurylink").getJSONObject("ZYXELC3000Z");
//						ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//					} else if (routerBrand.contains("DLINK")) {
//						if (routerModel.contains("824VUP")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY11ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("dlink").getJSONObject("824VUP");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerModel.contains("DIR1750")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("dlink").getJSONObject("DIR1750");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerModel.contains("DIR890L")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("dlink").getJSONObject("DIR890L");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						}
//
//					} else if (routerBrand.contains("UBEE")) {
//						if (routerModel.contains("EVW321B")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("ubee").getJSONObject("EVW321B");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						}
//
//					} else if (routerBrand.contains("HAWKING")) {
//						if (routerModel.contains("HW2R1")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("hawking").getJSONObject("HW2R1");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						} else if (routerModel.contains("HAW2R1")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("hawking").getJSONObject("HAW2R1");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						}
//					} else if (routerBrand.contains("VIZIO")) {
//						if (routerModel.contains("XWR100")) {
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("ALLRELAYOFF").build())
//									.getBoolVal());
//							Thread.sleep(10000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
//									.getBoolVal());
//							Thread.sleep(150000);
//							System.out.println(StatCommands.getInstance().cattCommandsStub
//									.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build())
//									.getBoolVal());
//							Thread.sleep(200000);
//							JSONObject get_RouterDetails = ApiCommonUtil.get_RouterDetails();
//							JSONObject json = get_RouterDetails.getJSONObject("vizio").getJSONObject("XWR100");
//							ApiCommonUtil.set_PropertiesData_Router(json, NetworkInfo.getDHCP_GatewayIP());
//						}
//					}
//				}
//			} catch (Exception e) {
//				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
//				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"router brnad " + routerBrand + " , router model is " + routerModel + " ,failed");
//				flag = false;
//			}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
//		return flag;
//	}
//
//	@Override
//	@AfterKeyword
//	public boolean postCondition() {
//		try {
////			Thread.sleep(90000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return flag;
//	}
//}
