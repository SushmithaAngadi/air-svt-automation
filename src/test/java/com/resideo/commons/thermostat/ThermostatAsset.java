package com.resideo.commons.thermostat;

public class ThermostatAsset {

	public static String getDeviceModelName(String name) {
		if (name.toUpperCase().contains("TH6220WF2006")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Good
		} else if (name.toUpperCase().contains("TH6320WF2003")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Better
		} else if (name.toUpperCase().contains("RCHT8610WF2006")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail_US
		} else if (name.toUpperCase().contains("RCHT8610WF2014")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail_CA
		} else if (name.toUpperCase().contains("RCHT8612WF2015")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail_CA
		} else if (name.toUpperCase().contains("RCHT8610WF3005")) {
			return "JASPER_SENIOR_NA_RETAIL";// Apple
		} else if (name.toUpperCase().contains("RCHT8612WF2005")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail Cannada
		} else if (name.toUpperCase().contains("RTH8800WF202")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail Renew
		} else if (name.toUpperCase().contains("TH6220WF2007")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Good_Wetsaw
		} else if (name.toUpperCase().contains("YT4710WF1003")) {
			return "JASPER_SENIOR_EMEA_WIRED";// EMEA_Wired
		} else if (name.toUpperCase().contains("YT4910WF4011")) {
			return "JASPER_SENIOR_EMEA_WIRELESS";// EMEA_Wireless
		} else if (name.toUpperCase().contains("THX321WF2001W")) {
			return "FLYCATCHER_TRADE";// trade
		} else if (name.toUpperCase().contains("RCHT9610WFW2004")) {
			return "FLYCATCHER_RETAIL";// retail
		} else if (name.toUpperCase().contains("WM10845E100")) {
			return "CASPIAN";// EnerCare
		} else if (name.toUpperCase().contains("WM12845T100")) {
			return "CASPIAN";// Trade
		} else if (name.toUpperCase().contains("THX321WF3001W")) {
			return "THOR_TRADE";// Trade
		} else if (name.toUpperCase().contains("RCHT9510WFW3001") || name.toUpperCase().contains("RCHT9610WFW3004")) {
			return "THOR_RETAIL";// Retail
		} else if (name.toUpperCase().contains("TFP220WF1")) {
			return "HOUDINI";// Trade
		} else if (name.toUpperCase().contains("RFP210WF1")) {
			return "HOUDINI";// Retail
		}else if (name.toUpperCase().contains("TH2320WF4010")) {
			return "FUJI_X2S_TRADE";// Trade
		}else if (name.toUpperCase().contains("TH2110WF4008")) {
			return "FUJI_X2S_TRADE";// Trade
		}else if (name.toUpperCase().contains("RTH2CWF")) {
			return "FUJI_X2S_RETAIL";// Retail
		} else if (name.toUpperCase().contains("THX1000W1") || name.toUpperCase().contains("THX1100W3")
				|| name.toUpperCase().contains("YTHX1100W4") || name.toUpperCase().contains("THX1200B7")
				|| name.toUpperCase().contains("THX1200W9S") || name.toUpperCase().contains("THX1200W5")
				|| name.toUpperCase().contains("YTHX1200W7") || name.toUpperCase().contains("THX1200W7")
				|| name.toUpperCase().contains("THX1200B6") || name.toUpperCase().contains("YTHX1200W7")
				|| name.toUpperCase().contains("YTHX1200W7S")|| name.toUpperCase().contains("THX1200W7S")
				|| name.toUpperCase().contains("THX1200B8S") ||name.toUpperCase().contains("THX1100B4")) {
			return "DENALI_TRADE";// Trade
		}  else if (name.toUpperCase().contains("RTH10WFW3") || name.toUpperCase().contains("RTH11WFB5")
				|| name.toUpperCase().contains("RTH12WFB7") || name.toUpperCase().contains("RTH12WFB8")
				|| name.toUpperCase().contains("RTH9WFW1")|| name.toUpperCase().contains("X8VMC9W")
				|| name.toUpperCase().contains("X8VMC8BC")) {
			return "DENALI_RETAIL";// Retail
		} else if (name.toUpperCase().contains("GLENEAGLES")) {
			return "GLENEAGLES_TRADE";// Trade
		} else {
			return null;
		}
	}

