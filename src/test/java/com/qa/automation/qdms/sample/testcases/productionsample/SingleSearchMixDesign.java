//*************************************************************************************************
//* Description
//*------------
//* Production Sample MixDesign Field Single Search
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0041   25/04/2023   Priyanka     Orginal Version
//*  TC-PRODUCT-SAM-0043         
//*  TC-PRODUCT-SAM-0045
//*  TC-PRODUCT-SAM-0047
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

public class SingleSearchMixDesign extends DriverIntialization {

	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleActionMethods action = new SampleActionMethods();
	static PlantLabTrailSamplePage plantlabpage = new PlantLabTrailSamplePage();
	static ProductionSamplePage pspage = new ProductionSamplePage();
	// static ScrollRight scroll = new ScrollRight();

	static boolean mixdesign = true;

	@Test
	public static void MixdesignFieldSingleSearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, plantlabpage);
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, pspage);

		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 4, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 4,
				"STEP 2 - CHECKING FINISH PRODUCT MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG PRODUCTION SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// PRODUCTION SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.productionSampleXpath(), 4,
				"STEP 3 - CHECKING PRODUCTION SAMPLE BUTTON");

		// **********************************************************************************
		// STEP-04 CHECKNIG BEFORE COUNT
		// **********************************************************************************

		PlantFieldSearchMethods.Beforecountcheck("STEP -04 CHECKING BEFORE COUNT");

		PlantLabTrailSamplePage.tableContainer.click();

		ScrollRight.scroll(4);

		// **********************************************************************************
		// STEP-05 - SINGLE SEARCH FOR MIXDESIGN FIELD
		// **********************************************************************************

		extent.createTest("STEP-05 - SINGLE SEARCH FOR PLANT FIELD");

		SampleSingleSearchMethods.singleSearch(ProductionSamplePage.MDsearchicon, ProductionSamplePage.MDsearchtextbox,
				ProductionSamplePage.MDsearchbutton, "Plant Lab Trail Sample- Plant Field", "Samples Module",
				"Production Sample", "TC-PRODUCT-SAM-0041", 1, 2, ProductionSamplePage.colummplant,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[4]", mixdesign);

		// **********************************************************************************
		// STEP-06 CHECKNIG RESET BUTTON IS DISPLAYED && STEP-06 CHECKNIG
		// RESET BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(ProductionSamplePage.MDResetbutton, 4, "STEP-06 CHECKING RESET BUTTON");

		driver.navigate().refresh();

		// **********************************************************************************
		// STEP-07 CHECKING AFTER COUNT
		// **********************************************************************************

		PlantFieldSearchMethods.aftercountcheck("STEP 07");

		Logout.LogoutFunction();
	}

}
