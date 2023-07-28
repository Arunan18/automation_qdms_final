
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PLANT LAB TRAIL NEW SAMPLE DIABLE / ENABLE CHECK METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   11:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-P-LAB-SAM-0155   	   11:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-P-LAB-SAM-0155	Check Disable Key Test Selection NEW status in sample Key Test 
*/

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCheckEnableDisableKeyTest;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class KeySelectionNewSampleMethodDisable extends DriverIntialization {
	static PlantLabTrailSamplePage Plantpg = new PlantLabTrailSamplePage();

	@Test
	public static void EnableDisableKey() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Plantpg);

		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.finishProductSampleMainNavigation();

		// PLANT LAB TRAIL SAMPLE NAVIGATION
		SampleNavigateTest.labTrialSampleNavigation();

		// SCROLL BAR
		PlantLabTrailSamplePage.tableContainer.click();
		ScrollRight.scroll(3);

		// COMMON METHOD CALLING ENABLE / DISABLE
		SampleCheckEnableDisableKeyTest.CheckEnableDisableKeyMethod("Samples Module", "Plant Lab Trial Sample",
				"TC-P-LAB-SAM-0155", 4, 14, 10);

		// PAGE REFRESH
		driver.navigate().refresh();

		// LOGOUT
		MultiSearchMethods.Logout();
	}
}