	public static String getDeviceModelName_SpecifiFeature(String name) {
		if (name.toUpperCase().contains("TH6220WF2006")) {
			return "JasperNATrade";// Trade_Good
		} else if (name.toUpperCase().contains("TH6320WF2003")) {
			return "JasperNATrade";// Trade_Better
		} else if (name.toUpperCase().contains("RCHT8610WF2006")) {
			return "JasperNATrade";// Retail_US
		} else if (name.toUpperCase().contains("RCHT8610WF2014")) {
			return "JasperNARetail";// Retail_CA
		} else if (name.toUpperCase().contains("RCHT8612WF2015")) {
			return "JasperNARetail";// Retail_CA
		} else if (name.toUpperCase().contains("RCHT8610WF3005")) {
			return "JasperNARetail";// Apple
		} else if (name.toUpperCase().contains("RCHT8612WF2005")) {
			return "JasperNARetail";// Retail Cannada
		} else if (name.toUpperCase().contains("RTH8800WF202")) {
			return "JasperNARetail";// Retail Renew
		} else if (name.toUpperCase().contains("TH6220WF2007")) {
			return "JasperNATrade";// Trade_Good_Wetsaw
		} else if (name.toUpperCase().contains("YT4710WF1003")) {
			return "JasperEmea";// EMEA_Wired
		} else if (name.toUpperCase().contains("YT4910WF4011")) {
			return "JasperEmea";// EMEA_Wireless
		} else if (name.toUpperCase().contains("THX321WF2001W")) {
			return "Flycatcher_Trade";// trade
		} else if (name.toUpperCase().contains("RCHT9610WFW2004")) {
			return "Flycatcher_Retail";// retail
		} else if (name.toUpperCase().contains("WM10845E100")) {
			return "Caspian";// EnerCare
		} else if (name.toUpperCase().contains("WM12845T100")) {
			return "Caspian";// Trade
		} else if (name.toUpperCase().contains("THX321WF3001W")) {
			return "Thor_Trade";// Trade
		} else if (name.toUpperCase().contains("RCHT9510WFW3001") || name.toUpperCase().contains("RCHT9610WFW3004")) {
			return "Thor_Retail";// Retail
		} else if (name.toUpperCase().contains("TFP220WF1")) {
			return "Houdini";// Trade
		} else if (name.toUpperCase().contains("RFP210WF1")) {
			return "Houdini";// Retail
		}else if (name.toUpperCase().contains("TH2320WF4010")) {
			return "FujiX2STrade";// Trade
		}else if (name.toUpperCase().contains("TH2110WF4008")) {
			return "FujiX2STrade";// Trade
		}else if (name.toUpperCase().contains("RTH2CWF")) {
			return "FujiX2SRetail";// Retail
		} else if (name.toUpperCase().contains("THX1000W1") || name.toUpperCase().contains("THX1100W3")
				|| name.toUpperCase().contains("YTHX1100W4") || name.toUpperCase().contains("THX1200B7")
				|| name.toUpperCase().contains("THX1200W9S") || name.toUpperCase().contains("THX1200W5")
				|| name.toUpperCase().contains("YTHX1200W7") || name.toUpperCase().contains("THX1200W7")
				|| name.toUpperCase().contains("THX1200B6") || name.toUpperCase().contains("YTHX1200W7")
				|| name.toUpperCase().contains("YTHX1200W7S")|| name.toUpperCase().contains("THX1200W7S")
				|| name.toUpperCase().contains("THX1200B8S")|| name.toUpperCase().contains("THX1100B4")) {
			return "DenaliTrade";// Trade
		}  else if (name.toUpperCase().contains("RTH10WFW3") || name.toUpperCase().contains("RTH11WFB5")
				|| name.toUpperCase().contains("RTH12WFB7") || name.toUpperCase().contains("RTH12WFB8")
				|| name.toUpperCase().contains("RTH9WFW1")|| name.toUpperCase().contains("X8VMC9W")
				|| name.toUpperCase().contains("X8VMC8BC")) {
			return "DenaliRetail";// Retail
		}else if (name.toUpperCase().contains("GLENEAGLES")) {
			return "GleneaglesTrade";// Trade
		} else {
			return null;
		}
	}

	public static String getDeviceModelTypeName_SpecifiFeature(String name) {
		if (name.toUpperCase().contains("JASPER_SENIOR_NA_TRADE")) {
			return "JasperNATrade";// Trade_Good
		} else if (name.toUpperCase().contains("JASPER_SENIOR_NA_RETAIL")) {
			return "JasperNARetail";// Apple
		} else if (name.toUpperCase().contains("JASPER_SENIOR_EMEA_WIRED")
				|| name.toUpperCase().contains("JASPER_SENIOR_EMEA_WIRELESS")) {
			return "JasperEmea";// EMEA_Wired
		} else if (name.toUpperCase().contains("FLYCATCHER_TRADE")) {
			return "Flycatcher_Trade";// trade
		} else if (name.toUpperCase().contains("FLYCATCHER_RETAIL")) {
			return "Flycatcher_Retail";// retail
		} else if (name.toUpperCase().contains("CASPIAN")) {
			return "Caspian";// EnerCare
		} else if (name.toUpperCase().contains("THOR_TRADE")) {
			return "Thor_Trade";// Trade
		} else if (name.toUpperCase().contains("THOR_RETAIL")) {
			return "Thor_Retail";// Trade
		} else if (name.toUpperCase().contains("HOUDINI")) {
			return "Houdini";// Retail
		}else if (name.toUpperCase().contains("FUJI_X2S_TRADE")) {
			return "FujiX2STrade";// Trade
		} else if (name.toUpperCase().contains("FUJI_X2S_RETAIL")) {
			return "FujiX2SRetail";// Retail
		} else if (name.toUpperCase().contains("DENALI_TRADE")) {
			return "DenaliTrade";// Retail
		} else if (name.toUpperCase().contains("DENALI_RETAIL")) {
			return "DenaliRetail";// Retail
		} else if (name.toUpperCase().contains("GLENEAGLES_TRADE")) {
			return "GleneaglesTrade";// Trade
		} else {
			return null;
		}
	}

	public static String getDeviceCountryNeedtoInstall(String deviceModelName) {
		if (deviceModelName.contains("JASPER_SENIOR_NA_TRADE")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("JASPER_SENIOR_NA_RETAIL")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("JASPER_SENIOR_EMEA_WIRED")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("JASPER_SENIOR_EMEA_WIRELESS")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("FLYCATCHER")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("CASPIAN")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("THOR")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("HOUDINI")) {
			return "UNITED_STATES";
		}else if (deviceModelName.contains("FUJI_X2S_TRADE")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("FUJI_X2S_RETAIL")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("DENALI")) {
			return "UNITED_STATES";
		}else if (deviceModelName.toUpperCase().contains("GLENEAGLES")) {
			return "EUROPE";
		}  else {
			return null;
		}
	}
	
}