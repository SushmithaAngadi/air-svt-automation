package com.resideo.system.utils;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.relay.RelayConfiguration;
import com.resideo.utils.resideo_app.PrimaryCardUtils;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg.Relays;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg.SetPoint;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.web.KeepAppActive;
import com.opencsv.CSVWriter;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

public class CommonUtils {

    private static CommonUtils instance = null;
    private static String futureTime;
    private static Random random;
    private static String CattData;
    KeepAppActive threadInitial;
    boolean isMobileThread = false;
    boolean isWebThread = false;
    boolean isSetpointThread = false;

    public static CommonUtils getStatus() {
        if (instance == null) {
            instance = new CommonUtils();
            random = new Random();
        }
        return instance;
    }

    public static void setDataTime(String time) {
        CattData = time;
    }

    public static String getDatatime() {
        return CattData;
    }

    public static String getRandom_DIYScenario() {
        String[] arr = {"AfterRegistration_DataSync", "AfterWifi_Connect", "Datasync_Api"};
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }

    public static String getRandom_RouterOption() {
        String[] arr = {"TurnOFF_TurnON", "Bandwidth"};
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }

    public static boolean waituntilTimeComplete(TestCases testCase) {
        boolean flag = false;
        if (testCase.getWebDriver() != null) {
            CommonUtils.getStatus().setIsWebThread(true);
        }
        futureTime = getFutureTimeFromCurrentTime(
                Integer.valueOf(SystemState.getStatus().getRandomBandwidthDowntime()));
        String currentTime = getCurrentTime();
        FluentWait<Boolean> fWait = new FluentWait<Boolean>(flag);
        fWait.withTimeout(Duration.ofMinutes(15));
        fWait.pollingEvery(Duration.ofSeconds(1));
        fWait.ignoring(IOException.class);

        boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
            public Boolean apply(Boolean input) {
                try {
                    if (futureTime.equals(getCurrentTime())) {
                        Keyword.ReportStep_Pass(testCase, "Router Interepted from This time  '>>>>>>>" + currentTime
                                + "<<<<<<<<' to this time  '>>>>>>>" + futureTime + "<<<<<<<<");
                        return true;
                    } else {

                        System.out.println("Thread Running " + futureTime);
                        return false;
                    }
                } catch (Exception e) {
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "Fluent wait for Downtime Got Exception, Exception is ++>>> " + e.getMessage());
                    return false;
                }
            }

        });
        if (isEventReceived) {
            if (CommonUtils.getStatus().isWebThread()) {
                CommonUtils.getStatus().setIsWebThread(false);
            }

            Keyword.ReportStep_Pass(testCase, "Thread Running Stopped due to User Request");
            flag = true;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Fluent wait for Downtime Got Failed");
            flag = false;
        }
        return flag;
    }

    public static void waituntilTimeComplete() {
        boolean time = false;
        FluentWait<Boolean> fWait = new FluentWait<Boolean>(time);
        fWait.withTimeout(Duration.ofMinutes(15));
        fWait.pollingEvery(Duration.ofSeconds(1));
        fWait.ignoring(IOException.class);

        boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
            public Boolean apply(Boolean input) {
                try {

                    if (futureTime.equals(getCurrentTime())) {
                        System.out.println("=================================================");
                        System.out.println(getCurrentTime());
                        System.out.println(futureTime);
                        System.out.println("=================================================");
                        return true;
                    } else {
                        System.out.println("Current time :::::   " + getCurrentTime());
                        System.out.println("Future time :::   " + futureTime);
                        System.out.println("no same");
                        return false;
                    }
                } catch (Exception e) {
                    return false;

                }
            }

        });
        if (isEventReceived) {
            System.out.println("completed");
        }

    }

    public static int getRandomTime_Bandwidth(int lowerBound, int UpperBound) {
//		Random rand = new Random(); // instance of random class
        // generate random values from 0-24
//		return rand.nextInt(Upperbound);

        return (int) Math.floor(Math.random() * (UpperBound - lowerBound + 1) + lowerBound);
    }

    public static String getCurrentTime() {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return parser.format(date);
    }

    public static String getFutureTimeFromCurrentTime(int randomTime) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String format = parser.format(date);
            Date myDate = parser.parse(format);
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.SECOND, randomTime); // this will add two hours
            myDate = cal.getTime();
            return parser.format(myDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) throws ParseException {
        String random_DIYScenario = getRandom_DIYScenario();
        System.out.println(random_DIYScenario);
        futureTime = getFutureTimeFromCurrentTime(getRandomTime_Bandwidth(10, 600));
        waituntilTimeComplete();
    }

    public static ArrayList getRelayArray(String[] strRelays) {
        ArrayList expectedRelays = new ArrayList();
        for (String s : strRelays) {

            switch (Relays.valueOf(s)) {
                case E: {
                    expectedRelays.add(Relays.E);
                    break;
                }
                case G: {
                    expectedRelays.add(Relays.G);
                    break;
                }
                case U1: {
                    expectedRelays.add(Relays.U1);
                    break;
                }
                case W2_AUX: {
                    expectedRelays.add(Relays.W2_AUX);
                    break;
                }
                case W_OB: {
                    expectedRelays.add(Relays.W_OB);
                    break;
                }
                case Y: {
                    expectedRelays.add(Relays.Y);
                    break;
                }
                case Y2: {
                    expectedRelays.add(Relays.Y2);
                    break;
                }
                default: {
                    break;
                }
            }
        }

        return expectedRelays;

    }

    public static void StatSetpointThread() {
        int result = random.nextInt(90 - 50) + 50;
        Float valueOf = Float.valueOf(String.valueOf(result));
        StatCommands.getInstance().cattCommandsStub.setSetpoint(SetPointMsg.newBuilder().setVal(valueOf).build())
                .getBoolVal();

    }

    public static float getRandomSetpoint(Random ran) {

        if (CommonState.getStatus().StatCurrentSetPointBeforeTrailStart() > 40) {
            CommonState.getStatus().getCurrentTempScale("F");
            float random = (float) ran.nextInt(81 - 75) + 75;
            if (random == CommonState.getStatus().StatCurrentSetPointBeforeTrailStart()) {
                return random + 1;
            } else {
                return random;
            }

        } else {
            CommonState.getStatus().getCurrentTempScale("C");
            float random = (float) ran.nextInt(27 - 29) + 29;
            if (random == CommonState.getStatus().StatCurrentSetPointBeforeTrailStart()) {
                return random + 1;
            } else {
                return random;
            }
        }
    }

    public static String getSystemModeChange() {
        if (CommonState.getStatus().StatCurrentModeBeforeTrailStart().toUpperCase().contains("HEAT")) {
            return "COOL";
        } else {
            return "HEAT";
        }
    }

    public static String getCurrentRunningModeFromBothEnd(TestCases testCase, PrimaryCardScreen pm) {
        String statmode = StatCommands.getInstance().cattCommandsStub.getSystemSwitch(String_Msg.newBuilder().build())
                .getSwitch().toString();
        String appmode = pm.getCurrentModeFromPrimaryCard();
        CommonState.getStatus().APPCurrentModeBeforeTrailStart(appmode);
        CommonState.getStatus().StatCurrentModeBeforeTrailStart(statmode);
        if (statmode.toUpperCase().contains(appmode.toUpperCase())) {
            return statmode;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Mode is not same in APP and STAT, This was absorbed in Before start Trail. Current mode in APP is "
                            + appmode + ",. Current Mode from TSTAT is " + statmode);
            return statmode;
        }

    }

    public static float getCurrentRunningSetPointFromBothEnd_WithMode(TestCases testCase, PrimaryCardScreen pm) {
        CommonState.getStatus().isMobileDriverNeedtoWait(false);
        String currentRunningModeFromBothEnd = getCurrentRunningModeFromBothEnd(testCase, pm);

        float statSetPoint = 0;
        if (currentRunningModeFromBothEnd.toUpperCase().contains("HEAT")) {
            statSetPoint = StatCommands.getInstance().cattCommandsStub
                    .getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_HEAT).build())
                    .getFloatVal();

        } else {
            statSetPoint = StatCommands.getInstance().cattCommandsStub
                    .getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_COOL).build())
                    .getFloatVal();
        }
        String appSetPointString = pm.getCurrentSetpoint();
        Float appSetpoint = Float.valueOf(appSetPointString);

        CommonState.getStatus().APPCurrentSetPointBeforeTrailStart(appSetpoint);
        CommonState.getStatus().StatCurrentSetPointBeforeTrailStart(statSetPoint);

        if (statSetPoint == appSetpoint) {
            return statSetPoint;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "SetPoint is not same in APP and STAT, This was absorbed in Before start Trail.Current Running Mode is "
                            + currentRunningModeFromBothEnd + ", Current Setpoint in APP is " + appSetpoint
                            + ",. Current Setpoint from TSTAT is " + statSetPoint);
            CommonState.getStatus().isMobileDriverNeedtoWait(true);
            return statSetPoint;
        }

    }

    public static boolean setpointChangesFromAppVerifyFromStat(TestCases testCase, PrimaryCardScreen pm,
                                                               float SetPoint) {
        TrailData.getStatus()
                .beforeTrailStart(String.valueOf(CommonState.getStatus().APPCurrentSetPointBeforeTrailStart()));
        boolean flag = false;
        try {

            CommonState.getStatus().isMobileDriverNeedtoWait(false);
            TrailData.getStatus().trailStartTime(String.valueOf(System.currentTimeMillis()));
            flag = PrimaryCardUtils.changeSetpointInApp(testCase, pm, SetPoint);
            CommonState.getStatus().isMobileDriverNeedtoWait(true);
            flag = flag && StatCommonCommandUtils.verifySetpointFromStat(testCase,
                    getDuration(CommonState.getStatus().getTimeOutForVerificationType(),
                            CommonState.getStatus().getTimeOutForVerification()),
                    CommonState.getStatus().StatCurrentModeBeforeTrailStart(), SetPoint, true);
            if (SuiteConstants.getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "IS_REVERIFICATION")
                    .contains("TRUE")) {
                flag = flag
                        && SystemPerformanceTest
                        .threadForWaitingForRevertBack(testCase,
                                getDuration(CommonState.getStatus().getTimeOutForReverificationType(),
                                        CommonState.getStatus().getTimeOutForReverification()),
                                Duration.ofMillis(500));
                flag = flag && PrimaryCardUtils.verifySetpointFromAPP(testCase, pm, Duration.ofSeconds(5), SetPoint,
                        "REVERIFICATION");
            }
            TrailData.getStatus().trailEndTime(String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean setPointChangesFromStatVerifyFromApp(TestCases testCase, PrimaryCardScreen pm,
                                                               float setPoint) {
        TrailData.getStatus()
                .beforeTrailStart(String.valueOf(CommonState.getStatus().StatCurrentSetPointBeforeTrailStart()));
        boolean flag = false;
        try {

            CommonState.getStatus().isMobileDriverNeedtoWait(true);
            TrailData.getStatus().trailStartTime(String.valueOf(System.currentTimeMillis()));
            flag = StatCommonCommandUtils.setPoint_Heat_Cool(testCase, setPoint);
            CommonState.getStatus().isMobileDriverNeedtoWait(false);
            flag = flag && PrimaryCardUtils.verifySetpointFromAPP(testCase, pm,
                    getDuration(CommonState.getStatus().getTimeOutForVerificationType(),
                            CommonState.getStatus().getTimeOutForVerification()),
                    setPoint, "VERIFY");
            CommonState.getStatus().isMobileDriverNeedtoWait(true);
            if (SuiteConstants.getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "IS_REVERIFICATION")
                    .contains("TRUE")) {
                flag = flag
                        && SystemPerformanceTest
                        .threadForWaitingForRevertBack(testCase,
                                getDuration(CommonState.getStatus().getTimeOutForReverificationType(),
                                        CommonState.getStatus().getTimeOutForReverification()),
                                Duration.ofMillis(500));
                flag = flag && StatCommonCommandUtils.verifySetpointFromStat(testCase, Duration.ofSeconds(5),
                        CommonState.getStatus().StatCurrentModeBeforeTrailStart(), setPoint, false);
            }
            TrailData.getStatus().trailEndTime(String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean setModeChangesFromAppVerifyFromStat(TestCases testCase, PrimaryCardScreen pm, String mode)
            throws Exception {
        boolean flag = false;
        TrailData.getStatus().beforeTrailStart(CommonState.getStatus().APPCurrentModeBeforeTrailStart());
        CommonState.getStatus().isMobileDriverNeedtoWait(false);
        TrailData.getStatus().trailStartTime(String.valueOf(System.currentTimeMillis()));
        flag = PrimaryCardUtils.changeSystemModeInApp(testCase, pm, mode);
        CommonState.getStatus().isMobileDriverNeedtoWait(true);
        flag = flag && StatCommonCommandUtils.verifyModeHeat_Cool(testCase,
                getDuration(CommonState.getStatus().getTimeOutForVerificationType(),
                        CommonState.getStatus().getTimeOutForVerification()),
                mode, true);
        if (SuiteConstants.getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "IS_REVERIFICATION")
                .contains("TRUE")) {
            flag = flag
                    && SystemPerformanceTest
                    .threadForWaitingForRevertBack(testCase,
                            getDuration(CommonState.getStatus().getTimeOutForReverificationType(),
                                    CommonState.getStatus().getTimeOutForReverification()),
                            Duration.ofMillis(500));
            CommonState.getStatus().isMobileDriverNeedtoWait(false);
            flag = flag && PrimaryCardUtils.verifySystemModeChangesInApp(testCase, pm, Duration.ofSeconds(5), mode);
        }
        CommonState.getStatus().isMobileDriverNeedtoWait(true);
        TrailData.getStatus().trailEndTime(String.valueOf(System.currentTimeMillis()));
        return flag;
    }

    public static boolean setModeChangesFromStatVerifyFromApp(TestCases testCase, PrimaryCardScreen pm, String mode)
            throws Exception {
        boolean flag = false;
        TrailData.getStatus().beforeTrailStart(CommonState.getStatus().StatCurrentModeBeforeTrailStart());
        CommonState.getStatus().isMobileDriverNeedtoWait(true);
        TrailData.getStatus().trailStartTime(String.valueOf(System.currentTimeMillis()));
        flag = StatCommonCommandUtils.setModeHeat_Cool(testCase, mode);
        CommonState.getStatus().isMobileDriverNeedtoWait(false);
        flag = flag && PrimaryCardUtils.verifySystemModeChangesInApp(testCase, pm,
                getDuration(CommonState.getStatus().getTimeOutForVerificationType(),
                        CommonState.getStatus().getTimeOutForVerification()),
                mode);
        CommonState.getStatus().isMobileDriverNeedtoWait(true);
        if (SuiteConstants.getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "IS_REVERIFICATION")
                .contains("TRUE")) {
            flag = flag
                    && SystemPerformanceTest
                    .threadForWaitingForRevertBack(testCase,
                            getDuration(CommonState.getStatus().getTimeOutForReverificationType(),
                                    CommonState.getStatus().getTimeOutForReverification()),
                            Duration.ofMillis(500));
            flag = flag && StatCommonCommandUtils.verifyModeHeat_Cool(testCase, Duration.ofSeconds(5), mode, false);
        }

        TrailData.getStatus().trailEndTime(String.valueOf(System.currentTimeMillis()));
        return flag;
    }

    public static boolean randomGenerate() {
        try {

            String[] trailNetworkState = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "TRAIL_NETWORK_STATES")
                    .split(":");
            String[] trailPlatformType = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "TRAIL_PLATFORM_TYPE").split(":");
            String[] trailChangesOn = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "TRAIL_CHANGEON").split(":");
            String[] removeMinMax = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "NEXT_TRAIL_WAIT_MIN_MAX_TIME")
                    .split("_");
            String[] minMaxNextTrailTime = removeMinMax[0].split(":");

            String[] verifyTimeOutArray = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "TIMEOUT_FOR_VERIFICATION")
                    .split("_");
            String TImeoutForVerificationType = verifyTimeOutArray[1];
            int TImeoutForVerification = Integer.valueOf(verifyTimeOutArray[0]);
            String[] reVerifyTimeOutArray = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.NETWORK_TRAFFIC_PERFORMANCE, "TIMEOUT_FOR_VERIFICATION")
                    .split("_");
            int TImeoutForReVerification = Integer.valueOf(reVerifyTimeOutArray[0]);
            String TImeoutForReVerificationType = reVerifyTimeOutArray[1];
            Random random = new Random();
            CommonState.getStatus().randomSetPoint(CommonUtils.getRandomSetpoint(random));
            CommonState.getStatus().nextTrailForApp_Stat(trailPlatformType[(random.nextInt(trailPlatformType.length))]);
            CommonState.getStatus()
                    .traffic_nonTrafficRun(trailNetworkState[(random.nextInt(trailNetworkState.length))]);
            CommonState.getStatus()
                    .nextTrailForSetPoint_SystemMode(trailChangesOn[(random.nextInt(trailChangesOn.length))]);
            CommonState.getStatus().nextTrailStartingTime(random.nextInt(Integer.valueOf(minMaxNextTrailTime[1])
                    - Integer.valueOf(minMaxNextTrailTime[0]) + Integer.valueOf(minMaxNextTrailTime[0])));

            CommonState.getStatus().getTimeOutForVerification(TImeoutForVerification);

            CommonState.getStatus().getTimeOutForReverification(TImeoutForReVerification);

            CommonState.getStatus().getTimeOutForVerificationType(TImeoutForVerificationType);
            CommonState.getStatus().getTimeOutForReverificationType(TImeoutForReVerificationType);
            CommonState.getStatus().trailBetweenWaitTimeOutUnit(removeMinMax[1]);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean startExecutionForTraffic(TestCases testCase, PrimaryCardScreen pm) {
        boolean flag = false;
        int i = 1;
        while (!CommonState.getStatus().isTrailLoopFinished()) {
            TrailData.getStatus().trailNo(i);

            CommonUtils.getCurrentRunningSetPointFromBothEnd_WithMode(testCase, pm);
            flag = randomGenerate();

            if (CommonState.getStatus().nextTrailForApp_Stat().contains("APP")) {
                TrailData.getStatus().changesApp_stat("APP");

                flag = setPoint_SystemModeChangesApp(testCase, pm);

            } else if (CommonState.getStatus().nextTrailForApp_Stat().contains("STAT")) {
                TrailData.getStatus().changesApp_stat("STAT");

                flag = setPoint_SystemModeChangesStat(testCase, pm);

            } else {

                flag = false;
                TrailData.getStatus().isTrailSuccess(flag);
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Provided Data not available, APP or STAT can be used");

            }

            writeDataIntoCSV("", String.valueOf(flag));
            flag = trailWaitForNextInteration(testCase);

            i = i + 1;
            if (i >= CommonState.getStatus().totaltrailforExecution()) {
                CommonState.getStatus().isTrailLoopFinished(true);
                CommonState.getStatus().schedulerForRunCommand().shutdown();
            }
        }

        return flag;
    }

    public static boolean setPoint_SystemModeChangesStat(TestCases testCase, PrimaryCardScreen pm) {
        boolean flag = false;
        try {
            if (CommonState.getStatus().nextTrailForSetPoint_SystemMode().contains("SET_POINT")) {
                float randomSetPoint = CommonState.getStatus().randomSetPoint();
                TrailData.getStatus().setpointMode_change("SET_POINT");
                if (CommonState.getStatus().traffic_nonTrafficRun().equals("TRAFFIC")) {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "TRAFFIC");
                    System.out.println("Traffic execution started");
                    flag = flag && setPointChangesFromStatVerifyFromApp(testCase, pm, randomSetPoint);
                } else {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("NON_TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "NON_TRAFFIC");
                    System.out.println("Non Traffic execution started");
                    flag = flag && setPointChangesFromStatVerifyFromApp(testCase, pm, randomSetPoint);
                }

            } else if (CommonState.getStatus().nextTrailForSetPoint_SystemMode().contains("SYSTEM_MODE")) {
                String mode = getSystemModeChange();
                TrailData.getStatus().setpointMode_change("SYSTEM_MODE");
                if (CommonState.getStatus().traffic_nonTrafficRun().equals("TRAFFIC")) {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "TRAFFIC");
                    System.out.println("Traffic execution started");
                    flag = flag && setModeChangesFromStatVerifyFromApp(testCase, pm, mode);

                } else {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("NON_TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "NON_TRAFFIC");
                    System.out.println("Non Traffic execution started");
                    flag = flag && setModeChangesFromStatVerifyFromApp(testCase, pm, mode);

                }

            } else {
                flag = false;
                TrailData.getStatus().isTrailSuccess(flag);
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Provided Data not available, SET_POINT or SYSTEM_MODE can be used");

            }
        } catch (Exception e) {
            flag = false;
            TrailData.getStatus().isTrailSuccess(flag);
        }

        TrailData.getStatus().isTrailSuccess(flag);
        return flag;

    }

    public static boolean setPoint_SystemModeChangesApp(TestCases testCase, PrimaryCardScreen pm) {
        boolean flag = false;
        try {
            if (CommonState.getStatus().nextTrailForSetPoint_SystemMode().contains("SET_POINT")) {
                float randomSetPoint = CommonState.getStatus().randomSetPoint();
                TrailData.getStatus().setpointMode_change("SET_POINT");
                if (CommonState.getStatus().traffic_nonTrafficRun().equals("TRAFFIC")) {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "TRAFFIC");
                    System.out.println("Traffic execution started");
                    flag = flag && setpointChangesFromAppVerifyFromStat(testCase, pm, randomSetPoint);
                } else {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("NON_TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "NON_TRAFFIC");
                    System.out.println("Non Traffic execution started");
                    flag = flag && setpointChangesFromAppVerifyFromStat(testCase, pm, randomSetPoint);
                }

            } else if (CommonState.getStatus().nextTrailForSetPoint_SystemMode().contains("SYSTEM_MODE")) {
                String mode = getSystemModeChange();
                TrailData.getStatus().setpointMode_change("SYSTEM_MODE");
                if (CommonState.getStatus().traffic_nonTrafficRun().equals("TRAFFIC")) {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "TRAFFIC");
                    System.out.println("Traffic execution started");
                    flag = flag && setModeChangesFromAppVerifyFromStat(testCase, pm, mode);

                } else {
                    TrailData.getStatus().executeOnTraffic_nonTraffic("NON_TRAFFIC");
                    CommonState.getStatus().isMobileDriverNeedtoWait(true);
                    flag = SystemPerformanceTest.waitTraffic_nonTrafficUpdate(testCase, Duration.ofSeconds(60),
                            Duration.ofSeconds(1), "NON_TRAFFIC");
                    System.out.println("Non Traffic execution started");
                    flag = flag && setModeChangesFromAppVerifyFromStat(testCase, pm, mode);

                }

            } else {
                flag = false;
                TrailData.getStatus().isTrailSuccess(flag);
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Provided Data not available, SET_POINT or SYSTEM_MODE can be used");

            }
        } catch (Exception e) {
            flag = false;
            TrailData.getStatus().isTrailSuccess(flag);
        }
        TrailData.getStatus().isTrailSuccess(flag);
        return flag;
    }

    public static void writeDataIntoCSV(String Path, String result) {
        String csv = "src/test/resources/testdata/TestData.csv";
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(csv, true));
            String trailNo = String.valueOf(TrailData.getStatus().trailNo());
            String executeOnTraffic_nonTraffic = TrailData.getStatus().executeOnTraffic_nonTraffic();
            String changesApp_stat = TrailData.getStatus().changesApp_stat();
            String setpointMode_change = TrailData.getStatus().setpointMode_change();
            String beforeTrailStart = TrailData.getStatus().beforeTrailStart();
            String changeToValue = TrailData.getStatus().changeToValue();
            String trafficStartTime = getDateString(TrailData.getStatus().trafficStartTime());
            String trailStartTime = getDateString(TrailData.getStatus().trailStartTime());
            String trailEndTime = getDateString(TrailData.getStatus().trailEndTime());
            String changeTime = getDateString(TrailData.getStatus().changeTime());
            String verifyTime = getDateString(TrailData.getStatus().verifyTime());
            String afterTrailWaitTime = TrailData.getStatus().AfterTrailWaitTime();
            String trailSuccess = String.valueOf(TrailData.getStatus().isTrailSuccess());
            String totalTimeTaken = getTotalTimeTakenforChanges();

            String[] record = {trailNo, executeOnTraffic_nonTraffic, changesApp_stat, setpointMode_change,
                    beforeTrailStart, changeToValue, trafficStartTime, trailStartTime, trailEndTime, changeTime,
                    verifyTime, totalTimeTaken, afterTrailWaitTime, trailSuccess, result};

            writer.writeNext(record);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDateString(String timeInMilliseconds) {
        long timeinMillisecond = Long.valueOf(timeInMilliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        return formatter.format(timeinMillisecond);
    }

    public static String getTotalTimeTakenforChanges() {
        long changeTime = Long.valueOf(TrailData.getStatus().changeTime());
        long verifyTime = Long.valueOf(TrailData.getStatus().verifyTime());
        long totalTime = verifyTime - changeTime;
        if (totalTime < 0) {
            return String.valueOf(1000 + Math.abs(totalTime));
        } else {
            return String.valueOf(totalTime);
        }

    }

    public static Duration getDuration(String durationType, int duration) {

        if (durationType.contains("SECONDS")) {
            return Duration.ofSeconds(duration);

        } else if (durationType.contains("MINUTES")) {
            return Duration.ofMinutes(duration);
        } else {
            return Duration.ofSeconds(duration);
        }
    }

    public static boolean trailWaitForNextInteration(TestCases testCase) {
        long currentMilli = System.currentTimeMillis();
        int nextTrailStartingTime = CommonState.getStatus().nextTrailStartingTime();
        TrailData.getStatus().AfterTrailWaitTime(String.valueOf(nextTrailStartingTime));
        long totalTime = (long) nextTrailStartingTime * 1000;

        while (!(System.currentTimeMillis() > (currentMilli + totalTime))) {
            /*
             * Need to Implement for Que
             *
             */
        }
        return true;

    }

    public static void exitTestCaseParam() {
        try {
//			String deviceNeedToInstall = SuiteConstants
//					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
//			if (deviceNeedToInstall.contains("CASPIAN")) {

            if (RelayConfiguration.getSerialPort() != null) {
                RelayConfiguration.getSerialPort().closePort();
                System.out.println("Serial communication closed");
            }
//			} else {
//				StatCommands.getInstance().cattCommandsStub
//						.disconnectStat(String_Msg.newBuilder().setStrVal("").build());
//				System.out.println(deviceNeedToInstall+" deivce AAT Layer closed");
//			}

        } catch (Exception e) {
            System.exit(1);
            System.out.println("Exception occured due to Device under test");
        }
    }

    public static void exitTestCaseParam_Keyword() {
        try {
            RelayConfiguration.getSerialPort().closePort();
            System.out.println("Caspian Serial communication closed");

        } catch (Exception e) {
            System.exit(1);
            System.out.println("Exception occured due to Device under test");
        }
    }

    public static float compareVersions(String version1, String version2) {
        float comparisonResult = 0;

        String[] version1Splits = version1.split("\\.");
        String[] version2Splits = version2.split("\\.");
        int maxLengthOfVersionSplits = Math.max(version1Splits.length, version2Splits.length);

        for (int i = 0; i < maxLengthOfVersionSplits; i++) {
            Integer v1 = i < version1Splits.length ? Integer.parseInt(version1Splits[i]) : 0;
            Integer v2 = i < version2Splits.length ? Integer.parseInt(version2Splits[i]) : 0;
            float compare = v1.compareTo(v2);
            if (compare != 0) {
                comparisonResult = compare;
                break;
            }
        }
        return comparisonResult;
    }

    public void setThreadClass(TestCases testcase) {
        this.threadInitial = new com.resideo.utils.web.KeepAppActive(testcase);
    }

    public com.resideo.utils.web.KeepAppActive getThreadClass(TestCases testcase) {
        return threadInitial;
    }

    public void setIsMobileThread(boolean ismobilethread) {
        this.isMobileThread = ismobilethread;
    }

    public boolean isMobileThread() {
        return isMobileThread;
    }

    public void setIsWebThread(boolean isWebethread) {
        this.isMobileThread = isWebethread;
    }

    public boolean isWebThread() {
        return isWebThread;
    }

    public void isSetpointThread(boolean isWebethread) {
        this.isSetpointThread = isWebethread;
    }

    public boolean isSetpointThread() {
        return isSetpointThread;
    }

}
