package com.resideo.system.utils;

import java.util.HashMap;

public class SystemState {
	private static SystemState instance = null;

	private SystemState() {
		this.CurrentCoolSP = 68.0f;
		this.CurrentHeatSP = 70.0f;
		this.IndoorTemperature = 70.0f;
	}

	public static SystemState getStatus() {
		if (instance == null)
			instance = new SystemState();
		return instance;
	}

	boolean isDeviceRegistered = false;
	boolean isRegError = false;
	boolean isAppCrashed = false;
	boolean isStatDeletedFromApp = false;
	boolean isDataSyncSuccessful = false;
	boolean isDeviceShownOnDashboard = false;
	boolean APmodeEnabled = false;
	boolean DeviceFoundForWACMode = false;
	boolean isConfigFinsished = false;
	boolean isWACFlowInitiated = false;
	boolean WacConnectionForDeviceCompleted = false;
	boolean ReInitiateAPModeFlow = false;
	boolean isAddNewDeviceScreenVisible = false;
	boolean isDashBoardScreenVisible = false;
	boolean isAddNewDeviceButtonVisible = false;
	boolean isLoggedIn = false;
	boolean isAccessorySetupErrorOccured = false;
	boolean isflightmodecompleted = false;
	boolean isRebateDRcompleted = false;
	String tStatName = null;
	String macIDName = null;
	boolean IsNavigateToWifiSCreenINFlycathcer = false;
	boolean IsThermostatNameSet = false;
	boolean IsDeviceDeletedFromApp = false;
	boolean isDeletePerformed = false;
	boolean IsThermostatLocationSet = false;
	boolean VacationStarted = false;
	boolean FollowingSchedule = false;
	boolean isBleErrorConnectingtoThermostat = false;
	boolean isDirectAPModeEnabledInIOS = false;
	boolean isNotNowButtonClickedAfterRegistrationInDashboard = false;
	int mfaCount = 0;
	boolean ismfa_firstAttempt = false;
	long pairingStartTime;
	String ble_AP_Connection_Status;
	boolean isDisconnected = false;
	long remaining_DisconnectionTime;
	String ble_Ap_flow;
	boolean isWifiConfigured;
	boolean isSensorAddedSuccessfully;

	float CurrentHeatSP = 0.0f;
	float CurrentCoolSP = 0.0f;
	float PreviousOverrideHeatSP = 0.0f;
	float PreviousOverrideCoolSP = 0.0f;
	float VacationHeatSP = 0.0f;
	float VacationCoolSP = 0.0f;
	float PreviousVacationHeatSP = 0.0f;
	float PreviousVacationCoolSP = 0.0f;
	float IndoorTemperature = 0.0f;
	String homeKitDeviceName = null;
	String WifiConnectionStatus;
	String RedlinkConnectionStatus;
	int Reg_failureCount = 1;
	boolean first_regFailure;
	boolean isSetupCodeShows = false;
	boolean isfromStartSetup;
	String unKnownMesssageShow;
	boolean isStatRegistrationStatus = false;
	boolean isCountryselectedBeforeTrail = false;
	HashMap<Object, Object> countrySelection = null; // iscountrySelected - boolean; selectedCountry -
	boolean isDeviceListAvailble; // String
	boolean isExpectedCountrySelected;
	boolean isStationMode;
	boolean isHomekitNeedToRun;
	String currentIPAddress;
	String currentWifiName;
	int iasCounterTrail;
	int oasCounterTrail;
	int eimPairingFailedContinouslyCount = 0;
	boolean isDirectScan;

