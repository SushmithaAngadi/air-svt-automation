//package com.resideo.system.utils;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import org.json.JSONObject;
//import com.resideo.commons.coreframework.SuiteConstants;
//import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
//import com.resideo.system.ui.HomeScreenUIDetails.HomeScreenItems;
//import com.resideo.system.ui.MenuScreenUIDetails.MenuScreenItems;
//import com.resideo.system.ui.NotificationsScreenUIDetails.NotificationScreenItems;
//import com.resideo.system.utils.DeviceEnums.A_DeviceInfoItem;
//import com.resideo.system.utils.DeviceEnums.A_FC_ADC;
//import com.resideo.system.utils.DeviceEnums.A_FC_Alert;
//import com.resideo.system.utils.DeviceEnums.A_FC_AlertState;
//import com.resideo.system.utils.DeviceEnums.A_FC_AutoChangeoverState;
//import com.resideo.system.utils.DeviceEnums.A_FC_Button;
//import com.resideo.system.utils.DeviceEnums.A_FC_CtrlAlgSetpoint;
//import com.resideo.system.utils.DeviceEnums.A_FC_DehumidificationModes;
//import com.resideo.system.utils.DeviceEnums.A_FC_EMEA_Alert;
//import com.resideo.system.utils.DeviceEnums.A_FC_FFuLocation;
//import com.resideo.system.utils.DeviceEnums.A_FC_FanSwitch;
//import com.resideo.system.utils.DeviceEnums.A_FC_HeatCoolModeSwitch;
//import com.resideo.system.utils.DeviceEnums.A_FC_HumidificationModes;
//import com.resideo.system.utils.DeviceEnums.A_FC_IsuItem;
//import com.resideo.system.utils.DeviceEnums.A_FC_IsuValue;
//import com.resideo.system.utils.DeviceEnums.A_FC_PairingPinMode;
//import com.resideo.system.utils.DeviceEnums.A_FC_PhysicalRelay;
//import com.resideo.system.utils.DeviceEnums.A_FC_PhysicalRelayState;
//import com.resideo.system.utils.DeviceEnums.A_FC_RecoveryState;
//import com.resideo.system.utils.DeviceEnums.A_FC_Reminder;
//import com.resideo.system.utils.DeviceEnums.A_FC_Remote;
//import com.resideo.system.utils.DeviceEnums.A_FC_ResetMode;
//import com.resideo.system.utils.DeviceEnums.A_FC_SPriorityModes;
//import com.resideo.system.utils.DeviceEnums.A_FC_SPriorityStatus;
//import com.resideo.system.utils.DeviceEnums.A_FC_ScheduleType;
//import com.resideo.system.utils.DeviceEnums.A_FC_SensorError;
//import com.resideo.system.utils.DeviceEnums.A_FC_SetpointStatus;
//import com.resideo.system.utils.DeviceEnums.A_FC_SystemSwitch;
//import com.resideo.system.utils.DeviceEnums.A_FC_UniSensor;
//import com.resideo.system.utils.DeviceEnums.A_FC_VentSwitch;
//import com.resideo.system.utils.DeviceEnums.A_FC_VentilationModes;
//import com.resideo.system.utils.DeviceEnums.A_FC_WifiCfgStatus;
//import com.resideo.system.utils.DeviceEnums.A_FC_WifiModuleState;
//import com.resideo.system.utils.DeviceEnums.A_FC_WifiSecurity;
//import com.resideo.system.utils.DeviceEnums.A_FFuStatus;
//import com.resideo.system.utils.DeviceEnums.A_ReminderElapsed;
//import cattjniwrapper.FlycatcherDevice;
////import mx4j.tools.config.DefaultConfigurationBuilder.New;
//import net.sf.jni4net.Bridge;
//
//public class FCDeviceUtils 
//{
//	private static FCDeviceUtils instance = null;
//	
//	public static boolean isInitialized = false;
//	public static boolean isStatConnected = false;
//		
//	
//	FlycatcherDevice flycatcherDevice = null;
//	
//	private FCDeviceUtils() 
//	{
//		Bridge.setVerbose(true);
//		try {
//			Bridge.init();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		File proxyAssemblyFile = new File("src\\test\\resources\\CattJniWrapper\\FlycatherDevice.j4n.dll");
//		Bridge.LoadAndRegisterAssemblyFrom(proxyAssemblyFile);
//		
//		flycatcherDevice = new FlycatcherDevice();
//		
//		try {
//			this.ConnectToStat();
//		} catch (Exception e) {
//			System.out.println("Connect to stat failed. Exception Raised : " + e.getMessage());
//		}
//		
//	}
//	
//	public static FCDeviceUtils getInstance()
//	{
//		if(instance == null) 
//		{
//			instance = new FCDeviceUtils();
//			isInitialized = true;
//		}
//			
//		
//		return instance;
//	}
//	
//	// COMMANDS //
//	//////////////////////////////////////////////////////////////////////////////
//
//	// CONNECT - DISCONNECT //
//	//////////////////////////////////////////////////////////////////////////////
//	private void ConnectToStat()  throws Exception  
//	{
//		boolean flag = false;
//		
//		try {
//			//Connect if real device
//			if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_TYPE").toUpperCase().contains("REAL_DEVICE"))
//				flag = flycatcherDevice.ConnectToStat();
//			//Connect if Simulator
//			else if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_TYPE").toUpperCase().contains("SIMULATOR"))
//				flag = flycatcherDevice.ConnectToSimulator(Integer.parseInt(SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "UDP_TX_PORT")), 
//						Integer.parseInt(SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "UDP_RX_PORT")));
//			
//			if(!flag) 
//			{
////				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Unbale to connect to stat!");
//				System.out.println("Unbale to connect to stat!");
//			}
//			else
//				isStatConnected = true;
//			
//							
//		} catch (Exception e) 
//		{
//			System.out.println("Unbale to connect to stat!");
//			System.out.println("Exception Raised : " + e.getMessage());
//			// TODO: handle exception
//		}
//	}
//	
//	public void DisconnectToStat() 
//	{	
//		flycatcherDevice.Disconnect();
//	}		
//	//////////////////////////////////////////////////////////////////////////////
//	
//	// ADC //
//	//////////////////////////////////////////////////////////////////////////////
//	void Set_AdcCount(A_FC_ADC adc, int count) {
//		flycatcherDevice.Set_AdcCount(adc.value, count);
//	}
//
//	public void Set_AdcFahrenheits(A_FC_ADC adc, float fahrenheits) {
//		flycatcherDevice.Set_AdcFahrenheits(adc.value, fahrenheits);
//	}
//
//	/* Set_AdcVoltage Not ready yet
//    public void Set_AdcVoltage(A_FC_ADC adc, float voltage)
//    {
//        SPYder.D_ADCs.Set_AdcValue(adc, A_AdcMode.VOLTAGE, fahrenheits);
//    }
//    */
//
//	public void Set_AdcToHardwareControl(A_FC_ADC adc) {
//		flycatcherDevice.Set_AdcToHardwareControl(adc.value);		
//	}
//
//	public Integer Get_AdcCount(A_FC_ADC adc) {
//		return flycatcherDevice.Get_AdcCount(adc.value);
//	}
//
//	public float Get_AdcFahrenheits(A_FC_ADC adc) {
//		return flycatcherDevice.Get_AdcFahrenheits(adc.value);
//	}
//
//	// Alerts //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_Alert(A_FC_Alert alert, A_FC_AlertState state) {
//		flycatcherDevice.Set_Alert(alert.value, state.value);
//	}
//	
//	public void Set_Alert_Int(int alert, A_FC_AlertState state) {
//		flycatcherDevice.Set_Alert(alert, state.value);
//	}
//	
//	public A_FC_AlertState Get_AlertState(A_FC_Alert alert) {
//		
//		int val = flycatcherDevice.Get_Alert_State(alert.value);
//		switch(val) 
//		{
//		case 0:
//			return A_FC_AlertState.ALERTS_STATE_INACTIVE;
//		case 1: 
//			return A_FC_AlertState.ALERTS_STATE_SNOOZED;
//		case 2: 
//			return A_FC_AlertState.ALERTS_STATE_DISMISSED;
//		case 3: 
//			return A_FC_AlertState.ALERTS_STATE_ACTIVE;
//		default: 
//			return null;
//		}
//		
//	}
//	
//	public boolean IsAlertDisplayed(A_FC_Alert alert) {		
//		return flycatcherDevice.IsAlertDisplayed(alert.value);		
//	}
//	
//	public void Set_AlertToHardwareControl(A_FC_Alert alert) {
//		flycatcherDevice.Set_AlertToHardwareControl(alert.value);
//	}
//
//	public void Set_AlertToHardwareControl(A_FC_EMEA_Alert alert) {
//		flycatcherDevice.Set_AlertToHardwareControl_EMEA(alert.value);
//	}
//	
//	// Ancillary //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Ping() {
//		flycatcherDevice.Ping();
//	}
//
//	public boolean  Set_Reset(A_FC_ResetMode mode) {
//		return flycatcherDevice.Set_Reset(mode.value);
//	}
//
//	public void Set_LockButtons()
//	{
//		flycatcherDevice.Set_LockButtons();
//	}
//
//	public String Get_DeviceInfo(A_DeviceInfoItem infoItem)
//	{
//		return flycatcherDevice.Get_DeviceInfo(infoItem.value);
//	}
//	//////////////////////////////////////////////////////////////////////////////
//	
//	// Buttons //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_ButtonsClick(int msClickDuration, A_FC_Button[] buttons) 
//	{
//		int[]b=new int[buttons.length];
//		int i=0;
//		for(A_FC_Button btn:buttons)b[i++]=btn.value;
//
//		flycatcherDevice.Set_ButtonsClick(msClickDuration,b);
//	}
//	
//	public void Set_ButtonsToRemoteControl()
//	{
//		flycatcherDevice.Set_ButtonsToRemoteControl();
//	}
//
//	public void Set_ButtonsToHardwareControl()
//	{
//		flycatcherDevice.Set_ButtonsToHardwareControl();
//	}
//
//	//////////////////////////////////////////////////////////////////////////////
//
//	// ControlAlgorithm //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_FanSwitch(A_FC_FanSwitch state)
//	{
//		flycatcherDevice.Set_FanSwitch(state.value);
//	}
//
//	public void Set_FanSwitch(A_FC_FanSwitch state, A_FC_FanSwitch expectedResult)
//	{
//		flycatcherDevice.Set_FanSwitch(state.value, expectedResult.value);
//	}
//
//	public void Set_VentSwitch(A_FC_VentSwitch state)
//	{
//		flycatcherDevice.Set_VentSwitch(state.value);
//	}
//
//	public void Set_VentSwitch(A_FC_VentSwitch state, A_FC_VentSwitch expectedResult)
//	{
//		flycatcherDevice.Set_VentSwitch(state.value, expectedResult.value);
//	}
//
//	public void Set_SystemSwitch(A_FC_SystemSwitch state)
//	{
//		flycatcherDevice.Set_SystemSwitch(state.value);
//	}
//
//	public void Set_SystemSwitch(A_FC_SystemSwitch state, A_FC_SystemSwitch expectedResult)
//	{
//		flycatcherDevice.Set_SystemSwitch(state.value, expectedResult.value);
//	}
//
//	public void Set_Setpoint(A_FC_CtrlAlgSetpoint setpoint, float fahrenheits)
//	{
//		flycatcherDevice.Set_Setpoint(setpoint.value, fahrenheits);
//	}
//
//	public void Set_Setpoint(A_FC_CtrlAlgSetpoint setpoint, float fahrenheits, float fahrenheits_expectedResult)
//	{
//		flycatcherDevice.Set_Setpoint(setpoint.value, fahrenheits, fahrenheits_expectedResult);
//	}
//
//	public A_FC_FanSwitch Get_FanSwitch()
//	{
//		return A_FC_FanSwitch.valueOf(flycatcherDevice.Get_FanSwitch());
//				
//	}
//
//	public A_FC_VentSwitch Get_VentSwitch()
//	{
//		return A_FC_VentSwitch.valueOf(flycatcherDevice.Get_VentSwitch());
//	}
//
//	/*
//    public A_FC_HumSwitch Get_HumSwitch()
//    {
//
//    }
//    */
//
//	/*
//    public A_FC_DehumSwitch Get_DehumSwitch()
//    {
//
//    }
//    */
//
//	/*
//    public A_FC_OccupancySwitch Get_OccupancySwitch()
//    {
//
//    }
//    */
//
//	public A_FC_SystemSwitch Get_SystemSwitch()
//	{
//		return A_FC_SystemSwitch.valueOf(flycatcherDevice.Get_SystemSwitch());
//	}
//
//	public A_FC_HeatCoolModeSwitch Get_HeatCoolModeSwitch()
//	{
//		return A_FC_HeatCoolModeSwitch.valueOf(flycatcherDevice.Get_HeatCoolModeSwitch());
//	}
//
//	public float Get_Setpoint(A_FC_CtrlAlgSetpoint setpoint)
//	{
//		return flycatcherDevice.Get_Setpoint(setpoint.value);
//	}
//
//	public A_FC_RecoveryState Get_RecoveryState()
//	{
//		return A_FC_RecoveryState.valueOf(flycatcherDevice.Get_RecoveryState());
//	}
//
//	//////////////////////////////////////////////////////////////////////////////
//	
//	
//    // ZoneSensing //
//    //////////////////////////////////////////////////////////////////////////////
//    
//    public void Set_SPriotity_Info(A_FC_SPriorityModes mode, short pickedRooms, A_FC_SPriorityStatus status)
//    {
//    	flycatcherDevice.Set_SPriotity_Info(mode.value, pickedRooms, status.value);
//    }
//
//    public void Set_SPriotityInfo_Mode(A_FC_SPriorityModes mode)
//    {
//    	flycatcherDevice.Set_SPriotityInfo_Mode(mode.value);
//    }
//
//    public void Set_SPriotityInfo_Status(A_FC_SPriorityStatus status)
//    {
//    	flycatcherDevice.Set_SPriotityInfo_Status(status.value);
//    }
//
//    public void Set_SPriotityInfo_PickedRoomStatus(int roomID, boolean status)
//    {
//    	flycatcherDevice.Set_SPriotityInfo_PickedRoomStatus(roomID, status);
//    }
//
//    public A_FC_SPriorityModes Get_SPriorityInfo_Mode()
//    {
//    	return A_FC_SPriorityModes.valueOf(flycatcherDevice.Get_SPriorityInfo_Mode());
//    }
//    
//    public A_FC_SPriorityStatus Get_SPriorityInfo_Status()
//    {
//    	return A_FC_SPriorityStatus.valueOf(flycatcherDevice.Get_SPriorityInfo_Status());
//    }
//
//    public boolean Get_SPriorityInfo_PickedRoomStatus(int roomID)
//    {
//    	return flycatcherDevice.Get_SPriorityInfo_PickedRoomStatus(roomID);
//    }
//
//    public void Set_RoomInfo(byte RoomID, String RoomName)
//    {
//    	flycatcherDevice.Set_RoomInfo(RoomID, RoomName);
//    }
//
//    public boolean Get_RoomInfo_ActiveFlag(byte RoomID)
//    {
//    	return flycatcherDevice.Get_RoomInfo_ActiveFlag(RoomID);
//    }
//
//    public boolean Get_RoomInfo_Occupancy(byte RoomID)
//    {
//    	return flycatcherDevice.Get_RoomInfo_Occupancy(RoomID);
//    }
//
//    public boolean Get_RoomInfo_PickedRoom(byte RoomID)
//    {
//    	return flycatcherDevice.Get_RoomInfo_PickedRoom(RoomID);
//    }
//
//    public short Get_RoomInfo_Temperature(byte RoomID)
//    {
//    	return (short)flycatcherDevice.Get_RoomInfo_Temperature(RoomID);
//    }
//
//    public short Get_RoomInfo_Humidity(byte RoomID)
//    {
//    	return (short)flycatcherDevice.Get_RoomInfo_Humidity(RoomID);
//    }
//
//    public String Get_RoomInfo_RoomName(byte RoomID)
//    {
//    	return flycatcherDevice.Get_RoomInfo_RoomName(RoomID);
//    }
//
//    public String Get_ActiveRooms()
//    {
//    	return flycatcherDevice.Get_ActiveRooms();
//    }
//
//    public void Set_IASInfo(byte SensorID, A_FC_Remote Remote, short IndoorTemperature, short IndoorHumidity, byte RoomID, boolean isActive,
//    		boolean SenseFromHere, boolean SensorFault, boolean CommError, boolean BatteryLow, byte SignalStrength, boolean isRemovedFromWholeHouse, boolean isRemovedFromFollowMe)
//    {
//    	flycatcherDevice.Set_IASInfo(SensorID, Remote.value, IndoorTemperature, IndoorHumidity, RoomID, 
//    			isActive, SenseFromHere, SensorFault, CommError, BatteryLow, SignalStrength, isRemovedFromWholeHouse, isRemovedFromFollowMe);
//    }
//
//    public void Set_IASInfo_Remote(byte SensorID, A_FC_Remote Remote)
//    {
//    	flycatcherDevice.Set_IASInfo_Remote(SensorID, Remote.value);
//    }
//
//    public void Set_IASInfo_IndoorTemperature(byte SensorID, short IndoorTemperature)
//    {
//    	flycatcherDevice.Set_IASInfo_IndoorTemperature(SensorID, IndoorTemperature);
//    }
//
//    public void Set_IASInfo_IndoorHumidity(byte SensorID, short IndoorHumidity)
//    {
//    	flycatcherDevice.Set_IASInfo_IndoorHumidity(SensorID, IndoorHumidity);
//    }
//
//    public void Set_IASInfo_RoomID(byte SensorID, byte RoomID)
//    {
//    	flycatcherDevice.Set_IASInfo_RoomID(SensorID, RoomID);
//    }
//
//    public void Set_IASInfo_ActiveFlag(byte SensorID, boolean isActive)
//    {
//    	flycatcherDevice.Set_IASInfo_ActiveFlag(SensorID, isActive);
//    }
//
//    public void Set_IASInfo_SenseFromHere(byte SensorID, boolean SenseFromHere)
//    {
//    	flycatcherDevice.Set_IASInfo_SenseFromHere(SensorID, SenseFromHere);
//    }
//
//    public void Set_IASInfo_SensorFault(byte SensorID, boolean SensorFault)
//    {
//    	flycatcherDevice.Set_IASInfo_SensorFault(SensorID, SensorFault);
//    }
//
//    public void Set_IASInfo_CommError(byte SensorID, boolean CommError)
//    {
//    	flycatcherDevice.Set_IASInfo_CommError(SensorID, CommError);
//    }
//
//    public void Set_IASInfo_BatteryLow(byte SensorID, boolean BatteryLow)
//    {
//    	flycatcherDevice.Set_IASInfo_BatteryLow(SensorID, BatteryLow);
//    }
//
//    public void Set_IASInfo_IsRemovedFromWholeHouse(byte SensorID, boolean isRemovedFromWholeHouse)
//    {
//    	flycatcherDevice.Set_IASInfo_IsRemovedFromWholeHouse(SensorID, isRemovedFromWholeHouse);
//    }
//
//    public void Set_IASInfo_IsRemovedFromFollowMe(byte SensorID, boolean isRemovedFromFollowMe)
//    {
//    	flycatcherDevice.Set_IASInfo_IsRemovedFromFollowMe(SensorID, isRemovedFromFollowMe);
//    }
//    
//    public A_FC_Remote Get_IASInfo_Remote(byte SensorID)
//    {
//    	return A_FC_Remote.valueOf(flycatcherDevice.Get_IASInfo_Remote(SensorID));
//    }
//
//    public short Get_IASInfo_IndoorTemperature(byte SensorID)
//    {
//    	return (short)flycatcherDevice.Get_IASInfo_IndoorTemperature(SensorID);
//    }
//
//    public short Get_IASInfo_IndoorHumidity(byte SensorID)
//    {
//    	return (short)flycatcherDevice.Get_IASInfo_IndoorHumidity(SensorID);
//    }
//
//    public byte Get_IASInfo_RoomID(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_RoomID(SensorID);
//    }
//
//    public boolean Get_IASInfo_ActiveFlag(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_ActiveFlag(SensorID);
//    }
//
//    public boolean Get_IASInfo_SenseFromHere(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_SenseFromHere(SensorID);
//    }
//
//    public boolean Get_IASInfo_SensorFault(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_SensorFault(SensorID);
//    }
//
//    public boolean Get_IASInfo_CommError(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_CommError(SensorID);
//    }
//
//    public boolean Get_IASInfo_BatteryLow(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_BatteryLow(SensorID);
//    }
//
//    public boolean Get_IASInfo_IsRemovedFromWholeHouse(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_IsRemovedFromWholeHouse(SensorID);
//    }
//
//    public boolean Get_IASInfo_IsRemovedFromFollowMe(byte SensorID)
//    {
//    	return flycatcherDevice.Get_IASInfo_IsRemovedFromFollowMe(SensorID);
//    }
//
//    public void Set_IASOccupancyInfo(byte SensorID, A_FC_Remote Remote, boolean Occupancy, boolean Motion, short TimeOut)
//    {
//    	flycatcherDevice.Set_IASOccupancyInfo(SensorID, Remote.value, Occupancy, Motion, TimeOut);
//    }
//
//    public void Set_IASOccupancyInfo_Remote(byte SensorID, A_FC_Remote Remote)
//    {
//    	flycatcherDevice.Set_IASOccupancyInfo_Remote(SensorID, Remote.value);
//    }
//
//    public void Set_IASOccupancyInfo_Occupancy(byte SensorID, boolean Occupancy)
//    {
//    	flycatcherDevice.Set_IASOccupancyInfo_Occupancy(SensorID, Occupancy);
//    }
//
//    public void Set_IASOccupancyInfo_Motion(byte SensorID, boolean Motion)
//    {
//    	flycatcherDevice.Set_IASOccupancyInfo_Motion(SensorID, Motion);
//    }
//
//    public void Set_IASOccupancyInfo_Timeout(byte SensorID, short TimeOut)
//    {flycatcherDevice.Set_IASOccupancyInfo_Timeout(SensorID, TimeOut);}
//
//    public A_FC_Remote Get_IASOccupancyInfo_Remote(byte SensorID)
//    {return A_FC_Remote.valueOf(flycatcherDevice.Get_IASOccupancyInfo_Remote(SensorID));}
//
//    public boolean Get_IASOccupancyInfo_Occupancy(byte SensorID)
//    {return flycatcherDevice.Get_IASOccupancyInfo_Occupancy(SensorID);}
//
//    public boolean Get_IASOccupancyInfo_Motion(byte SensorID)
//    {return flycatcherDevice.Get_IASOccupancyInfo_Motion(SensorID);}
//
//    public short Get_IASOccupancyInfo_Timeout(byte SensorID)
//    {return (short)flycatcherDevice.Get_IASOccupancyInfo_Timeout(SensorID);}
//
//    public String Get_ActiveIAS()
//    {return flycatcherDevice.Get_ActiveIAS();}
//
//    public void Set_WireSensing(A_FC_Remote Remote, byte State)
//    {flycatcherDevice.Set_WireSensing(Remote.value, State);}
//
//    public void Set_WireSensing_Remote(A_FC_Remote Remote)
//    {flycatcherDevice.Set_WireSensing_Remote(Remote.value);}
//
//    public void Set_WireSensing_State(byte State)
//    {flycatcherDevice.Set_WireSensing_State(State);}
//
//    public A_FC_Remote Get_WireSensing_Remote()
//    {return A_FC_Remote.valueOf(flycatcherDevice.Get_WireSensing_Remote());}
//
//    public int Get_WireSensing_State()
//    {return flycatcherDevice.Get_WireSensing_State();}
//    //////////////////////////////////////////////////////////////////////////////
//	
//	// DateTime //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_DateTime(String dateTime)
//	{
////		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		 try {
////			Date date = sdf.parse(dateTime);
//			flycatcherDevice.Set_DateTime(dateTime);
//		} catch (Exception e) 
//		 {
//			System.out.println("Set_DateTime Exception : " + e.getMessage());
//		}
//		
//	}
//
//	public void Set_DateTimeToHardwareControl()
//	{
//		flycatcherDevice.Set_DateTimeToHardwareControl();
//	}
//
//	public String Get_DateTime()
//	{								
//		return flycatcherDevice.Get_DateTime();
//	}
//
//	// Humidity //
//	//////////////////////////////////////////////////////////////////////////////
//
//	public void Set_OutdoorHum(float humidity)
//	{
//		flycatcherDevice.Set_OutdoorHum(humidity);
//	}
//
//	public void Set_OutdoorHumToHardwareControl()
//	{
//		flycatcherDevice.Set_OutdoorHumToHardwareControl();
//	}
//
//	public float Get_OutdoorHum()
//	{
//		return Float.parseFloat(flycatcherDevice.Get_OutdoorHum());
//	}
//	
//	public String Get_IndoorHum()
//	{
//		return flycatcherDevice.Get_IndoorHum();
//	}
//	
//	public void Set_IndoorHum(float fahrenheits)
//	{
//		flycatcherDevice.Set_IndoorHum(fahrenheits);
//	}
//    
//    public void Set_Ventilation_Settings(A_FC_VentilationModes ventilationMode, short timedVentilationInMin, boolean disableDuringSleep, boolean highOutdoorTemp, boolean lowOutdoorTemp, boolean highOutdoorDewPoint)
//    {
//    	flycatcherDevice.Set_Ventilation_Settings(ventilationMode.value, timedVentilationInMin, disableDuringSleep, highOutdoorTemp, lowOutdoorTemp, highOutdoorDewPoint);
//    }
//
//    public void Set_VentilationSettings_Mode(A_FC_VentilationModes ventilationMode)
//    {
//    	flycatcherDevice.Set_VentilationSettings_Mode(ventilationMode.value);
//    }
//
//    public void Set_VentilationSettings_TimedVentilation(short timedVentilationInMin)
//    {
//    	flycatcherDevice.Set_VentilationSettings_TimedVentilation(timedVentilationInMin);
//    }
//
//    public void Set_VentilationSettings_DisableDuringSleep(boolean disableDuringSleep)
//    {
//    	flycatcherDevice.Set_VentilationSettings_DisableDuringSleep(disableDuringSleep);
//    }
//
//    public void Set_VentilationSettings_HighOutdoorTemp(boolean highOutdoorTemp)
//    {
//    	flycatcherDevice.Set_VentilationSettings_HighOutdoorTemp(highOutdoorTemp);
//    }
//
//    public void Set_VentilationSettings_LowOutdoorTemp(boolean lowOutdoorTemp)
//    {
//    	flycatcherDevice.Set_VentilationSettings_LowOutdoorTemp(lowOutdoorTemp);
//    }
//
//    public void Set_VentilationSettings_HighOutdoorDewPoint(boolean highOutdoorDewPoint)
//	{
//    	flycatcherDevice.Set_VentilationSettings_HighOutdoorDewPoint(highOutdoorDewPoint);
//	}
//
//    public A_FC_VentilationModes Get_VentillationSettings_Mode()
//    {
//    	return A_FC_VentilationModes.valueOf(flycatcherDevice.Get_VentillationSettings_Mode());
//    }
//
//    public short Get_VentillationSettings_TimedVentillationInMin()
//	{
//    	return (short)flycatcherDevice.Get_VentillationSettings_TimedVentillationInMin();
//	}
//
//    public boolean Get_VentillationSettings_DisableDuringSleep()
//    {
//    	return flycatcherDevice.Get_VentillationSettings_DisableDuringSleep();
//    }
//   
//    public boolean  Get_VentillationSettings_HighOutdoorTemp()
//    {
//    	return flycatcherDevice.Get_VentillationSettings_HighOutdoorTemp();
//    }
//
//    public boolean Get_VentillationSettings_LowOutdoorTemp()
//	{
//    	return flycatcherDevice.Get_VentillationSettings_LowOutdoorTemp();
//	}
//    
//    public boolean  Get_VentillationSettings_HighOutdoorDewPoint()
//    {
//    	return flycatcherDevice.Get_VentillationSettings_HighOutdoorDewPoint();
//    }
//
//    public void Set_Humidifier_Settings(A_FC_HumidificationModes humidifierMode, short humiditySetPoint, byte windowProtectionLevel)
//    {
//    	flycatcherDevice.Set_Humidifier_Settings(humidifierMode.value, humiditySetPoint, windowProtectionLevel);
//    }
//
//    public void Set_HumidifierSettings_Mode(A_FC_HumidificationModes humidifierMode)
//    {
//    	flycatcherDevice.Set_HumidifierSettings_Mode(humidifierMode.value);
//    }
//
//    public void Set_HumidifierSettings_HumiditySetPoint(short humiditySetPoint)
//    {
//    	flycatcherDevice.Set_HumidifierSettings_HumiditySetPoint(humiditySetPoint);
//    }
//
//    public void Set_HumidifierSettings_WindowProtectionLevel(byte windowProtectionLevel)
//    {
//    	flycatcherDevice.Set_HumidifierSettings_WindowProtectionLevel(windowProtectionLevel);
//    }
//
//    public A_FC_HumidificationModes Get_HumidifierSettings_Mode()
//    {
//    	return A_FC_HumidificationModes.valueOf(flycatcherDevice.Get_HumidifierSettings_Mode());
//    }
//
//    public short Get_HumidifierSettings_HumiditySetPoint()
//    {
//    	return (short)flycatcherDevice.Get_HumidifierSettings_HumiditySetPoint();
//    }
//    
//    public byte Get_HumidifierSettings_WindowProtectionLevel()
//    {
//    	return flycatcherDevice.Get_HumidifierSettings_WindowProtectionLevel();
//    }
//    
//    public void Set_Dehumidifier_Settings(A_FC_DehumidificationModes dehumidifierMode, short humiditySetPoint)
//	{
//    	flycatcherDevice.Set_Dehumidifier_Settings(dehumidifierMode.value, humiditySetPoint);    	
//	}
//
//    public void Set_DehumidifierSettings_Mode(A_FC_DehumidificationModes dehumidifierMode)
//    {
//    	flycatcherDevice.Set_DehumidifierSettings_Mode(dehumidifierMode.value);
//    }
//
//    public void Set_DehumidifierSettings_HumiditySetPoint(short humiditySetPoint)
//	{
//    	flycatcherDevice.Set_DehumidifierSettings_HumiditySetPoint(humiditySetPoint);
//	}
//
//    public A_FC_DehumidificationModes Get_DehumidifierSettings_Mode()
//	{
//    	return A_FC_DehumidificationModes.valueOf(flycatcherDevice.Get_DehumidifierSettings_Mode());
//	}
//
//    public short Get_DehumidifierSettings_HumiditySetPoint()
//    {
//    	return (short)flycatcherDevice.Get_DehumidifierSettings_HumiditySetPoint();
//    }
//
//	//////////////////////////////////////////////////////////////////////////////
//	// ISU //
//	//////////////////////////////////////////////////////////////////////////////
//	
//	public void Set_ISU(A_FC_IsuItem item, A_FC_IsuValue isuValue)
//	{
//		flycatcherDevice.Set_ISU(item.value, isuValue.value);		
//	}
//	
//	public void Set_ISU(A_FC_IsuItem item, int isuValue)
//	{
//		flycatcherDevice.Set_ISU(item.value, isuValue);
//	}
//
//	public A_FC_IsuValue Get_ISU(A_FC_IsuItem item) 
//	{
//		return A_FC_IsuValue.valueOf(String.valueOf(flycatcherDevice.Get_ISU(item.value)));
//	}
//	
//	public String Get_ISU_StringVal(A_FC_IsuItem item) 
//	{		
//		return String.valueOf(flycatcherDevice.Get_ISU(item.value));
//	}
//	
//	public float Get_ISU_FloatVal(A_FC_IsuItem item) 
//	{
//		return Float.valueOf(flycatcherDevice.Get_ISU_FloatVal(item.value));
//	}
//	
//	
//	//////////////////////////////////////////////////////////////////////////////
//
//	// Relays //
//	//////////////////////////////////////////////////////////////////////////////
//
//	public void Set_LTerminal(A_FC_PhysicalRelayState state)
//	{
//		flycatcherDevice.Set_LTerminal(state.value);
//	}
//
//	public void Set_LTerminalToHardwareControl()
//	{
//		flycatcherDevice.Set_LTerminalToHardwareControl();
//	}
//
//	public A_FC_PhysicalRelay[] Get_PhysicalRelays()
//	{
//		try {
//			String str = flycatcherDevice.Get_PhysicalRelays();
//			if(str != "" && str.contains(","))
//			{
//				String[] output = str.split(",");
//				
//				A_FC_PhysicalRelay[] relayList = new A_FC_PhysicalRelay[output.length];
//				int i =0;
//				for(String s : str.split(","))
//					relayList[i++] = A_FC_PhysicalRelay.valueOf(s.trim());
//				
//				return relayList;
//			}
//			else
//				return null;			
//		} catch (Exception e) {
//			return null;	
//			// TODO: handle exception
//		}
//		
//
//	}
//
//	public A_FC_PhysicalRelayState Get_LTerminal()
//	{
//		return A_FC_PhysicalRelayState.valueOf(flycatcherDevice.Get_LTerminal());
//	}
//	
//	// Reminders //
//	//////////////////////////////////////////////////////////////////////////////
//
//	public void Set_Reminder(A_FC_Reminder reminder, int counterValueMinutes)
//	{
//		flycatcherDevice.Set_Reminder(reminder.value, counterValueMinutes);
//	}
//
//	public void Set_ReminderReset(A_FC_Reminder reminder)
//	{
//		flycatcherDevice.Set_ReminderReset(reminder.value);
//	}
//
//	public void Set_ReminderModuleTiming(int timeMultiplier)
//	{
//		flycatcherDevice.Set_ReminderModuleTiming(timeMultiplier);
//	}
//
//	public A_ReminderElapsed Get_ReminderStatus(A_FC_Reminder reminder) 
//	{
//		return A_ReminderElapsed.valueOf(flycatcherDevice.Get_ReminderStatus(reminder.value).toUpperCase());
//	}
//	
//	/*public T_FC_Reminder Get_Reminder(A_FC_Reminder reminder)
//	{
//		
//	}*/
//	//////////////////////////////////////////////////////////////////////////////
//
//	// Schedule //
//	//////////////////////////////////////////////////////////////////////////////
////	public void Set_Schedule(String schedule)
////	{
////		flycatcherDevice.Set_Schedule(schedule);		
////	}
//	
//	public void Set_ScheduleType(A_FC_ScheduleType type)
//	{
//		flycatcherDevice.Set_ScheduleType(type.value);		
//	}
//	
//	public A_FC_ScheduleType Get_ScheudleType() 
//	{
//		return A_FC_ScheduleType.valueOf(flycatcherDevice.Get_ScheduleType());
//	}
//
//	//////////////////////////////////////////////////////////////////////////////
//
//	// Temperature //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_InternalTempVariable(float fahrenheits)
//	{
//		flycatcherDevice.Set_InternalTempVariable(fahrenheits);
//	}
//
//	public void Set_InternalTempSensorError(A_FC_SensorError sensorError)
//	{
//		flycatcherDevice.Set_InternalTempSensorError(sensorError.value);
//	}
//
//	public void Set_InternalTempVariableToHardwareControl()
//	{
//		flycatcherDevice.Set_InternalTempVariableToHardwareControl();
//	}
//
//	public void Set_IndoorTempVariable(float fahrenheits)
//	{
//		flycatcherDevice.Set_IndoorTempVariable(fahrenheits);
//	}
//
//	public void Set_IndoorTempVariableToHardwareControl()
//	{
//		flycatcherDevice.Set_IndoorTempVariableToHardwareControl();
//	}
//
//	public void Set_OutdoorTemp(float fahrenheits)
//	{
//		flycatcherDevice.Set_OutdoorTemp(fahrenheits);
//	}
//	
//	public void Set_OutdoorTempSensorError(A_FC_SensorError sensorError)
//	{
//		flycatcherDevice.Set_OutdoorTempSensorError(sensorError.value);
//	}
//
//	public void Set_OutdoorTempToHardwareControl()
//	{
//		flycatcherDevice.Set_OutdoorTempToHardwareControl();
//	}
//
//	public void Set_UniSensor(A_FC_UniSensor uniSensor, float fahrenheits)
//	{
//		flycatcherDevice.Set_UniSensor(uniSensor.value, fahrenheits);
//	}
//
//	public void Set_UniSensorError(A_FC_UniSensor uniSensor, A_FC_SensorError sensorError)
//	{
//		flycatcherDevice.Set_UniSensorError(uniSensor.value, sensorError.value);
//	}
//
///*  public void Set_HumSensorTemp(float fahrenheits)
//    {
//    	
//    }*/
//    
//	public float Get_InternalTempVariable()
//	{
//		return flycatcherDevice.Get_InternalTempVariable();
//	}
//
//	public float Get_IndoorTempVariable()
//	{
//		return flycatcherDevice.Get_IndoorTempVariable(); 
//	}
//
//	public float Get_OutdoorTemp()
//	{
//		return flycatcherDevice.Get_OutdoorTemp();
//	}
//
//	public float Get_UniSensor(A_FC_UniSensor uniSensor)
//	{
//		return flycatcherDevice.Get_UniSensor(uniSensor.value);
//	}
//
//	public float Get_HumSensorTemp()
//	{
//		return flycatcherDevice.Get_HumSensorTemp();
//	}
//
//	//////////////////////////////////////////////////////////////////////////////
//	
//	
//	// SETPOINT STATUS //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_TemporaryHold(float heatSP, float coolSP) 
//	{
//		flycatcherDevice.Set_TemporaryHold(heatSP, coolSP);
//	}
//	
//	public void Set_HoldUntil(float heatSP, float coolSP, byte Hr, byte Min) 
//	{
//		flycatcherDevice.Set_HoldUntil(heatSP, coolSP, (int)Hr, (int)Min);
//	}
//	
//	public void Set_PermanentHold(float heatSP, float coolSP) 
//	{
//		flycatcherDevice.Set_PermanentHold(heatSP, coolSP);
//	}
//	
//	public void Set_NoHold() 
//	{
//		flycatcherDevice.Set_NoHold();
//	}
//	
//	public A_FC_SetpointStatus Get_SetpointStatus() 
//	{
//		return A_FC_SetpointStatus.valueOf(flycatcherDevice.Get_SetpointStatus().toUpperCase());
//		
//	}
//	
//	//////////////////////////////////////////////////////////////////////////////
//
//	// WiFi //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Set_WiFiState(A_FC_WifiModuleState state)
//	{
//		flycatcherDevice.Set_WiFiState(state.value);
//	}
//
//	public A_FC_WifiModuleState Get_WiFiState()
//	{
//		return A_FC_WifiModuleState.valueOf(flycatcherDevice.Get_WiFiState());
//	}
//
//	public String Get_PairingPin(A_FC_PairingPinMode mode)
//	{
//		return flycatcherDevice.Get_PairingPin(mode.value);
//	}
//
//	public boolean Get_APModeState()
//	{
//		return Boolean.parseBoolean( flycatcherDevice.Get_APModeState());
//	}
//	
//	public boolean Get_MDNSState()
//	{
//		return Boolean.parseBoolean(flycatcherDevice.Get_MDNSState());
//	}
//
//	public void Set_APModeState(boolean state)
//	{
//		flycatcherDevice.Set_APModeState(String.valueOf(state));
//	}
//	
//	public void Set_MDNSState(boolean state)
//	{
//		flycatcherDevice.Set_MDNSState(String.valueOf(state));
//	}
//
//	public void Set_NetworkName(String name)
//	{
//		flycatcherDevice.Set_NetworkName(name);
//	}
//
//	public void Set_NetworkSecurity(A_FC_WifiSecurity security)
//	{
//		flycatcherDevice.Set_NetworkSecurity(security.value);
//	}
//
//	public void Set_NetworkPassword(String password)
//	{
//		flycatcherDevice.Set_NetworkPassword(password);
//	}
//	
//	public A_FC_WifiCfgStatus Get_WiFiStatus()
//	{
//		return A_FC_WifiCfgStatus.valueOf(flycatcherDevice.Get_WiFiStatus());
//	}
//	
//	public boolean Get_WiFiStatus_isRegistered()
//	{
//		return flycatcherDevice.Get_WiFiStatus_isRegistered();
//	}
//
//	//////////////////////////////////////////////////////////////////////////////
//
//	// FFuHeaders //
//	//////////////////////////////////////////////////////////////////////////////	
///*	public t_NvmInfo Get_FFuHeaders()
//	{
//		
//	}*/
//	//////////////////////////////////////////////////////////////////////////////
//
//	/// <summary>
//	/// Returns State of specific FFu Location 
//	/// </summary>
//	/// <param name="Bank">specific FFu Location</param>
//	/// <returns>State</returns>
//	public A_FFuStatus Get_FFuLocationStatus(A_FC_FFuLocation Bank)
//	{
//		return A_FFuStatus.valueOf(flycatcherDevice.Get_FFuLocationStatus(Bank.value));
//		
//	}
//	
//	// Display //		
//	//////////////////////////////////////////////////////////////////////////////
//
//
//	public int Get_BacklightLevel()
//	{
//		return flycatcherDevice.Get_BacklightLevel();
//	}
//
//	// Domestic Hot Water //
//	//////////////////////// //////////////////////////////////////////////////////
//    public  void Set_DhwWaterTemp(float fahrenheits)
//    {
//        flycatcherDevice.Set_DhwWaterTemp(fahrenheits);
//    }
//
//    public  void Set_DhwWaterTempSensorError(A_FC_SensorError sensorError)
//    {
//        flycatcherDevice.Set_DhwWaterTempSensorError(sensorError.value);
//    }
//    
//
//	public void Set_DhwWaterTempToHardwareControl()
//	{
//		flycatcherDevice.Set_DhwWaterTempToHardwareControl();
//	}
//
//	//////////////////////////////////////////////////////////////////////////////	
///*	public void Set_DhwSchedule(T_FC_Schedule schedule)
//	{
//		
//	}*/
//
//
//	public void Set_DhwScheduleType(A_FC_ScheduleType type)
//	{
//		flycatcherDevice.Set_DhwScheduleType(type.value);
//	}
//
//
///*	public void Set_DhwSetpointStatus(T_FC_DhwSetpointStatus setpointStatus)
//	{
//		
//	}*/
//
//
//	public float Get_DhwWaterTemp()
//	{
//		return Float.parseFloat(flycatcherDevice.Get_DhwWaterTemp());
//	}
//
//
///*	public T_FC_Schedule Get_DhwSchedule()
//	{
//		
//	}*/
//
//	public A_FC_ScheduleType Get_DhwScheduleType()
//	{
//		return A_FC_ScheduleType.valueOf(flycatcherDevice.Get_DhwScheduleType());
//	}
//
///*	public T_FC_DhwSetpointStatus Get_DhwSetpointStatus()
//	{
//		
//	}*/
//
//	//////////////////////////////////////////////////////////////////////////////		
//
//	// HW Modules //
//	//////////////////////////////////////////////////////////////////////////////	#region Set_ACPowerLost
//
//	/// <summary>
//	/// Unplug AC power for defined time
//	/// </summary>
//	/// <param name="relayNumber">Number of relay what should be used (0 - 6)</param>
//
//	public void Set_ACPowerLost(byte relayNumber, boolean unplug)
//	{
//		flycatcherDevice.Set_ACPowerLost((int)relayNumber, String.valueOf(unplug));
//	}
//
//	public void Set_ACPowerLost(byte rel0, byte rel1, byte rel2, byte rel3, byte rel4, byte rel5, byte rel6, byte rel7)
//	{
//		flycatcherDevice.Set_ACPowerLost((int)rel0, (int)rel1, (int)rel2, (int)rel3, (int)rel4, (int)rel5, (int)rel6, (int)rel7);
//	}
//	//////////////////////////////////////////////////////////////////////////////
//	
//	// VERIFY //
//	//////////////////////////////////////////////////////////////////////////////
//	// ControlAlgorithm //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Verify_SetPoint(A_FC_CtrlAlgSetpoint setpoint, float fahrenheits)
//	{
//		flycatcherDevice.Verify_SetPoint(setpoint.value, fahrenheits);
//	}
//
//	public void Verify_FanSwitch(A_FC_FanSwitch expectedState)
//	{
//		flycatcherDevice.Verify_FanSwitch(expectedState.value);
//	}
//
//	public void Verify_VentSwitch(A_FC_VentSwitch expectedState)
//	{
//		flycatcherDevice.Verify_VentSwitch(expectedState.value);
//	}
//
//	
///*    public void Verify_HumSwitch(A_FC_HumSwitch expectedState)
//    {
//    	
//    }*/
//
///*    public void Verify_DehumSwitch(A_FC_DehumSwitch expectedState)
//    {
//    	
//    }*/
//
///*    public void Verify_OccupancySwitch(A_FC_OccupancySwitch expectedState)
//    {
//    	
//    }*/
//
//	public void Verify_SystemSwitch(A_FC_SystemSwitch expectedState)
//	{
//		flycatcherDevice.Verify_SystemSwitch(expectedState.value);		
//	}
//
//	public void Verify_HeatCoolModeSwitch(A_FC_HeatCoolModeSwitch expectedState)
//	{
//		flycatcherDevice.Verify_HeatCoolModeSwitch(expectedState.value);
//	}
//
//	public void Verify_AutoChangeoverState(A_FC_AutoChangeoverState expectedState)
//	{
//		flycatcherDevice.Verify_AutoChangeoverState(expectedState.value);
//	}
//
///*	public void Verify_SetpointStatus(T_FC_CtrlAlgSetpointStatus expectedState)
//	{
//		
//	}*/
//
//	//////////////////////////////////////////////////////////////////////////////
//
//	// ISU //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Verify_ISU(A_FC_IsuItem item, int expectedValue)
//	{
//		flycatcherDevice.Verify_ISU(item.value, expectedValue);
//	}
//
//	public void Verify_ISU(A_FC_IsuItem item, float expectedValue)
//	{
//		flycatcherDevice.Verify_ISU(item.value, expectedValue);
//	}
//	
//	public void Verify_ISU(A_FC_IsuItem item, A_FC_IsuValue expectedValue)
//	{
//		flycatcherDevice.Verify_ISU(item.value, expectedValue.value);
//	}
//
//	
//	// Relays //
//	//////////////////////////////////////////////////////////////////////////////
//	public void Verify_PhysicalRelays(A_FC_PhysicalRelay[] expectedRelaysTurnedOn)
//	{
//		if(expectedRelaysTurnedOn != null) 
//		{
//			int[] relayList = new int[expectedRelaysTurnedOn.length];
//			int i =0;
//			
//			for(A_FC_PhysicalRelay rly : expectedRelaysTurnedOn)
//				relayList[i++] = rly.value;
//			
//			flycatcherDevice.Verify_PhysicalRelays(relayList);
//		}
//		
//	}
//
//	public void Verify_PhysicalRelays(A_FC_PhysicalRelay[] expectedRelaysTurnedOn, A_FC_PhysicalRelay[] expectedRelaysTurnedOff)
//	{
//		if(expectedRelaysTurnedOn != null && expectedRelaysTurnedOff != null) 
//		{
//			int[] onRelayList = new int[expectedRelaysTurnedOn.length];
//			int[] offRelayList = new int[expectedRelaysTurnedOff.length];
//			int i =0;
//			
//			for(A_FC_PhysicalRelay rly : expectedRelaysTurnedOn)
//				onRelayList[i++] = rly.value;
//			
//			i = 0;
//			for(A_FC_PhysicalRelay rly : expectedRelaysTurnedOff)
//				offRelayList[i++] = rly.value;
//			
//			flycatcherDevice.Verify_PhysicalRelays(onRelayList, offRelayList);
//		}
//	}
//    //////////////////////////////////////////////////////////////////////////////
//	
//	// VACATION //
//	//////////////////////////////////////////////////////////////////////////////
//	public boolean Get_VacationActiveStatus() 
//	{
//		return flycatcherDevice.Get_VacationHoldStatus();
//	}
//	
//	public String Get_VacationInfo() 
//	{
//		return flycatcherDevice.Get_VacationHoldInfo();
//	}
//	
//	public void testMethod_setJsonObject(String s) 
//	{
//		flycatcherDevice.testMethod_setJsonObject(s);		
//	}
//	//////////////////////////////////////////////////////////////////////////////
//
////	public boolean ClickOnMenu() 
////	{
////		flycatcherDevice.Click_Item(0, 0);
////		return false;
////	}
//	
//	// WAIT FOR STATE //
//	//////////////////////////////////////////////////////////////////////////////
//	public void WaitForState_PhysicalRelays(int sMinTimeLimit, int sMaxTimeLimit, int sPeriod, A_FC_PhysicalRelay[] expectedRelaysTurnedOn) 
//	{
//		int[] onRelayList = new int[expectedRelaysTurnedOn.length];
//		int i =0;
//		for(A_FC_PhysicalRelay rly : expectedRelaysTurnedOn)
//			onRelayList[i++] = rly.value;
//		
//		flycatcherDevice.WaitForState_PhysicalRelays(sMinTimeLimit, sMaxTimeLimit, sPeriod, onRelayList);
//	}
//	
//	public boolean WaitForEvent_DEVICE_RESET(int hour, int minutes, int seconds) 
//	{
//		return flycatcherDevice.WaitForEvent_DEVICE_RESET(hour, minutes, seconds);
//	}
//	
//	//////////////////////////////////////////////////////////////////////////////
//	
//	// Schedule //
//	//////////////////////////////////////////////////////////////////////////////
///*	public void Verify_Schedule(T_FC_Schedule schedule)
//	{
//		
//	}*/
//	public A_FC_ScheduleType Get_ScheduleType()
//	{
//		return A_FC_ScheduleType.valueOf(flycatcherDevice.Get_ScheduleType());
//	}
//	
//	//LCC//
//    //////////////////////////////////////////////////////////////////////////////
//	public String UnregisterDeviceIfRegisteredByLCCApi(String Environment) 
//	{
//		if(Environment.toUpperCase().contains("QA") || Environment.toUpperCase().contains("STAGE"))
//			return flycatcherDevice.UnregisterDeviceIfRegistered(Environment);
//		else
//			return null;
//	}
//	
//	public String getCattExeOutput(ArrayList<String> command) 
//	{
//		try 
//		{
//			if(isStatConnected) 
//			{
//				DisconnectToStat();
//				
//				Thread.sleep(2000);
//				
//				try {
//					
//					DisconnectToStat();
//					
//				} catch (Exception e) {
//					System.out.println("Exception while disconnecting 2 : " + e.getMessage());
//				}
//			}
//				
//			
//			ArrayList<String> commandList = new ArrayList<String>();
//			commandList.add(SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CATT_EXEC_FLD"));
//			
//			for(int i=0;i<command.size();i++)
//				commandList.add(command.get(i));
//			
//			Process proc = new ProcessBuilder(commandList).start();
//			BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//
//			String line = null;
//			String outputMsg = "";
//
//			while ((line = input.readLine()) != null) {
//				System.out.println(line);
//				outputMsg = outputMsg + line;
//			}
//
////			int exitVal = proc.waitFor();
////			System.out.println("Exited with error code " + exitVal);
//			
////			Thread.sleep(120);
//			Thread.sleep(30);
//
//			if(isStatConnected)
//				ConnectToStat();
//			
//			return outputMsg;
//		} catch (IOException e) {
//			System.out.println("IO Exception");
//		} catch (InterruptedException e) {
//			System.out.println("InterruptedException");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
////			ConnectToStat();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "";
//	}
//	
//	public String Get_Schedule() 
//	{
//		try {
//									
//			ArrayList<String> commandList = new ArrayList<String>();			
//			commandList.add("GET_SCHEDULE");
//			String output = getCattExeOutput(commandList);
//			JSONObject obj = new JSONObject(output);			
//			obj = (JSONObject)obj.get("Response");
//			obj = (JSONObject)obj.get("Schedule_Data");
//			return obj.toString();
////			System.out.println(result);			
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
//	
//	public String UnregisterDeviceInLCC(String env) 
//	{
//		try {
//									
//			ArrayList<String> commandList = new ArrayList<String>();			
//			commandList.add("UNREGISTERDEVICE");
//			commandList.add(env.toUpperCase().trim());
//			
//			return getCattExeOutput(commandList);
////			System.out.println(result);			
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
//	
//	public void setSchedule(String schedule) 
//	{
//		try {
//									
//			ArrayList<String> commandList = new ArrayList<String>();			
//			commandList.add("SET_SCHEDULE");
//			commandList.add(schedule);
//			
//			getCattExeOutput(commandList);
////			System.out.println(result);			
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());			
//		}
//	}
//	
//	public void setAIRSchedule() 
//	{
//		try {
//									
//			ArrayList<String> commandList = new ArrayList<String>();			
//			commandList.add("SET_AIR_SCHEDULE");			
//			
//			getCattExeOutput(commandList);
////			System.out.println(result);			
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());			
//		}
//	}
//
//	//UI Commands//
//	
//	public boolean clickOnItem(short xCordinate, short yCordinate) 
//	{
//		try {
//			flycatcherDevice.Short_Screen_Touch(xCordinate, yCordinate);
//			return true;
//		} catch (Exception e) {
//			return false;
//			// TODO: handle exception
//		}
//		
//	}
//	
//	public String getScreenText(short X1, short Y1, short X2, short Y2, String ScreenShotPath) 
//	{
//		return flycatcherDevice.Get_TextFromScrenArea(X1, Y1, X2, Y2, ScreenShotPath);
//	}
//	
//	public boolean clickHomeScreenItem(HomeScreenItems item) 
//	{
//		return flycatcherDevice.Click_HomeScreen_Item(item.value);
//	}
//	
//	public boolean clickMenuScreenItem(MenuScreenItems item) 
//	{
//		return flycatcherDevice.Click_MenuScreen_Item(item.value);
//	}
//	
//	public boolean clickNotificationScreenItem(NotificationScreenItems item) 
//	{
//		return flycatcherDevice.Click_NotifScreen_Item(item.value);
//	}
//	
//	public String getTextFromScreenArea(short areaCordinates []) 
//	{
//		try {
//			String filePath = flycatcherDevice.getScreenShot(areaCordinates[0], areaCordinates[1], areaCordinates[2], areaCordinates[3], 
//					System.getProperty("user.dir").replace("\\", "\\\\") + "\\src\\test\\resources\\ThermostatScreenshots\\Temporary\\");
//			return "";
//		} catch (Exception e) {
//				System.out.println("Exception raised : " + e.getMessage());
//		}
//		
//		return "";
//		
//		
//	}
//	 	
//	public void setTouchControlHardWare() 
//	{
//		flycatcherDevice.Set_TouchControl_Hardware();
//	}
//	
//	public void setTouchControlRemote() 
//	{
//		flycatcherDevice.Set_TouchControl_Remote();
//	}
//}
