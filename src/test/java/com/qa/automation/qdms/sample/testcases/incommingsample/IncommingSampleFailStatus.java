//****************************************************************************************
//		DESCRIPTION
//------------------
//					INCOMING SAMPLE ALL TEST FAIL STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   02:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0217  	 02:05:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0218
//* TC-PRO-SAM-0219
//* TC-PRO-SAM-0220
//* TC-PRO-SAM-0221
//* TC-PRO-SAM-0222
//* TC-PRO-SAM-0223
//* TC-PRO-SAM-0224
//* TC-PRO-SAM-0225
//* TC-PRO-SAM-0226
//* TC-PRO-SAM-0227
//* TC-PRO-SAM-0228
//* TC-PRO-SAM-0229
//* TC-PRO-SAM-0230
//*****************************************************************************************

/*
* TC-INC-SAM-0217	ALL Key Test  FAIL and ALL Non Key Test New Check the Sample Status FAIL
* TC-INC-SAM-0218	One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0219	All Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0220	One Key Test FAIL and Only One Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0221	All Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0222	One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
* TC-INC-SAM-0223	All Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0224	Only One Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0225	Only One Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0226	Only One Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0227	Only One Key Test FAIL and All Non Key Test FAIL Check the Sample Status FAIL
* TC-INC-SAM-0228	Only One Key Test FAIL and All Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0229	Only One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0230	Only One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
*/


package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncommingSampleFailStatus extends DriverIntialization{
	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test

	public static void IncomingSampleNewStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);

		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 2,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG INCOMING SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// INCOMING SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.incommingSampleXpath(), 2,
				"STEP 3 - CHECKING INCOMING SAMPLE BUTTON");

		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0217",
				IncomingSamplePage.StatusColumn, 1, 16, 18, IncomingSamplePage.InComKeyBefore,
				IncomingSamplePage.InComKeyAfter);

	}

}