	public void initForDiy() {
		setDeviceRegistered(false);
		setRegError(false);
		setAppCrashed(false);
		setStatDeletedFromApp(false);
		setDataSyncSuccessful(false);
		setDeviceShownOnDashboard(false);
		setAPmodeEnabled(false);
		setDeviceFoundForWACMode(false);
		setConfigFinsished(false);
		setWACFlowInitiated(false);
		setAddNewDeviceScreenVisible(false);
		setDashBoardScreenVisible(false);
		setAddNewDeviceButtonVisible(false);
		setLoggedIn(false);
		setAccessorySetupErrorOccured(false);
		setWacConnectionForDeviceCompleted(false);
		setReInitiateAPModeFlow(false);
		IsDeviceDeletedFromApp(false);
		isDeletePerformed(false);
		isNotNowButtonClickedAfterRegistrationInDashboard(false);
		homeKitDeviceName(null);
		isThermostatCloudSynError(false);
		isThermostatOfflineSince(false);
		isThermostatOnlineSince(false);
		isNotnowUnPerformed(true);
		setPreviousPin("");
		isSingleDevice(false);
		isMultipleDevice(false);
		isPairingFailed(false);
		isDeviceNotFound(false);
		isCommunicationError(false);
		isWifiError(false);
		isError(false);
		setLoggedIn(false);
		setAddNewDeviceScreenVisible(false);
		mfaCount(0);
		ismfa_firstAttempt(false);
		pairingStartTime(0);
		ble_AP_Connection_Status("none");
		isDisconnected(false);
		remaining_DisconnectionTime(0);
		ble_Ap_flow(null);
		isThermostat_DisconnectedAlready(false);
		isSetupCodeShows(false);
		isPairingFailed(false);
		isfromStartSetup(false);
		unKnownMesssageShow("");
		isStatRegistrationStatus(false);
		isCountryselectedBeforeTrail(false);
//		countrySelectionBeforeTrail().clear();
		isDeviceListAvailble(false);
		isExpectedCountrySelected(false);
		isStationMode(false);
		isHomekitNeedToRun(false);
		isWifiConfigured(false);
		currentIPAddress(null);
		currentWifiName(null);
		isSensorAddedSuccessfully(false);
		iasCounterTrail(0);
		oasCounterTrail(0);
		isDirectScan(false);
	}

	public void isDirectScan(boolean setState) {
		isDirectScan = setState;
	}

	public boolean isDirectScan() {
		return isDirectScan;
	}

	public int eimPairingFailedContinouslyCount() {
		return eimPairingFailedContinouslyCount;
	}

	public void eimPairingFailedContinouslyCount(int count) {
		eimPairingFailedContinouslyCount = count;
	}

	public int iasCounterTrail() {
		return iasCounterTrail;
	}

	public void iasCounterTrail(int count) {
		iasCounterTrail = count;
	}

	public int oasCounterTrail() {
		return oasCounterTrail;
	}

	public void oasCounterTrail(int count) {
		oasCounterTrail = count;
	}

	public void isSensorAddedSuccessfully(boolean setState) {
		isSensorAddedSuccessfully = setState;
	}

	public boolean isSensorAddedSuccessfully() {
		return isSensorAddedSuccessfully;
	}

	public String currentIPAddress() {
		return currentIPAddress;
	}

	public void currentIPAddress(String message) {
		currentIPAddress = message;
	}

	public String currentWifiName() {
		return currentWifiName;
	}

	public void currentWifiName(String message) {
		currentWifiName = message;
	}

	public void isWifiConfigured(boolean setState) {
		isWifiConfigured = setState;
	}

	public boolean isWifiConfigured() {
		return isWifiConfigured;
	}

	public void isHomekitNeedToRun(boolean setState) {
		isHomekitNeedToRun = setState;
	}

	public boolean isHomekitNeedToRun() {
		return isHomekitNeedToRun;
	}

	public void isStationMode(boolean setState) {
		isStationMode = setState;
	}

	public boolean isStationMode() {
		return isStationMode;
	}

	public void isExpectedCountrySelected(boolean setState) {
		isExpectedCountrySelected = setState;
	}

	public boolean isExpectedCountrySelected() {
		return isExpectedCountrySelected;
	}

	public void isDeviceListAvailble(boolean setState) {
		isDeviceListAvailble = setState;
	}

	public boolean isDeviceListAvailble() {
		return isDeviceListAvailble;
	}

	public void isCountryselectedBeforeTrail(boolean setState) {
		isCountryselectedBeforeTrail = setState;
	}

