package com.resideo.utils.stat.screens_Gui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.relay.AAT_RelayConfiguration;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;

public class GUI_Screen_Utils {

	public static void randomTime(TestCases testCase, boolean isRandom) {
		try {
			int finalTime = 0;
			if (isRandom) {
				int minSeconds = 20;
				int maxSeconds = 60;
				int seconds = (int) Math.random() * (maxSeconds - minSeconds + 1) + minSeconds;

				finalTime = (seconds * 1000);
			} else {
				finalTime = 15000;
			}
			Keyword.ReportStep_Pass(testCase,
					"User have to wait for pairing with device until confirmation or time out , " + (finalTime / 1000)
							+ "Seoconds need to wait");
			Thread.sleep(finalTime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Pass(testCase, "Exception occured " + e.getMessage());
		}
	}

	public static boolean enrollEIM(TestCases testCase, SetUpDevice_T9_T10_T0Plus gui, boolean isRandomNeedtoStart) {
		boolean flag = false;
		if (gui.clickOnEIMEnroll_unEnroll("YES, I HAVE AN EIM")) {
			if (gui.isWirelessSetup_EIM_Screen()) {
				if (AAT_RelayConfiguration.EIM_Sensor_CommandControl(testCase, "EIM", "Pairing")) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (gui.clickOnNextButton()) {
						randomTime(testCase, isRandomNeedtoStart);
						if (gui.getScreen(testCase, "Connecting", Duration.ofSeconds(180), 0, 0, 319, 75)) {
							if (gui.EIM_Completed(testCase, Duration.ofSeconds(180), 28, 149, 300, 220)) {
								Keyword.ReportStep_Pass(testCase, "Eqipment Interface Module Added successfully");
								flag = true;
								SystemState.getStatus().eimPairingFailedContinouslyCount(0);
							} else {
								SystemState.getStatus().eimPairingFailedContinouslyCount(
										SystemState.getStatus().eimPairingFailedContinouslyCount() + 1);
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to find EIM Added Screen, waiting time 60 seconds");
								flag = false;
							}
						} else {
							SystemState.getStatus().eimPairingFailedContinouslyCount(
									SystemState.getStatus().eimPairingFailedContinouslyCount() + 1);
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find EIM adding.. Screen, waiting time 60 seconds");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on from wireless setup Screen");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
							"Not able to do pairing on EIM, Arduino Failed please check the connection");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to find wireless setup Screen, waiting time 60 seconds");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to click on yes I have an EIM button");
			flag = false;
		}
		return flag;
	}

	public static boolean addIASSensorAsFirst_WithoutEIM(TestCases testCase, SetUpDevice_T9_T10_T0Plus gui,
			String mainRoomName, int roomNo, boolean isRandomNeedToStart) {
		boolean flag = false;
		try {
			String common_RoomName = null;
			String roomName = mainRoomName.toUpperCase();

			switch (mainRoomName.toUpperCase()) {
			case "GUEST BEDROOM":
				common_RoomName = "Bedroom";
				break;
			case "MASTER BEDROOM":
				common_RoomName = "Bedroom";
				break;
			case "FAMILY ROOM":
				common_RoomName = "Living Space";
				break;
			case "LIVING ROOM":
				common_RoomName = "Living Space";
				break;
			case "REC ROOM":
				common_RoomName = "Living Space";
				break;
			case "DINING ROOM":
				common_RoomName = "Other";
				break;
			case "KITCHEN":
				common_RoomName = "Other";
				break;
			case "BASEMENT":
				common_RoomName = "Other";
				break;
			case "HALLWAY":
				common_RoomName = "Other";
				break;
			default:
				break;
			}

			if (gui.clickOnRedlinkAddDeviceButton()) {
				if (gui.getScreen(testCase, "Connect Device", Duration.ofSeconds(120), 0, 0, 319, 75)) {
					Thread.sleep(13000);
					if (AAT_RelayConfiguration.EIM_Sensor_CommandControl(testCase, roomNo + "IAS", "Pairing")) {
						randomTime(testCase, isRandomNeedToStart);
						if (gui.getScreen(testCase, "Pick Up Sensor", Duration.ofSeconds(180), 41, 141, 286, 190)) {
							if (gui.clickOnNextButton()) {
								if (gui.getScreen(testCase, "Room", Duration.ofSeconds(60), 0, 0, 319, 75)) {
									if (gui.clickOnRoomName_WithCustomName(testCase, common_RoomName)) {
										if (gui.getScreen(testCase, "Room", Duration.ofSeconds(60), 0, 0, 319, 75)) {
											if (gui.choose_BedRoom_Name_InAddingIASSensor(roomName)) {
												if (gui.IAS_SensorPlaced()) {
													flag = true;
													Keyword.ReportStep_Pass(testCase, "Successfully added IAS Sensor");
												} else {
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Not able to click on IAS Sensor placed from pickup sensor Screen, waiting time 60 seconds");
													flag = false;
												}
											} else {
												Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
														FailType.FUNCTIONAL_FAILURE,
														"Not able to click on " + common_RoomName
																+ " button from pickup sensor Screen, waiting time 60 seconds");
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"Not able to find Bedroom selection Screen, waiting time 60 seconds");
											flag = false;
										}
									} else {

										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Not able to click on Bedroom button from pickup sensor Screen, waiting time 60 seconds");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to find Room Screen, waiting time 60 seconds");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on next button from pickup sensor Screen, waiting time 60 seconds");
								flag = false;

							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find PickUp Sensor Screen, waiting time 60 seconds");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
								"Not able to do pairing on EIM, Arduino Failed please check the connection");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find After Connect Device Screen, waiting time 60 seconds");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Add Another Device button");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean addIASSensorAscontinueAdded(TestCases testCase, SetUpDevice_T9_T10_T0Plus gui,
			String mainRoomName, int roomNo, boolean israndomNeedToStart) {
		boolean flag = false;
		try {
			String common_RoomName = null;
			String roomName = mainRoomName.toUpperCase();

			switch (mainRoomName.toUpperCase()) {
			case "GUEST BEDROOM":
				common_RoomName = "Bedroom";
				break;
			case "MASTER BEDROOM":
				common_RoomName = "Bedroom";
				break;
			case "FAMILY ROOM":
				common_RoomName = "Living Space";
				break;
			case "LIVING ROOM":
				common_RoomName = "Living Space";
				break;
			case "REC ROOM":
				common_RoomName = "Living Space";
				break;
			case "DINING ROOM":
				common_RoomName = "Other";
				break;
			case "KITCHEN":
				common_RoomName = "Other";
				break;
			case "BASEMENT":
				common_RoomName = "Other";
				break;
			case "HALLWAY":
				common_RoomName = "Other";
				break;
			default:
				break;
			}
			Keyword.ReportStep_Pass(testCase,
					"Main room name is " + common_RoomName + " , Sensor will install in this room :: " + roomName);
			if (gui.AddSensor_EIMAddedScreen("ADD ANOTHER DEVICE")) {
				if (gui.getScreen(testCase, "Connect Device", Duration.ofSeconds(120), 0, 0, 319, 75)) {
					Thread.sleep(5000);
					if (AAT_RelayConfiguration.EIM_Sensor_CommandControl(testCase, roomNo + "IAS", "Pairing")) {
						randomTime(testCase, israndomNeedToStart);
						if (gui.getScreen(testCase, "Pick Up Sensor", Duration.ofSeconds(180), 41, 141, 286, 190)) {
							if (gui.clickOnNextButton()) {
								if (gui.getScreen(testCase, "Room", Duration.ofSeconds(60), 0, 0, 319, 75)) {
									if (gui.clickOnRoomName_WithCustomName(testCase, common_RoomName)) {
										if (gui.getScreen(testCase, "Room", Duration.ofSeconds(60), 0, 0, 319, 75)) {
											if (gui.chooseRoomInAddingIASSensor(testCase, roomName)) {
												if (gui.IAS_SensorPlaced()) {
													flag = true;
													Keyword.ReportStep_Pass(testCase, "Successfully added IAS Sensor");
												} else {
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Not able to click on IAS Sensor placed from pickup sensor Screen, waiting time 60 seconds");
													flag = false;
												}
											} else {
												Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
														FailType.FUNCTIONAL_FAILURE,
														"Not able to click on " + common_RoomName
																+ " button from pickup sensor Screen, waiting time 60 seconds");
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"Not able to find Bedroom selection Screen, waiting time 60 seconds");
											flag = false;
										}
									} else {

										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Not able to click on Bedroom button from pickup sensor Screen, waiting time 60 seconds");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to find Room Screen, waiting time 60 seconds");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on next button from pickup sensor Screen, waiting time 60 seconds");
								flag = false;

							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find PickUp Sensor Screen, waiting time 60 seconds");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
								"Not able to do pairing on EIM, Arduino Failed please check the connection");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find After Connect Device Screen, waiting time 60 seconds");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Add Another Device button");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean addOASSensorAsFirst_EIMAddedScreen(TestCases testCase, SetUpDevice_T9_T10_T0Plus gui,
			boolean isRandomNeedToStart) {
		boolean flag = false;
		try {
			if (gui.AddSensor_EIMAddedScreen("ADD ANOTHER DEVICE")) {
				if (gui.getScreen(testCase, "Connect Device", Duration.ofSeconds(120), 0, 0, 319, 75)) {
					Thread.sleep(5000);
					if (AAT_RelayConfiguration.EIM_Sensor_CommandControl(testCase, "OAS", "Pairing")) {
						randomTime(testCase, isRandomNeedToStart);
						if (gui.OAS_SensorAddedScreen(testCase, Duration.ofSeconds(180), 30, 141, 300, 220)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfully added OAS Sensor");
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find Pairing success Sensor Screen, waiting time 60 seconds");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
								"Not able to do pairing on EIM, Arduino Failed please check the connection");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find After Connect Device Screen, waiting time 60 seconds");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Add Another Device button");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean addEiqupment_SensorsInDIY(TestCases testCase, SetUpDevice_T9_T10_T0Plus gui, int eimCount,
			int oasCount, int iasCount, boolean randomTime) {
		boolean flag = false;
		try {
			boolean isEIMadded_Success = false;
			boolean isEimNotApplicable = false;
			boolean isEimAddRequested = false;

			if (eimCount == 1 && !(eimCount > 1)) {
				isEimAddRequested = true;
				if (gui.isEimScreenVisible(testCase)) {
					if (enrollEIM(testCase, gui, randomTime)) {
						flag = true;
						isEIMadded_Success = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to enroll EIM screen");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"EIM screen is not visible");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Eim count is 0, Skipping EIM Enroll");
				if (gui.isEimScreenVisible(testCase)) {
					flag = gui.clickOnEIMEnroll_unEnroll("NO");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to enroll EIM screen");
					flag = false;
				}
				flag = true;
				isEimNotApplicable = true;
			}

			if (oasCount != 0 && oasCount == 1) {
				if (isEIMadded_Success) {
					if (addOASSensorAsFirst_EIMAddedScreen(testCase, gui, randomTime)) {
						flag = true;
					} else {
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"EIM not added, failed to continue to add OAS sensor");
					flag = false;
				}

			} else if (oasCount > 1) {
				Keyword.ReportStep_Pass(testCase,
						"OAS count is " + oasCount + " which is more than one, So Skipping OAS Enroll");
				flag = true;

			} else {
				Keyword.ReportStep_Pass(testCase, "OAS count is 0, Skipping OAS Enroll");
				flag = true;

			}
			if (iasCount > 0 && isEimAddRequested) {
				if (isEIMadded_Success) {
					if (isEIMadded_Success) {
						for (int i = 0; i < iasCount; i++) {
							int counter = i + 1;

							flag = flag && addIASSensorAscontinueAdded(testCase, gui, roomName(counter), counter,
									randomTime);
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
								"EIM not added, failed to continue to add OAS sensor");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"EIM not added, failed to continue to add IAS sensor");
					flag = false;
				}
			} else if (iasCount > 0 && isEimNotApplicable) {

				for (int i = 0; i < iasCount; i++) {
					int counter = i + 1;
					if (i == 0) {
						flag = flag && addIASSensorAsFirst_WithoutEIM(testCase, gui, roomName(counter), counter,
								randomTime);
					} else {

						flag = flag
								&& addIASSensorAscontinueAdded(testCase, gui, roomName(counter), counter, randomTime);
					}
				}
			} else if (iasCount > 0) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"something went wrong, please check the ias logic is correct");
				flag = false;
			} else if (iasCount == 0) {
				if (gui.isRedlinkIASScreenVisible(testCase)) {
					flag = gui.clickOnRedlinkSetUpLaterButton();
					Keyword.ReportStep_Pass(testCase, "IAS count is 0, Skipping IAS Enroll");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"IAS Redlink screen is not visible");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"something went wrong, please check the ias logic is correct");
				flag = false;
			}
			if (iasCount > 0 || eimCount > 0) {
				if (flag) {
					if (gui.clickOnDoneAddingDevicesButton()) {
						Keyword.ReportStep_Pass(testCase, "Successfully added following redlink devices, EIM count is "
								+ eimCount + " , OAS Count is " + oasCount + " and IAS Count is " + iasCount);
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
								"Not able to click on Done Adding Devices Button.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to ADD Redlink devices");
					flag = false;
				}

			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean addEiqupment_SensorsInDIY_DummyEIMPlaceHolder_ForPairing(TestCases testCase,
			SetUpDevice_T9_T10_T0Plus gui, int eimCount, int oasCount, int iasCount, boolean randomTime) {
		boolean flag = false;
		try {
			boolean isEIMadded_Success = false;
			boolean isEimNotApplicable = false;
			boolean isEimAddRequested = false;

			if (eimCount == 1 && !(eimCount > 1)) {
				isEimAddRequested = true;
				flag = true;
				isEIMadded_Success = true;
				Thread.sleep(10000);
			} else {
				Keyword.ReportStep_Pass(testCase, "Eim count is 0, Skipping EIM Enroll");
				if (gui.isEimScreenVisible(testCase)) {
					flag = gui.clickOnEIMEnroll_unEnroll("NO");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to enroll EIM screen");
					flag = false;
				}
				flag = true;
				isEimNotApplicable = true;
			}

			if (oasCount != 0 && oasCount == 1) {
				if (isEIMadded_Success) {
					if (addOASSensorAsFirst_EIMAddedScreen(testCase, gui, randomTime)) {
						flag = true;
					} else {
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"EIM not added, failed to continue to add OAS sensor");
					flag = false;
				}

			} else if (oasCount > 1) {
				Keyword.ReportStep_Pass(testCase,
						"OAS count is " + oasCount + " which is more than one, So Skipping OAS Enroll");
				flag = true;

			} else {
				Keyword.ReportStep_Pass(testCase, "OAS count is 0, Skipping OAS Enroll");
				flag = true;

			}
			if (iasCount > 0 && isEimAddRequested) {
				if (isEIMadded_Success) {
					if (isEIMadded_Success) {
						for (int i = 0; i < iasCount; i++) {
							int counter = i + 1;

							flag = flag && addIASSensorAscontinueAdded(testCase, gui, roomName(counter), counter,
									randomTime);
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
								"EIM not added, failed to continue to add OAS sensor");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"EIM not added, failed to continue to add IAS sensor");
					flag = false;
				}
			} else if (iasCount > 0 && isEimNotApplicable) {

				for (int i = 0; i < iasCount; i++) {
					int counter = i + 1;
					if (i == 0) {
						flag = flag && addIASSensorAsFirst_WithoutEIM(testCase, gui, roomName(counter), counter,
								randomTime);
					} else {

						flag = flag
								&& addIASSensorAscontinueAdded(testCase, gui, roomName(counter), counter, randomTime);
					}
				}
			} else if (iasCount > 0) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"something went wrong, please check the ias logic is correct");
				flag = false;
			} else if (iasCount == 0) {
				if (gui.isRedlinkIASScreenVisible(testCase)) {
					flag = gui.clickOnRedlinkSetUpLaterButton();
					Keyword.ReportStep_Pass(testCase, "IAS count is 0, Skipping IAS Enroll");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"IAS Redlink screen is not visible");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"something went wrong, please check the ias logic is correct");
				flag = false;
			}
			if (iasCount > 0 || eimCount > 0) {
				if (flag) {
					if (gui.clickOnDoneAddingDevicesButton()) {
						Keyword.ReportStep_Pass(testCase, "Successfully added following redlink devices, EIM count is "
								+ eimCount + " , OAS Count is " + oasCount + " and IAS Count is " + iasCount);
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
								"Not able to click on Done Adding Devices Button.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to ADD Redlink devices");
					flag = false;
				}

			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static String roomName(int sensorNumber) {
		String common_RoomName = null;

		switch (sensorNumber) {
		case 1:
		case 10:
			common_RoomName = "GUEST BEDROOM";
			break;
		case 2:
		case 11:
			common_RoomName = "MASTER BEDROOM";
			break;
		case 3:
		case 12:
			common_RoomName = "FAMILY ROOM";
			break;
		case 4:
		case 13:
			common_RoomName = "LIVING ROOM";
			break;
		case 5:
		case 14:
			common_RoomName = "REC ROOM";
			break;
		case 6:
		case 15:
			common_RoomName = "DINING ROOM";
			break;
		case 7:
		case 16:
			common_RoomName = "KITCHEN";
			break;
		case 8:
		case 17:
			common_RoomName = "BASEMENT";
			break;
		case 9:
		case 18:
			common_RoomName = "HALLWAY";
			break;
		default:
			common_RoomName = "GUEST BEDROOM";
			break;
		}
		return common_RoomName;
	}

	public static boolean factoryReset_ThermostatUI(TestCases testCase, String resetType, boolean isConfirmToDelete) {
		boolean flag = false;
		SetUpDevice_T9_T10_T0Plus t10Plus = new SetUpDevice_T9_T10_T0Plus();

		if (StatCommands.getInstance().cattCommandsStub
				.t10PlusNavigateTo(
						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build())
				.getBoolVal()) {
			if (StatCommands.getInstance().cattCommandsStub
					.t10PlusNavigateTo(
							NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
					.getBoolVal()) {
				if (StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_RESET).build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
							NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_RESET).build())
							.getBoolVal()) {
						if (t10Plus.clickOnResetButton(resetType)) {
							if (t10Plus.isResetConfirmMessage(testCase, resetType)) {
								if (isConfirmToDelete) {
									if (t10Plus.clickOnResetConfirmButton()) {
										Keyword.ReportStep_Pass(testCase, "Thermostat successfully started " + resetType
												+ ". Waiting to complete the reset, Wait time is 60 Seconds");
										flag = true;
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
												"Not able to click on confirm Reset Button");
										flag = false;
									}
								} else {
									if (t10Plus.clickOnResetCancelButton()) {
										Keyword.ReportStep_Pass(testCase, "Thermostat Reset canceled by user...");
										flag = true;
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
												"Not able to click on Reset cancel Button");
										flag = false;
									}
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
										"Not able to identify is Reset confirm message Screen?");
								flag = false;
							}
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Not able to click on Reset Button");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not able to identify is Reset option Screen?");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Not able to navigate to Reset option Screen");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Home Screen");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Idle Screen");
			flag = false;
		}
		return flag;
	}

	public static boolean showQRScanCodeToRegistration(TestCases testCase) {
		boolean flag = false;
		SetUpDevice_T9_T10_T0Plus t10Plus = new SetUpDevice_T9_T10_T0Plus();
		if (t10Plus.waitForDevice_QRCODE_Generate(testCase)) {
			if (t10Plus.clickOnConnectAppButton_HomeScreen()) {
				if (t10Plus.wifiConfiguration_InQRScreen(testCase)) {
					if (t10Plus.waitForDevice_QRCODE_Generate(testCase)) {
						if (t10Plus.clickOnConnectAppButton_HomeScreen()) {
							if (t10Plus._HaveYouDownloadedResideoAPP_Screen(testCase)) {
								if (t10Plus.connectApp_AppAvailability("YES, I HAVE THE APP")) {
									if (t10Plus._QRCodeScreen_Confirmation(testCase)) {
										if (t10Plus._QRCodeScreenShot(testCase, timestamp())) {
											Keyword.ReportStep_Pass(testCase, "QR Code is visible, QR Code captured.");
										} else {
											Keyword.ReportStep_Pass(testCase, "Not able to capture screenshot");
										}
										flag = true;
									} else {
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
											"Not able to click on Yes, I have the app button");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
										"Not able to click on Connect APP button");
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Not able to click on Connect APP button");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Device is already registered, please check the log");
						flag = false;
					}

				} else {
					if (t10Plus._HaveYouDownloadedResideoAPP_Screen(testCase)) {
						if (t10Plus.connectApp_AppAvailability("YES, I HAVE THE APP")) {
							if (t10Plus._QRCodeScreen_Confirmation(testCase)) {
								if (t10Plus._QRCodeScreenShot(testCase, timestamp())) {
									Keyword.ReportStep_Pass(testCase, "QR Code is visible, QR Code captured.");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to capture screenshot");
								}
								flag = true;
							} else {
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Not able to click on Yes, I have the app button");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not able to click on Connect APP button");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to click on Connect APP button");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Device is already registered, please check the log");
			flag = false;
		}
		return flag;
	}

	public static String timestamp() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}

//	public static boolean showQRScanCodeToRegistration(TestCases testCase) {
//		boolean flag = false;
//		SetUpDevice_T9_T10_T0Plus t10Plus = new SetUpDevice_T9_T10_T0Plus();
//		if (StatCommands.getInstance().cattCommandsStub
//				.t10PlusNavigateTo(
//						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build())
//				.getBoolVal()) {
//			if (StatCommands.getInstance().cattCommandsStub
//					.t10PlusNavigateTo(
//							NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
//					.getBoolVal()) {
//				if (StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
//						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
//						.getBoolVal()) {
//					if (StatCommands.getInstance().cattCommandsStub
//							.t10PlusNavigateTo(NavigateTo.newBuilder()
//									.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
//							.getBoolVal()) {
//						if (!t10Plus.isDeviceAlreadyRegistered(testCase)) {
////						if (!t10Plus.isConnectAppScreenFrom_HomeScreen(testCase)) {
//							if (t10Plus.isConnectAppScreenFrom_ConnectAPPToGoForAppConfirmation(testCase)) {
//								if (t10Plus.clickOnConnectAppButton_HomeScreen()) {
//
//									if (!t10Plus.isConnectAppScreenFrom_HomeScreen(testCase)) {
//
//										if (t10Plus.connectApp_AppAvailability("YES, I HAVE THE APP")) {
//
//											flag = true;
//
//										} else {
//											Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//													"Not able to click on Yes, I have the app button");
//											flag = false;
//										}
//									} else {
//										Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//												"Not able to click on Connect APP button");
//										flag = false;
//									}
//
//								} else {
//									Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//											"Not able to click on Connect APP button");
//									flag = false;
//								}
//							} else {
//
//							}
//
//						} else {
//							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//									"Device is already registered, please check the log");
//							flag = false;
//						}
//
//					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//								"Not able to identify is Reset option Screen?");
//						flag = false;
//					}
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//							"Not able to navigate to Reset option Screen");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Home Screen");
//				flag = false;
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Idle Screen");
//			flag = false;
//		}
//		return flag;
//	}

	public static boolean waitForConnectAppScreen_Reg(TestCases testCase, SetUpDevice_T9_T10_T0Plus t10Plus) {
		boolean flag = false;

		if (StatCommands.getInstance().cattCommandsStub
				.t10PlusNavigateTo(
						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build())
				.getBoolVal()) {
			if (StatCommands.getInstance().cattCommandsStub
					.t10PlusNavigateTo(
							NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
					.getBoolVal()) {
				if (StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.t10PlusNavigateTo(NavigateTo.newBuilder()
									.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_APPSEQUENCE).build())
							.getBoolVal()) {
						if (!t10Plus.isDeviceAlreadyRegistered(testCase)) {

							flag = true;

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Device is already registered, please check the log");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not able to identify is Reset option Screen?");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Not able to navigate to Reset option Screen");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Home Screen");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to navigate to Idle Screen");
			flag = false;
		}
		return flag;
	}

}