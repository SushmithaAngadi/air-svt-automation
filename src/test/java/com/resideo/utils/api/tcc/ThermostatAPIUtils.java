package com.resideo.utils.api.tcc;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;

public class ThermostatAPIUtils {

	public static boolean change_VerifyTheSetPointfromThermostat(TestCases testCase, TestCaseInputs input, String macID,
			boolean isSyncCanApply) {
		boolean flag = false;
		float heatSetpoint = 0;
		float coolSetpoint = 0;
		float min_HeatSetpoint = 0;
		float max_HeatSetpoint = 0;
		float min_CoolSetpoint = 0;
		float max_CoolSetpoint = 0;
		float changed_HeatSetpoint = 0;
		float changed_CoolSetpoint = 0;
		try {
			DeviceInformation deviceInfo = new DeviceInformation(testCase, input, macID);
			List<String> allowedModes = deviceInfo.getAllowedModes_upperCase();
			try {
				if (allowedModes.contains("HEAT")) {
					heatSetpoint = Float.parseFloat(deviceInfo.getHeatSetpoint());
					min_HeatSetpoint = Float.parseFloat(deviceInfo.getMin_HeatSetpoint());
					max_HeatSetpoint = Float.parseFloat(deviceInfo.getMax_HeatSetpoint());
					Keyword.ReportStep_Pass(testCase, "Current heat setpoint is " + heatSetpoint);
				}
				if (allowedModes.contains("COOL")) {
					coolSetpoint = Float.parseFloat(deviceInfo.getCoolSetpoint());
					min_CoolSetpoint = Float.parseFloat(deviceInfo.getMin_CoolSetpoint());
					max_CoolSetpoint = Float.parseFloat(deviceInfo.getMax_CoolSetpoint());
					Keyword.ReportStep_Pass(testCase, "Current Cool setpoint is " + coolSetpoint);
				}
				if (allowedModes.contains("HEAT")) {
					changed_HeatSetpoint = getRandomTemperaturewithinRange(min_HeatSetpoint, coolSetpoint,
							heatSetpoint);
				} else {

					changed_HeatSetpoint = getRandomTemperaturewithinRange(min_HeatSetpoint, max_HeatSetpoint,
							heatSetpoint);
				}
				if (allowedModes.contains("COOL")) {
					changed_CoolSetpoint = getRandomTemperaturewithinRange(changed_HeatSetpoint, max_CoolSetpoint,
							coolSetpoint);
				} else {
					changed_CoolSetpoint = getRandomTemperaturewithinRange(min_CoolSetpoint, max_CoolSetpoint,
							coolSetpoint);
				}
				try (TCCUtils chil = new TCCUtils(input)) {
					if (chil.getConnection()) {
						for (int i = 0; i < 3; i++) {
							if (allowedModes.contains("HEAT")) {
								int responseCode = chil.setHeatSetPoint(changed_HeatSetpoint);
								if (responseCode == 200 || responseCode == 201) {
									Thread.sleep(60000);
									if (checkSetpointFromTcc(testCase, input, "HEAT", changed_HeatSetpoint)) {
										flag = true;
									} else {
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Response code " + responseCode
													+ " failed to change the heat setpoint from " + heatSetpoint
													+ " , to " + changed_HeatSetpoint);
									flag = false;
								}
								if (allowedModes.contains("COOL")) {
									int setHeatSetPoint = chil.setCoolSetPoint(changed_CoolSetpoint);
									if (setHeatSetPoint == 200 || setHeatSetPoint == 201) {
										Thread.sleep(60000);
										if (checkSetpointFromTcc(testCase, input, "COOL", changed_CoolSetpoint)) {
											flag = true;
										} else {
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE, "failed to change the Cool setpoint from "
														+ heatSetpoint + " , to " + changed_HeatSetpoint);
										flag = false;
									}
								}
							} else if (allowedModes.contains("COOL")) {
								int setHeatSetPoint = chil.setCoolSetPoint(changed_CoolSetpoint);
								if (setHeatSetPoint == 200 || setHeatSetPoint == 201) {
									Thread.sleep(60000);
									if (checkSetpointFromTcc(testCase, input, "COOL", changed_CoolSetpoint)) {
										flag = true;
									} else {
										flag = false;
									}
									flag = true;
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"failed to change the Cool setpoint from " + heatSetpoint + " , to "
													+ changed_HeatSetpoint);
									flag = false;
								}
								if (allowedModes.contains("HEAT")) {
									int responseCode = chil.setHeatSetPoint(changed_HeatSetpoint);
									if (responseCode == 200 || responseCode == 201) {
										Thread.sleep(60000);
										if (checkSetpointFromTcc(testCase, input, "HEAT", changed_CoolSetpoint)) {
											flag = true;
										} else {
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Response code " + responseCode
														+ " failed to change the heat setpoint from " + heatSetpoint
														+ " , to " + changed_HeatSetpoint);
										flag = false;
									}
								}
							}
							if (isSyncCanApply) {
								if (flag) {
									break;
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
											"Failed to sync, retry " + (i + 1) + " out of 3");
									flag = false;
								}
							} else {
								if (!flag) {
									flag = true;
									Keyword.ReportStep_Pass(testCase, "Thermostat not able to sync with cloud");
									break;
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
											"Syste should sycn due to wifi settings " + (i + 1) + " out of 3");
									flag = false;
								}
							}

						}
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
							"Exception occured due to " + e.getMessage());
					flag = false;
				}
			} catch (Exception e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Exception occured due to " + e.getMessage());
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;

		}
		return flag;
	}

	public static boolean checkComTaskStatus(TestCases testCase, TestCaseInputs inputs, String heat_cool,
			float setpoint) {
		try {
			boolean eventRec = false;
			FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
			fwait1.pollingEvery(Duration.ofSeconds(10));
			fwait1.withTimeout(Duration.ofSeconds(120));
			boolean isEventReceived = fwait1.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {
						DeviceInformation deviceInfo = new DeviceInformation(testCase, inputs, TCC_CommonUtils.deviceID);
						float currentsetPoint = 0;
						if (heat_cool.contains("HEAT")) {
							currentsetPoint = Float.parseFloat(deviceInfo.getHeatSetpoint());
						} else {
							currentsetPoint = Float.parseFloat(deviceInfo.getCoolSetpoint());
						}
						if (currentsetPoint == setpoint) {
							Keyword.ReportStep_Pass(testCase,
									"Passed ::current mode is " + heat_cool + " current setpoint is " + currentsetPoint
											+ " match with expeted setpoint " + setpoint);
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase, "current mode is " + heat_cool + " current setpoint is "
									+ currentsetPoint + "Waitting to sync with cloud...");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase, "Failed to sync...");
						return false;
					}
				}
			});
			if (isEventReceived) {
				return true;
			} else {
				return false;
			}
		} catch (TimeoutException e) {
			return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean checkSetpointFromTcc(TestCases testCase, TestCaseInputs inputs, String heat_cool,
			float setpoint) {
		try {
			boolean eventRec = false;
			FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
			fwait1.pollingEvery(Duration.ofSeconds(10));
			fwait1.withTimeout(Duration.ofSeconds(60));
			boolean isEventReceived = fwait1.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {
						DeviceInformation deviceInfo = new DeviceInformation(testCase, inputs, TCC_CommonUtils.deviceID);
						float currentsetPoint = 0;
						if (heat_cool.contains("HEAT")) {
							currentsetPoint = Float.parseFloat(deviceInfo.getHeatSetpoint());
						} else {
							currentsetPoint = Float.parseFloat(deviceInfo.getCoolSetpoint());
						}
						if (currentsetPoint == setpoint) {
							Keyword.ReportStep_Pass(testCase,
									"Passed ::current mode is " + heat_cool + " current setpoint is " + currentsetPoint
											+ " match with expeted setpoint " + setpoint);
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase, "current mode is " + heat_cool + " current setpoint is "
									+ currentsetPoint + "Waitting to sync with cloud...");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase, "Failed to sync...");
						return false;
					}
				}
			});
			if (isEventReceived) {
				return true;
			} else {
				return false;
			}
		} catch (TimeoutException e) {
			return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean checkSetpointFromTcc(TestCases testCase, TestCaseInputs inputs, long comtaskID) {
		try (TCCUtils tcc = new TCCUtils(inputs)) {
			boolean eventRec = false;
			FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
			fwait1.pollingEvery(Duration.ofSeconds(10));
			fwait1.withTimeout(Duration.ofSeconds(120));
			boolean isEventReceived = fwait1.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {
						if (tcc.getComTaskStatus(comtaskID)) {
							Keyword.ReportStep_Pass(testCase, "Com task is completed and success");
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase, "Waitting to sync with cloud and comtask is pending...");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase, "Failed to sync...");
						return false;
					}
				}
			});
			if (isEventReceived) {
				return true;
			} else {
				return false;
			}
		} catch (TimeoutException e) {
			return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static float getRandomTemperaturewithinRange(float min, float max, float currentSetpoint) {
		float setpoint = 0;
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			// For Celsius, we choose from 10.00, 10.25, 10.50, ... , 30.50
			float minCelsius = min;
			float maxCelsius = max;
			float stepCelsius = 0.50f;
			// For Fahrenheit, we choose from 50.0, 50.0, 50.0, ... , 90.0
			float minFahrenheit = min;
			float maxFahrenheit = max;
			float stepFahrenheit = 1.0f;
			if (max < 45) {
				// Generate a random Celsius temperature
				float randomCelsius = minCelsius
						+ stepCelsius * random.nextInt((int) ((maxCelsius - minCelsius) / stepCelsius) + 1);
				System.out.println("Random Celsius Temperature: " + randomCelsius);
				if (currentSetpoint != randomCelsius) {
					setpoint = randomCelsius;
					break;
				}
			} else {
				// Generate a random Fahrenheit temperature
				float randomFahrenheit = minFahrenheit
						+ stepFahrenheit * random.nextInt((int) ((maxFahrenheit - minFahrenheit) / stepFahrenheit) + 1);
				System.out.println("Random Fahrenheit Temperature: " + randomFahrenheit);
				if (currentSetpoint != randomFahrenheit) {
					setpoint = randomFahrenheit;
					break;
				}
			}
		}
		return setpoint;
	}

}
