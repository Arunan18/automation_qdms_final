
//****************************************************************************************
//		DESCRIPTION
//------------------
//				PRODUCTION SAMPLE ALL TEST FAIL STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   04:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRODUCT-SAM-0267    	04:05:2023     @SASIKALA     Original Version
//* TC-PRODUCT-SAM-0268
//* TC-PRODUCT-SAM-0269
//* TC-PRODUCT-SAM-0270
//* TC-PRODUCT-SAM-0271
//* TC-PRODUCT-SAM-0272
//* TC-PRODUCT-SAM-0273
//* TC-PRODUCT-SAM-0274
//* TC-PRODUCT-SAM-0275
//* TC-PRODUCT-SAM-0276
//* TC-PRODUCT-SAM-0277
//* TC-PRODUCT-SAM-0278
//* TC-PRODUCT-SAM-0279
//* TC-PRODUCT-SAM-0280
//* TC-PRODUCT-SAM-0281
//* TC-PRODUCT-SAM-0282
//****************************************************************************************************************

/*
* TC-PRODUCT-SAM-0267	One Key Test  FAIL and ALL Non Key Test New Check the Sample Status FAIL
* TC-PRODUCT-SAM-0268	ALL Key Test  FAIL and ALL Non Key Test New Check the Sample Status FAIL
* TC-PRODUCT-SAM-0269	One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0270	All Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0271	One Key Test FAIL and Only One Non Key Test PASS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0272	All Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0273	One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
* TC-PRODUCT-SAM-0274	All Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-PRODUCT-SAM-0275	Only One Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-PRODUCT-SAM-0276	Only One Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0277	Only One Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0278	Only One Key Test FAIL and All Non Key Test FAIL Check the Sample Status FAIL
* TC-PRODUCT-SAM-0279	Only One Key Test FAIL and All Non Key Test NEW Check the Sample Status FAIL
* TC-PRODUCT-SAM-0280	Only One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-PRODUCT-SAM-0281	Only One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
*/

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class ProductionSampleFAILSamplekeytestFunction extends DriverIntialization {
	static ProductionSamplePage Productionsample = new ProductionSamplePage();

	@Test

	public static void IncomingSampleNewStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Productionsample);

//*********************Login Method*********************************
		LoginTest.Login();

// ***CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE BUTTON IS ENABLED***************
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

//****CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH PRODUCT MENU IS ENABLED********************************
		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 2,
				"STEP 2 - CHECKING FINISH PRODUCT MENU");

//*****CHECKNIG PRODUCTION SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG BUTTON IS ENABLED***********************
		SampleActionMethods.clicking(SampleNavigationPage.productionSampleXpath(), 2,
				"STEP 3 - CHECKING PRODUCTION SAMPLE BUTTON");

//*********************************Sample Fail Key Status Check ***************************************
		SampleKeyTest.keyTest("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0267",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 24, 19, 18);

		
		MultiSearchMethods.Logout();
	}
}
