//*************************************************************************************************
//* Description
//*------------
//* Production Sample Work Order No Field Single Search
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0095   26/04/2023   Priyanka     Orginal Version
//*  TC-PRODUCT-SAM-0097         
//*  TC-PRODUCT-SAM-0099
//*  TC-PRODUCT-SAM-0101
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

public class SingleSearchWorkOrderNo extends DriverIntialization {

	static SampleNavigationPage page = new SampleNavigationPage();
	static SampleActionMethods action = new SampleActionMethods();
	static PlantLabTrailSamplePage plantlabpage = new PlantLabTrailSamplePage();
	static ProductionSamplePage pspage = new ProductionSamplePage();

	static boolean creationdate = true;

	@Test
	public static void SampleDateFieldSingleSearch() throws InterruptedException, IOException {

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
		driver.navigate().refresh();

		PlantLabTrailSamplePage.tableContainer.click();

		ScrollRight.scroll(6);

		// **********************************************************************************
		// STEP-05 - SINGLE SEARCH FOR PLANT FIELD
		// **********************************************************************************
		Thread.sleep(3000);
		extent.createTest("STEP-05 - SINGLE SEARCH FOR PLANT FIELD");

		SampleSingleSearchMethods.singleSearch(ProductionSamplePage.WONsearchicon,
				ProductionSamplePage.WONsearchtextbox, ProductionSamplePage.WONsearchbutton,
				"Production Sample- Plant Field", "Samples Module", "Production Sample", "TC-PRODUCT-SAM-0095", 1, 2,
				ProductionSamplePage.colummWON, "//tbody[@class='ant-table-tbody']/tr[", "]/td[6]", creationdate);

		// **********************************************************************************
		// STEP-06 CHECKNIG RESET BUTTON IS DISPLAYED && STEP-06 CHECKNIG
		// RESET BUTTON IS ENABLED
		// **********************************************************************************
		Thread.sleep(3000);
		SampleActionMethods.clicking(ProductionSamplePage.WONResetbutton, 2, "STEP-06 CHECKING RESET BUTTON");

		driver.navigate().refresh();

		// **********************************************************************************
		// STEP-07 CHECKING AFTER COUNT
		// **********************************************************************************

		PlantFieldSearchMethods.aftercountcheck("STEP 07");

		Logout.LogoutFunction();

	}

}
