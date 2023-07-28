/***********************************************************************************
* Description
*------------
*"Plant Lab Trial Sample" Sub Menu Button Functionality
***********************************************************************************
*
* Author           : Karunya Navanesan
* Date Written     : 08/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0004      08/05/2023    Karunya    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PlantTrialSamplesubmenuButtonfunctionality extends DriverIntialization {

	 static  PlantLabTrailSamplePage pts = new PlantLabTrailSamplePage();
	
	
	 @Test
	 public static void planttrialSamplesSubmenuButton() throws InterruptedException, IOException {
		 
         LoginTest.Login();
		 
         SampleNavigateTest.sampleNavigation();
		 
		 SampleNavigateTest.finishProductSampleMainNavigation();
		 
		 PlantTrialSamplesubmenuButtonfunctionality.planttrialSamplesSubmenuButtonfunction();
		 
		
	}
	
	 public static void planttrialSamplesSubmenuButtonfunction() throws InterruptedException {
		 
//****************************************************************************************
//	     	STEP-01--PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS DISPLAYED &	STEP-02--PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS ENABLED
//****************************************************************************************		
			 
			 PageFactory.initElements(driver, pts);
			 Thread.sleep(3000);
			 PlantLabTrailSamplePage.finishproductsamplesbutton.click();
			 
			 
			 if ( PlantLabTrailSamplePage.plantlabTrialsamplesubmenubutton.isDisplayed()) {
					testCase = extent.createTest("STEP-01--PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");

					if ( PlantLabTrailSamplePage.plantlabTrialsamplesubmenubutton.isEnabled()) {
						testCase = extent.createTest("STEP-02--PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						 PlantLabTrailSamplePage.plantlabTrialsamplesubmenubutton.click();

					} else {
						testCase = extent.createTest("STEP-02-PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS NOT ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("STEP-01--PLANT LAB TRIAL SAMPLES SUB MENU BUTTON IS NOT DISPLAYED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			 
			
			  //LOGOUT
		      Logout.LogoutFunction();
		}

		
	}
	 

