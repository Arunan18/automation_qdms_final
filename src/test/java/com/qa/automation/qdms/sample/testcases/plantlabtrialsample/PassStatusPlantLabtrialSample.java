//*************************************************************************************************
//* Description
//*------------
//* Plant Lab Trial Sample Pass Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0128    01/05/2023   Priyanka     Orginal Version
//*  TC-P-LAB-SAM-0129
//*  TC-P-LAB-SAM-0130
//*  TC-P-LAB-SAM-0131
//*  TC-P-LAB-SAM-0132
//*  TC-P-LAB-SAM-0133
//*  TC-P-LAB-SAM-0134
//*  TC-P-LAB-SAM-0135
//*  TC-P-LAB-SAM-0136
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PassStatusPlantLabtrialSample extends DriverIntialization {

	static PlantLabTrailSamplePage plantLabTrialSample = new PlantLabTrailSamplePage();

	@Test

	public static void IncomingSampleNewStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, plantLabTrialSample);

		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 2,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG INCOMING SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// INCOMING SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 2,
				"STEP 3 - CHECKING INPROCESS SAMPLE BUTTON");

		Thread.sleep(2000);

		PlantLabTrailSamplePage.tableContainer.click();

		ScrollRight.scroll(3);

		SampleStatus.sampleStatus("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0128",
				PlantLabTrailSamplePage.statusColumn, 4, 10, 8, PlantLabTrailSamplePage.plantLabKeyBefore,
				PlantLabTrailSamplePage.plantLabKeyAfter);
		
		Logout.LogoutFunction();

	}

}
