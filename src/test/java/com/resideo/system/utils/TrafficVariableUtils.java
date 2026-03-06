package com.resideo.system.utils;

import com.resideo.system.utils.MultiThreadRunning.NetworkTraffic;
import com.resideo.system.utils.MultiThreadRunning.ThreadInitializeOnCondition;

public class TrafficVariableUtils {
	private static TrafficVariableUtils instance = null;

	private TrafficVariableUtils() {

	}

	public static TrafficVariableUtils getStatus() {
		if (instance == null)
			instance = new TrafficVariableUtils();
		return instance;
	}

	private boolean isMobileDriverNeedtoAwake = false;

	private boolean isNextTrailDataToBeDetermine;
//	private Random random;
	private float randomSetPoint;
//	private boolean isSetpointChangesDuringNetworkTraffic;
	private boolean isWaitingTimerClose = false;
	private String traffic_nonTrafficRun = "TRAFFIC";

	private String nextTrailForApp_Stat = "APP";
	private String nextTrailForSetPoint_SystemMode = "SET POINT";

	private int whenSetpoint_ModeNeedToChangeBTWTrail = 0;
	private boolean isTrafficStop = false;
	private boolean isCoolingPeriodStop = false;

	private boolean reVerifyCheckSumAgainstChanges;

	private int setThisSetPoint;
	private String setThisSetMode;
	private int SetPointChangeFromThisSetPoint;
	private String setModeChangesFromThisMode;
	private int currentSetPointFromApp;
	private int currentSetPointFromStat;
	private String currentModeFromApp;
	private String currentModeFromStat;

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

//	public boolean isSetpointChangesDuringNetworkTraffic() {
//		return isSetpointChangesDuringNetworkTraffic;
//	}
//
//	public void isSetpointChangesDuringNetworkTraffic(boolean flag) {
//		isSetpointChangesDuringNetworkTraffic = flag;
//	}

//	public boolean isMobileSetPointNeedToChange() {
//		return isMobileSetPointNeedToChange;
//	}
//
//	public void isMobileSetPointNeedToChange(boolean flag) {
//		isMobileSetPointNeedToChange = flag;
//	}

	public float randomSetPoint() {
		return randomSetPoint;
	}

	public void randomSetPoint(float flag) {
		randomSetPoint = flag;
	}

	public int whenSetpoint_ModeNeedToChangeBTWTrail() {
		return whenSetpoint_ModeNeedToChangeBTWTrail;
	}

	public void whenSetpoint_ModeNeedToChangeBTWTrail(int time) {
		whenSetpoint_ModeNeedToChangeBTWTrail = time;
	}

//	public Random randomInstance() {
//		if (random == null) {
//			return random = new Random();
//		} else {
//			return random;
//		}
//	}

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

	public void setThisSetPoint(int flag) {
		setThisSetPoint = flag;
	}

	public int setThisSetPoint() {
		return setThisSetPoint;
	}

	public void setThisSetMode(String flag) {
		setThisSetMode = flag;
	}

	public String setThisSetMode() {
		return setThisSetMode;
	}

	public void SetPointChangeFromThisSetPoint(int flag) {
		SetPointChangeFromThisSetPoint = flag;
	}

	public int SetPointChangeFromThisSetPoint() {
		return SetPointChangeFromThisSetPoint;
	}

	public void setModeChangesFromThisMode(String flag) {
		setModeChangesFromThisMode = flag;
	}

	public String setModeChangesFromThisMode() {
		return setModeChangesFromThisMode;
	}

	public void traffic_nonTrafficRun(String traffic_nonTraffic) {
		traffic_nonTrafficRun = traffic_nonTraffic;
	}

	public String traffic_nonTrafficRun() {
		return traffic_nonTrafficRun;
	}

	public void currentSetPointFromApp(int flag) {
		currentSetPointFromApp = flag;
	}

	public int currentSetPointFromApp() {
		return currentSetPointFromApp;
	}

	public void currentSetPointFromStat(int flag) {
		currentSetPointFromStat = flag;
	}

	public int currentSetPointFromStat() {
		return currentSetPointFromStat;
	}

	public void currentModeFromApp(String flag) {
		currentModeFromApp = flag;
	}

	public String currentModeFromApp() {
		return currentModeFromApp;
	}

	public void currentModeFromStat(String flag) {
		currentModeFromStat = flag;
	}

	public String currentModeFromStat() {
		return currentModeFromStat;
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

	/*
	 * Get SetPoint for App or Stat During Trail Changes from random value
	 */

	private float getNeedToBeSetSetpointForAPP_Stat;

	public void getNeedToBeSetSetpointForAPP_Stat(float setPoint) {
		getNeedToBeSetSetpointForAPP_Stat = setPoint;
	}

	public float getNeedToBeSetSetpointForAPP_Stat() {
		return getNeedToBeSetSetpointForAPP_Stat;
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

	/*
	 * Result Update for Trails
	 * 
	 */

	private long currentMilliSecond;
	private long remainingMilliSecond;
	private long totalMilliSecond;
	private long verifySuccessTime;
	private long verifyFailedTime;
	private long changesStartTime;
	private boolean istestCaseSuccess;

	public long currentMilliSecond() {
		return currentMilliSecond;
	}

	public void currentMilliSecond(long timer) {
		currentMilliSecond = timer;
	}

	public long remainingMilliSecond() {
		return remainingMilliSecond;
	}

	public void remainingMilliSecond(long timer) {
		remainingMilliSecond = timer;
	}

	public long totalMilliSecond() {
		return totalMilliSecond;
	}

	public void totalMilliSecond(long timer) {
		totalMilliSecond = timer;
	}

	public long verifySuccessTime() {
		return verifySuccessTime;
	}

	public void verifySuccessTime(long timer) {
		verifySuccessTime = timer;
	}

	public long verifyFailedTime() {
		return verifyFailedTime;
	}

	public void verifyFailedTime(long timer) {
		verifyFailedTime = timer;
	}

	public long changesStartTime() {
		return changesStartTime;
	}

	public void changesStartTime(long timer) {
		changesStartTime = timer;
	}

	public boolean istestCaseSuccess() {
		return istestCaseSuccess;
	}

	public void istestCaseSuccess(boolean flag) {
		istestCaseSuccess = flag;
	}

}
