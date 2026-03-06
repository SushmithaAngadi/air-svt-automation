package com.resideo.system.utils;

import java.util.concurrent.ScheduledExecutorService;

import com.resideo.system.utils.MultiThreadRunning.NetworkTraffic;
import com.resideo.system.utils.MultiThreadRunning.ThreadInitializeOnCondition;

public class CommonState {
	private static CommonState instance = null;

	private CommonState() {

	}

	public static CommonState getStatus() {
		if (instance == null)
			instance = new CommonState();
		return instance;
	}

	private boolean isMobileDriverNeedtoAwake = false;

	private boolean isNextTrailDataToBeDetermine;
	private float randomSetPoint;
	private boolean isWaitingTimerClose = false;
	private String traffic_nonTrafficRun;

	private String nextTrailForApp_Stat;
	private String nextTrailForSetPoint_SystemMode;

	private int whenSetpoint_ModeNeedToChangeBTWTrail;
	private boolean isTrafficStop = false;
	private boolean isCoolingPeriodStop = false;

	private boolean reVerifyCheckSumAgainstChanges;

	public boolean isMobileDriverNeedtoWait() {
		return isMobileDriverNeedtoAwake;
	}

	public void isMobileDriverNeedtoWait(boolean flag) {
		isMobileDriverNeedtoAwake = flag;
	}

	public boolean isNextTrailDataToBeDetermine() {
		return isNextTrailDataToBeDetermine;
	}

	public void isNextTrailDataToBeDetermine(boolean flag) {
		isNextTrailDataToBeDetermine = flag;
	}

	public boolean isWaitingTimerClose() {
		return isWaitingTimerClose;
	}

	public void isWaitingTimerClose(boolean flag) {
		isWaitingTimerClose = flag;
	}

	public float randomSetPoint() {
		return randomSetPoint;
	}

	public void randomSetPoint(float flag) {
		randomSetPoint = flag;
	}

	public int nextTrailStartingTime() {
		return whenSetpoint_ModeNeedToChangeBTWTrail;
	}

	public void nextTrailStartingTime(int time) {
		whenSetpoint_ModeNeedToChangeBTWTrail = time;
	}

	public boolean isTrafficStop() {
		return isTrafficStop;
	}

	public void isTrafficStop(boolean flag) {
		isTrafficStop = flag;
	}

	public boolean isCoolingPeriodStop() {
		return isCoolingPeriodStop;
	}

	public void isCoolingPeriodStop(boolean flag) {
		isCoolingPeriodStop = flag;
	}

	public void InitNetworkTraffic(boolean run, boolean cool) {
		isTrafficStop = run;
		isCoolingPeriodStop = cool;
	}

	public void traffic_nonTrafficRun(String traffic_nonTraffic) {
		traffic_nonTrafficRun = traffic_nonTraffic;
	}

	public String traffic_nonTrafficRun() {
		return traffic_nonTrafficRun;
	}

	public void initforNetwork() {
		instance = null;
		totaltrailforExecution = 0;
		isTrafficCodeRunning = false;
		networkTraffic = null;

	}

	public void reVerifyCheckSumAgainstChanges(boolean flag) {
		reVerifyCheckSumAgainstChanges = flag;
	}

	public boolean reVerifyCheckSumAgainstChanges() {
		return reVerifyCheckSumAgainstChanges;
	}

	public String nextTrailForApp_Stat() {
		return nextTrailForApp_Stat;
	}

	public void nextTrailForApp_Stat(String flag) {
		nextTrailForApp_Stat = flag;
	}

	public String nextTrailForSetPoint_SystemMode() {
		return nextTrailForSetPoint_SystemMode;
	}

	public void nextTrailForSetPoint_SystemMode(String flag) {
		nextTrailForSetPoint_SystemMode = flag;
	}

	/*
	 * Current Mode and Current Setpoint from app and stat
	 */

	private String APPCurrentModeBeforeTrailStart;
	private String StatCurrentModeBeforeTrailStart;
	private float APPCurrentSetPointBeforeTrailStart;
	private float StatCurrentSetPointBeforeTrailStart;
	private String getCurrentTempScale;
	private boolean isTimeForDataCollect_beforeTrailStart;
	private int getTimeOutForVerification;
	private int getTimeOutForReverification;
	private String getTimeOutForVerificationType;
	private String getTimeOutForReverificationType;
	private String trailBetweenWaitTimeOutUnit;
	private int totaltrailforExecution;
	private boolean isTrafficCodeRunning;

	public String APPCurrentModeBeforeTrailStart() {
		return APPCurrentModeBeforeTrailStart;
	}

