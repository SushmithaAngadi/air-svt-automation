package com.resideo.utils.resideoPro_app;

import java.time.Duration;
import java.util.Iterator;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import org.python.antlr.ast.keyword;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.KeepAppActive;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.screen.CustomerInfoScreen;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import org.openqa.selenium.WebElement;

public class CustomerUtils {

	public static void threadLocker(TestCases testCase, int threadTime) {
		KeepAppActive appActive = new KeepAppActive(testCase);
		try {
			appActive.start();
			Thread.sleep(threadTime);
			if (appActive.isAlive())
				appActive.requestStop();
		} catch (InterruptedException e) {
			if (appActive.isAlive())
				appActive.requestStop();
			e.printStackTrace();
		}
	}

	public static boolean sendInvitationToExistingCustomer(TestCases testCase, CustomerInfoScreen cuScreen,
			String customerMail) {
		boolean flag = false;
		if (cuScreen.isRecentCustomers(50)) {
			threadLocker(testCase, 10000);
			flag = cuScreen.setCustomerNameinSearchBox(customerMail);
			flag = flag && cuScreen.clickOnCustomerNameInList(customerMail);
			Keyword.ReportStep_Pass(testCase, "Is Sucessfully selected Customer Mail ID ? " + flag);
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Customer list Screen is Not visible");
		}
		if (flag && cuScreen.isSelectLocationScreen(4)) {
			flag = cuScreen.clickOnHomeLocationFromLocationList();
			Keyword.ReportStep_Pass(testCase, "Sucessfully selected Location from the list");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Location list Screen is Not visible");
		}
		if (flag && cuScreen.isVerifyInfoScreen(3)) {
			flag = cuScreen.clickOnNextButton();
			Keyword.ReportStep_Pass(testCase, "Sucessfully Verified User");

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Verify Screen is Not visible");
			flag = false;
		}
		if (flag && cuScreen.isSuccessScreen(15)) {
			flag = cuScreen.clickOnDoneButton();
			Keyword.ReportStep_Pass(testCase, "Sucessfully Invitation sent to User");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Sucess! Screen is Not visible");
			flag = false;
		}
		return flag;
	}

	public static boolean CheckthePopup_sendInvite(TestCases testCase) {
		boolean flag = false;
		boolean success = false;
		ReziDIYScreen diy = new ReziDIYScreen(testCase);
		if (diy.isDisconnectfromThermostatPopup(20)) {
			if (diy.clickOnDisconnectAndInviteButton()) {
				SystemState.getStatus().isThermostat_DisconnectedAlready(true);
				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofMillis(1));
				fWait.withTimeout(Duration.ofSeconds(50));
				try {
					success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {
							try {
								if (diy.isRecentCustomers(3)) {
									return true;
								} else if (diy.isNoInternetConnectioncreen(1)) {
									diy.clickOnCheckCOnnectionButtonInNoInternetConnection();
									return false;
								} else {
									return false;
								}
							} catch (TimeoutException e) {
								return false;
							} catch (StaleElementReferenceException e) {
								return false;
							} catch (Exception e) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Exception Occured due to " + e.getMessage());
								return false;
							}
						}
					});
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Occured due to " + e.getMessage());
					flag = false;
				}

				if (success) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find recent customer list after the disconnect from thermostat in AP mode");
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Disconnect and Invite Button");
				flag = false;

			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Disconnect from Thermostat Pop Up is not visible");
			flag = false;
		}
		return flag;
	}

	public static boolean sendInviteToTheCustomer(TestCases testCase, CustomerInfoScreen cuScreen,
			String customerMail) {
		boolean flag = false;
		if (cuScreen.isRecentCustomers(40)) {
			threadLocker(testCase, 10000);
			if (cuScreen.setCustomerNameinSearchBox(customerMail)) {
				if (cuScreen.clickOnCustomerNameInList(customerMail)) {
					if (cuScreen.isSelectLocationScreen(4)) {
						if (cuScreen.clickOnHomeLocationFromLocationList()) {
							Keyword.ReportStep_Pass(testCase, "Sucessfully selected Location from the list");
							if (cuScreen.isVerifyInfoScreen(4)) {
								if (cuScreen.clickOnNextButton()) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully verified customer");
									if (cuScreen.isSuccessScreen(15)) {
										if (cuScreen.clickOnDoneButton()) {
											Keyword.ReportStep_Pass(testCase, "Sucessfully Invitation sent to User");
											flag = true;
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"failed to click on done button");
											flag = false;
										}

									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Sucess! Screen is Not visible");
										flag = false;
									}
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to find next button");
								}
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"verify Screen is Not visible");
							}
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find Home location in given customer");
						}
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Location list Screen is Not visible");
					}
				} else {
					if (create_customer(testCase, cuScreen, customerMail)) {
						Keyword.ReportStep_Pass(testCase,
								"Successfully created new customer and invite sent to customer");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to create new customer and invite");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to enter Customer mail id in search box");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer screen is not visible");
			flag = false;
		}
		return flag;
	}