	public boolean isCountryselectedBeforeTrail() {
		return isCountryselectedBeforeTrail;
	}

	public void countrySelectionBeforeTrail(HashMap<Object, Object> countrySelect) {
		countrySelection = countrySelect;
	}

	public HashMap<Object, Object> countrySelectionBeforeTrail() {
		return countrySelection;
	}

	public String unKnownMesssageShow() {
		return unKnownMesssageShow;
	}

	public void unKnownMesssageShow(String message) {
		unKnownMesssageShow = message;
	}

	public boolean isfromStartSetup() {
		return isfromStartSetup;
	}

	public void isfromStartSetup(boolean is_StartSetup) {
		isfromStartSetup = is_StartSetup;
	}

	public String ble_Ap_flow() {
		return ble_Ap_flow;
	}

	public void ble_Ap_flow(String flow) {
		ble_Ap_flow = flow;
	}

	public long remaining_DisconnectionTime() {
		return remaining_DisconnectionTime;
	}

	public void remaining_DisconnectionTime(long startTime) {
		remaining_DisconnectionTime = startTime;
	}

	public boolean isDisconnected() {
		return isDisconnected;
	}

	public void isDisconnected(boolean isDisconnect) {
		isDisconnected = isDisconnect;
	}

	public String ble_AP_Connection_Status() {
		return ble_AP_Connection_Status;
	}

	public void ble_AP_Connection_Status(String status) {
		ble_AP_Connection_Status = status;
	}

	public long pairingStartTime() {
		return pairingStartTime;
	}

	public void pairingStartTime(long startTime) {
		pairingStartTime = startTime;
	}

	public int mfaCount() {
		return mfaCount;
	}

	public void mfaCount(int count) {
		mfaCount = count;
	}

	public boolean ismfa_firstAttempt() {
		return ismfa_firstAttempt;
	}

	public void ismfa_firstAttempt(boolean isFirstAttempt) {
		ismfa_firstAttempt = isFirstAttempt;
	}

	public void isSetupCodeShows(boolean status) {
		isSetupCodeShows = status;
	}

	public boolean isSetupCodeShows() {
		return isSetupCodeShows;
	}

	public int Reg_failureCount() {
		return Reg_failureCount;
	}

	public void Reg_failureCount(int status) {
		Reg_failureCount = status;
	}

	public boolean first_regFailure() {
		return first_regFailure;
	}

	public void first_regFailure(boolean status) {
		first_regFailure = status;
	}

	public String WifiConnectionStatus() {
		return WifiConnectionStatus;
	}

	public void WifiConnectionStatus(String status) {
		WifiConnectionStatus = status;
	}

	public boolean isStatRegistrationStatus() {
		return isStatRegistrationStatus;
	}

	public void isStatRegistrationStatus(boolean status) {
		isStatRegistrationStatus = status;
	}

	public String RedlinkConnectionStatus() {
		return RedlinkConnectionStatus;
	}

	public void RedlinkConnectionStatus(String status) {
		RedlinkConnectionStatus = status;
	}

	public void homeKitDeviceName(String device) {
		homeKitDeviceName = device;
	}

	public String homeKitDeviceName() {
		return homeKitDeviceName;
	}

	public void isDirectAPModeEnabledInIOS(boolean isdeleted) {
		isDirectAPModeEnabledInIOS = isdeleted;
	}

	public boolean isDirectAPModeEnabledInIOS() {
		return isDirectAPModeEnabledInIOS;
	}

	public void isBleErrorConnectingtoThermostat(boolean isdeleted) {
		isBleErrorConnectingtoThermostat = isdeleted;
	}

	public boolean isBleErrorConnectingtoThermostat() {
		return isBleErrorConnectingtoThermostat;
	}

	public void macIDName(String MacID) {
		macIDName = MacID;
	}

	public String macIDName() {
		return macIDName;
	}

	public void IsThermostatLocationSet(boolean isdeleted) {
		IsThermostatLocationSet = isdeleted;
	}

