//*************************************************************************************************
//* Description
//*------------
//* Plant Lab Trial Sample Single Trial Test
//*************************************************************************************************
//*
//* Author           : S.Sayanthan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0226       16/05/2023    Sayanthan    Orginal Version
//
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.TestStatus;
import com.qa.automation.qdms.sample.commonmethods.TrailsTestFinishProduct;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SingleTrialPlantLabTrialSample extends DriverIntialization {
	
	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	
	@Test
	
	public static void singleTrial() throws InterruptedException, IOException {
		
		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 20,
				"STEP 2 - CHECKING FINISH PRODUCT MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// PLANT LAB TRIAL SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 20,
				"STEP 3 - CHECKING PLANT LAB TRIAL SAMPLE BUTTON");

//  MULTI TRIAL TEST
//	-----------------	
		
		 TrailsTestFinishProduct.trailsTest("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0226",
					driver.findElement(By.xpath("//div[@class='ant-table-container']")), 7);
	Logout.LogoutFunction();
			
		
		
		
	}
	

}
