
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-COMING SAMPLE ALL TEST INPROCESS STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   03:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-INC-SAM-0248    	   03:05:2023     @SASIKALA     Original Version
//* TC-INC-SAM-0249
//* TC-INC-SAM-0250
//* TC-INC-SAM-0251
//* TC-INC-SAM-0252
//* TC-INC-SAM-0253
//* TC-INC-SAM-0254
//* TC-INC-SAM-0255
//* TC-INC-SAM-0256
//* TC-INC-SAM-0257
//* TC-INC-SAM-0258
//* TC-INC-SAM-0259
//* TC-INC-SAM-0260
//* TC-INC-SAM-0261
//* TC-INC-SAM-0262
//* TC-INC-SAM-0263
//* TC-INC-SAM-0264
//* TC-INC-SAM-0265
//* TC-INC-SAM-0266
//* TC-INC-SAM-0267
//* TC-INC-SAM-0268
//* TC-INC-SAM-0269
//****************************************************************************************************************

/*
* TC-INC-SAM-0249	AtLeast completed one test (more than one test and more than one key test )
* TC-INC-SAM-0250	All Key Test are New and One non Key tests are Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0251	All Key Test are New and All non Key tests are Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0252	All Key Test are New and One non Key tests are Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0253	All Key Test are New and All non Key tests are Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0254	One Key Test are Process and One non Key tests are Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0255	One Key Test are Process and All non Key tests are Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0256	One Key Test are Process and One non Key tests are Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0257	One Key Test are Process and All non Key tests are Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0258	One Key Test are Pass and All non Key tests are New Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0259	One Key Test are Pass and One non Key tests are New Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0260	One Key Test are Pass and All non Key tests are Process Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0261	One Key Test are Pass and All non Key tests are Pass Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0262	One Key Test are Pass and One non Key tests are Pass Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0263	One Key Test are Pass and All non Key tests are Fail Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0264	One Key Test are Pass and One non Key tests are Fail Check the Sample Status also PROCESS (more than 1 key test)
* TC-INC-SAM-0265	All Key Test are Process and One non Key test Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0266	All Key Test are Process and All non Key test Pass Check the Sample Status also PROCESS
* TC-INC-SAM-0267	All Key Test are Process and One non Key test Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0268	All Key Test are Process and All non Key test Fail Check the Sample Status also PROCESS
* TC-INC-SAM-0269	All Key Test are Process and All non Key test Fail Check the Sample Status also PROCESS
*/

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InComingSampleInProgressSamplekeytestFunction extends DriverIntialization {
	static IncomingSamplePage InCommingSamplePg = new IncomingSamplePage();

	@Test
	public static void inComingSample_Process() throws InterruptedException, IOException {

		PageFactory.initElements(driver, InCommingSamplePg);

//**************************************Log in Method*****************************************
		LoginTest.Login();
		Thread.sleep(500);
//******************************Main Path Sample Way******************************************
		IncomingSamplePage.MainSample.click();

//******************************Key Test Method***********************************************
		SampleKeyTest.keyTest("Samples Module", "Incoming Sample", "TC-INC-SAM-0249",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 22, 16, 18);

		MultiSearchMethods.Logout();
	}
}
