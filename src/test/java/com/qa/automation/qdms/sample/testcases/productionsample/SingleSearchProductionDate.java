//*************************************************************************************************
//* Description
//*------------
//* Production Sample Production Date Field Single Search
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0122 27/04/2023   Priyanka     Orginal Version
//*  TC-PRODUCT-SAM-0124         
//*  TC-PRODUCT-SAM-0126
//*  TC-PRODUCT-SAM-0128
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantFieldSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SingleSearchProductionDate extends DriverIntialization {

	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleActionMethods action = new SampleActionMethods();
	static PlantLabTrailSamplePage plantlabpage = new PlantLabTrailSamplePage();
	static ProductionSamplePage pspage = new ProductionSamplePage();

	static boolean productiondate = true;

	@Test
	public static void ProDateFieldSingleSearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, plantlabpage);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, pspage);

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
				"STEP 2 - CHECKING FINISH PRODUCT MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG PRODUCTION SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// PRODUCTION SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.productionSampleXpath(), 2,
				"STEP 3 - CHECKING PRODUCTION SAMPLE BUTTON");

		// **********************************************************************************
		// STEP-04 CHECKNIG BEFORE COUNT
		// **********************************************************************************

		PlantFieldSearchMethods.Beforecountcheck("STEP -04 CHECKING BEFORE COUNT");
		// driver.navigate().refresh();

		PlantLabTrailSamplePage.tableContainer.click();

		ScrollRight.scroll(11);

		// **********************************************************************************
		// STEP-05 - SINGLE SEARCH FOR PLANT FIELD
		// **********************************************************************************
		Thread.sleep(3000);
		extent.createTest("STEP-05 - SINGLE SEARCH FOR PLANT FIELD");

		SampleSingleSearchMethods.singleSearch(ProductionSamplePage.PDsearchicon, ProductionSamplePage.PDsearchtextbox,
				ProductionSamplePage.PDsearchbutton, "Production Sample- Plant Field", "Samples Module",
				"Production Sample", "TC-PRODUCT-SAM-0122", 1, 2, ProductionSamplePage.colummPD,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[12]", productiondate);

		// **********************************************************************************
		// STEP-06 CHECKNIG RESET BUTTON IS DISPLAYED && STEP-06 CHECKNIG
		// RESET BUTTON IS ENABLED
		// **********************************************************************************
		Thread.sleep(3000);
		SampleActionMethods.clicking(ProductionSamplePage.PDResetbutton, 2, "STEP-06 CHECKING RESET BUTTON");

		// **********************************************************************************
		// STEP-07 CHECKING AFTER COUNT
		// **********************************************************************************

		PlantFieldSearchMethods.aftercountcheck("STEP 07");

		Logout.LogoutFunction();

	}

}
