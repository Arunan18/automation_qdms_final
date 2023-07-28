
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST NEW STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   04:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0233    	   04:05:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0234
//* TC-PRO-SAM-0235
//* TC-PRO-SAM-0236
//* TC-PRO-SAM-0237
//* TC-PRO-SAM-0238
//* TC-PRO-SAM-0239
//* TC-PRO-SAM-0240
//****************************************************************************************************************

/*
* TC-PRO-SAM-0233	All Tests are New Status Check the Sample Status also NEW
* TC-PRO-SAM-0234	Incoming Sample without giving test trial value (this is applicable for 1 or all test)
* TC-PRO-SAM-0235	One Key Test Process Other All Non Key Tests are New Status Check the Sample Status also NEW
* TC-PRO-SAM-0236	All Key Test are Process and All Non Key Test New Status Check the Sample Status also NEW
* TC-PRO-SAM-0237	All Key Tests are New and one Non Key test are Process Check the Sample Status also NEW
* TC-PRO-SAM-0238	All Key Tests are New and All Non Key test are Process Check the Sample Status also NEW
* TC-PRO-SAM-0239	One Key Test Process Other All Non Key Tests are Process Status Check the Sample Status also NEW
* TC-PRO-SAM-0240	All Key test are New And All Non Key Test are Process Check the Sample Status also NEW
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InProcessSampleNewSamplekeytestFunction extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// **********************************************Login Method********************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// *******************************************Reach In-Process Sample**************************

		AddInprocessSampleTest.SampleMainMethod();

//****************************************Key Test Method******************************************		
		SampleKeyTest.keyTest("Samples Module", "Process Sample", "TC-PRO-SAM-0233",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 20, 16, 18);

		MultiSearchMethods.Logout();
	}

}
