
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PLANT LAB TRAIL SAMPLE ALL TEST IN PROCESS STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   01:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-P-LAB-SAM-0106  	 01:05:2023     @SASIKALA     Original Version
//* TC-P-LAB-SAM-0107
//* TC-P-LAB-SAM-0108
//* TC-P-LAB-SAM-0109
//* TC-P-LAB-SAM-0110
//* TC-P-LAB-SAM-0111
//* TC-P-LAB-SAM-0112
//* TC-P-LAB-SAM-0113
//* TC-P-LAB-SAM-0114
//* TC-P-LAB-SAM-0115
//* TC-P-LAB-SAM-0116
//* TC-P-LAB-SAM-0117
//* TC-P-LAB-SAM-0118
//* TC-P-LAB-SAM-0119
//* TC-P-LAB-SAM-0120
//* TC-P-LAB-SAM-0121
//* TC-P-LAB-SAM-0122
//* TC-P-LAB-SAM-0123
//* TC-P-LAB-SAM-0124
//* TC-P-LAB-SAM-0125
//* TC-P-LAB-SAM-0126
//*****************************************************************************************

/*
* TC-P-LAB-SAM-0106	 AtLeast completed one test (more than one test and more than one key test )
* TC-P-LAB-SAM-0107	 All Key Test are New and One non Key tests are Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0108	 All Key Test are New and All non Key tests are Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0109	 All Key Test are New and One non Key tests are Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0110	 All Key Test are New and All non Key tests are Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0111	 One Key Test are Process and One non Key tests are Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0112	 One Key Test are Process and All non Key tests are Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0113	 One Key Test are Process and One non Key tests are Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0114	 One Key Test are Process and All non Key tests are Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0115	 One Key Test are Pass and All non Key tests are New Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0116	 One Key Test are Pass and One non Key tests are New Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0117	 One Key Test are Pass and All non Key tests are Process Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0118	 One Key Test are Pass and All non Key tests are Pass Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0119	 One Key Test are Pass and One non Key tests are Pass Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0120	 One Key Test are Pass and All non Key tests are Fail Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0121	 One Key Test are Pass and One non Key tests are Fail Check the Sample Status also PROCESS (more than 1 key test)
* TC-P-LAB-SAM-0122	 All Key Test are Process and One non Key test Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0123	 All Key Test are Process and All non Key test Pass Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0124	 All Key Test are Process and One non Key test Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0125	 All Key Test are Process and All non Key test Fail Check the Sample Status also PROCESS
* TC-P-LAB-SAM-0126	 All Key Test are Process and All non Key test Fail Check the Sample Status also PROCESS
*/

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class PlantLabTrailSampleInProcessStatusCheck extends DriverIntialization {
	static PlantLabTrailSamplePage LabTrailPage = new PlantLabTrailSamplePage();
	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, LabTrailPage);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);

// ***************************Login Method*************************

		LoginTest.Login();
		Thread.sleep(3000);

		// CHECK SAMPLE MODULE
		action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

		// CHECK FINISH PRODUCT SAMPLE
		action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

		// CHECK PLANT LABTRAILSAMPLE
		action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");

//***********************Sample Status Verification***************************************
		SampleStatus.sampleStatus("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0106",
				PlantLabTrailSamplePage.StatusColumn, 4, 10, 8, PlantLabTrailSamplePage.labtrailBeforepath,
				PlantLabTrailSamplePage.labtrailAfterpath);
		
		MultiSearchMethods.Logout();
	}
}
