
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS FAIL SAMPLE DIABLE / ENABLE CHECK METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0226   	   10:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-PRO-SAM-0226	Check Disable Key Test Selection FAIL status in sample Key Test  
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCheckEnableDisableKeyTest;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class KeySelectionFailSampleMethodDisable extends DriverIntialization {
	static InprocessSamplePage Inpropg = new InprocessSamplePage();

	@Test
	public static void EnableDisableKey() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Inpropg);

		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.inprocessSampleNavigation();

		// COMMON METHOD CALLING ENABLE / DISABLE
		SampleCheckEnableDisableKeyTest.CheckEnableDisableKeyMethod("Samples Module", "Process Sample",
				"TC-PRO-SAM-0226", 1, 20, 16);

		// PAGE REFRESH
		driver.navigate().refresh();

		// LOGOUT
		MultiSearchMethods.Logout();
	}
}
