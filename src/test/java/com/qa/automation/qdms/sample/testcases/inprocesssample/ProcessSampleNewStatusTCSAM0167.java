
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST NEW STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   28:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0167	 	 28:04:2023     @SASIKALA     Original Version
//* 
//*****************************************************************************************

/*
* Process Sample without giving test trial value (this is applicable for 1 or all test) - TC-PRO-SAM-0167
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;

public class ProcessSampleNewStatusTCSAM0167 extends DriverIntialization{
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();
	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();
		
//***********************Sample Status Verification***************************************
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0167", InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch, InprocessSamplePage.InproAfterSearch);
	}

}
