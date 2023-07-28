//*************************************************************************************************
//* Description
//*------------
//* Production Sample Fail Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0190   01/05/2023   Priyanka     Orginal Version
//*  TC-PRODUCT-SAM-0191
//*  TC-PRODUCT-SAM-0192
//*  TC-PRODUCT-SAM-0193
//*  TC-PRODUCT-SAM-0194
//*  TC-PRODUCT-SAM-0195
//*  TC-PRODUCT-SAM-0196
//*  TC-PRODUCT-SAM-0197
//*  TC-PRODUCT-SAM-0198
//*  TC-PRODUCT-SAM-0199
//*  TC-PRODUCT-SAM-0200
//*  TC-PRODUCT-SAM-0201
//*  TC-PRODUCT-SAM-0202
//*  TC-PRODUCT-SAM-0203
//*  TC-PRODUCT-SAM-0204
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class FailStatusProductionSample extends DriverIntialization {

	static ProductionSamplePage productionSample = new ProductionSamplePage();
	static PlantLabTrailSamplePage plantlabTrailSample = new PlantLabTrailSamplePage();

	@Test

	public static void ProductionSampleFailStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, productionSample);
		PageFactory.initElements(driver, plantlabTrailSample);

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

		SampleActionMethods.clicking(SampleNavigationPage.productionSampleXpath(), 2,
				"STEP 3 - CHECKING INPROCESS SAMPLE BUTTON");

		Thread.sleep(2000);

		SampleStatus.sampleStatus("Samples Module", "Production Sample", "TC-PRO-SAM-0190",
				ProductionSamplePage.statusColumn, 1, 19, 18, ProductionSamplePage.productionKeyBefore,
				ProductionSamplePage.productionKeyAfter);

		Logout.LogoutFunction();

	}

}
