package com.resideo.system.scheduler;

import java.util.Date;
import java.util.TimerTask;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.system.utils.LCC_Admin;
//import com.resideo.system.utils.LCC_Admin;
import com.resideo.utils.api.dfc.CustomCommands;

public class ScheduledTask extends TimerTask {

	Date now; // to display current time

	// Add your task here
	public void run1() {
//		now = new Date(); // initialize date
//		System.out.println("Time is :" + now); // Display current time
		String currentTime = CustomCommands.getCurrentTime();
//		System.out.println("Current scheduler name is " + SchedulerMain.schedulerName);

		try {
			if (SchedulerMain.schedulerName.equals("registration cooling Period")) {
				if (!SchedulerMain.isRegistered) {
					try {
//						LCC_Admin.doRegisterLCCDeviceInAdminPortal(SchedulerMain.testCases,
//								SchedulerMain.testCases.getTestCaseInputs(), "Jasper", SchedulerMain.macId);
						SchedulerMain.isRegistered = true;
					} catch (Exception e) {
						Keyword.ReportStep_Pass(SchedulerMain.testCases,
								"Exception occured in registration " + e.getMessage());
					}

				}
				System.out.println(
						"Current time is " + currentTime + " ,  Wait until " + SchedulerMain.afterRegistrationWaitTime);

				if (SchedulerMain.afterRegistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "unregistration cooling Period";
					SchedulerMain.afterUnregistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterUnRegistrationCoolingTime);
				}
			} else if (SchedulerMain.schedulerName.equals("unregistration cooling Period")) {
				if (!SchedulerMain.isUnregistered) {

					try {
//						LCC_Admin.doUnRegisterLCCDeviceInAdminPortal(SchedulerMain.testCases,
//								SchedulerMain.testCases.getTestCaseInputs(), "Jasper", SchedulerMain.macId);
						SchedulerMain.isUnregistered = true;
					} catch (Exception e) {
						Keyword.ReportStep_Pass(SchedulerMain.testCases,
								"Exception occured in unregistration " + e.getMessage());
					}

				}
				System.out.println("Current time is " + currentTime + " ,  Wait until "
						+ SchedulerMain.afterUnregistrationWaitTime);
				if (SchedulerMain.afterUnregistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "Timer Stop";
				}
			} else if (SchedulerMain.schedulerName.equals("Timer Stop")) {
				SchedulerMain.scheduler.cancel();
				SchedulerMain.time.cancel();
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(SchedulerMain.testCases, "Exception occured in scheduler part " + e.getMessage());
		}
	}

	public void run12() {
//		now = new Date(); // initialize date
//		System.out.println("Time is :" + now); // Display current time
		String currentTime = CustomCommands.getCurrentTime();
//		System.out.println("Current scheduler name is " + SchedulerMain.schedulerName);

		try {
			if (SchedulerMain.schedulerName.equals("registration cooling Period")) {
				if (!SchedulerMain.isRegistered) {
					try {
//						LCC_Admin.doRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
						SchedulerMain.isRegistered = true;
					} catch (Exception e) {
						System.out.println("Exception occured in registration " + e.getMessage());
					}

				}
				System.out.println(
						"Current time is " + currentTime + " ,  Wait until " + SchedulerMain.afterRegistrationWaitTime);

				if (SchedulerMain.afterRegistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "unregistration cooling Period";
					SchedulerMain.afterUnregistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterUnRegistrationCoolingTime);
				}
			} else if (SchedulerMain.schedulerName.equals("unregistration cooling Period")) {
				if (!SchedulerMain.isUnregistered) {

					try {
//						LCC_Admin.doUnRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
						SchedulerMain.isUnregistered = true;
					} catch (Exception e) {
						System.out.println("Exception occured in unregistration " + e.getMessage());
					}

				}
				System.out.println("Current time is " + currentTime + " ,  Wait until "
						+ SchedulerMain.afterUnregistrationWaitTime);
				if (SchedulerMain.afterUnregistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "Timer Stop";
				}
			} else if (SchedulerMain.schedulerName.equals("Timer Stop")) {
				SchedulerMain.scheduler.cancel();
				SchedulerMain.time.cancel();
			}
		} catch (Exception e) {
			System.out.println("Exception occured in scheduler part " + e.getMessage());
		}
	}

