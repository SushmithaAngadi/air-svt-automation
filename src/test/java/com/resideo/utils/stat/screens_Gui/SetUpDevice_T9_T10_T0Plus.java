package com.resideo.utils.stat.screens_Gui;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.T9_T10_T10Plus_KeyboardUtils;
import com.resideo.utils.stat.UI_Stat_Data;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.dataParam;
import com.resideo.utils.stat.cattgrpccommands.dataParam.actionType;
import com.resideo.utils.stat.cattgrpccommands.dataParam.methodType;
import com.resideo.utils.stat.cattgrpccommands.screenshotData;
import com.resideo.utils.stat.cattgrpccommands.scroll;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;
import com.resideo.utils.stat.cattgrpccommands.scroll.ScrollScreen;
//import com.resideo.robotic_arm.imageProcessUtils.Stat_ImageProcessngUtils;
//import com.resideo.robotic_arm.supportConstant.ArmConstants;

public class SetUpDevice_T9_T10_T0Plus {

//	static boolean isOASPaired = false;
//	static boolean isIASPaired = false;
//	static boolean isEIMPaired = false;

	public boolean OAS_SensorAddedScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend) {
		try {
			SystemState.getStatus().isSensorAddedSuccessfully(false);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						if (stat_text == null) {
							return false;
						} else if (stat_text.contains("Outdoor Air Sensor") && stat_text.contains("Added")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Error Adding Device")) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Error Adding OAS Sensor");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else {
							System.out
									.println("retrying to get text, Captured text is  " + stat_text.replace("\n", " "));
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isSensorAddedSuccessfully()) {
				return true;
			} else {
				return false;
			}

		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}

	}

	public boolean IAS_SensorAddedScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend) {
		try {
			SystemState.getStatus().isSensorAddedSuccessfully(false);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						if (stat_text == null) {
							return false;
						} else if (stat_text.contains("Pick Up Sensor")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Error Adding Device")) {
//						Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Error Adding OAS Sensor");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isSensorAddedSuccessfully()) {
				return true;
			} else {
				return false;
			}

		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean EIM_IAS_OAS_SensorAddedScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend) {
		try {
			SystemState.getStatus().isSensorAddedSuccessfully(false);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						if (stat_text == null) {
							return false;
						} else if (stat_text.contains("Outdoor Air Sensor") && stat_text.contains("Added")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Setup Complete")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Equipment Interface") && stat_text.contains("Module Added")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Error Adding Device")) {
//						Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Error Adding OAS Sensor");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else {
							System.out
									.println("retrying to get text, Captured text is  " + stat_text.replace("\n", " "));
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isSensorAddedSuccessfully()) {
				return true;
			} else {
				return false;
			}

		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean getScreen(TestCases testCase, String expectText, Duration timeOut, int xstart, int ystart, int xend,
			int yend) {
		try {
			SystemState.getStatus().isSensorAddedSuccessfully(false);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						if (stat_text == null) {
							return false;
						} else if (stat_text.contains(expectText)) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + expectText);
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Equipment Interface") && stat_text.contains("Module Added")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Error Adding")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to add sensor, Thermostat shows Error Adding Device, please check logs for more details");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else if (stat_text.contains("Unable to Connect")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Thermostat shows Unable to connect to equipment interface module, please check logs for more details");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else {
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isSensorAddedSuccessfully()) {
				return true;
			} else {
				return false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}

	}

	public boolean EIM_Completed(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend, int yend) {
		try {
			SystemState.getStatus().isSensorAddedSuccessfully(false);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						if (stat_text == null) {
							return false;
						} else if (stat_text.contains("Equipment Interface") && stat_text.contains("Module Added")) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text.replace("\n", " "));
							SystemState.getStatus().isSensorAddedSuccessfully(true);
							return true;
						} else if (stat_text.contains("Error Adding Device")) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Error Adding OAS Sensor");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else if (stat_text.contains("Unable to Connect")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Thermostat shows Unable to connect to equipment interface module, please check logs for more details");
							SystemState.getStatus().isSensorAddedSuccessfully(false);
							return true;
						} else {
//						System.out.println("retrying to get text, Captured text is  " + stat_text.replace("\n", " "));
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isSensorAddedSuccessfully()) {
				return true;
			} else {
				return false;
			}

		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean getScreen(TestCases testCase, String[] expectText, Duration timeOut, int xstart, int ystart,
			int xend, int yend) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();

						if (stat_text.contains(expectText[0])) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + expectText);
							return true;
						} else if (stat_text.contains(expectText[1])) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + expectText);
							return false;
						} else {
//						System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to add sensor , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean getScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend, int yend,
			String... expectText) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();

						if (stat_text.contains(expectText[0])) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + expectText);
							return true;
						} else if (stat_text.contains(expectText[1])) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + expectText);
							return false;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get screen failed due to screen not present at the moment , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean getScreenwithValidation(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend, int counterTarget, String... expectText) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						boolean status = false;
						String currentText = null;
						for (int i = 0; i < expectText.length; i++) {
							String text = expectText[i];
							if (stat_text.contains(text) && counterTarget == (i + 1)) {
								Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
								status = true;
								currentText = stat_text;
								break;
							}
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend,int counterTarget,String... expectText) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend,int counterTarget,String... expectText) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend,int counterTarget,String... expectText) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Screen validation failed due to time out , please check the logs, Timeout to add");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
							+ e.getMessage());
			return false;
		}
	}

	public boolean isWelcomeScreen() {
		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
						.setXEndCordinate(coordinates[2]).setYEndCoordinate(100).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().equals("Welcome!")) {
			return true;
		} else {
			return false;
		}
	}

	public String getScreenName() {
		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
						.setXEndCordinate(coordinates[2]).setYEndCoordinate(100).build())
				.getStrVal();

		return txt;
	}

	public boolean isRegistrationSucess() {
		String txt = StatCommands.getInstance().cattCommandsStub
				.getTextsFromScreenParticualrArea(
						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(0)
								.setYStartCoordinate(200).setXEndCordinate(319).setYEndCoordinate(300).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().equals("Welcome!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean screenfind() {
//		System.out.println();
		String txt = StatCommands.getInstance().cattCommandsStub
				.getTextsFromScreenParticualrArea(
						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(0)
								.setYStartCoordinate(0).setXEndCordinate(319).setYEndCoordinate(479).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().equals("Welcome!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExpectedScreen(String expectText) {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(100).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().equals(expectText)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUnits_Screen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().contains("Units")) {
			return true;
		} else {
			return false;
		}
	}

//	public boolean isEIMScreen() {
////		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
//						.setYStartCoordinate(150).setXEndCordinate(290).setYEndCoordinate(276).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (txt.trim().contains("Equipment Interface")) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public boolean isEimScreenVisible(TestCases testCase) {
		return getScreenwithValidation(testCase, Duration.ofSeconds(15), 30, 150, 290, 276, 1, "Equipment Interface");
	}

	public boolean isRedlinkIASScreenVisible(TestCases testCase) {
		return getScreenwithValidation(testCase, Duration.ofSeconds(15), 30, 150, 290, 276, 1, "RedLINK Devices");
	}

	public boolean isExitInstallerScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
						.setYStartCoordinate(25).setXEndCordinate(300).setYEndCoordinate(80).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().contains("Exit Installer Setup")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isConnectAppScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt1 = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
						.setYStartCoordinate(25).setXEndCordinate(300).setYEndCoordinate(80).build())
				.getStrVal();
		System.out.println(txt1);
		String txt2 = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(15)
						.setYStartCoordinate(200).setXEndCordinate(300).setYEndCoordinate(270).build())
				.getStrVal();

		System.out.println(txt2);
		if (txt1.trim().contains("Connect App") && txt2.trim().contains("Would you like to connect with")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isConnectApp_AppAvailablityScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt1 = StatCommands.getInstance().cattCommandsStub
				.getTextsFromScreenParticualrArea(
						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(0)
								.setYStartCoordinate(0).setXEndCordinate(300).setYEndCoordinate(50).build())
				.getStrVal();
		System.out.println(txt1);
		String txt2 = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(17)
						.setYStartCoordinate(170).setXEndCordinate(300).setYEndCoordinate(270).build())
				.getStrVal();

		System.out.println(txt2);
		if (txt1.trim().contains("Connect App") && txt2.trim().contains("Have you downloaded the")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isWirelessSetup_EIM_Screen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();

		System.out.println(txt);
		if (txt.trim().contains("Wireless Setup")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnGetStartedButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(250).build())
				.getBoolVal();
	}

	public boolean isLanguageScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(90).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Language")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTypeOfRoom_Screen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(90).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Room")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnNextButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(445).build())
				.getBoolVal();
	}

	public boolean clickOnRedlinkSetUpLaterButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(425).build())
				.getBoolVal();
	}

	public boolean clickOnRetailSensorSetUpLaterButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(245).build())
				.getBoolVal();
	}

	public boolean clickOnRetailSensorAddDeviceButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(180).build())
				.getBoolVal();
	}

	public boolean clickOnRedlinkAddDeviceButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(355).build())
				.getBoolVal();
	}

	public boolean clickOnCreateScheduleButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(355).build())
				.getBoolVal();
	}

	public boolean clickOnWIFISetUpLaterButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(345).build())
				.getBoolVal();
	}

	public boolean clickOnGetConnectedWifiButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(155).setYEndCoordinate(275).build())
				.getBoolVal();
	}

	public boolean clickOn() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(445).build())
				.getBoolVal();
	}

	public boolean clickOnOKButton_wifiSucessScreen() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(435).build())
				.getBoolVal();
	}

	public boolean isEasySetupInstructionScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.trim().equals("Welcome")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isApplicationScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.trim().contains("Application")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isWifiScreen() {
//		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		String txt = StatCommands.getInstance().cattCommandsStub
				.getTextsFromScreenParticualrArea(
						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
								.setYStartCoordinate(0).setXEndCordinate(319).setYEndCoordinate(150).build())
				.getStrVal();
		System.out.println(txt);

		if (txt.contains("Wi-Fi")) {
			System.out.println("Exact Screen find");
			return true;
		} else if (txt.contains("internet") || txt.contains("get") || txt.contains("connected")
				|| txt.contains("to the") || txt.contains("lets get")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnWifiSelection(String wifiConfig) {
		if (wifiConfig.toUpperCase().equals("CONNECT")) {
			return StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(275).build())
					.getBoolVal();
		} else {
			return StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(345).build())
					.getBoolVal();
		}
	}

	public boolean isFloorSensorScreen() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(90).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Floor Sensor")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBackupHeatScreen() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(90).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Backup Heat")) {
			return true;
		} else {
			return false;
		}
	}

