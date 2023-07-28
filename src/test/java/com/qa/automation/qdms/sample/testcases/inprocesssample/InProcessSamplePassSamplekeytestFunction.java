

//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ALL TEST PASS STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   08:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0267   	   08:05:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0268
//* TC-PRO-SAM-0269
//* TC-PRO-SAM-0270
//* TC-PRO-SAM-0271
//* TC-PRO-SAM-0272
//* TC-PRO-SAM-0273
//* TC-PRO-SAM-0274
//* TC-PRO-SAM-0275
//* TC-PRO-SAM-0276
//****************************************************************************************

/*
* TC-PRO-SAM-0267	PASS  -Sample key test (Select Key Test)
* TC-PRO-SAM-0268	All Key Test are Pass and One Non Key Test New Check the Sample Status PASS
* TC-PRO-SAM-0269	All Key Test are Pass and All Non Key Test New Check the Sample Status PASS
* TC-PRO-SAM-0270	All Key Test are Pass and One Non Key Test Process Check the Sample Status PASS
* TC-PRO-SAM-0271	All Key Test are Pass and All Non Key Test Process Check the Sample Status PASS
* TC-PRO-SAM-0272	All Key Test are Pass and One Non Key Test Pass Check the Sample Status PASS
* TC-PRO-SAM-0273	All Key Test are Pass and All Non Key Test Pass Check the Sample Status PASS
* TC-PRO-SAM-0274	All Key Test are Pass and One Non Key Test Fail Check the Sample Status PASS
* TC-PRO-SAM-0275	All Key Test are Pass and All Non Key Test Fail Check the Sample Status PASS
* TC-PRO-SAM-0276	All Key Test are pass and no any non key test Check the sample Status PASS
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

public class InProcessSamplePassSamplekeytestFunction extends DriverIntialization{
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// **********************************************Login Method********************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// *******************************************Reach In-Process Sample**************************

		AddInprocessSampleTest.SampleMainMethod();

//****************************************Key Test Method******************************************		
		SampleKeyTest.keyTest("Samples Module", "Process Sample", "TC-PRO-SAM-0267",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 20, 16, 18);

		MultiSearchMethods.Logout();
	}


}
