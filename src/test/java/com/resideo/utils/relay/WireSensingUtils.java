package com.resideo.utils.relay;

//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.app.screens.WireSensingScreen;

public class WireSensingUtils  {
//extends WireSensingScreen {
	
//	public WireSensingUtils(TestCases testCase) {
//		super(testCase);
//	}



	/*
	 * Conventional Wiresensing
	 */
	protected static String[] ConventionalInValid= {"Y2_W2","Y2_W2_G","Y_Y2_W2_G","Y2_W_W2_G","Y_Y2_W_W2"};
	protected static String Conventional_1H1C="Y_W_G";
	protected static String Conventional_2H1C="Y_W_W2_G";
	protected static String Conventional_1H2C="Y_Y2_W_G";
	protected static String Conventional_2H2C="Y_Y2_W_W2_G";
	protected static String Conventional_Gas_Oil_1H0C="W";
	protected static String Conventional_Gas_Oil_2H0C="W_W2";
	protected static String Conventional_Electric_Hot_1H0C="W_G";
	protected static String Conventional_Electric_Hot_2H0C="W_W2_G";
	/*
	 * HeatPump Wiresensing		
	 */
	protected static String[] HeatPumpInValid= {"Y_Y2_W_W2","G_Y_W2", "G_Y2_W" ,"G_Y_Y2","G_Y_Y2_W2","G_Y_W_W2", "G_W_W2"};
	protected static String HeatPump_1H1C ="Y_W_G";
	protected static String HeatPump_2H1C="Y_W_W2_G";
	protected static String HeatPump_2H2C="Y_Y2_W_G";
	protected static String HeatPump_3H2C="Y_Y2_W_W2_G";
	/*
	 * Radiant Heat Wiresensing 
	 * 
	 */
	protected static String[] RadiantHeatInValid= {"W2_G","Y2_W2","Y_W_G","Y_Y2_G","Y_W2_G","Y2_W_W2_G"};
	protected static String RadiantHeat_1H1C="Y_W_G";
	protected static String RadiantHeat_2H1C="Y_W_W2_G";
	protected static String RadiantHeat_1H2C="Y_Y2_W_G";
	protected static String RadiantHeat_2H2C="Y_Y2_W_W2_G";
	protected static String RadiantHeat_1H0C="W";
	protected static String RadiantHeat_2H0C="Y_W_W2_G";
	/*
	 * Cool Only
	 */
	protected static String[] CoolOnlyInValid= {"W_G","W_W2_G","Y_W_W2_G","Y2_G","Y2_W_G","Y2_W_W2_G","Y_W2_G","Y_Y2_W2_G","Y2","G","Y_Y2","Y","Y_W_G","Y_Y2_W_W2"};
	protected static String Cool_0H1C="Y_G";
	protected static String Cool_0H2C="Y_Y2_G";
			
