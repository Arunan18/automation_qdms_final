//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST NEW STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   01:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0166	 	 28:04:2023     @SASIKALA     Original Version
//* 
//*****************************************************************************************

/*
* Process Sample All test should be in a New status - TC-PRO-SAM-0166
*/


package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;

public class ProcessSampleNewStatusTCSAM0166 extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();
	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();
		
//***********************Sample Status Verification***************************************
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0166", InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch, InprocessSamplePage.InproAfterSearch);
	}

}
