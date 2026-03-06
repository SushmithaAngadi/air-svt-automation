package com.resideo.utils.api.command_control;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.ResilientSleep;
import com.resideo.utils.api.device_Information.DeviceInformation;
import com.resideo.utils.api.dfc.CHILUtil;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.ScaleChangeStatus;
import com.resideo.utils.stat.cattgrpccommands.ScaleChangeStatus.ScaleType;

public class ChilAPI_Command_Control {

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
			String deviceName = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").toUpperCase().trim();
			DeviceInformation deviceInfo = new DeviceInformation(testCase, input, macID);
			List<String> allowedModes = deviceInfo.getAllowedModes_upperCase();
			try {
				if (deviceName.contains("JASPER_SENIOR_EMEA")) {
					if (allowedModes.contains("HEAT")) {

						heatSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getHeatSetpoint()));
						min_HeatSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getMin_HeatSetpoint()));
						max_HeatSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getMax_HeatSetpoint()));
						Keyword.ReportStep_Pass(testCase, "Current heat setpoint is " + heatSetpoint);
					}
					if (allowedModes.contains("COOL")) {
						coolSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getCoolSetpoint()));
						min_CoolSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getMin_CoolSetpoint()));
						max_CoolSetpoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getMax_CoolSetpoint()));
						Keyword.ReportStep_Pass(testCase, "Current Cool setpoint is " + coolSetpoint);
					}
				} else {
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
				}
				if (deviceName.contains("JASPER_SENIOR_EMEA")) {
					if (allowedModes.contains("HEAT")) {
						changed_HeatSetpoint = tempScale_To_Fahrenheit(
								getRandomTemperatureWithinRange(min_HeatSetpoint, max_HeatSetpoint, heatSetpoint));
					}

				} else {
					if (allowedModes.contains("HEAT")) {

						changed_HeatSetpoint = getRandomTemperatureWithinRange(min_HeatSetpoint, coolSetpoint,
								heatSetpoint);
					} else {

						changed_HeatSetpoint = getRandomTemperatureWithinRange(min_HeatSetpoint, max_HeatSetpoint,
								heatSetpoint);
					}
					if (allowedModes.contains("COOL")) {
						changed_CoolSetpoint = getRandomTemperatureWithinRange(changed_HeatSetpoint, max_CoolSetpoint,
								coolSetpoint);
					} else {
						changed_CoolSetpoint = getRandomTemperatureWithinRange(min_CoolSetpoint, max_CoolSetpoint,
								coolSetpoint);
					}
					changed_HeatSetpoint = Math.round(changed_HeatSetpoint);
					changed_CoolSetpoint = Math.round(changed_CoolSetpoint);
				}
				System.out.println("Randomly generated Heat setpoint :" + changed_HeatSetpoint);
				System.out.println("Randomly generated Cool setpoint :" + changed_CoolSetpoint);

				try (CHILUtil chil = new CHILUtil(input)) {
					if (chil.getConnection()) {
						for (int i = 0; i < 3; i++) {
							try {
								if (allowedModes.contains("HEAT")) {
									int responseCode = chil.setHeatSetPoint(LyricUtils.locationID, LyricUtils.deviceID,
											changed_HeatSetpoint);
									if (responseCode == 200 || responseCode == 201) {
										Keyword.ReportStep_Pass(testCase,
												"Changed heat setpoint to " + changed_HeatSetpoint);
										ResilientSleep.silentSleep(60000);
										if (checkSetpointFromChil(testCase, input, deviceName, "HEAT",
												changed_HeatSetpoint)) {
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
									if (allowedModes.contains("COOL")) {
										int setHeatSetPoint = chil.setCoolSetPoint(LyricUtils.locationID,
												LyricUtils.deviceID, changed_CoolSetpoint);
										if (setHeatSetPoint == 200 || setHeatSetPoint == 201) {
											Keyword.ReportStep_Pass(testCase,
													"Changed cool setpoint to " + changed_CoolSetpoint);
											ResilientSleep.silentSleep(60000);
											if (checkSetpointFromChil(testCase, input, deviceName, "COOL",
													changed_CoolSetpoint)) {
												flag = true;
											} else {
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"failed to change the Cool setpoint from " + heatSetpoint + " , to "
															+ changed_HeatSetpoint);
											flag = false;
										}
									}
								} else if (allowedModes.contains("COOL")) {
									int setHeatSetPoint = chil.setCoolSetPoint(LyricUtils.locationID,
											LyricUtils.deviceID, changed_CoolSetpoint);
									if (setHeatSetPoint == 200 || setHeatSetPoint == 201) {
										Keyword.ReportStep_Pass(testCase,
												"Changed cool setpoint to " + changed_CoolSetpoint);

										ResilientSleep.silentSleep(60000);
										if (checkSetpointFromChil(testCase, input, deviceName, "COOL",
												changed_CoolSetpoint)) {
											flag = true;
										} else {
											flag = false;
										}
										flag = true;
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE, "failed to change the Cool setpoint from "
														+ heatSetpoint + " , to " + changed_HeatSetpoint);
										flag = false;
									}
									if (allowedModes.contains("HEAT")) {
										int responseCode = chil.setHeatSetPoint(LyricUtils.locationID,
												LyricUtils.deviceID, changed_HeatSetpoint);
										Keyword.ReportStep_Pass(testCase,
												"Changed heat setpoint to " + changed_HeatSetpoint);

										if (responseCode == 200 || responseCode == 201) {
											ResilientSleep.silentSleep(60000);
											if (checkSetpointFromChil(testCase, input, deviceName, "HEAT",
													changed_CoolSetpoint)) {
												flag = true;
											} else {
												flag = false;
											}
											flag = true;
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
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.NO_FAILURE,
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
							} catch (Exception e) {
								Keyword.ReportStep_Pass(testCase, "Message occured due to " + e.getMessage());
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

	public static boolean checkSetpointFromChil(TestCases testCase, TestCaseInputs inputs, String deviceName,
			String heat_cool, float setpoint) {
		try {
			boolean eventRec = false;
			FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
			fwait1.pollingEvery(Duration.ofSeconds(10));
			fwait1.withTimeout(Duration.ofSeconds(120));
			boolean isEventReceived = fwait1.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {
						float setpoint_final = setpoint;
						DeviceInformation deviceInfo = new DeviceInformation(testCase, inputs, LyricUtils.locationID,
								LyricUtils.deviceID);
						float currentsetPoint = 0;
						if (deviceName.contains("JASPER_SENIOR_EMEA")) {
							setpoint_final = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getHeatSetpoint()));
							if (heat_cool.contains("HEAT")) {
								currentsetPoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getHeatSetpoint()));
							} else {
								currentsetPoint = tempScale_To_Celcius(Float.parseFloat(deviceInfo.getCoolSetpoint()));
							}
						} else {
							if (heat_cool.contains("HEAT")) {
								currentsetPoint = Float.parseFloat(deviceInfo.getHeatSetpoint());
							} else {
								currentsetPoint = Float.parseFloat(deviceInfo.getCoolSetpoint());
							}
						}

						if (currentsetPoint == setpoint_final) {
							Keyword.ReportStep_Pass(testCase,
									"Passed ::current mode is " + heat_cool + " current setpoint is " + currentsetPoint
											+ " match with expeted setpoint " + setpoint_final);
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase,
									"current mode is " + heat_cool + " current setpoint is " + currentsetPoint
											+ "And Expected Setpoint:" + setpoint_final
											+ ", Waitting to sync with cloud...");
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

	public static float getRandomTemperatureWithinRange(float min, float max, float currentSetpoint) {
		if (max <= min) {
			throw new IllegalArgumentException("Max temperature must be greater than min temperature.");
		}

		Random random = new Random();
		float setpoint = 0;

		// Choose the step size based on the range
		float step = (max - min < 45) ? 0.50f : 1.0f;

		// Determine whether to generate Celsius or Fahrenheit temperatures
		boolean isCelsius = max < 45;

		while (true) {
			float randomTemperature = min + step * random.nextInt((int) ((max - min) / step) + 1);
//			System.out
//					.println("Random " + (isCelsius ? "Celsius" : "Fahrenheit") + " Temperature: " + randomTemperature);

			// Check if the random temperature is different from the current setpoint
			if (Math.abs(randomTemperature - currentSetpoint) > 0.001) {
				setpoint = randomTemperature;
				break;
			}
		}
		return setpoint;
	}

	public static float tempScale_To_Celcius(float setpoint) {
		ScaleChangeStatus changeTemperatureScale = StatCommands.getInstance().cattCommandsStub
				.changeTemperatureScale(ScaleChangeStatus.newBuilder().setGivenTemperature(setpoint)
						.setReturnScaleType(ScaleType.CELSIUS).build());
		return changeTemperatureScale.getTemperatureChange();
	}

	public static float tempScale_To_Fahrenheit(float setpoint) {
		ScaleChangeStatus changeTemperatureScale = StatCommands.getInstance().cattCommandsStub
				.changeTemperatureScale(ScaleChangeStatus.newBuilder().setGivenTemperature(setpoint)
						.setReturnScaleType(ScaleType.FAHRENHEIT).build());
		return changeTemperatureScale.getTemperatureChange();
	}
}