//	public void run() {
//		String currentTime = CustomCommands.getCurrentTime();
//		try {
//			if (SchedulerMain.schedulerName.equals("registration cooling Period")) {
//				if (!SchedulerMain.isRegistered) {
//					try {
////						LCC_Admin.doRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
//						SchedulerMain.isRegistered = true;
//						SchedulerMain.isUnregistered = false;
//					} catch (Exception e) {
//						System.out.println("Exception occured in registration " + e.getMessage());
//					}
//				}
//				System.out.println(
//						"Current time is " + currentTime + " ,  Wait until " + SchedulerMain.afterRegistrationWaitTime);
//				if (SchedulerMain.afterRegistrationWaitTime.contains(currentTime)) {
//					SchedulerMain.schedulerName = "unregistration cooling Period";
//					SchedulerMain.afterUnregistrationWaitTime = CustomCommands
//							.getTime_Add(SchedulerMain.afterUnRegistrationCoolingTime);
//				}
//			} else if (SchedulerMain.schedulerName.equals("unregistration cooling Period")) {
//				if (!SchedulerMain.isUnregistered) {
//					try {
////						LCC_Admin.doUnRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
//						SchedulerMain.isUnregistered = true;
//						SchedulerMain.isRegistered = false;
//					} catch (Exception e) {
//						System.out.println("Exception occured in unregistration " + e.getMessage());
//					}
//				}
//				System.out.println("Current time is " + currentTime + " ,  Wait until "
//						+ SchedulerMain.afterUnregistrationWaitTime);
//				if (SchedulerMain.afterUnregistrationWaitTime.contains(currentTime)) {
//					SchedulerMain.schedulerName = "registration cooling Period";
//					SchedulerMain.afterRegistrationWaitTime = CustomCommands
//							.getTime_Add(SchedulerMain.afterRegistrationCoolingTime);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Exception occured in scheduler part " + e.getMessage());
//		}
//	}

	public void run() {
		// now = new Date(); // initialize date
		// System.out.println("Time is :" + now); // Display current time
		String currentTime = CustomCommands.getCurrentTime();
		// System.out.println("Current scheduler name is " +
		// SchedulerMain.schedulerName);
		try {
			if (SchedulerMain.schedulerName.equals("registration cooling Period")) {
				if (!SchedulerMain.isRegistered) {
					try {
						LCC_Admin.doRegisterLCCDeviceInAdminPortal("Flycatcher", SchedulerMain.macId);
						SchedulerMain.isRegistered = true;
						SchedulerMain.isUnregistered = false;
					} catch (Exception e) {
						System.out.println("Exception occured in registration " + e.getMessage());
					}
				}
				System.out.println(
						"Current time is " + currentTime + " ,  Wait until " + SchedulerMain.afterRegistrationWaitTime);
				if (SchedulerMain.afterRegistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "unregistration cooling Period";
					SchedulerMain.afterUnregistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterUnRegistrationCoolingTime);
				}
			} else if (SchedulerMain.schedulerName.equals("unregistration cooling Period")) {
				if (!SchedulerMain.isUnregistered) {
					try {
						LCC_Admin.doUnRegisterLCCDeviceInAdminPortal("Flycatcher", SchedulerMain.macId);
						SchedulerMain.isUnregistered = true;
						SchedulerMain.isRegistered = false;
					} catch (Exception e) {
						System.out.println("Exception occured in unregistration " + e.getMessage());
					}
				}
				System.out.println("Current time is " + currentTime + " ,  Wait until "
						+ SchedulerMain.afterUnregistrationWaitTime);
				if (SchedulerMain.afterUnregistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "registration cooling Period";
					SchedulerMain.afterRegistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterRegistrationCoolingTime);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured in scheduler part " + e.getMessage());
		}
	}
	/*
	 * Jasper Run
	 */
	
	public void runJasper() {
		// now = new Date(); // initialize date
		// System.out.println("Time is :" + now); // Display current time
		String currentTime = CustomCommands.getCurrentTime();
		// System.out.println("Current scheduler name is " +
		// SchedulerMain.schedulerName);
		try {
			if (SchedulerMain.schedulerName.equals("registration cooling Period")) {
				if (!SchedulerMain.isRegistered) {
					try {
						LCC_Admin.doRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
						SchedulerMain.isRegistered = true;
						SchedulerMain.isUnregistered = false;
					} catch (Exception e) {
						System.out.println("Exception occured in registration " + e.getMessage());
					}
				}
				System.out.println(
						"Current time is " + currentTime + " ,  Wait until " + SchedulerMain.afterRegistrationWaitTime);
				if (SchedulerMain.afterRegistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "unregistration cooling Period";
					SchedulerMain.afterUnregistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterUnRegistrationCoolingTime);
				}
			} else if (SchedulerMain.schedulerName.equals("unregistration cooling Period")) {
				if (!SchedulerMain.isUnregistered) {
					try {
						LCC_Admin.doUnRegisterLCCDeviceInAdminPortal("Jasper", SchedulerMain.macId);
						SchedulerMain.isUnregistered = true;
						SchedulerMain.isRegistered = false;
					} catch (Exception e) {
						System.out.println("Exception occured in unregistration " + e.getMessage());
					}
				}
				System.out.println("Current time is " + currentTime + " ,  Wait until "
						+ SchedulerMain.afterUnregistrationWaitTime);
				if (SchedulerMain.afterUnregistrationWaitTime.contains(currentTime)) {
					SchedulerMain.schedulerName = "registration cooling Period";
					SchedulerMain.afterRegistrationWaitTime = CustomCommands
							.getTime_Add(SchedulerMain.afterRegistrationCoolingTime);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured in scheduler part " + e.getMessage());
		}
	}

}