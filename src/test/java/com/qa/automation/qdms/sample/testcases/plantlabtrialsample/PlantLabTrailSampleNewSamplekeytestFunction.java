
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PLANT LAB TRAIL SAMPLE ALL TEST NEW STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   08:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-P-LAB-SAM-0163       08:05:2023     @SASIKALA     Original Version
//* TC-P-LAB-SAM-0164
//* TC-P-LAB-SAM-0165
//* TC-P-LAB-SAM-0166
//* TC-P-LAB-SAM-0167
//* TC-P-LAB-SAM-0168
//* TC-P-LAB-SAM-0169
//* TC-P-LAB-SAM-0170
//* TC-P-LAB-SAM-0171
//****************************************************************************************************************

/*
* TC-P-LAB-SAM-0164	All Tests are New Status Check the Sample Status also NEW
* TC-P-LAB-SAM-0165	Incoming Sample without giving test trial value (this is applicable for 1 or all test)
* TC-P-LAB-SAM-0166	One Key Test Process Other All Non Key Tests are New Status Check the Sample Status also NEW
* TC-P-LAB-SAM-0167	All Key Test are Process and All Non Key Test New Status Check the Sample Status also NEW
* TC-P-LAB-SAM-0168	All Key Tests are New and one Non Key test are Process Check the Sample Status also NEW
* TC-P-LAB-SAM-0169	All Key Tests are New and All Non Key test are Process Check the Sample Status also NEW
* TC-P-LAB-SAM-0170	One Key Test Process Other All Non Key Tests are Process Status Check the Sample Status also NEW
* TC-P-LAB-SAM-0171	All Key test are New And All Non Key Test are Process Check the Sample Status also NEW
*/


package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class PlantLabTrailSampleNewSamplekeytestFunction extends DriverIntialization{
	static PlantLabTrailSamplePage LabTrailPage = new PlantLabTrailSamplePage();
	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		boolean contnue=false;
		PageFactory.initElements(driver, LabTrailPage);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);

// ***************************Login Method*************************

		try {
			LoginTest.Login();
			contnue=true;
		} catch (Exception e) {
			contnue=false;
		}
		if (LoginTest.login) {
			// CHECK SAMPLE MODULE
			SampleActionMethods.clicking(SampleNavigationPage.sampleXpath, 2, "STEP 1:CHECK SAMPLE MODULE");
			// CHECK FINISH PRODUCT SAMPLE
			SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath, 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");
			// CHECK PLANT LABTRAILSAMPLE
			SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath, 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");
			
			
			try {
				PlantLabTrailSamplePage.tableContainer.click();
			} catch (Exception e) {
			}
			try {
				ScrollRight.scroll(4);
			} catch (Exception e) {
			}
			// ******************************Key Test Method***********************************************
			SampleKeyTest.keyTest("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0163",
					driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[4]")), 4, 14, 10, 8);
		}
		
		
		if (contnue==true) {
			MultiSearchMethods.Logout();
		}
	
	}
}