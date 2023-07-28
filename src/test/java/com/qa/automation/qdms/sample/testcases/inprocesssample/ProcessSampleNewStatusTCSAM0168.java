
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST NEW STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   28:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0168    	 28:04:2023     @SASIKALA     Original Version
//* 
//*****************************************************************************************

/*
* One Key Test Process Other All Non Key Tests are New Status Check the Sample Status also NEW - TC-PRO-SAM-0168
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;

public class ProcessSampleNewStatusTCSAM0168 extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();

//***********************Sample Status Verification***************************************
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0168",
				InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch,
				InprocessSamplePage.InproAfterSearch);
	}

}
