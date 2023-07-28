//***********************************************************************************
//* Description
//*------------
//* CANCEL PLANT LAB TRAIL SAMPLE FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/04/2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0010   17/04/2023   NILUXY.K    Orginal Version

//
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class CancelLabTrailSampleTest extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();
	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
	// static AddLabTrailSampleMethods methods = new AddLabTrailSampleMethods();

	@Test
	public static void plantlabtrail() throws InterruptedException, IOException {
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, labtrailpage);
		// PageFactory.initElements(driver, methods);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(3000);

		// CHECK SAMPLE MODULE
		action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

		// CHECK FINISH PRODUCT SAMPLE
		action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

		// CHECK PLANT LABTRAILSAMPLE
		action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");

		// CHECK ADD PLANT LAB TRAIL SAMPLE
		action.clicking(labtrailpage.AddPlantTrailSample, 2000, "STEP 4:CHECK ADD PLANT-LAB TRAIL SAMPLE");

		// TAKES THE DATA FROM THE EXCEL
		CancelLabTrailSamplemethod.excelselection();

//		// CHECK CANCEL BUTTON FUCNTIONALITY	
		CancelLabTrailSamplemethod.CancelMaterialbutton();
		//action.clicking(labtrailpage.Cancelbutton, 2, "STEP 6:CHECK CANCEL BUTTON FUCNTIONALITY");

		// CHECK THE DATA HAS COME IN FIRST ROW
		CancelLabTrailSamplemethod.checkLastAddvalue();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}