
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE SUB MENU BAR BUTTON FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   09:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0002    	   09:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-PRO-SAM-0002	"Process Samples" Sub Menu Button Functionality
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class InProcessSamplesubmenuButtonfunctionality extends DriverIntialization {
	static InprocessSamplePage inprocesspg = new InprocessSamplePage();

//**********************IN PROCESS SAMPLE NAVIGATION METHOD****************************		
	@Test
	public static void InProcessSamplesSubmenuButton() throws InterruptedException, IOException {

//------Login-----------
		LoginTest.Login();

//------Sample Navigation-----------
		SampleNavigateTest.sampleNavigation();

//------Raw Material Sample Navigation-----------
		SampleNavigateTest.rawMaterialSampleMainNavigation();

//------InProcess Sample Site Bar Button Navigation-----------
		InProcessSamplesubmenuButtonfunctionality.InprocessSamplesSubmenuButtonfunction();

	}

//****************************************************************************************
//	    IN PROCESS SAMPLES SUB MENU BUTTON IS DISPLAYED & ENABLED
//****************************************************************************************		
	public static void InprocessSamplesSubmenuButtonfunction() throws InterruptedException {
		PageFactory.initElements(driver, inprocesspg);
		Thread.sleep(3000);

//------InProcess Sample Click-----------
		InprocessSamplePage.InprocessSample.click();

		if (InprocessSamplePage.InprocessSample.isDisplayed()) {
			testCase = extent.createTest("STEP-01--IN PROCESS SAMPLES SAMPLES SUB MENU BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");

			if (InprocessSamplePage.InprocessSample.isEnabled()) {
				testCase = extent.createTest("STEP-02--IN PROCESS SAMPLES SAMPLES SUB MENU BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				InprocessSamplePage.InprocessSample.click();

			} else {
				testCase = extent.createTest("STEP-02-IN PROCESS SAMPLES SAMPLES SUB MENU BUTTON IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-01--IN PROCESS SAMPLES SAMPLES SUB MENU BUTTON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}

//*********************************LOGOUT***********************************
		Logout.LogoutFunction();
	}

}
