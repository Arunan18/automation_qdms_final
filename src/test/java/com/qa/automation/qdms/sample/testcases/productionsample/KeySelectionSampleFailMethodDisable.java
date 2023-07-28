
//****************************************************************************************
//		DESCRIPTION
//------------------
//					PRODUCTION FAIL SAMPLE DIABLE / ENABLE CHECK METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   11:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRODUCT-SAM-0208   	   11:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-PRODUCT-SAM-0208	Check Disable Key Test Selection FAIL status in sample Key Test 
*/

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCheckEnableDisableKeyTest;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class KeySelectionSampleFailMethodDisable extends DriverIntialization{
	static ProductionSamplePage productionpg = new ProductionSamplePage();

	@Test
	public static void EnableDisableKey() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionpg);

		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.finishProductSampleMainNavigation();

		// PRODUCTION SAMPLE NAVIGATION
		SampleNavigateTest.productionSampleNavigation();

		// COMMON METHOD CALLING ENABLE / DISABLE
		SampleCheckEnableDisableKeyTest.CheckEnableDisableKeyMethod("Samples Module", "Production Sample",
				"TC-PRODUCT-SAM-0208", 1, 24, 19);

		// PAGE REFRESH
		driver.navigate().refresh();

		// LOGOUT
		MultiSearchMethods.Logout();
	}

}