	public String validWireSensing(String SystemType, String Stages) {
		if(SystemType.contains("Forced Air")) {
			if(Stages.equals("Conventional_1H1C")) {
				return Conventional_1H1C;
			}else if(Stages.equals("Conventional_2H1C")) {
				return Conventional_2H1C;
			}else if(Stages.equals("Conventional_1H2C")) {
				return Conventional_1H2C;
			}else if(Stages.equals("Conventional_2H2C")) {
				return Conventional_2H2C;
			}else if(Stages.equals("Conventional_Gas_Oil_1H0C")) {
				return Conventional_Gas_Oil_1H0C;
			}else if(Stages.equals("Conventional_Gas_Oil_2H0C")) {
				return Conventional_Gas_Oil_2H0C;
			}else if(Stages.equals("Conventional_Electric_Hot_1H0C")) {
				return Conventional_Electric_Hot_1H0C;
			}else if(Stages.equals("Conventional_Electric_Hot_2H0C")) {
				return Conventional_Electric_Hot_2H0C;
			}else {
				return null;
			}
		}else if(SystemType.contains("Heat Pump")) {
			if(Stages.equals("HeatPump_1H1C")) {
				return HeatPump_1H1C;
			}else if(Stages.equals("HeatPump_2H1C")) {
				return HeatPump_2H1C;
			}else if(Stages.equals("HeatPump_2H2C")) {
				return HeatPump_2H2C;
			}else if(Stages.equals("HeatPump_3H2C")) {
				return HeatPump_3H2C;
			}else {
				return null;
			}
		}else if(SystemType.contains("Radiant/Boiler")) {
			if(Stages.equals("RadiantHeat_1H1C")) {
				return RadiantHeat_1H1C;
			}else if(Stages.equals("RadiantHeat_2H1C")) {
				return RadiantHeat_2H1C;
			}else if(Stages.equals("RadiantHeat_1H2C")) {
				return RadiantHeat_1H2C;
			}else if(Stages.equals("RadiantHeat_2H2C")) {
				return RadiantHeat_2H2C;
			}else if(Stages.equals("RadiantHeat_1H0C")) {
				return RadiantHeat_1H0C;
			}else if(Stages.equals("RadiantHeat_2H0C")) {
				return RadiantHeat_2H0C;
			}else {
				return null;
			}
		}else if(SystemType.contains("None(Cool only)")) {
			if(Stages.equals("Cool_0H1C")) {
				return Cool_0H1C;
			}else if(Stages.equals("Cool_0H2C")) {
				return Cool_0H2C;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
//	public boolean InvalidWireSensing(RelayUtils ru,String SystemType, String[] InvalidWireSensingName) {
//		boolean flag = true;
//		for (int i = 0; i < InvalidWireSensingName.length; i++) {
//			String InvalidSensing = InvalidWireSensingName[i];
//			flag = flag && ru.relayStatusUpdate(InvalidSensing, "ON");
//			flag = flag && ClickOnSystemType(SystemType);
//			flag =flag && clickOnManualWireSensingScreen();
//			flag = flag && IsCheckedISU(InvalidSensing+"_Rc_R");
//			flag = flag && clickBack();
//			if(flag) {
//				Keyword.ReportStep_Pass(testCase, "Invalid wiresensing for :" +SystemType+ " Invalid Relay is :"+ InvalidSensing);
//				flag = true;
//			}else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Invalid Wiresensing Failure for this SystemType "+SystemType+"and for this Combination :: "+InvalidSensing);
//			flag = false;
//			}
//		}
//		return flag;
//	}
//	
//	
//	public boolean validWireSensingFlow(RelayUtils relay ,String SystemType, String HeatingType, String Stages,String ExtraISU ) {
//		boolean flag = true;
//		String TurnValidON=validWireSensing(SystemType, Stages);
//		flag = flag && relay.relayStatusUpdate(TurnValidON, "ON");
//		flag = flag && ClickOnSystemType(SystemType);
//		flag = flag && clickOnHeatingType(HeatingType);
//		if(SystemType.contains("Conventional")) {
//			flag = flag && ExtraISu(ExtraISU);
//		}
//		flag = flag && clickOnNext();
//		return flag;
//	}
//	
//	public boolean  AutoWireSensing(RelayUtils relay,String TempScale,String SystemType, String Equipment,String Stages,String ExtraISU) {
//		boolean flag = true;
//		flag = flag && clickOnNext(); // wait 30 sec
//		if(TempScale.equals("Fahrenheit")) {
//			flag = flag && IsFahrenheit();
//			flag = flag && clickOnFahrenheit();
//			
//		}else {
//			flag = flag && Iscelcius();
//			flag = flag && clickOncelcius();
//		}
//		Keyword.ReportStep_Pass(testCase, "Temperature Format Selected as :: " +TempScale );
//		if(SystemType.equals("Conventional_Forced")) {
//			flag =flag && InvalidWireSensing(relay, SystemType, ConventionalInValid);
//			flag = flag && validWireSensingFlow(relay, SystemType, Equipment, Stages, ExtraISU);
//		}else if(SystemType.equals("HeatPump")) {
//			flag =flag && InvalidWireSensing(relay, SystemType, HeatPumpInValid);
//			flag = flag && validWireSensingFlow(relay, SystemType, Equipment, Stages, ExtraISU);
//		}else if(SystemType.equals("RadiantBoiler")) {
//			flag =flag && InvalidWireSensing(relay, SystemType, RadiantHeatInValid);
//			flag = flag && validWireSensingFlow(relay, SystemType, Equipment, Stages, ExtraISU);
//		}else if(SystemType.equals("CoolOnly")) {
//			flag =flag && InvalidWireSensing(relay, SystemType, CoolOnlyInValid);
//			flag = flag && validWireSensingFlow(relay, SystemType, Equipment, Stages, ExtraISU);
//		}else {
//			flag = false;
//		}
//		return flag;
//	}
//			
			
			
	
}