	public void APPCurrentModeBeforeTrailStart(String mode) {
		APPCurrentModeBeforeTrailStart = mode;
	}

	public String StatCurrentModeBeforeTrailStart() {
		return StatCurrentModeBeforeTrailStart;
	}

	public void StatCurrentModeBeforeTrailStart(String mode) {
		StatCurrentModeBeforeTrailStart = mode;
	}

	public void APPCurrentSetPointBeforeTrailStart(float setPoint) {
		APPCurrentSetPointBeforeTrailStart = setPoint;
	}

	public float APPCurrentSetPointBeforeTrailStart() {
		return APPCurrentSetPointBeforeTrailStart;
	}

	public void StatCurrentSetPointBeforeTrailStart(float setPoint) {
		StatCurrentSetPointBeforeTrailStart = setPoint;
	}

	public float StatCurrentSetPointBeforeTrailStart() {
		return StatCurrentSetPointBeforeTrailStart;
	}

	public String getCurrentTempScale() {
		return getCurrentTempScale;
	}

	public void getCurrentTempScale(String Scale) {
		getCurrentTempScale = Scale;
	}

	public void isTimeForDataCollect_beforeTrailStart(boolean flag) {
		isTimeForDataCollect_beforeTrailStart = flag;
	}

	public boolean isTimeForDataCollect_beforeTrailStart() {
		return isTimeForDataCollect_beforeTrailStart;
	}

	public int getTimeOutForVerification() {
		return getTimeOutForVerification;
	}

	public void getTimeOutForVerification(int timeout) {
		getTimeOutForVerification = timeout;
	}

	public int getTimeOutForReverification() {
		return getTimeOutForReverification;
	}

	public void getTimeOutForReverification(int timeout) {
		getTimeOutForReverification = timeout;
	}

	public String getTimeOutForVerificationType() {
		return getTimeOutForVerificationType;
	}

	public void getTimeOutForVerificationType(String type) {
		getTimeOutForVerificationType = type;
	}

	public String getTimeOutForReverificationType() {
		return getTimeOutForReverificationType;
	}

	public void getTimeOutForReverificationType(String type) {
		getTimeOutForReverificationType = type;
	}

	public String trailBetweenWaitTimeOutUnit() {
		return trailBetweenWaitTimeOutUnit;
	}

	public void trailBetweenWaitTimeOutUnit(String type) {
		trailBetweenWaitTimeOutUnit = type;
	}

	public void totaltrailforExecution(int totalTrail) {
		totaltrailforExecution = totalTrail;
	}

	public int totaltrailforExecution() {
		return totaltrailforExecution;
	}

	public void isTrafficCodeRunning(boolean flag) {
		isTrafficCodeRunning = flag;
	}

	public boolean isTrafficCodeRunning() {
		return isTrafficCodeRunning;
	}

	/*
	 * Execution starts for Traffic and Non Traffic
	 * 
	 */

	private boolean isTrafficStarted = false;
	private boolean isNonTrafficCoolingStarted = false;

	public void isTrafficStarted(boolean flag) {
		isTrafficStarted = flag;
	}

	public boolean isTrafficStarted() {
		return isTrafficStarted;
	}

	public void isNonTrafficCoolingStarted(boolean flag) {
		isNonTrafficCoolingStarted = flag;
	}

	public boolean isNonTrafficCoolingStarted() {
		return isNonTrafficCoolingStarted;
	}

	/*
	 * Thread class for Stop instance
	 * 
	 */

	private NetworkTraffic networkTraffic;
	private ThreadInitializeOnCondition threadInitializeOnCondition;
	private boolean isTrailLoopFinished = false;
	private ScheduledExecutorService schedulerForRunCommand = null;

	public void networkTraffic(NetworkTraffic Class) {
		networkTraffic = Class;
	}

	public NetworkTraffic networkTraffic() {
		return networkTraffic;
	}

	public void threadInitializationCondition(ThreadInitializeOnCondition Class) {
		threadInitializeOnCondition = Class;
	}

	public ThreadInitializeOnCondition threadInitializeOnCondition() {
		return threadInitializeOnCondition;
	}

	public void isTrailLoopFinished(boolean flag) {
		isTrailLoopFinished = flag;
	}

	public boolean isTrailLoopFinished() {
		return isTrailLoopFinished;
	}

	public void schedulerForRunCommand(ScheduledExecutorService command) {
		schedulerForRunCommand = command;
	}

	public ScheduledExecutorService schedulerForRunCommand() {
		return schedulerForRunCommand;
	}

}
