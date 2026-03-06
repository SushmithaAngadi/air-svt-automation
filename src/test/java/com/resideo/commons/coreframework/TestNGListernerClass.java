package com.resideo.commons.coreframework;

import com.resideo.commons.XLTVUtil.XLTVUtil;
import com.resideo.commons.devicepool.DevicePoolUtility;
import com.resideo.commons.mobile.MobileTestCase;
import com.resideo.commons.report.SoftAssertion;
import com.resideo.commons.report.XRayUtils;
import com.resideo.commons.report.rebot.RebotReportUtils;
import com.resideo.commons.report.rebot.ReportUploadUtility;
import com.resideo.gmail.app.feedback.SendAppFeedBack;
import com.resideo.utils.stat.mqtt.MqttSerialController;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TestNGListernerClass class represents TestNG test cases life cycle.
 */

public class TestNGListernerClass implements ITestListener, ISuiteListener, IInvokedMethodListener, ITest,
        IAnnotationTransformer {

    int executionCount = 0;

    public String getTestName() {
        return null;
    }

    /**
     * beforeInvocation is used to perform action before methods of test are
     * executed
     *
     * @param method     IInvokedMethod type variable that holds reference of invoked
     *                   method.
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

//		if(method.getTestMethod().isBeforeGroupsConfiguration()){
//			
//			MobileTestCase mTestCase = ((MobileTestCase)method.getTestMethod().getInstance());
//		}


        if (method.getTestMethod().isBeforeMethodConfiguration()) {

            MobileTestCase mTestCase = ((MobileTestCase) testResult.getInstance());

            TestCases testCase;
            try {
                System.out.println("******************************** Test Execution Started - " + mTestCase.getName()
                        + " ********************************");
//				System.out.println("================================= Test Setup Execution Started - " + mTestCase.getName()
//				+ " =================================");

                testCase = TestCases.initializeTestCase(mTestCase.getTestInputs());
                mTestCase.setTestCase(testCase);

            } catch (Exception e) {

                System.out.println("Error occured while initializing test case - " + e.getMessage());
            }
        }
    }

    /**
     * afterInvocation is used to perform action after methods of test are
     * executed
     *
     * @param method     IInvokedMethod type variable that holds reference of invoked
     *                   method.
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        Reporter.setCurrentTestResult(testResult);
        TestCases testCase = null;

        MobileTestCase mtestCase = ((MobileTestCase) testResult.getInstance());

        if (mtestCase != null) {
            testCase = mtestCase.getTestCase();

            if (testCase != null) {
                if (method.isTestMethod()) {

                    testCase = mtestCase.getTestCase();

                    mtestCase.getTestCase().completedActualTest();

                    List<Throwable> verificationFailures = SoftAssertion.getVerificationFailures();

                    int size = verificationFailures.size();

                    // if there are verification failures...
                    if (size > 0) {

                        Reporter.log("<p> Execution Result for : <b>" + mtestCase.getName() + "</b></p>");

                        // set the test to failed
                        testResult.setStatus(ITestResult.FAILURE);

                        // if there is an assertion failure add it to
                        // verificationFailures
                        if (testResult.getThrowable() != null) {
                            verificationFailures.add(testResult.getThrowable());
                        }

                        StringBuilder errorMessages = new StringBuilder();

                        String className = verificationFailures.get(0).getStackTrace()[4].getClassName();

                        errorMessages.append("Total Error(s) - " + size + " in Test : " + className + ".\n");

                        Reporter.log("<p>" + "Total Error(s) - <b>" + size + "</b> in Test : <b>" + className + "</b>.<p>");

                        String[] messages;

                        for (int i = 0; i <= size - 1; i++) {
                            String temp = verificationFailures.get(i).getMessage();
                            messages = temp.split("::::");
                            if (messages.length > 1) {
                                errorMessages.append((i + 1) + ". [ERROR] :: [Error Message] - " + messages[0] + " @"
                                        + verificationFailures.get(i).getStackTrace()[4]);
                                Reporter.log(
                                        "<p>" + (i + 1) + ". <a href='../" + FrameworkGlobalVariables.SCRSHOTS_FLD + messages[1]
                                                + "' title='Click here to get Screen Shot for Investigation'><b>[ERROR] :: [Error Message]</b> - "
                                                + messages[0] + " <b>@</b>" + verificationFailures.get(i).getStackTrace()[4]
                                                + "</a></p>");
                            }

                        }

                        SoftAssertion.clearVerificationFailures();

                        testResult.setThrowable(new Throwable(errorMessages.toString()));
                    } else {
                        if (testResult.getStatus() == ITestResult.SUCCESS) {
                            if (executionCount % 2 == 0) {
                                Reporter.log(
                                        "<p> Execution Result for : <b>" + method.getTestMethod().getMethodName() + "</b></p>");
                                Reporter.log("<p><b>ALL STEPS PASSED</b></p>");
                            }
                        }
                    }

                    ++executionCount;

                } else {
                    if (method.getTestMethod().isAfterMethodConfiguration()) {

                        try {
                            testCase.getXMLTestNode().addTags(testCase);
                            testCase.testCaseCompleted();
                        } catch (Exception e) {
                            FrameworkGlobalVariables.logger4J.logError(FrameworkUtils.getMessage(e));
                        } finally {
                            DevicePoolUtility.releaseDevicePoolResources(testCase.getResourceIDs());

//							System.out.println("================================= Tear Down of Test Completed - "
//									+ mtestCase.getName() + " =================================");
                            System.out.println("********************************Test Execution Completed - " + mtestCase.getName()
                                    + " ********************************");

                            if (XLTVUtil.UPLOAD_TO_XLTV || FrameworkGlobalVariables.PUBLISH_RESULT) {

                                ReportUploadUtility reportUploadUtility = new ReportUploadUtility(ReportUploadUtility.ArtifactType.SCREENSHOTS,
                                        FrameworkGlobalVariables.CURRENT_EXECUTION_SUB_FOLDER);
                                reportUploadUtility.uploadResultToServer(mtestCase.getTestCase().getScrShotPath());
                            }
                        }
                    }

                    if (method.getTestMethod().isBeforeMethodConfiguration()) {

                        testCase.completedSetup();

//						System.out.println("================================= Test Setup Execution Completed - "
//								+ mtestCase.getName() + " =================================");
                    }

                }
            }
        }
    }

    /**
     * onStart is used to perform action before suite starts execution.
     *
     * @param suite ISuite type variable that holds reference of test suite.
     * @author E880579
     */

    public void onStart(ISuite suite) {

    }

    /**
     * onFinish is used to perform action after suite execution completes.
     *
     * @param suite ISuite type variable that holds reference of test suite.
     * @author E880579
     */

    public void onFinish(ISuite suite) {

        Map<String, ISuiteResult> results = suite.getResults();
        Set<String> keys = results.keySet();

        Iterator<String> iter = keys.iterator();
        ISuiteResult result;
        ITestContext testContext;

        while (iter.hasNext()) {
            result = results.get(iter.next());
            testContext = result.getTestContext();
            RebotReportUtils.PASSES_TESTS += testContext.getPassedTests().size();
            RebotReportUtils.FAILED_TESTS += testContext.getFailedTests().size();
            RebotReportUtils.FAILED_TESTS += testContext.getSkippedTests().size();
        }

        if (FrameworkGlobalVariables.PUBLISH_RESULT) {
            XRayUtils.doPostTestExecution();
        }
        MqttSerialController.sendLogs();

    }

    /**
     * onTestStart is used to perform action before test are executed
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onTestStart(ITestResult testResult) {

        executionCount++;

        MobileTestCase testCase = ((MobileTestCase) testResult.getInstance());

//		System.out.println("================================= Actual Test Execution Started - " + testCase.getName()
//		+ " =================================");

    }

    /**
     * onTestSuccess is used perform action after test is success
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onTestSuccess(ITestResult testResult) {

        MobileTestCase mTestCase = ((MobileTestCase) testResult.getInstance());

        if (mTestCase != null) {
            TestCases testCase = mTestCase.getTestCase();

            if (testCase != null) {

                if (FrameworkGlobalVariables.PUBLISH_RESULT) {
                    XRayUtils.updateExecutionResults(testCase);
//					XRayUtils.addTestToTestPlan(testCase);
//					if(testCase.getXRayTestID()!=null){
//						if (testCase.getXRayTestID().isEmpty()) {
//							FrameworkGlobalVariables.logger4J.logger.error("XRay Test ID is not set for - " + testCase.getTestCaseName());
//						} else {						
//							XRayUtils.updateExecutionResultsToXRay(testCase);	
//						}
//					}
                }

                testCase.completedActualTest();

//				testCase.getXMLTestNode().addTags(testCase);
//				
//				if(testCase.hasFalsePositive()){
//					testCase.getXMLTestNode().addDocumentToTest(testCase.getFalsePositiveReason());
//				}

                System.out.println("=================================" + testCase.getTestCaseName()
                        + " [PASSED] =================================");
//				System.out.println("================================= Tear Down of Test Started - " + testCase.getTestCaseName()
//				+ " =================================");
//                SendAppFeedBack.mailAppFeedBack(testCase, testCase.getTestCaseInputs());
            }
        }

    }

    /**
     * onTestFailure is used perform action after test is fail
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onTestFailure(ITestResult testResult) {

        MobileTestCase mTestCase = ((MobileTestCase) testResult.getInstance());

        if (mTestCase != null) {

            TestCases testCase = mTestCase.getTestCase();

            testCase.getXMLTestNode().setTestSuccess(false);

            if (testCase != null) {
                testCase.completedActualTest();

//				testCase.getXMLTestNode().addTags(testCase);
//				
//				if(testCase.hasFalsePositive()){
//					testCase.getXMLTestNode().addDocumentToTest(testCase.getFalsePositiveReason());
//				}

                System.out.println("=================================" + testCase.getTestCaseName()
                        + " [FAILED] =================================");
//				System.out.println("================================= Tear Down of Test Started - " + testCase.getTestCaseName()
//				+ " =================================");
//                SendAppFeedBack.mailAppFeedBack(testCase, testCase.getTestCaseInputs());
            }
        }

    }

    /**
     * onTestSkipped is used perform action after test is skipped
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onTestSkipped(ITestResult testResult) {

        MobileTestCase mTestCase = ((MobileTestCase) testResult.getInstance());


        if (mTestCase != null) {

            TestCases testCase = mTestCase.getTestCase();

            if (testCase != null) {
                testCase.completedActualTest();

//				testCase.getXMLTestNode().addTags(testCase);
//				
//				if(testCase.hasFalsePositive()){
//					testCase.getXMLTestNode().addDocumentToTest(testCase.getFalsePositiveReason());
//				}


                System.out.println("=================================" + testCase.getTestCaseName()
                        + " [SKIPPED] =================================");
//				System.out.println("================================= Tear Down of Test Started - " + testCase.getTestCaseName()
//				+ " =================================");
//                SendAppFeedBack.mailAppFeedBack(testCase, testCase.getTestCaseInputs());
            }

        }

    }

    /**
     * onTestFailedButWithinSuccessPercentage is used perform action after test
     * is failed within success percentage
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    /**
     * onStart is used perform action on start of test
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onStart(ITestContext context) {
    }

    /**
     * onFinish is used perform action on finish of test
     *
     * @param testResult ITestResult type variable that holds the reference for TestNG
     *                   result.
     * @author E880579
     */

    public void onFinish(ITestContext context) {

        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        for (ITestResult temp : failedTests) {

            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
    }

//	/**
//	 * intercept is used to perform selection of test cases based on groups
//	 * provided.
//	 * 
//	 * @param methodInstances
//	 *            List<IMethodInstance> type variable that holds reference of
//	 *            test methods.
//	 * @param testContext
//	 *            ITestContext type variable that holds the reference for TestNG
//	 *            result.
//	 * @author E880579
//	 */
//
//	@Override
//	public List<IMethodInstance> intercept(List<IMethodInstance> methodInstances, ITestContext testContext) {
//
//		
//		return methodInstances;
////		ArrayList<IMethodInstance> selectedTests = new ArrayList<IMethodInstance>();
//
////		List<String> includedGroups = new LinkedList<String>();
////		includedGroups.add("Executor");
////
////		List<String> excludedGroups = testContext.getCurrentXmlTest().getExcludedGroups();
////
////		Iterator<String> includedGroupIter = includedGroups.iterator();
////		Iterator<String> excludedGroupIter = excludedGroups.iterator();
////		Iterator<IMethodInstance> methodInstanceIter = methodInstances.iterator();
////
////		String excludedGroup;
////
////		IMethodInstance methodInstance;
////
////		String[] methodGroups = {};
////
////		boolean flag;
////
////		if (FrameworkGlobalVariables.INSTANTIATE_DRIVER_GROUP_LEVEL) {
////			if (excludedGroups.size() > 0) {
////
////				while (methodInstanceIter.hasNext()) {
////					flag = true;
////					methodInstance = methodInstanceIter.next();
////					methodGroups = methodInstance.getMethod().getGroups();
////					while (excludedGroupIter.hasNext()) {
////						excludedGroup = excludedGroupIter.next();
////						for (String group : methodGroups) {
////							if (group.equalsIgnoreCase(excludedGroup)) {
////								flag = false;
////								break;
////							}
////						}
////
////						if (!flag) {
////							break;
////						}
////
////					}
////
////					if (flag) {
////						selectedTests.add(methodInstance);
////					}
////				}
////
////			} else {
////				while (methodInstanceIter.hasNext()) {
////					selectedTests.add(methodInstanceIter.next());
////				}
////			}
////
////		} else {
////
////			while (methodInstanceIter.hasNext()) {
////				flag = false;
////				methodInstance = methodInstanceIter.next();
////
////				methodGroups = methodInstance.getMethod().getGroups();
////
////				if (excludedGroups.isEmpty()) {
////					// Excluded Group list is empty. Moving ahead for Included
////					// evaluation.
////				} else {
////					String exGroup;
////					boolean found;
////					excludedGroupIter = excludedGroups.iterator();
////					while (excludedGroupIter.hasNext()) {
////						found = false;
////						exGroup = excludedGroupIter.next();
////
////						for (String group : methodGroups) {
////							
////							if (group.equalsIgnoreCase(exGroup)) {
////								found = true;
////								break;
////							}
////						}
////
////						if (found) {
////							flag = flag & found;
////						} else {
////							flag = found;
////							break;
////						}
////					}
////				}
////
////				if (flag) {
////					// Excluded group is present. Skipping the included group
////					// evaluation.
////				} else {
////					boolean found;
////					String incGroup;
////					includedGroupIter = includedGroups.iterator();
////					while (includedGroupIter.hasNext()) {
////						found = false;
////						incGroup = includedGroupIter.next();
////						for (String group : methodGroups) {
////							if (group.equalsIgnoreCase(incGroup)) {
////								found = true;
////								break;
////							}
////						}
////
////						if (found) {
////							flag = !flag & found;
////							if (flag) {
////								selectedTests.add(methodInstance);
////							}
////
////						} else {
////							flag = found;
////							break;
////						}
////					}
////				}
////
////			}
////		}
//
//	}


    /**
     * transform is used to add retry analyzer to all test classes.
     *
     * @param annotation      ITestAnnotation type variable that holds reference of
     *                        test annotation.
     * @param testClass       Class type variable that holds the reference for TestNG
     *                        class.
     * @param testConstructor Constructor type variable that holds the reference to test class constructor
     * @param testMethod      Method type variable that holds the reference to test method.
     * @author E880579
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(TestCaseRetryMechanism.class);
        annotation.setTimeOut(FrameworkGlobalVariables.SCRIPT_TIME_OUT);
//		annotation.setAlwaysRun(true);
    }

}
