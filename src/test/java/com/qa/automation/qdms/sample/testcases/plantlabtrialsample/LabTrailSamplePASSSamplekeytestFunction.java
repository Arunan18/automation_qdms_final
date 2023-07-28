
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PLANT LAB TRAIL SAMPLE ALL TEST PASS STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   04:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-P-LAB-SAM-0199    	   04:05:2023     @SASIKALA     Original Version
//* TC-P-LAB-SAM-0200
//* TC-P-LAB-SAM-0201
//* TC-P-LAB-SAM-0202
//* TC-P-LAB-SAM-0203
//* TC-P-LAB-SAM-0204
//* TC-P-LAB-SAM-0205
//* TC-P-LAB-SAM-0206
//* TC-P-LAB-SAM-0207
//****************************************************************************************************************

/*
* TC-P-LAB-SAM-0199	All Key Test are Pass and One Non Key Test New Check the Sample Status PASS
* TC-P-LAB-SAM-0200	All Key Test are Pass and All Non Key Test New Check the Sample Status PASS
* TC-P-LAB-SAM-0201	All Key Test are Pass and One Non Key Test Process Check the Sample Status PASS
* TC-P-LAB-SAM-0202	All Key Test are Pass and All Non Key Test Process Check the Sample Status PASS
* TC-P-LAB-SAM-0203	All Key Test are Pass and One Non Key Test Pass Check the Sample Status PASS
* TC-P-LAB-SAM-0204	All Key Test are Pass and All Non Key Test Pass Check the Sample Status PASS
* TC-P-LAB-SAM-0205	All Key Test are Pass and One Non Key Test Fail Check the Sample Status PASS
* TC-P-LAB-SAM-0206	All Key Test are Pass and All Non Key Test Fail Check the Sample Status PASS
* TC-P-LAB-SAM-0207	All Key Test are pass and no any non key test Check the sample Status PASS
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

public class LabTrailSamplePASSSamplekeytestFunction extends DriverIntialization {
	static PlantLabTrailSamplePage LabTrailPage = new PlantLabTrailSamplePage();
	static SampleActionMethods action = new SampleActionMethods();
	static SampleNavigationPage page = new SampleNavigationPage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, LabTrailPage);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, page);

// ***************************Login Method*************************

		LoginTest.Login();
		Thread.sleep(3000);

		// CHECK SAMPLE MODULE
		action.clicking(page.sampleXpath(), 2, "STEP 1:CHECK SAMPLE MODULE");

		// CHECK FINISH PRODUCT SAMPLE
		action.clicking(page.finishProductMainXpath(), 2, "STEP 2:CHECK FINISH PRODUCT SAMPLES");

		// CHECK PLANT LABTRAILSAMPLE
		action.clicking(page.labTrialSampleXpath(), 2, "STEP 3:CHECK PLANT-LAB TRAIL SAMPLE");
		PlantLabTrailSamplePage.tableContainer.click();
		ScrollRight.scroll(4);

// ******************************Key Test Method***********************************************
		SampleKeyTest.keyTest("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0199",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[4]")), 4, 14, 10, 8);

	}

}
