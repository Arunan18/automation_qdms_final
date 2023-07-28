//***********************************************************************************
//* Description
//*------------
//* SINGLESEARCH- EQUIPMENT FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 20/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0052   20/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0054
//TC-P-LAB-SAM-0056
//TC-P-LAB-SAM-0058
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class FinishproductSampleFieldSearchTest extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleSingleSearchMethods singlesearch = new SampleSingleSearchMethods();
	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
//	static Actions actions = new Actions(driver);

	static boolean FinishproductsampleTabledata = true;
	public static int counts = 0;

	@Test

	public static void EquipmentdTest() throws InterruptedException, IOException {

		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, labtrailpage);
//		PageFactory.initElements(driver, actions);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);

		// CHECK SAMPLE MODULE
		action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

		// CHECK FINISH PRODUCT SAMPLE
		action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

		// CHECK PLANT LABTRAILSAMPLE
		action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		PlantFieldSearchMethods.Beforecountcheck("STEP 5");

		// REFRESH THE PAGE
		driver.navigate().refresh();
		Thread.sleep(2000);

		PlantLabTrailSamplePage.tableContainer.click();
		// SCROLL TO RIGHT ARROW

		ScrollRight.scroll(4);
		// COMMEN METHOD FOR SINGLE SEARCH
		SampleSingleSearchMethods.singleSearch(labtrailpage.FPSAMPLESearchIcon, labtrailpage.FPSAMPLESearchTextbox,
				labtrailpage.PlantfieldsearchButton, "Plant Lab Trail Sample-FinishproductSampleField",
				"Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0052", 1, 2,
				labtrailpage.columnFinishproductsample, "//tbody[@class='ant-table-tbody']/tr[", "]/td[4]",
				FinishproductsampleTabledata);

		// CHECK RESET BUTTON
		Thread.sleep(2000);
		action.clicking(labtrailpage.ResetbuttonPlantfieldsearch, 2, "STEP 6:CHECK PLANT FIELD RESET BUTTON ");
		// ResetButtonCheckMethods.resetbutton("STEP 6:", "STEP 7:");

		 driver.navigate().refresh();
		
		 // CHECK THE DATA COUNT IN TABLE AFTER RESET
		PlantFieldSearchMethods.aftercountcheck("STEP 7:");


		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
