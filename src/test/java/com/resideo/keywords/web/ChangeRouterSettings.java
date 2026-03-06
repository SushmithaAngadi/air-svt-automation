package com.resideo.keywords.web;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.IOP_StateUtils;
import com.resideo.utils.ipcontroller.IpControllerUtils;
import com.resideo.utils.web.AirLiveRouterUtils;
import com.resideo.utils.web.AmpedRouterUtils;
import com.resideo.utils.web.AsusRouterUtils;
import com.resideo.utils.web.BelkinRouterUtils;
import com.resideo.utils.web.BuffaloRouterUtils;
import com.resideo.utils.web.CenturyLinkRouterUtils;
import com.resideo.utils.web.CiscoRouterUtils;
import com.resideo.utils.web.DLinkRouterUtils;
import com.resideo.utils.web.HawkingRouterUtils;
import com.resideo.utils.web.IntellinetRouterUtils;
import com.resideo.utils.web.NetGearRouterUtils;
import com.resideo.utils.web.TpLinkRouterUtil;
import com.resideo.utils.web.UbeeRouterUtils;
import com.resideo.utils.web.VerizonRouterUtils;
import com.resideo.utils.web.VizioRouterUtils;
import com.resideo.utils.web.WDRouterUtils;

import io.cucumber.java.en.Given;

public class ChangeRouterSettings extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String routerName;

	public ChangeRouterSettings(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^user edit router settings as (.+) in (.+) router screen$")
	@Override
	@KeywordStep(gherkins = "^user edit router settings as (.+) in (.+) router screen$")
	public boolean keywordSteps() throws KeywordException {
		String screenName = exampleData.get(1).toUpperCase();
		String options = exampleData.get(0);
		if (testCase.isTestSuccessful()) {
			try {
				routerName = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME")
						.toUpperCase();
				switch (routerName) {
				case "ASUS":
					flag = AsusRouterUtils.changeRouterSettingsInAsus(testCase, screenName, options);
					break;
				case "NETGEAR":
				case "NET GEAR":
				case "NET_GEAR":
					flag = NetGearRouterUtils.changeRouterSettingsInNetgear(testCase, screenName, options);
					break;
				case "TPLINK":
					flag = TpLinkRouterUtil.changeRouterSettingsInTPLink(testCase, screenName, options);
					break;
				case "CISCO":
					flag = CiscoRouterUtils.changeRouterSettingsInCisco(testCase, screenName, options);
					break;
				case "BELKIN":
					flag = BelkinRouterUtils.changeRouterSettingsInBelkin(testCase, screenName, options);
					break;
				case "BUFFALO":
					flag = BuffaloRouterUtils.changeRouterSettingsInBuffalo(testCase, screenName, options);
					break;
				case "INTELLINET":
					flag = IntellinetRouterUtils.changeRouterSettingsInIntellient(testCase, screenName, options);
					break;
				case "UBEE":
					flag = UbeeRouterUtils.changeRouterSettingsInUbee(testCase, screenName, options);
					break;
				case "AMPED":
					flag = AmpedRouterUtils.changeRouterSettingsInAmped(testCase, screenName, options);
					break;
				case "AIRLIVE":
					flag = AirLiveRouterUtils.changeRouterSettingsInAirLive(testCase, screenName, options);
					break;
				case "CENTURYLINK":
					flag = CenturyLinkRouterUtils.changeRouterSettingsInCenturyLink(testCase, screenName, options);
					break;
				case "DLINK":
					flag = DLinkRouterUtils.changeRouterSettingsInDLink(testCase, screenName, options);
					break;
				case "HAWKING":
					flag = HawkingRouterUtils.changeRouterSettingsInHawking(testCase, screenName, options);
					break;
				case "VIZIO":
					flag = VizioRouterUtils.changeRouterSettingsInVizio(testCase, screenName, options);
					break;
				case "WESTERNDIGITAL":
					flag = WDRouterUtils.changeRouterSettingsInWD(testCase, screenName, options);
					break;
				case "VERIZON":
					flag = VerizonRouterUtils.changeRouterSettingsInVerizon(testCase, screenName, options);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Isu type " + screenName + " , ISU Value is " + options + " ,failed");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		try {
			if (testCase.isTestSuccessful()) {
				if (IpControllerUtils.checkInternetConnection_on_IPAddress(testCase,
						IOP_StateUtils.getInstance().getIPAddress(), 300)) {
					Keyword.ReportStep_Pass(testCase, "Internet Detected and IP Assigned");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Internet not detected");
					flag = false;
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
}


/*
 * When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;mode to 2.4Ghz BGN;channel to Auto;password is Home@123." in "advance wireless settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto;security to WPA3_WPA2 MIXED;password is Home@123." in "advance wireless settings" router screen 
	CISCO EAB11:
	When user edit router settings as "frequency to 5GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to 44;security to WPA2 Enterprise;Radius Server is 1.1.1.1;Radius Port is 1;Shared Key is CISCO" in "advance wireless settings" router screen
	When user edit router settings as "frequency to 2.4GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to 6;security to WEP;WEPENCRYPTION is 64" in "advance wireless settings" router screen 
	Then user edit router settings as "is DHCP to YES;Start IP Address is 192.162.1.100;Max No Users is 50;Client Lease Time is 1441" in "DHCP settings" router screen 
	BELKIN F9K1102v1:
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 7;mode to G" in "channel and ssid" router screen
	Intellinet:
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen
	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen
	When user edit router settings as "Encryption to WEP;WEP Key Length is 64 bit ;WEP KEy Format is Hex;password is Home@123." in "SECURITY SETTING" router screen
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is Forever;DHCP Start IP Address is 192.168.2.101;DHCP End IP Address is 192.168.2.201" in "DHCP settings" router screen	
	Ubee:
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WEP;Encryption to 64bit;PassPhrase is UbeeWEP" in "wireless primary network settings" router screen 
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is 3700;DHCP Start IP Address is 192.168.178.12" in "DHCP settings" router screen 
	TPLINK AX1800
	When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;is SSID to No;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen	
	Amped
	Then  user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen 
	Then user edit router settings as "is DHCP to Enable;DHCP Lease Time is 600;DHCP Start IP Address is 192.168.3.101;DHCP End IP Address is 192.168.3.201" in "DHCP settings" router screen

*/