	public boolean IsThermostatLocationSet() {
		return IsThermostatLocationSet;
	}

	public void IsThermostatNameSet(boolean isdeleted) {
		IsThermostatNameSet = isdeleted;
	}

	public boolean IsThermostatNameSet() {
		return IsThermostatNameSet;
	}

	public void IsDeviceDeletedFromApp(boolean isdeleted) {
		IsDeviceDeletedFromApp = isdeleted;
	}

	public boolean IsDeviceDeletedFromApp() {
		return IsDeviceDeletedFromApp;
	}

	public void isDeletePerformed(boolean isdeleted) {
		isDeletePerformed = isdeleted;
	}

	public boolean isDeletePerformed() {
		return isDeletePerformed;
	}

	public void IsNavigateToWifiSCreenINFlycathcer(boolean iscompleted) {
		this.IsNavigateToWifiSCreenINFlycathcer = iscompleted;
	}

	public boolean IsNavigateToWifiSCreenINFlycathcer() {
		return IsNavigateToWifiSCreenINFlycathcer;
	}

	public void isflightmodecompleted(boolean iscompleted) {
		this.isflightmodecompleted = iscompleted;
	}

	public void isRebateDRcompleted(boolean iscompleted) {
		this.isRebateDRcompleted = iscompleted;
	}

	public boolean isflightmodecompleted() {
		return isflightmodecompleted;
	}

	public boolean isRebateDRcompleted() {
		return isRebateDRcompleted;
	}

	public void setTstatName(String tstat) {
		this.tStatName = tstat;
	}

	public String getTstatName() {
		return tStatName;
	}

	public boolean isAccessorySetupErrorOccured() {
		return isAccessorySetupErrorOccured;
	}

