package com.resideo.system.utils;

public class TrailData {
	private static TrailData instance = null;
	private int trailNo;
	private String executeOnTraffic_nonTraffic;
	private String changesApp_stat;
	private String setpointMode_change;
	private String beforeTrailStart;
	private String ChangefromValue;
	private String changeToValue;
	private String trafficStartTime;
	private String trailEndTime;
	private String trailStartTime;
	private String changeTime;
	private String verifyTime;
	private String TotalTimeTaken;
	private String AfterTrailWaitTime;
	private boolean isTrailSuccess;

	private TrailData() {

	}

	public static TrailData getStatus() {
		if (instance == null)
			instance = new TrailData();
		return instance;
	}

	public TrailData(int trailNo, String executeOnTraffic_nonTraffic, String changesApp_stat, String setpointMode_change,
			String beforeTrailStart, String ChangefromValue, String changeToValue, String trafficStartTime,
			String trailEndTime, String trailStartTime, String changeTime, String verifyTime, String TotalTimeTaken,
			String AfterTrailWaitTime, boolean isTrailSuccess) {
		this.trailNo = trailNo;
		this.executeOnTraffic_nonTraffic = executeOnTraffic_nonTraffic;
		this.changesApp_stat = changesApp_stat;
		this.setpointMode_change = setpointMode_change;
		this.beforeTrailStart = beforeTrailStart;
		this.ChangefromValue = ChangefromValue;
		this.changeToValue = changeToValue;
		this.trafficStartTime = trafficStartTime;
		this.trailEndTime = trailEndTime;
		this.trailStartTime = trailStartTime;
		this.changeTime = changeTime;
		this.verifyTime = verifyTime;
		this.TotalTimeTaken = TotalTimeTaken;
		this.AfterTrailWaitTime = AfterTrailWaitTime;
		this.isTrailSuccess = isTrailSuccess;
	}

	public int trailNo() {
		return trailNo;
	}

	public void trailNo(int trailNo) {
		this.trailNo = trailNo;
	}

	public String executeOnTraffic_nonTraffic() {
		return executeOnTraffic_nonTraffic;
	}

	public void executeOnTraffic_nonTraffic(String executeOnTraffic_nonTraffic) {
		this.executeOnTraffic_nonTraffic = executeOnTraffic_nonTraffic;
	}

	public String changesApp_stat() {
		return changesApp_stat;
	}

	public void changesApp_stat(String changesApp_stat) {
		this.changesApp_stat = changesApp_stat;
	}

	public String setpointMode_change() {
		return setpointMode_change;
	}

	public void setpointMode_change(String setpointMode_change) {
		this.setpointMode_change = setpointMode_change;
	}

	public String beforeTrailStart() {
		return beforeTrailStart;
	}

	public void beforeTrailStart(String beforeTrailStart) {
		this.beforeTrailStart = beforeTrailStart;
	}

	public String ChangefromValue() {
		return ChangefromValue;
	}

	public void ChangefromValue(String ChangefromValue) {
		this.ChangefromValue = ChangefromValue;
	}

	public String changeToValue() {
		return changeToValue;
	}

	public void changeToValue(String changeToValue) {
		this.changeToValue = changeToValue;
	}

	public String trafficStartTime() {
		return trafficStartTime;
	}

	public void trafficStartTime(String trafficStartTime) {
		this.trafficStartTime = trafficStartTime;
	}

	public String trailEndTime() {
		return trailEndTime;
	}

	public void trailEndTime(String trailEndTime) {
		this.trailEndTime = trailEndTime;
	}

	public String trailStartTime() {
		return trailStartTime;
	}

	public void trailStartTime(String trailStartTime) {
		this.trailStartTime = trailStartTime;
	}

	public String changeTime() {
		return changeTime;
	}

	public void changeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String verifyTime() {
		return verifyTime;
	}

	public void verifyTime(String verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String TotalTimeTaken() {
		return TotalTimeTaken;
	}

	public void TotalTimeTaken(String TotalTimeTaken) {
		this.TotalTimeTaken = TotalTimeTaken;
	}

	public String AfterTrailWaitTime() {
		return AfterTrailWaitTime;
	}

	public void AfterTrailWaitTime(String AfterTrailWaitTime) {
		this.AfterTrailWaitTime = AfterTrailWaitTime;
	}

	public boolean isTrailSuccess() {
		return isTrailSuccess;
	}

	public void isTrailSuccess(boolean isTrailSuccess) {
		this.isTrailSuccess = isTrailSuccess;
	}

	@Override
	public String toString() {
		return "TrailData [Trail_No=" + trailNo + ", ExecuteOnTraffic_NonTraffic=" + executeOnTraffic_nonTraffic
				+ ", Changes_in_APP_STAT=" + changesApp_stat + ", Setpoint_ModeChange=" + setpointMode_change
				+ ", Before_Trail_Start_Value=" + beforeTrailStart + ", Start_value=" + ChangefromValue + ", End_Value="
				+ changeToValue + ", Traffic_StartTime=" + trafficStartTime + ", Trail_EndTime=" + trailEndTime
				+ ", Trail_StartTime=" + trailStartTime + ", Change_Time=" + changeTime + ", Verify_Time=" + verifyTime
				+ ", Total_TimeTaken=" + TotalTimeTaken + ", AfterTrailWaitTime=" + AfterTrailWaitTime
				+ ", isTrailSuccess=" + isTrailSuccess + "]";
	}

}