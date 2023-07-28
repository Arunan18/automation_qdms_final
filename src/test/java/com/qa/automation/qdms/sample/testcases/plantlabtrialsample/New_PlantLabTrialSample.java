//***********************************************************************************
//* Description
//*------------
//* Key test new and various non key test status - Status
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 02/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0095     02/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {96,97,98,99,100,101,102,103}
//*
//************************************************************************************

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

public class New_PlantLabTrialSample extends DriverIntialization {

	static PlantLabTrailSamplePage PlantLabTriallSamplePg = new PlantLabTrailSamplePage();

	@Test

	public static void plantLabTrialTestNew() throws InterruptedException, IOException {

		PageFactory.initElements(driver, PlantLabTriallSamplePg);

		LoginTest.Login();

		// CHECKNIG SAMPLE MODULE IS DISPLAYED && CHECKNIG SAMPLE MODULE BUTTON IS
		// ENABLED
		// ---------------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, " CHECKING SAMPLE MODULE");

		// CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && CHECKNIG FINISH PRODUCT MENU IS
		// ENABLED
		// ------------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 20,
				" CHECKING FINISH PRODUCT MENU");

		// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && CHECKNIG PLANT LAB
		// TRIAL SAMPLE BUTTON IS ENABLED
		// -----------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 20,
				" CHECKING PLANT LAB TRIAL SAMPLE BUTTON");

//	CHECKING THE STATUS OF NEW TEST
//	--------------------------------	

		Thread.sleep(5000);
		SampleStatus.sampleStatus("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0095",
				PlantLabTrailSamplePage.statusColumn, 4, 10, 8, PlantLabTrailSamplePage.labtrailBeforepath,
				PlantLabTrailSamplePage.labtrailAfterpath);
		
//		LOGOUT
//		-------

		MultiSearchMethods.Logout();

	}

}
