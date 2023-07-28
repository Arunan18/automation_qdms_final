
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST NEW STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   01:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0166  	 01:05:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0167
//* TC-PRO-SAM-0168
//* TC-PRO-SAM-0169
//* TC-PRO-SAM-0170
//* TC-PRO-SAM-0171
//* TC-PRO-SAM-0172
//* TC-PRO-SAM-0173
//*****************************************************************************************

/*
* TC-PRO-SAM-0166	Process Sample All test should be in a New status
* TC-PRO-SAM-0167	Process Sample without giving test trial value (This is applicable for 1 or all test)
* TC-PRO-SAM-0168	One Key Test Process Other All Non Key Tests are New Status Check the Sample Status also NEW
* TC-PRO-SAM-0169	All Key Test are Process and All Non Key Test New Status Check the Sample Status also NEW
* TC-PRO-SAM-0170	All Key Tests are New and one Non Key test are Process Check the Sample Status also NEW
* TC-PRO-SAM-0171	All Key Tests are New and All Non Key test are Process Check the Sample Status also NEW
* TC-PRO-SAM-0172	One Key Test Process Other All Non Key Tests are Process Status Check the Sample Status also NEW
* TC-PRO-SAM-0173	All Key test are New And All Non Key Test are Process Check the Sample Status also NEW
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;

public class InProcessSampleNewStatus extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();

//***********************Sample Status Verification***************************************
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0166",
				InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch,
				InprocessSamplePage.InproAfterSearch);
	}
}