//	public static boolean sendCustomerInvite(TestCases testCase, CustomerInfoScreen cus, String customerMail) {
//		boolean flag = false;
//
//		return flag;
//	}

	public static boolean create_customer(TestCases testCase, CustomerInfoScreen cus, String customerMail) {
		boolean flag = false;

		if (cus.clickOnAddCustomerButton()) {
			if (cus.isNewCustomerScreen(10)) {
				if (cus.setCustomerEmail(customerMail)) {
					if (cus.setCustomerFirstName("auto")) {
						if (cus.setCustomerLastName("comfort")) {
							if (cus.setPhoneNumberTextBox("+12345678901")) {
								if (cus.clickOnNextButton()) {
									if (cus.isNewLocationScreen(10)) {
										if (cus.setlocationName()) {
											if (cus.setAddress()) {
												if (cus.setCity()) {
													if (cus.setState_province()) {
														if (cus.setPostalCode()) {
															if (cus.clickOnNextButton()) {
																if (cus.isVerifyInfoScreen(10)) {
																	if (cus.clickOnNextButton()) {
																		if (cus.isSuccessScreen(120)) {
																			if (cus.isSuccessScreen(15)) {
																				if (cus.clickOnDoneButton()) {
																					flag = true;
																					Keyword.ReportStep_Pass(testCase,
																							"Invite mail sent to customer");
																				}
																			} else {
																				Keyword.ReportStep_Fail(testCase,
																						FailType.FUNCTIONAL_FAILURE,
																						"success Screen not visible");
																				flag = false;
																			}
																		} else {
																			Keyword.ReportStep_Fail(testCase,
																					FailType.FUNCTIONAL_FAILURE,
																					"Invite not able to sent to the customer");
																			flag = false;
																		}
																	} else {
																		Keyword.ReportStep_Fail(testCase,
																				FailType.FUNCTIONAL_FAILURE,
																				"next Button not able to click");
																		flag = false;
																	}
																} else {
																	Keyword.ReportStep_Fail(testCase,
																			FailType.FUNCTIONAL_FAILURE,
																			"verify screen is not visible");
																	flag = false;
																}
															} else {
																Keyword.ReportStep_Fail(testCase,
																		FailType.FUNCTIONAL_FAILURE,
																		"next Button not able to click");
																flag = false;
															}
														} else {
															Keyword.ReportStep_Fail(testCase,
																	FailType.FUNCTIONAL_FAILURE,
																	"not able to set postal code");
															flag = false;
														}
													} else {
														Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
																"not able to set state");
														flag = false;
													}
												} else {
													Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
															"not able to set city");
													flag = false;
												}
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set address");
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set location");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"location screen is not visible");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"next Button not able to click");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to set phone number");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to set customer last name ");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to set customer first name ");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to set cutomer email");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "customer info screen not visible");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on add customer button ");
			flag = false;
		}

		return flag;
	}

	public static boolean disconnectStatFromResideoPro(TestCases testCase, ReziDIYScreen diy) {
		boolean flag = false;

		if (diy.IswelcomeToResideoPro(3)) {
			if (diy.isConnectedToThermostatVisible(2)) {
				flag = diy.clickOnConnectedToThermostatVisible();
				if (flag && diy.isConnectedScreenForISUBegin()) {
					if (diy.isDisconnectButton(2)) {
						flag = diy.clickOnDisconnectButton();
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Disconnect Button not Visible");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Configuration screen not Visible");
				}

			} else {
			//	System.out.println(testCase.getMobileDriver().getPageSource());
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Thermostat Connected to Tstat Button not Visible");
			}
		} else if (diy.isConnectedScreenForISUBegin()) {
			if (diy.isDisconnectButton(2)) {
				flag = diy.clickOnDisconnectButton();
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Disconnect Button not Visible");
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Disconnect Button not Visible");
		}
//		System.out.println(testCase.getMobileDriver().getPageSource());
		if (diy.isInviteCustomerPopUp(5)) {
			flag = diy.clickOnInviteCustomerLater();
		}
		
		return flag;
	}
}
