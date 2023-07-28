
	
	//***********************************************************************************
	//* Description
	//*------------
	//* DELETE FUCNTIONALITY AFTER DEPEND IN PLANT LAB TRAIL SAMPLE 
	//***********************************************************************************
	//*
	//* Author           : NILUXY KRISHNATHAVAM
	//* Date Written     : 20/04/2023
	//* 
	//* 
	//* Test Case Number       Date         Intial        Comments
	//* ================       ====         =====        ========
	//*TC-P-LAB-SAM-0016   20/04/2023   NILUXY.K    Orginal Version
	//************************************************************************************

	package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

	import java.io.IOException;

	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.qa.automation.qdms.base.DriverIntialization;
	import com.qa.automation.qdms.commonmethods.Logout;
	import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
	import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
	import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
	import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
	import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
	import com.qa.automation.qdms.testcases.login.LoginTest;

	public class DeleteFunctionAfterDepend extends DriverIntialization {

		static SampleActionMethods action = new SampleActionMethods();
		static SampleNavigationPage page = new SampleNavigationPage();
		static SampleSingleSearchMethods singlesearch = new SampleSingleSearchMethods();
		//static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();

		static DeleteFunctionMethod deletemethod = new DeleteFunctionMethod();

		@Test

		public static void FinishedProductFieldTest() throws InterruptedException, IOException {

			PageFactory.initElements(driver, action);
			PageFactory.initElements(driver, page);
			//PageFactory.initElements(driver, labtrailpage);

			// LOGIN TO THE SYSTEM
			LoginTest.Login();
			Thread.sleep(2000);

			// CHECK SAMPLE MODULE
			action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

			// CHECK FINISH PRODUCT SAMPLE
			action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

			// CHECK PLANT LABTRAILSAMPLE
			action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");

			
			DeleteFunctionMethod.deleteonstadependstatus();
			
			Thread.sleep(2000);
			// CONFIRM THE DATA HAS ADDED OR NOT IN TABLE
			DeleteFunctionMethod.deletematerialstateConfirm();
				
			// LOGOUT TO THE SYSTEM
			Logout.LogoutFunction();

		}
	}


