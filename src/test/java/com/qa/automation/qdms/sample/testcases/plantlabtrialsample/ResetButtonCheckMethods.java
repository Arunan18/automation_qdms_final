
//***********************************************************************************
//* Description
//*------------
//* RESET BUTTON CHECK -PLANT FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 19/04/2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM   19/04/2023   NILUXY.K    Orginal Version
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class ResetButtonCheckMethods extends DriverIntialization {
	
	static PlantLabTrailSamplePage labtrail = new PlantLabTrailSamplePage();
	
	public static void resetbutton(String colname , String colname1) throws InterruptedException, IOException {
		PageFactory.initElements(driver,labtrail);
			 
		 try {
		if (PlantLabTrailSamplePage.ResetbuttonPlantfieldsearch.isDisplayed()) {
			testCase = extent.createTest(colname +"RESET BUTTON IS VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
		
		if(PlantLabTrailSamplePage.ResetbuttonPlantfieldsearch.isEnabled()) {
			testCase = extent.createTest(colname1 +"RESET BUTTON IS ENABLED");
			testCase.log(Status.PASS, "TEST PASS");
			
			PlantLabTrailSamplePage.ResetbuttonPlantfieldsearch.click();
			
			}else {
				testCase = extent.createTest(colname1 + "RESET BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");	
				
			}
		}else{
   			testCase = extent.createTest(colname +"CHECKING RESET BUTTON IS VISIBLE ");
   			testCase.log(Status.PASS, "TEST FAIL");						
			
			}
		 }
	
	catch(Exception e)	{
		
	}
		 }
 
}		 
	


