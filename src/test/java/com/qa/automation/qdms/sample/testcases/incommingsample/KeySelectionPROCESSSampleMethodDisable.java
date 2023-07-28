
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-COMMING PROCESS SAMPLE DIABLE / ENABLE CHECK METHOD FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   09:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-INC-SAM-0234   	   09:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-INC-SAM-0234	Check Disable Key Test Selection PROCESS status in sample Key Test  
*/

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleCheckEnableDisableKeyTest;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class KeySelectionPROCESSSampleMethodDisable extends DriverIntialization {
	static IncomingSamplePage Incomepg = new IncomingSamplePage();

	@Test
	public static void EnableDisableKey() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Incomepg);

		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.incommingSampleNavigation();

		// COMMON METHOD CALLING ENABLE / DISABLE
		SampleCheckEnableDisableKeyTest.CheckEnableDisableKeyMethod("Samples Module", "Incoming Sample",
				"TC-INC-SAM-0233", 1, 22, 16);

		// PAGE REFRESH
		driver.navigate().refresh();

		// LOGOUT
		MultiSearchMethods.Logout();
	}
}
