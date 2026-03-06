package com.resideo.commons.coreframework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.resideo.commons.mobile.MobileTestCase;
import com.resideo.commons.report.XRayUtils;

/**
 * TestCaseRetryMechanism class represents the failed test case retry mechanism.
 */

public class TestCaseRetryMechanism implements IRetryAnalyzer {

	/**
	 * retry method is used to check count of retries for failed test cases.
	 * 
	 * @param result
	 *            ITestResult type variable that holds the TestCases result.
	 * 
	 *            Its return boolean type value representing retry required or
	 *            not based on test status and number of retry counts.
	 * 
	 * @author E880579
	 * @return boolean
	 */

	@Override
	public boolean retry(ITestResult result) {

		MobileTestCase mtestCase = ((MobileTestCase) result.getInstance());
		TestCases testCases = mtestCase.getTestCase();
		
		if (!result.isSuccess()) {
			if(doRetry(testCases)){
				FrameworkGlobalVariables.retryCounter++;
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}
		}

		if(FrameworkGlobalVariables.PUBLISH_RESULT){
			
					XRayUtils.updateExecutionResults(testCases);	
		}
		
		return false;
	}
	
	public static boolean doRetry(TestCases testcase){
		return (SuiteConstants.getMAX_RETRYCount()>0) && 
				!testcase.isTestSuccessful() && (getRetryCounter(testcase) < SuiteConstants.getMAX_RETRYCount());
	}

	public static void moveTestResultToRetryFolder(TestCases testCase) {
		if(TestCaseRetryMechanism.doRetry(testCase)){
			File retryFolder = new File(FrameworkGlobalVariables.REBOT_FOLDER + "/retried_tests/");
			try {
				String xmlFileName = testCase.getTestXmlFileName();
				FileUtils.moveFileToDirectory(new File(xmlFileName), retryFolder, true);
				testCase.getTestCaseInputs().setInputValue("RetryCount", getRetryCounter(testCase)+1, false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	public static int getRetryCounter(TestCases testcase){
		TestCaseInputs inputs = testcase.getTestCaseInputs();
		
		if(inputs.isInputAvailable("RetryCount")){
			return Integer.parseInt(inputs.getInputValue("RetryCount"));
		}else{
			inputs.setInputValue("RetryCount", 0, false);
			return 0;
		}
	}
	
}
