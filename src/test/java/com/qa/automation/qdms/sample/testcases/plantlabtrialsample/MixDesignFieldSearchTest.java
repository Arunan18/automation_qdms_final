
//***********************************************************************************
//* Description
//*------------
//* SINGLESEARCH- MIX DESIGN FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 19/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0043   19/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0045
//TC-P-LAB-SAM-0047
//TC-P-LAB-SAM-0049
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MixDesignFieldSearchTest extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleSingleSearchMethods singlesearch = new SampleSingleSearchMethods();
	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();

	static boolean MixDesignTabledata = true;
	public static int counts = 0;

	@Test

	public static void MixedFieldTest() throws InterruptedException, IOException {

		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, labtrailpage);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);

		// CHECK SAMPLE MODULE
		action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

		// CHECK FINISH PRODUCT SAMPLE
		action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

		// CHECK PLANT LABTRAILSAMPLE
		action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");

		
		// CHECK THE DATA COUNT IN TABLE BEFORE RESET
				PlantFieldSearchMethods.Beforecountcheck("STEP 4");

				driver.navigate().refresh();
		// COMMEN METHOD FOR SINGLE SEARCH
		SampleSingleSearchMethods.singleSearch(labtrailpage.MixedDesignSearchicon, labtrailpage.MixedDesignSearchTextbox,
				labtrailpage.PlantfieldsearchButton, "Plant Lab Trail Sample-MixDesignField", "Samples Module",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0043", 1, 2, labtrailpage.columnMD,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[3]", MixDesignTabledata);


		// CHECK RESET BUTTON
		Thread.sleep(3000);	
		action.clicking(labtrailpage.ResetbuttonPlantfieldsearch, 2000, "STEP 6:CHECK PLANT FIELD RESET BUTTON ");
		// ResetButtonCheckMethods.resetbutton("STEP 6:", "STEP 7:");

		// REFRESH THE PAGE
		driver.navigate().refresh();
		Thread.sleep(2000);

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		PlantFieldSearchMethods.aftercountcheck("STEP 7:");

		// REFRESH THE PAGE
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