//	public boolean isChooseWifiNetworkScreen() {
//		boolean flag = false;
//		try {
////			double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
//			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
//							.setYEndCoordinate(65).build())
//					.getStrVal();
//			System.out.println(txt);
//			if (txt.contains("Choose Network")) {
//				for (int i = 0; i < 30; i++) {
//
//					txt = StatCommands.getInstance().cattCommandsStub
//							.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
//									.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(8)
//									.setYStartCoordinate(64).setXEndCordinate(240).setYEndCoordinate(115).build())
//							.getStrVal();
//					System.out.println(txt);
//					if (!txt.isEmpty() && txt != null) {
//						flag = true;
//						break;
//					} else {
//						System.out.println("retry....");
//						Thread.sleep(1000);
//						flag = false;
//					}
//				}
//
//			} else {
//				flag = false;
//			}
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}

	public boolean isWifi_ScanList_Available(TestCases testCase) {
		boolean flag = false;
		if (getScreen(testCase, "Choose Network", Duration.ofSeconds(60), 0, 0, 319, 65)) {

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String txt = StatCommands.getInstance().cattCommandsStub
								.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
										.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(8)
										.setYStartCoordinate(64).setXEndCordinate(240).setYEndCoordinate(115).build())
								.getStrVal();
						System.out.println(txt);
						if (!txt.isEmpty() && txt != null) {
							Keyword.ReportStep_Pass(testCase, "Wifi Screen loaded with Wifi SSID");
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, );
							return true;
						} else {
							System.out.println("retry....");
//						Thread.sleep(1000);
							return false;
						}

					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to get Wifi list name from gateway");
			flag = false;
		}
		return flag;
	}
	
	public boolean isWifi_ScanList_Available(TestCases testCase,Duration timeout) {
		boolean flag = false;
		if (getScreen(testCase, "Choose Network", Duration.ofSeconds(60), 0, 0, 319, 65)) {

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(timeout);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String txt = StatCommands.getInstance().cattCommandsStub
								.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
										.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(8)
										.setYStartCoordinate(64).setXEndCordinate(240).setYEndCoordinate(115).build())
								.getStrVal();
						System.out.println(txt);
						if (!txt.isEmpty() && txt != null) {
							Keyword.ReportStep_Pass(testCase, "Wifi Screen loaded with Wifi SSID");
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, );
							return true;
						} else {
							System.out.println("retry....");
//						Thread.sleep(1000);
							return false;
						}

					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to get Wifi list name from gateway");
			flag = false;
		}
		return flag;
	}

	public boolean IsWifi_Success(TestCases testCase) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
		fWait.pollingEvery(Duration.ofSeconds(10));
		fWait.withTimeout(Duration.ofMinutes(2));
		boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean flag1) {
				try {
					String txt = StatCommands.getInstance().cattCommandsStub
							.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
									.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(43)
									.setYStartCoordinate(130).setXEndCordinate(270).setYEndCoordinate(200).build())
							.getStrVal();
					System.out.println(txt);
//					String[] splits =	txt.split("\r\n");
//					System.out.println(splits[0]);

					if (txt == null || txt.isEmpty()) {
						return false;
					} else if (txt.contains("Could Not Connect")) {
						SystemState.getStatus().WifiConnectionStatus("Could Not Connect");
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to connect with Wifi");
						return true;
					} else if (txt.contains("Success")) {
						Keyword.ReportStep_Pass(testCase, "Success");
						SystemState.getStatus().WifiConnectionStatus("Success");
//							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, );
						return true;
					} else if (txt.contains("Error")) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Error occured");
						SystemState.getStatus().WifiConnectionStatus("Error");
//							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, );
						return true;
					} else {
						System.out.println("retry....");
						SystemState.getStatus().WifiConnectionStatus(txt);
						return false;
					}

				} catch (TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				} catch (StaleElementReferenceException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived && SystemState.getStatus().WifiConnectionStatus().contains("Could Not Connect")) {
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().WifiConnectionStatus().contains("Success")) {
			flag = true;
		} else if (isEventReceived && SystemState.getStatus().WifiConnectionStatus().contains("Error")) {
			flag = false;
		} else if (isEventReceived && !SystemState.getStatus().WifiConnectionStatus().isEmpty()) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect with Wifi, Error is " + SystemState.getStatus().WifiConnectionStatus());
		}
		return flag;
	}

	public boolean IsRegistration_Success(TestCases testCase) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
		fWait.pollingEvery(Duration.ofSeconds(10));
		fWait.withTimeout(Duration.ofMinutes(2));
		boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean flag1) {
				try {
					String txt = StatCommands.getInstance().cattCommandsStub
							.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
									.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
									.setYStartCoordinate(170).setXEndCordinate(300).setYEndCoordinate(230).build())
							.getStrVal().trim();
					System.out.println(txt);
					if (txt == null || txt.isEmpty()) {
						return false;
					} else if (txt.contains("Registration Failed") || txt.contains("Failed")) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Registration failed, Text On Stat UI " + txt);
						SystemState.getStatus().isStatRegistrationStatus(false);
						return true;
					} else if (txt.contains("Success")) {
						Keyword.ReportStep_Pass(testCase, "Registration Status is Success!");
						SystemState.getStatus().isStatRegistrationStatus(true);
						return true;
					} else {
						System.out.println("retry....");
						return false;
					}

				} catch (TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in IsRegistration_Success(TestCases testCase) due to " + e.getMessage());
					return false;
				} catch (StaleElementReferenceException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in IsRegistration_Success(TestCases testCase) due to " + e.getMessage());
					return false;
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in IsRegistration_Success(TestCases testCase) due to " + e.getMessage());
					return false;
				}
			}
		});
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
						.setYStartCoordinate(170).setXEndCordinate(300).setYEndCoordinate(225).build())
				.getStrVal().trim();
		if (isEventReceived && !SystemState.getStatus().isStatRegistrationStatus()) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Registration failed, Text On Stat UI " + txt);
		} else if (isEventReceived && SystemState.getStatus().isStatRegistrationStatus()) {
			flag = true;
		}
		return flag;
	}

	public boolean isRedlink_Broadcasted(TestCases testCase) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(2));
		boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean flag1) {
				try {
					String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
							screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
									.setXEndCordinate(319).setYEndCoordinate(75).build())
							.getStrVal();
					System.out.println(txt);
					if (txt == null || txt.isEmpty()) {
						return false;
					} else if (txt.contains("Preparing")) {
						SystemState.getStatus().RedlinkConnectionStatus("Preparing");
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to connect with Wifi");
						return false;
					} else if (txt.contains("Connect Sensor")) {
						Keyword.ReportStep_Pass(testCase, "Success");
						SystemState.getStatus().RedlinkConnectionStatus("Connect Sensor");
//							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, );
						return true;
					} else {
						System.out.println("retry....");
						SystemState.getStatus().RedlinkConnectionStatus(txt);
						return false;
					}

				} catch (TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				} catch (StaleElementReferenceException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised in public boolean getScreen(TestCases testCase, String expectText, int xstart, int ystart, int xend, int yend) due to "
									+ e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived && SystemState.getStatus().RedlinkConnectionStatus().contains("Preparing")) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Thermostat still showing Preparing");
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().RedlinkConnectionStatus().contains("Connect Sensor")) {
			flag = true;
		} else if (isEventReceived && !SystemState.getStatus().RedlinkConnectionStatus().isEmpty()) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect with Wifi, Error is " + SystemState.getStatus().RedlinkConnectionStatus());
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect with Wifi, Error is " + SystemState.getStatus().RedlinkConnectionStatus());
		}
		return flag;
	}

	public boolean isConnectingToEIMScreen() {
		boolean flag = false;
		try {
			System.out.println();
//			double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
							.setYEndCoordinate(90).build())
					.getStrVal();
			System.out.println(txt);
			if (txt.contains("Connecting to") && txt.contains("Equipment Interface")) {
				for (int i = 0; i < 30; i++) {

					txt = StatCommands.getInstance().cattCommandsStub
							.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
									.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(8)
									.setYStartCoordinate(64).setXEndCordinate(240).setYEndCoordinate(115).build())
							.getStrVal();
					System.out.println(txt);
					if (!txt.isEmpty() && txt != null) {
						flag = true;
						break;
					} else {
						System.out.println("retry....");
						Thread.sleep(1000);
						flag = false;
					}
				}

			} else {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean clickOnElement_byCoordinate(double x1, double y1, double x2, double y2) {
		return StatCommands.getInstance().cattCommandsStub.clickOnExactButton(screenshotData.newBuilder()
				.setXStartCordinate(x1).setYStartCoordinate(y1).setXEndCordinate(x2).setYEndCoordinate(y2).build())
				.getBoolVal();
	}

	public boolean ChooseWifiFromList(TestCases testCase, String wifi) {

		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText(wifi).build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			Keyword.ReportStep_Pass(testCase, "Expected Wifi available in List, Wifi SSID is " + wifi);
			return true;
		} else {
			return false;
		}

	}

	public boolean clickOnRoomName(String roomName) {

		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText(roomName).build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean clickOnRoomName_WithCustomName(TestCases testCase, String roomName) {
//		boolean flag = true;
//		if (roomName.toUpperCase().contains("DINING ROOM") || roomName.toUpperCase().contains("KITCHEN")
//				|| roomName.toUpperCase().contains("BASEMENT") || roomName.toUpperCase().contains("HALLWAY")) {
//			String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
//					.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText("Other").build())
//					.getStrVal();
//			System.out.println(strVal);
//			Keyword.ReportStep_Pass(testCase, "Clicked on Other option in Room.");
//			if (strVal.contains("PASSED")) {
//				flag = true;
//			} else {
//				flag = false;
//			}
//		}
//		if (flag) {
		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText(roomName).build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			return true;
		} else {
			return false;
		}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Not able to select room name as " + roomName);
//			return false;
//		}

	}

	public boolean chooseApplicationType(String applicationType) {
		if (applicationType.equals("RESIDENTIAL")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 150);
		} else if (applicationType.equals("COMMERCIAL")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 200);
		} else {
			return false;
		}
	}

	public boolean clickOnretailRoomName(TestCases testCase, String roomName) {

		if (roomName.equals("BEDROOM")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 135);
		} else if (roomName.equals("LIVING SPACE")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 200);
		} else if (roomName.equals("GUEST BEDROOM")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 85);
		} else if (roomName.equals("MASTER BEDROOM")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(150, 150);
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Room name is not available, please check the default room name in Thermostat " + roomName);
			return false;
		}

	}

	public boolean clickOnSetupLater() {
		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText("Set Up Later").build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnTemperatureScale(String scaleUnit) {
		boolean flag = false;
		if (scaleUnit.toUpperCase().contains("FAHRENHEIT")) {
			flag = UI_Stat_Data.clickOnElement_byCoordinate(150, 150);
		} else if (scaleUnit.toUpperCase().contains("CELSIUS")) {
			flag = UI_Stat_Data.clickOnElement_byCoordinate(150, 205);
		} else {
			new Throwable("invalid Scale unit");
			flag = false;
		}

		if (flag) {
			flag = clickOnNextButton();
		}
		return flag;
	}

	public boolean clickOnEIMEnroll_unEnroll(String isEnrollNeeds) {

		if (isEnrollNeeds.contains("YES, I HAVE AN EIM")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(160, 359);
		} else if (isEnrollNeeds.contains("NO")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(160, 425);
		} else {
			new Throwable("invalid EIM Selection Screen");
			return false;
		}
	}

	public boolean clickOnTypeRoom_Selection(TestCases testCase, String typeOfRoom) {

		if (typeOfRoom.toUpperCase().contains("BEDROOM")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(100, 137);
		} else if (typeOfRoom.toUpperCase().contains("LIVING SPACE")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(100, 205);
		} else if (typeOfRoom.toUpperCase().contains("OTHER")) {
			return UI_Stat_Data.clickOnElement_byCoordinate(100, 270);
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Room name is not available, please check the default room name in Thermostat " + typeOfRoom);
			return false;
		}
	}

	public boolean clickOnOtherButton_WifiScanList() {
		return UI_Stat_Data.clickOnElement_byCoordinate(80, 444);
	}

	public boolean clickOnConnectButton_WifiScanList() {
		return UI_Stat_Data.clickOnElement_byCoordinate(230, 444);
	}

	public boolean clickOnExpectedText(String text) {

		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText(text).build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean chooseSSID_securityTypeFromList(String SecurityType) {

		String strVal = StatCommands.getInstance().cattCommandsStub.clickOnElement(dataParam.newBuilder()
				.setActionstate(actionType.click).setMethodstate(methodType.textMethod).setText(SecurityType).build())
				.getStrVal();
		System.out.println(strVal);
		if (strVal.contains("PASSED")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isWifiConnectSucess() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(43)
						.setYStartCoordinate(130).setXEndCordinate(270).setYEndCoordinate(200).build())
				.getStrVal();

		if (txt.contains("Success")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isConnectingToWifi() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Connecting")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPreparing_Sensor() {
		boolean flag = false;
		for (int i = 0; i < 30; i++) {
			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
							.setYEndCoordinate(75).build())
					.getStrVal();
			System.out.println(txt);
			if (txt.contains("Preparing")) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}

		return flag;
	}

	public boolean isConnectSensor_Screen() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Connect Sensor")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAddingSensor_Screen() {
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
							.setYEndCoordinate(75).build())
					.getStrVal();
			System.out.println(txt);

			if (txt.contains("Adding Sensor")) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isSensorAdded_screen() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(43)
						.setYStartCoordinate(145).setXEndCordinate(270).setYEndCoordinate(200).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Sensor Added")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isScanCode_screen() {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains("Scan Code")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSecondaryHeader_screen(String expected) {
		String txt = StatCommands.getInstance().cattCommandsStub
				.getTextsFromScreenParticualrArea(
						screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(5)
								.setYStartCoordinate(55).setXEndCordinate(319).setYEndCoordinate(100).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains(expected)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPrimaryHeader_screen(String expected) {
		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXEndCordinate(319)
						.setYEndCoordinate(75).build())
				.getStrVal();
		System.out.println(txt);
		if (txt.contains(expected)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnRightArrow() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(275).setYEndCoordinate(444).build())
				.getBoolVal();
	}

	public boolean clickOnLeftArrow() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(45).setYEndCoordinate(444).build())
				.getBoolVal();
	}

	public boolean clickOnDoneButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(444).build())
				.getBoolVal();
	}

	public boolean clickOnDoneAddingDevicesButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(436).build())
				.getBoolVal();
	}

	public boolean selectOutdoorTemperature(String outDoorTemperatureOptions) {
		boolean flag = false;
		switch (outDoorTemperatureOptions.toUpperCase()) {
		case "NONE":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "WIRED":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "INTERNET":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(235).build())
					.getBoolVal();
			break;
		case "WIRELESS":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectOutdoorTemperature_1060(String outDoorTemperatureOptions) {
		boolean flag = false;
		switch (outDoorTemperatureOptions.toUpperCase()) {
		case "WIRELESS":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectChangeOver(String changeOverOption) {
		boolean flag = false;
		switch (changeOverOption.toUpperCase()) {
		case "MANUAL":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "AUTOMATIC":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectCWireAdapter(String cWireAdapter) {
		boolean flag = false;
		switch (cWireAdapter.toUpperCase()) {
		case "YES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(300).build())
					.getBoolVal();
			break;
		case "NO":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(375).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnNextButton();
		} else {
			return false;
		}
	}

	public boolean selectAdvanceSetup(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "BASIC OPTIONS":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "ADVANCED OPTIONS":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectWiredFloorTemperatureSensor(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "EIM S1":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(198).build())
					.getBoolVal();
			break;
		case "EIM S2":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		case "EIM S3":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(310).build())
					.getBoolVal();
			break;
		case "EIM S4":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(365).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectTypeOfHumidifier(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "STEAM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(198).build())
					.getBoolVal();
			break;
		case "BYPASS OR FAN POWERED":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectHumidifierTerminalareWired(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "EIM U1":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(198).build())
					.getBoolVal();
			break;
		case "EIM U2":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		case "EIM U3":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(310).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectDeHumidifierTerminalareWired(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "EIM U2":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		case "EIM U3":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(310).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectVentilationTerminalareWired(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "EIM U3":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectVentilationControlMethod(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "ASHRAE":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "PERCENT ON TIME":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(181).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectVentilationFanControl(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "THERMOSTAT CONTROLS FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "EQUIPMENT CONTROLS FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(181).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selecHumidifierWindowsProtection(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "OFF":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "ON":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(198).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectTypeOfDeHumidifier(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		case "LOW SPEED FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(198).build())
					.getBoolVal();
			break;
		case "HIGH SPEED FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(255).build())
					.getBoolVal();
			break;
		case "WHOLE HOUSE DEHUMIDIFIER":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(315).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectTypeOfVentilation(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "None":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "ERV HRV":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "PASSIVE (FAN ONLY)":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(230).build())
					.getBoolVal();
			break;
		case "FRESH AIR DAMPER":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(285).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectStagingControlHighHeatStage(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "NO":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "YES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectAIR(String setup) {
		boolean flag = false;
		switch (setup.toUpperCase()) {
		case "NO":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "YES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectTemperatureControl_3240(String offTime) {
		boolean flag = false;
		int offtime = Integer.parseInt(offTime);
		switch (offtime) {
		case 5:
			flag = true;
			break;
		case 4:
			flag = MinimumCompressorOFFTimeDecreaseButton();
			break;
		case 3:
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			break;
		case 2:
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			break;
		case 1:
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			break;
		case 0:
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			flag = MinimumCompressorOFFTimeDecreaseButton();
			break;
		default:
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectStagingControlHighHeatStageDifferential() {
		return clickOnRightArrow();
	}

	public boolean selectAdaptiveIntelligentRecovery(String AdaptiveIROption) {
		boolean flag = false;
		switch (AdaptiveIROption.toUpperCase()) {
		case "NO":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "YES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectTemperatureUnits(String scale) {
		boolean flag = false;
		switch (scale.toUpperCase()) {
		case "FAHRENHEIT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "CELSIUS":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnNextButton();
		} else {
			return false;
		}
	}

	public boolean selectSystemType(String systemType) {
		boolean flag = false;
		switch (systemType.toUpperCase()) {
		case "CONVENTIONAL":
		case "CONVENTIONAL FORCED AIR HEAT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "HEATPUMP":
		case "HEAT PUMP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "RADIANT HEAT":
		case "RADIANTHEAT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(235).build())
					.getBoolVal();
			break;
		case "NONE":
		case "COOL ONLY":
		case "COOLONLY":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(285).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectEquipmentType(String systemType) {
		boolean flag = false;
		switch (systemType.toUpperCase()) {
		case "STANDARD EFFICIENCY GAS FORCED AIR":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "HIGH EFFICIENCY GAS FORCED AIR":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "OIL FORCED AIR":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(235).build())
					.getBoolVal();
			break;
		case "ELECTRIC FORCED AIR":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(285).build())
					.getBoolVal();
			break;
		case "HOT WATER FAN COIL":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(345).build())
					.getBoolVal();
			break;
		case "AIR TO AIR HEAT PUMP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "GEOTHERMAL HEAT PUMP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "HOT WATER RADIANT HEAT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "HOT WATER RADIANT FLOOR HEAT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		case "STEAM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(230).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectBackUpHeatType(String systemType) {
		boolean flag = false;
		try {
			switch (systemType.toUpperCase()) {
			case "NONE":
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(125).build())
						.getBoolVal();
				break;
			case "STANDARD EFFICIENCY GAS FORCED AIR":
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(178).build())
						.getBoolVal();
				break;
			case "HIGH EFFICIENCY GAS FORCED AIR":
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(230).build())
						.getBoolVal();
				break;
			case "OIL FORCED AIR":
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(285).build())
						.getBoolVal();
				break;
			case "ELECTRIC FORCED AIR":
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(345).build())
						.getBoolVal();
				break;
			case "HOT WATER FAN COIL":

				StatCommands.getInstance().cattCommandsStub
						.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build());
				Thread.sleep(2000);
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(275).build())
						.getBoolVal();
				Thread.sleep(2000);
				break;
			case "HOT WATER RADIANT HEAT":
				StatCommands.getInstance().cattCommandsStub
						.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build());
				Thread.sleep(2000);
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(333).build())
						.getBoolVal();
				Thread.sleep(2000);
				break;
			case "OTHER":
				StatCommands.getInstance().cattCommandsStub
						.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build());
				Thread.sleep(2000);
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(385).build())
						.getBoolVal();
				Thread.sleep(2000);
				break;
			default:
				flag = false;
				break;
			}
		} catch (Exception e) {
			return false;
		}
		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectWifiSecurityType(String SecurityType) {
		boolean flag = false;
		switch (SecurityType.toUpperCase()) {
		case "NONE":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(105).build())
					.getBoolVal();
			break;
		case "WEP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(155).build())
					.getBoolVal();
			break;
		case "WPA AES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(205).build())
					.getBoolVal();
			break;
		case "WPA TKIP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(260).build())
					.getBoolVal();
			break;
		case "WPA2 AES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(318).build())
					.getBoolVal();
			break;
		case "WPA2 TKIP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(370).build())
					.getBoolVal();
			break;
		case "WPA2 MIXED":

			try {
				StatCommands.getInstance().cattCommandsStub
						.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build());
				Thread.sleep(2000);
				flag = StatCommands.getInstance().cattCommandsStub
						.clickOnExactButton(
								screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(380).build())
						.getBoolVal();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectReversingValve(String reversingValve) {
		boolean flag = false;
		switch (reversingValve.toUpperCase()) {
		case "O OB ON COOL":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(125).build())
					.getBoolVal();
			break;
		case "O OB ON HEAT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectFanControl(String controller) {
		boolean flag = false;
		switch (controller.toUpperCase()) {
		case "EQUIPMENT CONTROLS FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "THERMOSTAT CONTROLS FAN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectControlMode(String controller) {
		boolean flag = false;
		switch (controller.toUpperCase()) {
		case "AIR AND FLOOR":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "AIR ONLY":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectChangOver(String controller) {
		boolean flag = false;
		switch (controller.toUpperCase()) {
		case "MANUAL":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "AUTOMATIC":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

	public boolean selectFloorSensor(String floorSensor) {
		boolean flag = false;
		switch (floorSensor.toUpperCase()) {
		case "NO":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(120).build())
					.getBoolVal();
			break;
		case "WIRED":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}

		if (flag) {
			return clickOnRightArrow();
		} else {
			return false;
		}
	}

//	public boolean selectOutdoorTemperature(String floorSensor) {
//		boolean flag = false;
//		switch (floorSensor.toUpperCase()) {
//		case "NO":
//			flag = StatCommands.getInstance().cattCommandsStub
//					.clickOnExactButton(
//							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(120).build())
//					.getBoolVal();
//			break;
//		case "WIRED":
//			flag = StatCommands.getInstance().cattCommandsStub
//					.clickOnExactButton(
//							screenshotData.newBuilder().setXEndCordinate(150).setYEndCoordinate(175).build())
//					.getBoolVal();
//			break;
//		default:
//			flag = false;
//			break;
//		}
//
//		if (flag) {
//			return clickOnRightArrow();
//		} else {
//			return false;
//		}
//	}

	public boolean exitInstallerSetup(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "EXIT SETUP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(275).build())
					.getBoolVal();
			break;
		case "DON'T EXIT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(345).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean connectApp(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "CONNECT APP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(325).build())
					.getBoolVal();
			break;
		case "SET UP LATER":
		case "SETUP LATER":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(393).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean connectApp_AppAvailability(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "YES, I HAVE THE APP":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(325).build())
					.getBoolVal();
			break;
		case "NO, I NEED TO DOWNLAOD":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(393).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean verifyQRScanScreenAndTakeQRScreenShot(TestCases testCase, String timeStamp) {
		boolean flag = false;
		if (_QRCodeScreen_Confirmation(testCase)) {
			if (_QRCodeScreenShot(testCase, timeStamp)) {
				Keyword.ReportStep_Pass(testCase, "QR Code is visible, QR Code captured.");
			} else {
				Keyword.ReportStep_Pass(testCase, "Not able to capture screenshot");
			}
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean CoolIncreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(250).setYEndCoordinate(185).build())
				.getBoolVal();
	}

	public boolean CoolDecreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(65).setYEndCoordinate(185).build())
				.getBoolVal();
	}

	public boolean CoolIncreaseButton_CoolOnly() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(250).setYEndCoordinate(130).build())
				.getBoolVal();
	}

	public boolean CoolDecreaseButton_CoolOnly() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(65).setYEndCoordinate(130).build())
				.getBoolVal();
	}

	public boolean HeatIncreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(250).setYEndCoordinate(315).build())
				.getBoolVal();
	}

	public boolean MinimumCompressorOFFTimeIncreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(250).setYEndCoordinate(130).build())
				.getBoolVal();
	}

	public boolean MinimumCompressorOFFTimeDecreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(65).setYEndCoordinate(135).build())
				.getBoolVal();
	}

	public boolean heatDecreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(65).setYEndCoordinate(315).build())
				.getBoolVal();
	}

	public boolean BackUpHeatIncreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(250).setYEndCoordinate(130).build())
				.getBoolVal();
	}

	public boolean BackUpheatDecreaseButton() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(65).setYEndCoordinate(135).build())
				.getBoolVal();
	}

	public boolean setCoolStages(int stage) {
		boolean flag = false;
		if (stage == 0) {
			flag = CoolDecreaseButton();
		} else if (stage == 1) {
			flag = true;
		} else if (stage == 2) {
			flag = CoolIncreaseButton();
		} else if (stage == 3) {
			flag = CoolIncreaseButton();
			flag = CoolIncreaseButton();
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean setCompressorStages(int stage) {
		boolean flag = false;
		if (stage == 0) {
			flag = CoolDecreaseButton();
			flag = CoolDecreaseButton();
		} else if (stage == 1) {
			flag = CoolDecreaseButton();
		} else if (stage == 2) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean setBackHeatStages(int stage) {
		boolean flag = false;
		if (stage == 0) {
			flag = heatDecreaseButton();
		} else if (stage == 1) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean setCoolStages_CoolOnly(int stage) {
		boolean flag = false;
		if (stage == 0) {
			flag = CoolDecreaseButton_CoolOnly();
		} else if (stage == 1) {
			flag = true;
		} else if (stage == 2) {
			flag = CoolIncreaseButton_CoolOnly();
		} else if (stage == 3) {
			flag = CoolIncreaseButton_CoolOnly();
			flag = CoolIncreaseButton_CoolOnly();
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean setHeatStages(int stage) {
		boolean flag = false;
		if (stage == 0) {
			flag = heatDecreaseButton();
		} else if (stage == 1) {
			flag = true;
		} else if (stage == 2) {
			flag = HeatIncreaseButton();
		} else if (stage == 3) {
			flag = HeatIncreaseButton();
			flag = HeatIncreaseButton();
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean equipmentStages(String cool, String heat) {
		boolean flag = false;

		if (cool != null && heat != null) {
			int cool_stage = Integer.parseInt(cool);
			flag = setCoolStages(cool_stage);
		} else if (cool != null && heat == null) {
			int cool_stage = Integer.parseInt(cool);
			flag = setCoolStages_CoolOnly(cool_stage);
		}

		if (heat != null) {
			int heat_stage = Integer.parseInt(heat);
			flag = setHeatStages(heat_stage);
		}
		if (flag) {
			flag = clickOnRightArrow();
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean heatPump_equipmentStages(String compressor, String backup_heat) {
		boolean flag = false;

		if (compressor != null && backup_heat != null) {
			int compressor_stage = Integer.parseInt(compressor);
			flag = setCompressorStages(compressor_stage);
		}

		if (backup_heat != null) {
			int backup_heat_stage = Integer.parseInt(backup_heat);
			flag = setHeatStages(backup_heat_stage);
		}
		if (flag) {
			flag = clickOnRightArrow();
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean wifiConfiguration(TestCases testCase, String wifiName, String security_Type, String password) {
		boolean flag = false;
		try {
			String securityType = null;
			switch (security_Type) {
			case "WPA2_PERSONAL_MIXED":
				securityType = "WPA2 MIXED";
				break;
			case "WPA2_PERSONAL_AES":
				securityType = "WPA2 AES";
				break;
			case "WPA2_PERSONAL_TKIP":
				securityType = "WPA2 TKIP";
				break;

			default:
				securityType = null;
				break;
			}

			if (isWifiScreen()) {

				if (clickOnGetConnectedWifiButton()) {
					Keyword.ReportStep_Pass(testCase, "Wifi scan started");
					if (isWifi_ScanList_Available(testCase)) {
						Keyword.ReportStep_Pass(testCase, "Wifi scan finished");
						if (clickOnOtherButton_WifiScanList()) {
							Thread.sleep(2000);
							if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_NAME", wifiName)) {

							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to Enter Wifi ssid name");
								flag = false;
							}
							Keyword.ReportStep_Pass(testCase, "Wifi SSID name entered");
							if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {
								if (selectWifiSecurityType(securityType)) {
									Keyword.ReportStep_Pass(testCase, "Wifi security entered");
									Thread.sleep(2000);
									if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_PASSWORD",
											password)) {
										Keyword.ReportStep_Pass(testCase, "Wifi password entered");
										if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {

											if (IsWifi_Success(testCase)) {
												Keyword.ReportStep_Pass(testCase, "Wifi sucess screen");
												if (clickOnOKButton_wifiSucessScreen()) {
													Keyword.ReportStep_Pass(testCase,
															"Wifi configured sucessfully, SSID name is " + wifiName
																	+ " , Wifi security type is " + securityType);
													flag = true;
												} else {
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Not able toConnect with Wifi after credential shared");
													flag = false;
												}

											} else {
												Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
														FailType.FUNCTIONAL_FAILURE,
														"Not able toConnect with Wifi after credential shared");
												flag = false;
											}

										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE, "Not able to click on next button");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE, "Not able to Enter Wifi ssid Password");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to select Wifi security type");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on next button");
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on other button from wifi scan list");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Wifi scan list");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on Get connected button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to find Wifi screen");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
		}
		return flag;

	}

	public boolean selectWifi_SSIDByAutomate(TestCases testCase, String wifissid, String bandWidth) {
		boolean flag = false;
		String bandwidth = null;
		if (bandWidth.contains("5GHZ")) {
			bandwidth = "5";
		} else if (bandWidth.contains("2.4GHZ") || bandWidth.contains("24GHZ")) {
			bandwidth = "2.4";
		}
//System.out.println();
		for (int i = 0; i < 4; i++) {
			try {
				String txt = StatCommands.getInstance().cattCommandsStub
						.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
								.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(4)
								.setYStartCoordinate(64).setXEndCordinate(305).setYEndCoordinate(130).build())
						.getStrVal();
//				System.out.println(txt);
				String exactWifiName = txt.split("\n")[0];
				System.out.println(exactWifiName);
				if ((exactWifiName.contains(wifissid) && txt.contains(bandwidth) && !txt.contains("_" + bandwidth))
						|| (exactWifiName.toUpperCase().contains(wifissid.toUpperCase())
								&& txt.toUpperCase().contains(bandwidth.toUpperCase()))) {
//					System.out.println(txt);
					flag = StatCommands.getInstance().cattCommandsStub
							.clickOnExactButton(
									screenshotData.newBuilder().setXEndCordinate(60).setYEndCoordinate(100).build())
							.getBoolVal();
					break;
				}
				Thread.sleep(1000);
				txt = StatCommands.getInstance().cattCommandsStub
						.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
								.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(4)
								.setYStartCoordinate(154).setXEndCordinate(310).setYEndCoordinate(230).build())
						.getStrVal();
//				System.out.println(txt);					
				exactWifiName = txt.split("\n")[0];
				System.out.println(exactWifiName);
				if ((exactWifiName.contains(wifissid) && txt.contains(bandwidth))
						|| (exactWifiName.toUpperCase().contains(wifissid.toUpperCase())
								&& txt.toUpperCase().contains(bandwidth.toUpperCase()))) {
//					System.out.println(txt);
					flag = StatCommands.getInstance().cattCommandsStub
							.clickOnExactButton(
									screenshotData.newBuilder().setXEndCordinate(60).setYEndCoordinate(190).build())
							.getBoolVal();
					break;
				}
				Thread.sleep(1000);
				txt = StatCommands.getInstance().cattCommandsStub
						.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
								.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(4)
								.setYStartCoordinate(244).setXEndCordinate(310).setYEndCoordinate(318).build())
						.getStrVal();
//				System.out.println(txt);					
				exactWifiName = txt.split("\n")[0];
				System.out.println(exactWifiName);
				if ((exactWifiName.contains(wifissid) && txt.contains(bandwidth))
						|| (exactWifiName.toUpperCase().contains(wifissid.toUpperCase())
								&& txt.toUpperCase().contains(bandwidth.toUpperCase()))) {
//					System.out.println(txt);
					flag = StatCommands.getInstance().cattCommandsStub
							.clickOnExactButton(
									screenshotData.newBuilder().setXEndCordinate(60).setYEndCoordinate(280).build())
							.getBoolVal();
					break;
				}
				Thread.sleep(1000);
				txt = StatCommands.getInstance().cattCommandsStub
						.getTextsFromScreenParticualrArea(screenshotData.newBuilder()
								.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(4)
								.setYStartCoordinate(332).setXEndCordinate(315).setYEndCoordinate(405).build())
						.getStrVal();
//				System.out.println(txt);
				exactWifiName = txt.split("\n")[0];
				System.out.println(exactWifiName);
				if ((exactWifiName.contains(wifissid) && txt.contains(bandwidth))
						|| (exactWifiName.toUpperCase().contains(wifissid.toUpperCase())
								&& txt.toUpperCase().contains(bandwidth.toUpperCase()))) {
//					System.out.println(txt);
					flag = StatCommands.getInstance().cattCommandsStub
							.clickOnExactButton(
									screenshotData.newBuilder().setXEndCordinate(60).setYEndCoordinate(370).build())
							.getBoolVal();
					break;
				} else {
					StatCommands.getInstance().cattCommandsStub
							.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build());
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				Keyword.ReportStep_Pass(testCase, "Error occured due to " + e.getMessage());
			}
		}

		if (flag) {
			if (clickOnConnectButton_WifiScanList()) {
				Keyword.ReportStep_Pass(testCase,
						"Sucessfully found Wifi ssid name in wifi scan screen, Wifi name is " + wifissid);
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Connect button from wifi scan list");
				flag = false;
			}

		}

		return flag;
	}

	public boolean wifiConfiguration(TestCases testCase, String wifiName, String bandWidth, String security_Type,
			String password) {
		boolean flag = false;
		try {
			String securityType = null;
			switch (security_Type) {
			case "WPA2_PERSONAL_MIXED":
				securityType = "WPA2 MIXED";
				break;
			case "WPA2_PERSONAL_AES":
				securityType = "WPA2 AES";
				break;
			case "WPA2_PERSONAL_TKIP":
				securityType = "WPA2 TKIP";
				break;

			default:
				securityType = null;
				break;
			}

			if (isWifiScreen()) {
				if (clickOnGetConnectedWifiButton()) {
					Keyword.ReportStep_Pass(testCase, "Wifi scan started");
					if (isWifi_ScanList_Available(testCase)) {
						Keyword.ReportStep_Pass(testCase, "Wifi scan finished");
						if (selectWifi_SSIDByAutomate(testCase, wifiName, bandWidth)) {
							flag = true;
						} else {
							if (clickOnOtherButton_WifiScanList()) {
								Thread.sleep(2000);
								if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_NAME",
										wifiName)) {
									Thread.sleep(2000);
									flag = true;
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to Enter Wifi ssid name");
									flag = false;
								}
								Keyword.ReportStep_Pass(testCase, "Wifi SSID name entered");
								if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {
									if (selectWifiSecurityType(securityType)) {
										Keyword.ReportStep_Pass(testCase, "Wifi security entered");
										Thread.sleep(2000);
										flag = true;
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE, "Not able to select Wifi security type");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on next button");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on other button from wifi scan list");
								flag = false;
							}
						}

						if (flag) {
							if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_PASSWORD",
									password)) {
								Keyword.ReportStep_Pass(testCase, "Wifi password entered");
								if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {

									if (IsWifi_Success(testCase)) {
										Keyword.ReportStep_Pass(testCase, "Wifi sucess screen");
										if (clickOnOKButton_wifiSucessScreen()) {
											Keyword.ReportStep_Pass(testCase,
													"Wifi configured sucessfully, SSID name is " + wifiName
															+ " , Wifi security type is " + securityType);
											flag = true;
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"Not able toConnect with Wifi after credential shared");
											flag = false;
										}

									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Not able toConnect with Wifi after credential shared");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on next button");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to Enter Wifi ssid Password");
								flag = false;
							}
						} else {

						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Wifi scan list");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on Get connected button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to find Wifi screen");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;

	}

	public boolean isConfirmedAfterWifi(TestCases testCase) {
		boolean flag = false;
		ArrayList<String> dataList = GetData_TakeScreenShot(testCase);
		System.out.println(dataList);
		for (String string : dataList) {
			if (string.toLowerCase().contains("success")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean is_WifiScreen(TestCases testCase) {
		boolean flag = false;
		ArrayList<String> dataList = GetData_TakeScreenShot(testCase);
//		System.out.println(dataList);
		for (String string : dataList) {
			if (string.toLowerCase().contains("gh")) {
				flag = true;
				break;
			} else if (string.toLowerCase().contains("g")) {
				flag = true;
				break;
			} else if (string.toLowerCase().contains("2")) {
				flag = true;
				break;
			} else if (string.toLowerCase().contains("D")) {
				flag = true;
				break;
			} else if (string.toLowerCase().contains("?")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public ArrayList<String> GetData_TakeScreenShot(TestCases testCase) {
		ArrayList<String> element_Data = null;
		for (int i = 0; i < 8; i++) {
			try {
				String strVal = StatCommands.getInstance().cattCommandsStub
						.clickOnElement(dataParam.newBuilder().setActionstate(actionType.click)
								.setMethodstate(methodType.textMethod).setText("Set Up Later").build())
						.getStrVal();
				System.out.println(strVal);
				Thread.sleep(500);
//				element_Data = Stat_ImageProcessngUtils.getElements_Text();
				System.out.println(element_Data);
				if (element_Data != null && !element_Data.isEmpty()) {
					break;
				} else {
					break;
				}
			} catch (Exception e) {
				Keyword.ReportStep_Pass(testCase,
						"Exception occured due to " + e.getMessage() + " , Retry to get screenshot");
				System.out.println("Retry.....");
			}
		}
		return element_Data;
	}

	public boolean setBackHeatStagesOnly(String stages_Heat) {
		int stages = Integer.parseInt(stages_Heat);

		boolean flag = false;
		if (stages == 0) {
			flag = BackUpheatDecreaseButton();
		} else if (stages == 1) {
			flag = true;
		} else if (stages == 2) {
			flag = BackUpHeatIncreaseButton();
		} else if (stages == 3) {
			flag = BackUpHeatIncreaseButton();
			flag = BackUpHeatIncreaseButton();
		} else {
			flag = false;
		}
		if (flag) {
			flag = clickOnRightArrow();
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean setChangeOverDifferential(String diff) {
		boolean flag = false;
		if (diff.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {
			int stages = Integer.parseInt(diff);

			if (stages == 0) {
				flag = true;
			} else if (stages >= 1 && stages <= 5) {

				for (int i = 0; i < stages; i++) {
					flag = BackUpHeatIncreaseButton();
				}

			} else {
				flag = false;
			}
		}
		if (flag) {
			flag = clickOnRightArrow();
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean AddSensor_EIMAddedScreen(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "ADD ANOTHER DEVICE":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(366).build())
					.getBoolVal();
			break;
		case "DONE ADDING DEVICES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(438).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean chooseRoomInAddingIASSensor(TestCases testCase, String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "GUEST BEDROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(87).build())
					.getBoolVal();
			break;
		case "MASTER BEDROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(150).build())
					.getBoolVal();
			break;
		case "FAMILY ROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(87).build())
					.getBoolVal();
			break;
		case "LIVING ROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(150).build())
					.getBoolVal();
			break;
		case "REC ROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(218).build())
					.getBoolVal();
			break;
		case "DINING ROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(85).build())
					.getBoolVal();
			break;
		case "KITCHEN":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(150).build())
					.getBoolVal();
			break;
		case "BASEMENT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(215).build())
					.getBoolVal();
			break;
		case "HALLWAY":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(280).build())
					.getBoolVal();
			break;
		default:
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Room name is not available, please check the default room name in Thermostat " + option);
			flag= false;
			break;
		}
		return flag;
	}

	public boolean choose_BedRoom_Name_InAddingIASSensor(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "GUEST BEDROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(84).build())
					.getBoolVal();
			break;
		case "MASTER BEDROOM":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(148).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean IAS_SensorPlaced() {
		return StatCommands.getInstance().cattCommandsStub
				.clickOnExactButton(screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(433).build())
				.getBoolVal();
	}

	public String _unixToDateTime(long unixMilliSecond, String expectedFormat) {
		Date date = new Date(unixMilliSecond);
		// format of the date
		SimpleDateFormat jdf = new SimpleDateFormat(expectedFormat);
		String conv_date = jdf.format(date);
		System.out.println("\n" + conv_date + "\n");
		return conv_date;
	}

	public boolean isHome_ClockScreen() {
		boolean flag = false;
		double[] coordinates = UI_Stat_Data.getCoordinates("readerHeader");
		for (int i = 0; i < 3; i++) {
			String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
					screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
							.setXEndCordinate(coordinates[2]).setYEndCoordinate(100).build())
					.getStrVal();
			System.out.println(txt);
			String indoorValue = String.valueOf(StatCommands.getInstance().cattCommandsStub
					.getIndoorHum(String_Msg.newBuilder().build()).getFloatVal());
			if (txt.trim().equals(indoorValue)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isTextIsPresentInScreen(TestCases testCase,Duration pollingTimeout, Duration timeOut, int xstart, int ystart, int xend,
			int yend, int counterTarget, String... expectText) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(pollingTimeout); // Changes made from 2 seconds to 10 seconds
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						boolean status = false;
						String currentText = null;
						for (int i = 0; i < expectText.length; i++) {
							String text = expectText[i];
							if (stat_text.contains(text) && counterTarget == (i + 1)) {
								Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
								status = true;
								currentText = stat_text;
								break;
							}
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isTextIsPresentInScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend, int counterTarget, String... expectText) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(10)); // Changes made from 2 seconds to 10 seconds
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						boolean status = false;
						String currentText = null;
						for (int i = 0; i < expectText.length; i++) {
							String text = expectText[i];
							if (stat_text.contains(text) && counterTarget == (i + 1)) {
								Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
								status = true;
								currentText = stat_text;
								break;
							}
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isTextIsPresentInScreen(TestCases testCase, Duration timeOut, int xstart, int ystart, int xend,
			int yend, int counterTarget, boolean _deleteScreenShot, String... expectText) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(timeOut);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
								screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
										.setXStartCordinate(xstart).setYStartCoordinate(ystart).setXEndCordinate(xend)
										.setYEndCoordinate(yend).build())
								.getStrVal();
						boolean status = false;
						String currentText = null;
						for (int i = 0; i < expectText.length; i++) {
							String text = expectText[i];
							if (stat_text.contains(text) && counterTarget == (i + 1)) {
								Keyword.ReportStep_Pass(testCase, "Expected text is " + stat_text);
								status = true;
								currentText = stat_text;
								break;
							}
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isInstallerScreen(TestCases testCase) {
//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(70)
//						.setYStartCoordinate(6).setXEndCordinate(250).setYEndCoordinate(45).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (txt.trim().contains("Installer Options")) {
//			return true;
//		} else {
//			return false;
//		}

		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 70, 6, 250, 45, 1, "Installer Options");
	}

	public boolean isResetScreen(TestCases testCase) {
//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(70)
//						.setYStartCoordinate(6).setXEndCordinate(250).setYEndCoordinate(45).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (txt.trim().contains("Reset")) {
//			return true;
//		} else {
//			return false;
//		}

		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 70, 6, 250, 45, 1, "Reset");
	}

	public boolean isResetConfirmMessage(TestCases testCase, String resetMessage) {
//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(30)
//						.setYStartCoordinate(135).setXEndCordinate(285).setYEndCoordinate(175).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (resetMessage.equals("RESET SCHEDULE")) {
//			if (txt.trim().contains("Reset Schedule")) {
//				return true;
//			} else {
//				return false;
//			}
//		} else if (resetMessage.equals("DELETE ALL DEVICES")) {
//			if (txt.trim().contains("Delete All Devices")) {
//				return true;
//			} else {
//				return false;
//			}
//		} else if (resetMessage.equals("RESET HOMEKIT")) {
//			if (txt.trim().contains("Reset HomeKit")) {
//				return true;
//			} else {
//				return false;
//			}
//		} else if (resetMessage.equals("FACTORY RESET")) {
//			if (txt.trim().contains("Factory Reset")) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} else {
//			return false;
//		}return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 90, 10, 235, 45, 1, "Connect App");
		if (resetMessage.equals("RESET SCHEDULE")) {
			return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 30, 135, 285, 175, 1, "Reset Schedule");
		} else if (resetMessage.equals("DELETE ALL DEVICES")) {
			return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 30, 135, 285, 175, 1,
					"Delete All Devices");
		} else if (resetMessage.equals("RESET HOMEKIT")) {
			return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 30, 135, 285, 175, 1, "Reset HomeKit");
		} else if (resetMessage.equals("FACTORY RESET")) {
			return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 30, 135, 285, 175, 1, "Factory Reset");
		} else {
			return false;
		}

	}

	public boolean clickOnResetButton_mainScreen() {
		return UI_Stat_Data.clickOnElement_byCoordinate(160, 412);
	}

	public boolean clickOnResetButton(String option) {
		boolean flag = false;
		switch (option.toUpperCase()) {
		case "RESET SCHEDULE":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(150).build())
					.getBoolVal();
			break;
		case "DELETE ALL DEVICES":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(215).build())
					.getBoolVal();
			break;
		case "RESET HOMEKIT":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(285).build())
					.getBoolVal();
			break;
		case "FACTORY RESET":
			flag = StatCommands.getInstance().cattCommandsStub
					.clickOnExactButton(
							screenshotData.newBuilder().setXEndCordinate(160).setYEndCoordinate(355).build())
					.getBoolVal();
			break;
		default:
			flag = false;
			break;
		}
		return flag;
	}

	public boolean clickOnResetConfirmButton() {
		return UI_Stat_Data.clickOnElement_byCoordinate(90, 435);
	}

	public boolean clickOnResetCancelButton() {
		return UI_Stat_Data.clickOnElement_byCoordinate(235, 435);
	}

	public boolean isConnectAppScreenFrom_HomeScreen(TestCases testCase) {
		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 90, 10, 235, 45, 1, "Connect App");

//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(90)
//						.setYStartCoordinate(10).setXEndCordinate(235).setYEndCoordinate(45).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (txt.trim().contains("Installer Options")) {
//			return true;
//		} else {
//			return false;
//		}
	}

	public boolean isConnectAppScreenFrom_ConnectAPPToGoForApp_REG_Confirmation_Unlock_morePowerToControl(
			TestCases testCase) {
		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 25, 175, 300, 205, 1,
				"Unlock more power to control");

//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(90)
//						.setYStartCoordinate(10).setXEndCordinate(235).setYEndCoordinate(45).build())
//				.getStrVal();
//
//		System.out.println(txt);
//		if (txt.trim().contains("Installer Options")) {
//			return true;
//		} else {
//			return false;
//		}
	}

	public boolean clickOnConnectAppButton_HomeScreen() {
		return UI_Stat_Data.clickOnElement_byCoordinate(160, 435);
	}

	public boolean isDeviceAlreadyRegistered(TestCases testCase) {
		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 20, 175, 300, 235, 1,
				"This thermostat is registered");
	}

	public boolean _HaveYouDownloadedResideoAPP_Screen(TestCases testCase) {
		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 20, 175, 300, 210, 1, "Have you downloaded");
	}

	public boolean _QRCodeScreen_Confirmation(TestCases testCase) {
		return isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), 60, 60, 270, 90, 1, "Open and log in to");
	}

	public boolean _QRCodeScreenShot(TestCases testCase, String name) {
		return StatCommands.getInstance().cattCommandsStub.getScreenShot(
				screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset" + name).setXStartCordinate(75)
						.setYStartCoordinate(255).setXEndCordinate(243).setYEndCoordinate(423).build())
				.getStrVal().contains("ArmConstants.stat_UI_Tmp_Asset");
	}

	public boolean isDeviceRegistered(TestCases testCase) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(6));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						boolean status = false;
						String currentText = null;
						String stat_text = null;
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
								NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build())
								.getBoolVal();
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
								NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
								.getBoolVal();
						StatCommands.getInstance().cattCommandsStub
								.t10PlusNavigateTo(NavigateTo.newBuilder()
										.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
								.getBoolVal();
						if (StatCommands.getInstance().cattCommandsStub
								.t10PlusNavigateTo(NavigateTo.newBuilder()
										.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
								.getBoolVal()) {
							stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
									screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
											.setXStartCordinate(20).setYStartCoordinate(175).setXEndCordinate(300)
											.setYEndCoordinate(235).build())
									.getStrVal();
							if (stat_text.contains("This thermostat is registered")) {
								status = true;
							} else {
								currentText = stat_text;
							}
						} else {
							Keyword.ReportStep_Pass(testCase, "Not able to navigate to Connect APP Screen");
							status = false;
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean waitForDevice_QRCODE_Generate(TestCases testCase) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(6));
			fWait.withTimeout(Duration.ofMinutes(3));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						boolean status = false;
						String currentText = null;
						String stat_text = null;
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
								NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build())
								.getBoolVal();
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
								NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
								.getBoolVal();
						StatCommands.getInstance().cattCommandsStub
								.t10PlusNavigateTo(NavigateTo.newBuilder()
										.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
								.getBoolVal();
						if (StatCommands.getInstance().cattCommandsStub
								.t10PlusNavigateTo(NavigateTo.newBuilder()
										.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
								.getBoolVal()) {
							stat_text = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
									screenshotData.newBuilder().setCapturePath("ArmConstants.stat_UI_Tmp_Asset")
											.setXStartCordinate(20).setYStartCoordinate(175).setXEndCordinate(300)
											.setYEndCoordinate(210).build())
									.getStrVal();
							if (stat_text.contains("Unlock more power to control")) {
								status = true;
								Keyword.ReportStep_Pass(testCase, "Device is unregistered, able to generate QR Code");
							} else if (stat_text.contains("This thermostat is registered")) {
								Keyword.ReportStep_Pass(testCase,
										"Device showing Registered, wait for sometime to check the status");
							} else {
								currentText = stat_text;
							}
						} else {
							Keyword.ReportStep_Pass(testCase, "Not able to navigate to Connect APP Screen");
							status = false;
						}
						if (status) {
							Keyword.ReportStep_Pass(testCase, "Expected text is " + currentText);
							return true;
						} else {
//							System.out.println("retrying to get text, Captured text is  " + stat_text);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean wifiConfiguration_InQRScreen(TestCases testCase) {
		boolean flag = false;
		try {
			String wifiName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			String security_Type = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"WIFI_SECURITY");
			String password = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD");
			String bandWidth = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_BANDWIDTH");

			String securityType = null;
			switch (security_Type) {
			case "WPA2_PERSONAL_MIXED":
				securityType = "WPA2 MIXED";
				break;
			case "WPA2_PERSONAL_AES":
				securityType = "WPA2 AES";
				break;
			case "WPA2_PERSONAL_TKIP":
				securityType = "WPA2 TKIP";
				break;

			default:
				securityType = null;
				break;
			}

			if (isWifiScreen()) {
				if (clickOnGetConnectedWifiButton()) {
					Keyword.ReportStep_Pass(testCase, "Wifi scan started");
					if (isWifi_ScanList_Available(testCase)) {
						Keyword.ReportStep_Pass(testCase, "Wifi scan finished");
						if (selectWifi_SSIDByAutomate(testCase, wifiName, bandWidth)) {
							flag = true;
						} else {
							if (clickOnOtherButton_WifiScanList()) {
								Thread.sleep(2000);
								if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_NAME",
										wifiName)) {
									Thread.sleep(2000);
									flag = true;
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to Enter Wifi ssid name");
									flag = false;
								}
								Keyword.ReportStep_Pass(testCase, "Wifi SSID name entered");
								if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {
									if (selectWifiSecurityType(securityType)) {
										Keyword.ReportStep_Pass(testCase, "Wifi security entered");
										Thread.sleep(2000);
										flag = true;
									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE, "Not able to select Wifi security type");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on next button");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on other button from wifi scan list");
								flag = false;
							}
						}

						if (flag) {
							if (T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(testCase, "SSID_PASSWORD",
									password)) {
								Keyword.ReportStep_Pass(testCase, "Wifi password entered");
								if (T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT")) {

									if (IsWifi_Success(testCase)) {
										Keyword.ReportStep_Pass(testCase, "Wifi sucess screen");
										if (clickOnOKButton_wifiSucessScreen()) {
											Keyword.ReportStep_Pass(testCase,
													"Wifi configured sucessfully, SSID name is " + wifiName
															+ " , Wifi security type is " + securityType);
											flag = true;
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"Not able toConnect with Wifi after credential shared");
											flag = false;
										}

									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Not able toConnect with Wifi after credential shared");
										flag = false;
									}

								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on next button");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to Enter Wifi ssid Password");
								flag = false;
							}
						} else {

						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Wifi scan list");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on Get connected button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "WIFI Already Configured, Will move to QR Registration");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;

	}

//	public static void main(String[] args) throws InterruptedException {
////		StatCommands.getInstance().cattCommandsStub.setReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_FACTORY_RESET).build());
//		SetUpDevice_T9_T10_T0Plus sc = new SetUpDevice_T9_T10_T0Plus();
//		sc.isHome_ClockScreen();
//sc
//		T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(null, "SSID_NAME", "Home");
//		T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT");
//		StatCommands.getInstance().cattCommandsStub.setButtonsToHardwareControl(String_Msg.newBuilder().build());
//		sc.selectWifiSecurityType("WPA2 MIXED");
////		StatCommands.getInstance().cattCommandsStub.setButtonsToHardwareControl(String_Msg.newBuilder().build());
////		sc.clickOnNextButton();
//		T9_T10_T10Plus_KeyboardUtils.designKeyboardLayout(null, "SSID_PASSWORD", "Home@123.");
//		T9_T10_T10Plus_KeyboardUtils.sendKey("NEXT");
//
////		 boolVal = StatCommands.getInstance().cattCommandsStub.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.UP).build()).getBoolVal();
////		 boolean boolVal = StatCommands.getInstance().cattCommandsStub.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_DOWN).build()).getBoolVal();
////		boolean boolVal = StatCommands.getInstance().cattCommandsStub.scrollGuiScreen(scroll.newBuilder().setScroller(ScrollScreen.HALF_UP).build()).getBoolVal();
//
////		RoboKeyboardUtils.designKeyboardLayout(null, "SSID_NAME", "AAA");
////		RoboKeyboardUtils.designKeyboardLayout(null, "SSID_NAME", "Shweta@WeareA");
////		RoboKeyboardUtils.designKeyboardLayout(null, "SSID_PASSWORD", "HOME@123as.");
//
////		Thread.sleep(4000);
////		sc.clickOnGetStartedButton();
////		sc.clickOnNextButton();
////		sc.IsRegistration_Success(null);
////		sc.clickOnRoomName("Bedroom");
////		String screenName = sc.getScreenName();
////		System.out.println(screenName);
////		sc.selectCWireAdapter("NO");
////		sc.clickOnRoomName("Master Bedroom");
////		sc.clickOnTemperatureScale("Fahrenheit");
////		sc.clickOnNextButton();
////		sc.clickOnRedlinkSetUpLaterButton();
////		sc.selectOutdoorTemperature("Internet");
////		sc.selectSystemType("Conventional");
////		sc.selectEquipmentType("Standard efficiency gas forced air");
////		sc.equipmentStages("0", "2");
////		sc.clickOnDoneButton();
////		StatCommands.getInstance().cattCommandsStub.setDateTime(String_Msg.newBuilder().setStrVal("24/12/2022 10:19 AM").build());
////		sc.clickOnWIFISetUpLaterButton();
////		sc.clickOnDoneButton();
//
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
////		sc.clickOnNextButton();
//	}

}