	public void setAccessorySetupErrorOccured(boolean isAccessorySetupErrorOccured) {
		this.isAccessorySetupErrorOccured = isAccessorySetupErrorOccured;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public boolean isAddNewDeviceButtonVisible() {
		return isAddNewDeviceButtonVisible;
	}

	public void setAddNewDeviceButtonVisible(boolean isAddNewDeviceButtonVisible) {
		this.isAddNewDeviceButtonVisible = isAddNewDeviceButtonVisible;
	}

	public boolean isAddNewDeviceScreenVisible() {
		return isAddNewDeviceScreenVisible;
	}

	public void setAddNewDeviceScreenVisible(boolean isAddNewDeviceScreenVisible) {
		this.isAddNewDeviceScreenVisible = isAddNewDeviceScreenVisible;
	}

	public boolean isDashBoardScreenVisible() {
		return isDashBoardScreenVisible;
	}

	public void setDashBoardScreenVisible(boolean isDashBoardScreenVisible) {
		this.isDashBoardScreenVisible = isDashBoardScreenVisible;
	}

	public boolean isWACFlowInitiated() {
		return isWACFlowInitiated;
	}

	public void setWACFlowInitiated(boolean isWACFlowInitiated) {
		this.isWACFlowInitiated = isWACFlowInitiated;
	}

	public boolean isWacConnectionForDeviceCompleted() {
		return WacConnectionForDeviceCompleted;
	}

	public void setWacConnectionForDeviceCompleted(boolean wacConnectionForDeviceCompleted) {
		WacConnectionForDeviceCompleted = wacConnectionForDeviceCompleted;
	}

	public boolean isReInitiateAPModeFlow() {
		return ReInitiateAPModeFlow;
	}

	public void setReInitiateAPModeFlow(boolean reInitiateAPModeFlow) {
		ReInitiateAPModeFlow = reInitiateAPModeFlow;
	}

	public boolean isAPmodeEnabled() {
		return APmodeEnabled;
	}

	public void setAPmodeEnabled(boolean aPmode) {
		APmodeEnabled = aPmode;
	}

	public boolean isDeviceFoundForWACMode() {
		return DeviceFoundForWACMode;
	}

	public void setDeviceFoundForWACMode(boolean wACmode) {
		DeviceFoundForWACMode = wACmode;
	}

	public boolean isConfigFinsished() {
		return isConfigFinsished;
	}

	public void setConfigFinsished(boolean isConfigFinsished) {
		this.isConfigFinsished = isConfigFinsished;
	}

	public boolean isDeviceShownOnDashboard() {
		return isDeviceShownOnDashboard;
	}

	public void setDeviceShownOnDashboard(boolean isDeviceShownOnDashboard) {
		this.isDeviceShownOnDashboard = isDeviceShownOnDashboard;
	}

	public boolean isDataSyncSuccessful() {
		return isDataSyncSuccessful;
	}

	public void setDataSyncSuccessful(boolean isDataSyncSuccessful) {
		this.isDataSyncSuccessful = isDataSyncSuccessful;
	}

	public boolean isStatDeletedFromApp() {
		return isStatDeletedFromApp;
	}

	public void setStatDeletedFromApp(boolean isStatDeletedFromApp) {
		this.isStatDeletedFromApp = isStatDeletedFromApp;
	}

	public boolean isAppCrashed() {
		return isAppCrashed;
	}

	public void setAppCrashed(boolean isAppCrashed) {
		this.isAppCrashed = isAppCrashed;
	}

	public boolean isDeviceRegistered() {
		return isDeviceRegistered;
	}

	public void setDeviceRegistered(boolean isDeviceRegistered) {
		this.isDeviceRegistered = isDeviceRegistered;
	}

	public boolean isRegError() {
		return isRegError;
	}

	public void setRegError(boolean isRegError) {
		this.isRegError = isRegError;
	}

	public void isNotNowButtonClickedAfterRegistrationInDashboard(boolean status) {
		this.isNotNowButtonClickedAfterRegistrationInDashboard = status;
	}

	public boolean isNotNowButtonClickedAfterRegistrationInDashboard() {
		return isNotNowButtonClickedAfterRegistrationInDashboard;
	}

	// Random Scenario for WIFI configuration

	String randomInteruption = null;
	String randomHighBandwidth = null;
	String randomLowBandwidth = null;
	String randomBandwidthDowntime = null;
	String randomOnOff_Bandwidth = null;

	public void setRandomInteruption(String randomName) {
		this.randomInteruption = randomName;
	}

	public String getRandomInteruption() {
		return randomInteruption;
	}

	public void setRandomBandwidthDowntime(String downtime) {
		this.randomBandwidthDowntime = downtime;
	}

	public String getRandomBandwidthDowntime() {
		return randomBandwidthDowntime;
	}

	public void setRandomLowBandwidth(String lowBandwidth) {
		this.randomLowBandwidth = lowBandwidth;
	}

	public String getRandomLowBandwidth() {
		return randomLowBandwidth;
	}

	public void setRandomHighBandwidth(String highBandwidth) {
		this.randomHighBandwidth = highBandwidth;
	}

	public String getRandomHighBandwidth() {
		return randomHighBandwidth;
	}

	public void setRandomRouterOff_Bandwidth(String switchCase) {
		this.randomOnOff_Bandwidth = switchCase;
	}

	public String getRandomRandomRouterOff_Bandwidth() {
		return randomOnOff_Bandwidth;
	}

	// Caspian environment variable
	boolean isConnectWithValve = false;
	boolean isSingleDevice = false;
	boolean isMultipleDevice = false;
	boolean isPairingFailed = false;
	boolean isDeviceNotFound = false;
	boolean isCaspainConnectionError = false;
	boolean isCaspainCloudSynError = false;
	boolean isCaspianCouldNtOpen = false;
	boolean isCaspianOfflineSince = false;
	boolean isCapianWorkingSince = false;
	boolean isCaspianWaterLeakDetect = false;
	boolean isCaspianValveOpened = false;
	boolean isCaspianValveClosed = false;
	boolean isCaspianHighHumidity = false;
	boolean isCaspianError = false;
	boolean isCaspianOnlineSince = false;
	String getFailedRegistrationDeviceName;
//	String getCaspianDeviceName;
	boolean isLastDeviceRegistrationFailure = false;
	boolean isCommunicationError = false;
	boolean isWifiError = false;
	boolean isDeviceAlreadyRegisteredError = false;
	boolean isDeviceNotRegisteredError = false;
	boolean isWifiNetworkError = false;
	boolean isPreviousTrailFailed = false;

//	public String getFailedRegistrationDeviceName () {
//		return getFailedRegistrationDeviceName;
//	}
//	
//	public void getFailedRegistrationDeviceName(String deviceName) {
//		this.getFailedRegistrationDeviceName = deviceName;
//	}

	public boolean isPreviousTrailFailed() {
		return isPreviousTrailFailed;
	}

	public void isPreviousTrailFailed(boolean flag) {
		this.isPreviousTrailFailed = flag;
	}

	public boolean isCaspainConnectionError() {
		return isCaspainConnectionError;
	}

	public void isCaspainConnectionError(boolean flag) {
		this.isCaspainConnectionError = flag;
	}

	public boolean isLastDeviceRegistrationFailure() {
		return isLastDeviceRegistrationFailure;
	}

	public void isLastDeviceRegistrationFailure(boolean flag) {
		this.isLastDeviceRegistrationFailure = flag;
	}

	public boolean isCaspianOnlineSince() {
		return isCaspianOnlineSince;
	}

	public void isCaspianOnlineSince(boolean flag) {
		this.isCaspianOnlineSince = flag;
	}

	public boolean isCaspianCouldNtOpen() {
		return isCaspianCouldNtOpen;
	}

	public void isCaspianCouldNtOpen(boolean flag) {
		this.isCaspianCouldNtOpen = flag;
	}

	public boolean isCaspianOfflineSince() {
		return isCaspianOfflineSince;
	}

	public void isCaspianOfflineSince(boolean flag) {
		this.isCaspianOfflineSince = flag;
	}

	public boolean isCapianWorkingSince() {
		return isCapianWorkingSince;
	}

	public void isCapianWorkingSince(boolean flag) {
		this.isCapianWorkingSince = flag;
	}

	public boolean isCaspianWaterLeakDetect() {
		return isCaspianWaterLeakDetect;
	}

	public void isCaspianWaterLeakDetect(boolean flag) {
		this.isCaspianWaterLeakDetect = flag;
	}

	public boolean isCaspianValveOpened() {
		return isCaspianValveOpened;
	}

	public void isCaspianValveOpened(boolean flag) {
		this.isCaspianValveOpened = flag;
	}

	public boolean isCaspianValveClosed() {
		return isCaspianValveClosed;
	}

	public void isCaspianValveClosed(boolean flag) {
		this.isCaspianValveClosed = flag;
	}

	public boolean isCaspianHighHumidity() {
		return isCaspianHighHumidity;
	}

	public void isCaspianHighHumidity(boolean flag) {
		this.isCaspianHighHumidity = flag;
	}

	public boolean isCaspianError() {
		return isCaspianError;
	}

	public void isCaspianError(boolean flag) {
		this.isCaspianError = flag;
	}

	public boolean isCaspainCloudSynError() {
		return isCaspainCloudSynError;
	}

	public void isCaspainCloudSynError(boolean flag) {
		this.isCaspainCloudSynError = flag;
	}

	public boolean isDeviceNotFound() {
		return isDeviceNotFound;
	}

	public void isDeviceNotFound(boolean flag) {
		this.isDeviceNotFound = flag;
	}

	public boolean isPairingFailed() {
		return isPairingFailed;
	}

	public void isPairingFailed(boolean flag) {
		this.isPairingFailed = flag;
	}

	public boolean isSingleDevice() {
		return isSingleDevice;
	}

	public void isSingleDevice(boolean flag) {
		this.isSingleDevice = flag;
	}

	public boolean isConnectWithValve() {
		return isConnectWithValve;
	}

	public void isConnectWithValve(boolean flag) {
		this.isConnectWithValve = flag;
	}

	public boolean isMultipleDevice() {
		return isMultipleDevice;
	}

	public void isMultipleDevice(boolean flag) {
		this.isMultipleDevice = flag;
	}

	public void isCommunicationError(boolean flag) {
		this.isCommunicationError = flag;
	}

	public boolean isCommunicationError() {
		return isCommunicationError;
	}

	public boolean isWifiError() {
		return isWifiError;
	}

	public void isWifiError(boolean flag) {
		this.isWifiError = flag;
	}

	public boolean isWifiNetworkError() {
		return isWifiNetworkError;
	}

	public void isWifiNetworkError(boolean flag) {
		this.isWifiNetworkError = flag;
	}

	public void isDeviceAlreadyRegisteredError(boolean flag) {
		this.isDeviceAlreadyRegisteredError = flag;
	}

	public boolean isDeviceAlreadyRegisteredError() {
		return isDeviceAlreadyRegisteredError;
	}
	
	public void isDeviceNotRegisteredError(boolean flag) {
		this.isDeviceNotRegisteredError = flag;
	}

	public boolean isDeviceNotRegisteredError() {
		return isDeviceNotRegisteredError;
	}

	public void initforCaspianDiy() {
		isSingleDevice(false);
		isMultipleDevice(false);
		isPairingFailed(false);
		isDeviceNotFound(false);
		isCaspainCloudSynError(false);
		isCaspianCouldNtOpen(false);
		isCaspianOfflineSince(false);
		isCapianWorkingSince(false);
		isCaspianWaterLeakDetect(false);
		isCaspianValveOpened(false);
		isCaspianValveClosed(false);
		isCaspianHighHumidity(false);
		isCaspianError(false);
		isCaspianOnlineSince(false);
		isConnectWithValve(false);
		isCommunicationError(false);
		isWifiError(false);
		isWifiNetworkError(false);
		isError(false);
		setLoggedIn(false);
		setAddNewDeviceScreenVisible(false);
	}

	/*
	 * 
	 * Resideo Pro Application Environment Dependency This Feature for Connect
	 * between Resideo pro and Honeywell Home
	 * 
	 */
	public void initforResideoProWithResieoHome() {
		isInvitationSentToCustomer(false);
		isInvitationScenarioNeedToverify(false);
		isInvitationIsVisibleDuringLogin(false);
		isInvitationVisibleInAddDevice(false);
		isThermostatOnWallorIosNetwork(false);
		isStartThermostatNetwork(false);
		setPreviousPin("");
		isBleErrorConnectingtoThermostat(false);
		isClickedResideoProAccountBtn(false);
		isSignIndone(false);
		isError(false);
		ble_AP_Connection_Status("none");
		isDisconnected(false);
		remaining_DisconnectionTime(0);
		ble_Ap_flow(null);
		isThermostat_DisconnectedAlready(false);
	}

	boolean isThermostat_DisconnectedAlready = false;
	boolean isStartThermostatNetwork = false;
	boolean isThermostatOnWallorIosNetwork = false;
	boolean isInvitationSentToCustomer = false;
	boolean isInvitationScenarioNeedToverify = false;
	boolean isInvitationIsVisibleDuringLogin = false;
	boolean isInvitationVisibleInAddDevice = false;
	String previousPin = "";
	boolean isClickedResideoProAccountBtn = false;
	boolean isSignIndone = false;
	boolean isError = false;

	public void isThermostat_DisconnectedAlready(boolean value) {
		this.isThermostat_DisconnectedAlready = value;
	}

	public boolean isThermostat_DisconnectedAlready() {
		return isThermostat_DisconnectedAlready;
	}

	public void isClickedResideoProAccountBtn(boolean value) {
		this.isClickedResideoProAccountBtn = value;
	}

	public boolean isClickedResideoProAccountBtn() {
		return isClickedResideoProAccountBtn;
	}

	public void isSignIndone(boolean value) {
		this.isSignIndone = value;
	}

	public boolean isSignIndone() {
		return isSignIndone;
	}

	public void setPreviousPin(String value) {
		this.previousPin = value;
	}

	public String getPreviousPin() {
		return previousPin;
	}

	public void isInvitationSentToCustomer(boolean value) {
		this.isInvitationSentToCustomer = value;
	}

	public boolean isInvitationSentToCustomer() {
		return isInvitationSentToCustomer;
	}

	public void isInvitationScenarioNeedToverify(boolean value) {
		this.isInvitationScenarioNeedToverify = value;
	}

	public boolean isInvitationScenarioNeedToverify() {
		return isInvitationScenarioNeedToverify;
	}

	public void isInvitationIsVisibleDuringLogin(boolean value) {
		this.isInvitationIsVisibleDuringLogin = value;
	}

	public boolean isInvitationIsVisibleDuringLogin() {
		return isInvitationIsVisibleDuringLogin;
	}

	public void isInvitationVisibleInAddDevice(boolean value) {
		this.isInvitationVisibleInAddDevice = value;
	}

	public boolean isInvitationVisibleInAddDevice() {
		return isInvitationVisibleInAddDevice;
	}

	public void isThermostatOnWallorIosNetwork(boolean value) {
		this.isThermostatOnWallorIosNetwork = value;
	}

	public boolean isThermostatOnWallorIosNetwork() {
		return isThermostatOnWallorIosNetwork;
	}

	public void isStartThermostatNetwork(boolean value) {
		this.isStartThermostatNetwork = value;
	}

	public boolean isStartThermostatNetwork() {
		return isStartThermostatNetwork;
	}

	/*
	 * HomeKit Paring Detial
	 * 
	 */

	String getLast6CharDeviceMacID;
	boolean isUncertifiedDevice;
	boolean isUnableToAddedAccessory;
	boolean isPairedDevice_HK;
//boolean bridgeLocationNameFinished=

	public void initForHomeKit() {
		isUncertifiedDevice(false);
		isUnableToAddedAccessory(false);
		isPairedDevice_HK(false);
	}

	public void isUncertifiedDevice(boolean status) {
		isUncertifiedDevice = status;
	}

	public boolean isUncertifiedDevice() {
		return isUncertifiedDevice;
	}

	public void isPairedDevice_HK(boolean status) {
		isPairedDevice_HK = status;
	}

	public boolean isPairedDevice_HK() {
		return isPairedDevice_HK;
	}

	public void isUnableToAddedAccessory(boolean status) {
		isUnableToAddedAccessory = status;
	}

	public boolean isUnableToAddedAccessory() {
		return isUnableToAddedAccessory;
	}

	public void getLast6CharDeviceMacID(String deviceName) {
		getLast6CharDeviceMacID = deviceName;
	}

	public String getLast6CharDeviceMacID() {
		return getLast6CharDeviceMacID;
	}

	/*
	 * 
	 * Thermostat Configuration
	 * 
	 */

	boolean isThermostatCloudSynError = false;
	boolean isThermostatOfflineSince = false;
	boolean isThermostatOnlineSince = false;
	boolean isfirstTimeChecking = true;
	boolean isNotnowUnPerformed = true;

	public void isThermostatCloudSynError(boolean flag) {
		this.isThermostatCloudSynError = flag;
	}

	public boolean isThermostatCloudSynError() {
		return isThermostatCloudSynError;
	}

	public boolean isThermostatOfflineSince() {
		return isThermostatOfflineSince;
	}

	public void isThermostatOfflineSince(boolean flag) {
		this.isThermostatOfflineSince = flag;
	}

	public boolean isThermostatOnlineSince() {
		return isThermostatOnlineSince;
	}

	public void isThermostatOnlineSince(boolean flag) {
		this.isThermostatOnlineSince = flag;
	}

	public boolean isfirstTimeChecking() {
		return isfirstTimeChecking;
	}

	public void isfirstTimeChecking(boolean flag) {
		this.isfirstTimeChecking = flag;
	}

	public boolean isNotnowUnPerformed() {
		return isNotnowUnPerformed;
	}

	public void isNotnowUnPerformed(boolean flag) {
		this.isNotnowUnPerformed = flag;
	}

	public void isError(boolean b) {
		isError = b;
	}

	public boolean isError() {
		return isError;
	}

}