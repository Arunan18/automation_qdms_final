/***********************************************************************************
* Description
*------------
*"Finish Product Sample" Main Menu Functionality
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 08/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0002      08/05/2023    Karunya    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class FinishproductSamplesMainmenuFunctionality extends DriverIntialization {
	
	 static  PlantLabTrailSamplePage pts = new PlantLabTrailSamplePage();
	
	
	 @Test
	public static void finishproductMainmenu() throws InterruptedException, IOException {
		
		 LoginTest.Login();
		 
         SampleNavigateTest.sampleNavigation();
		 
		 SampleNavigateTest.finishProductSampleMainNavigation();
		 
		 FinishproductSamplesMainmenuFunctionality.finishproductMainmenubutton();
		
	}
	
	public static void finishproductMainmenubutton() throws InterruptedException {
		
//****************************************************************************************
//     	STEP-01--FINISH PRODUCT SAMPLES BUTTON IS DISPLAYED &	STEP-02--FINISH PRODUCT SAMPLES BUTTON IS ENABLED
//****************************************************************************************		
		 
		 PageFactory.initElements(driver, pts);
		 Thread.sleep(3000);
		
		 
		 if ( PlantLabTrailSamplePage.finishproductsamplesbutton.isDisplayed()) {
				testCase = extent.createTest("STEP-01--FINISH PRODUCT SAMPLES BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if ( PlantLabTrailSamplePage.finishproductsamplesbutton.isEnabled()) {
					testCase = extent.createTest("STEP-02--FINISH PRODUCT SAMPLES BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					 PlantLabTrailSamplePage.finishproductsamplesbutton.click();

				} else {
					testCase = extent.createTest("STEP-02-FINISH PRODUCT SAMPLES BUTTON IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--FINISH PRODUCT SAMPLES BUTTON IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		 
       //LOGOUT
      Logout.LogoutFunction();
		
	}

}
