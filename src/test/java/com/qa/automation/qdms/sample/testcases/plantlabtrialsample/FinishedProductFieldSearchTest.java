
//***********************************************************************************
//* Description
//*------------
//* SINGLESEARCH- FINISHED PRODUCT FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 19/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0034   19/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0036
//TC-P-LAB-SAM-0038
//TC-P-LAB-SAM-0040
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class FinishedProductFieldSearchTest extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleSingleSearchMethods singlesearch = new SampleSingleSearchMethods();
	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();

	static boolean finishproductTabledata = true;
	public static int counts = 0;

	@Test

	public static void FinishedProductFieldTest() throws InterruptedException, IOException {

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
		SampleSingleSearchMethods.singleSearch(labtrailpage.Finisheproductsearchicon,
				labtrailpage.FinisheproductsearchTextbox, labtrailpage.PlantfieldsearchButton,
				"Plant Lab Trail Sample-FinishedField", "Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0034",
				1, 2, labtrailpage.column, "//tbody[@class='ant-table-tbody']/tr[", "]/td[2]", finishproductTabledata);


		// CHECK RESET BUTTON
		Thread.sleep(2000);
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
