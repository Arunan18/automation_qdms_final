
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PRODUCTION SAMPLE ALL TEST PASS STATUS FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   02:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRODUCT-SAM-0180  	 02:05:2023     @SASIKALA     Original Version
//* TC-PRODUCT-SAM-0181
//* TC-PRODUCT-SAM-0182
//* TC-PRODUCT-SAM-0183
//* TC-PRODUCT-SAM-0184
//* TC-PRODUCT-SAM-0185
//* TC-PRODUCT-SAM-0186
//* TC-PRODUCT-SAM-0187
//* TC-PRODUCT-SAM-0188
//*****************************************************************************************

/*
* TC-PRODUCT-SAM-0180	All Key Test are Pass and One Non Key Test New Check the Sample Status PASS
* TC-PRODUCT-SAM-0181	All Key Test are Pass and All Non Key Test New Check the Sample Status PASS
* TC-PRODUCT-SAM-0182	All Key Test are Pass and One Non Key Test Process Check the Sample Status PASS
* TC-PRODUCT-SAM-0183	All Key Test are Pass and All Non Key Test Process Check the Sample Status PASS
* TC-PRODUCT-SAM-0184	All Key Test are Pass and One Non Key Test Pass Check the Sample Status PASS
* TC-PRODUCT-SAM-0185	All Key Test are Pass and All Non Key Test Pass Check the Sample Status PASS
* TC-PRODUCT-SAM-0186	All Key Test are Pass and One Non Key Test Fail Check the Sample Status PASS
* TC-PRODUCT-SAM-0187	All Key Test are Pass and All Non Key Test Fail Check the Sample Status PASS
* TC-PRODUCT-SAM-0188	All Key Test are pass and no any non key test Check the sample Status PASS
*/

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSamplePassStatus extends DriverIntialization {
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

//*********************************Sample Pass Status Check *******************************
		SampleStatus.sampleStatus("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0180",
				ProductionSamplePage.StatusColumn, 1, 19, 18, ProductionSamplePage.proBeforeSearch,
				ProductionSamplePage.proAfterSearch);

	}

}
