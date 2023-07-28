//***********************************************************************************
//* Description
//*------------
//* SINGLESEARCH- SAMPLECODE FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 20/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0061   20/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0063
//TC-P-LAB-SAM-0065
//TC-P-LAB-SAM-0067
//************************************************************************************


package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.Keys;
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

public class SampleCodeFieldSearchTest extends DriverIntialization {
	
	
	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleSingleSearchMethods singlesearch = new SampleSingleSearchMethods();
	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();

	
	static boolean SamplecodeTabledata = true;
	public static int counts = 0;

	@Test

	public static void SamplecodeFieldTest() throws InterruptedException, IOException {

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
		PlantFieldSearchMethods.Beforecountcheck("STEP 5");
		
		driver.navigate().refresh();
		
		PlantLabTrailSamplePage.tableContainer.click();
		//SCROLL TO RIGHT ARROW
		
		ScrollRight.scroll(4);
		
		// COMMEN METHOD FOR SINGLE SEARCH
		SampleSingleSearchMethods.singleSearch(labtrailpage.Samplecodesearchicon, labtrailpage.SamplecodesearchTextbox,
				labtrailpage.PlantfieldsearchButton, "Plant Lab Trail Sample-SamplecodeField", "Samples Module",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0061", 1, 2, labtrailpage.columnSamplecode,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[5]", SamplecodeTabledata);

		// CHECK RESET BUTTON
		Thread.sleep(3000);	
		action.clicking(labtrailpage.ResetbuttonPlantfieldsearch, 2000, "STEP 6:CHECK PLANT FIELD RESET BUTTON ");
		// ResetButtonCheckMethods.resetbutton("STEP 6:", "STEP 7:");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		PlantFieldSearchMethods.aftercountcheck("STEP 7:");

		// REFRESH THE PAGE
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}







}
