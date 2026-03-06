package com.resideo.utils.stat;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.CtrlAlgSetpointStatusMsg;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg.Relays;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg.SetPoint;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.SystemSwitchMsg;
import com.resideo.utils.stat.cattgrpccommands.float_Msg;

public class StatRelayUtils {
	public static boolean verifyRelays(TestCases testCase, List<Relays> relays, String OnOffStatus, int MaxWaitTime) {
		boolean flag = false;

		try {
			float Setpoint = 0.0f;
			SystemSwitchMsg Switch = StatCommands.getInstance().cattCommandsStub.getSystemSwitch(String_Msg.newBuilder().build());
			String Mode = Switch.toString();
			
			float_Msg IndTemp = StatCommands.getInstance().cattCommandsStub.getIndoorTempVariable(String_Msg.newBuilder().build());
			float Temp = IndTemp.getFloatVal();
			
			
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(MaxWaitTime));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() 
			{
				@SuppressWarnings("unlikely-arg-type")
				public Boolean apply(Boolean flag) 
				{
					try 
					{
						PhysicalRelayMsg physicalRelays = StatCommands.getInstance().cattCommandsStub
								.getPhysicalRelays(String_Msg.newBuilder().build());
						
						if(Mode.toUpperCase().contains("HEAT"))
						{
							float_Msg SP = StatCommands.getInstance().cattCommandsStub.
							getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_HEAT).build());
							float Setpoint = SP.getFloatVal();
						}
						else
						{
							float_Msg SP = StatCommands.getInstance().cattCommandsStub.
									getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_COOL).build());
									float Setpoint = SP.getFloatVal();
						}
							
						
						
						if(OnOffStatus.toUpperCase().contains("ON")) 
						{
							if (new HashSet<>(physicalRelays.getRelayList()).equals(new HashSet<>(relays))) 
							{
								Keyword.ReportStep_Pass(testCase, "Expected Relays" + relays.toString() + " are turned on as expected.");
								return true;
							}							
							else 
							{
								Keyword.ReportStep_Pass(testCase, "Expected Relays to turn on " + relays.toString() + ", observed : " + physicalRelays.getRelayList().toString());
								Keyword.ReportStep_Pass(testCase, "Indoor Temp :" + Temp +  " Setpoint :" + Setpoint + "SystemMode : " + Mode );
								return false;
							}
						}
						else if(OnOffStatus.toUpperCase().contains("OFF")) 
						{
							if (!physicalRelays.getRelayList().contains(relays)) 
							{
								Keyword.ReportStep_Pass(testCase, "Expected Relays" + relays.toString() + " are turned Off as expected.");
								return true;
							}							
							else 
							{
								Keyword.ReportStep_Pass(testCase, "Expected Relays" + relays.toString() + " are not turned Off. ");
								Keyword.ReportStep_Pass(testCase, "Currently " + physicalRelays.getRelayList().toString() + " relays are turned on. Rechecking...");
								Keyword.ReportStep_Pass(testCase, "Indoor Temp :" + Temp +  " Setpoint :" + Setpoint + "SystemMode : " + Mode );
								return false;
							}
						}
						else 
						{
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Invalid On Off Status String. Expected : 'ON' or 'OFF'");
							return false;
						}
					}
					catch (Exception e) 
					{
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to verify relays. Execption raised : " + e.getMessage());
						return false;
					}
				}
			});

			flag = isEventReceived;
		} catch (Exception e) {

//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to verify required relays status.");
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Current Heat SP : "+ StatCommands.getInstance().cattCommandsStub.);
			
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Execption raised : " + e.getMessage());
			
			flag = false;
		}

		return flag;
	}

}
