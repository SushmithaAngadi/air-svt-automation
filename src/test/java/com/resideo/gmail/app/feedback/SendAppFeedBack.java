package com.resideo.gmail.app.feedback;

import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.gmail.actions.GmailActions;
import com.resideo.utils.firstalert_app.NavigateToAnyScreeninFA;
import com.resideo.utils.firstalert_app.screen.NavigatingScreenToScreeninFA;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SendAppFeedBack {

	public static void mailAppFeedBack(TestCases testCase, TestCaseInputs inputs) {
        String feedBacklLocator;
        String emailID = "bengalurucomfortsystem@gmail.com";
        NavigatingScreenToScreeninFA navigateToScreen = new NavigatingScreenToScreeninFA(testCase);
        NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "APP SETTINGS");
        if (testCase.getMobileDriver().getPlatformName().toUpperCase().contains("ANDROID")) {
            feedBacklLocator = "//*[contains(@content-desc,'App Feedback')]";
            MobileUtils.clickOnElement(testCase, "XPATH", feedBacklLocator);
            try {
                TimeUnit.SECONDS.sleep(3);
                testCase.getMobileDriver().navigate().back();
            } catch (Exception e) {
                System.out.println("HIde keyboard failed due to: " + e.getMessage());
            }
 
            MobileUtils.clickOnElement(testCase, "ID", "com.google.android.gm:id/add_cc_bcc");
            if (MobileUtils.isMobElementExists("XPATH", "//android.widget.Button[contains(@content-desc,'firstalert')]", testCase)) 
            	MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[contains(@content-desc,'firstalert')]");
            if (MobileUtils.isMobElementExists("XPATH", "//android.widget.Button[contains(@content-desc,'lumina-logs')]", testCase)) {
            	 MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[contains(@content-desc,'lumina-logs')]");
            	 if (!MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Remove')]", testCase))
            		 MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[contains(@content-desc,'lumina-logs')]");
            }else if (MobileUtils.isMobElementExists("XPATH", "//android.widget.Button[contains(@content-desc,'beta-feedb')]", testCase)) {
           	 	MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[contains(@content-desc,'beta-feedb')]");
           }
            MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Remove')]");
            String toFieldEmail = "(//android.view.ViewGroup[@resource-id='com.google.android.gm:id/peoplekit_autocomplete_chip_group'])[1]/android.widget.EditText";
            MobileUtils.setValueToElement(testCase, "XPATH", toFieldEmail, emailID);
            String selectGmailFromSuggestion = "//*[@resource-id='com.google.android.gm:id/peoplekit_info_icon_title']/../../../..//android.widget.TextView[@text='bengalurucomfortsystem@gmail.com'][last()]";
            MobileUtils.clickOnElement(testCase, "XPATH", selectGmailFromSuggestion);
            MobileUtils.clickOnElement(testCase, "ID", "com.google.android.gm:id/send");
        } else {
            feedBacklLocator = "//*[contains(@label,'App Feedback')]";
            MobileUtils.clickOnElement(testCase, "XPATH", feedBacklLocator);
            WebElement element = MobileUtils.getMobElement(testCase, "XPATH", "//*[@name='toField']");
            assert element != null;
            element.click();
            element.clear();
            MobileUtils.setValueToElement(testCase, "XPATH", "//*[@name='toField']", emailID);
			MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeOther[@name='Mail.subjectField']");
			MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Mail.sendButton']");
        }
        try {
            System.out.println("Waiting for 20 seconds for to email appear in the inbox");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sent an App logs to the email id : bengalurucomfortsystem@gmail.com Proceed to download the attachment from Gmail application from Android device");
        String fileName = "AppLogs_"+ testCase.getMobileDriver().getPlatformName() + "_" + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())+"_Trail_"+TestCases.getTrailNo()+ ".log";
        GmailActions.getInstance().getGmailResponse("First Alert by Resideo", fileName);
        MobileUtils.isMobElementExists("XPATH", feedBacklLocator, testCase, 30);
    }
}
