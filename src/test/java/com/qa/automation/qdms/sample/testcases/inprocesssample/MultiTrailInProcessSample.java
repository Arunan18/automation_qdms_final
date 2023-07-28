
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE MULTI TRAIL  FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   12:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0296	 	 12:05:2023     @SASIKALA     Original Version
//*****************************************************************************************

/*
* TC-PRO-SAM-0296	Check the more than one trail  
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.TestStatus;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MultiTrailInProcessSample extends DriverIntialization {
	@Test

	public static void InProcessSampleMultiTrial() throws InterruptedException, IOException {

		// LOGIN
		LoginTest.Login();

		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG RAW MATERIAL MENU IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 2,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// STEP-03 CHECKNIG INCOMING SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG INPROCESS SAMPLE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 2,
				"STEP 3 - CHECKING INPROCESS SAMPLE BUTTON");

		// STEP-04 SEARCHING SAMPLE CODE
		TestStatus.clickTestAndResults("Samples Module", "Process Sample", "TC-PRO-SAM-0296-data",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 18);

		// STEP-05 CLICK TEST AND ENTER TRIAL VALUES
		TestStatus.inputTestDataForRawMaterial("TC-PRO-SAM-0296-Input");

		// STEP-06 COMPARE TRIAL EXPECTED VALUES
		TestStatus.testExpected("TC-PRO-SAM-0296-Expected");

		// LOGOUT
		Logout.LogoutFunction();

	}
}
