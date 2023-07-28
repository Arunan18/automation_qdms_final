
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-COMING SAMPLE ALL TEST FAIL STATUS KEY FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   08:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-INC-SAM-0280    	   08:05:2023     @SASIKALA     Original Version
//* TC-INC-SAM-0281
//* TC-INC-SAM-0282
//* TC-INC-SAM-0283
//* TC-INC-SAM-0284
//* TC-INC-SAM-0285
//* TC-INC-SAM-0286
//* TC-INC-SAM-0287
//* TC-INC-SAM-0288
//* TC-INC-SAM-0289
//* TC-INC-SAM-0290
//* TC-INC-SAM-0291
//* TC-INC-SAM-0292
//* TC-INC-SAM-0293
//* TC-INC-SAM-0294
//* TC-INC-SAM-0295
//****************************************************************************************************************

/*
* TC-INC-SAM-0280	FAIL  -Sample key test (Select Key Test)
* TC-INC-SAM-0281	One Key Test  FAIL and ALL Non Key Test New Check the Sample Status FAIL
* TC-INC-SAM-0282	ALL Key Test  FAIL and ALL Non Key Test New Check the Sample Status FAIL
* TC-INC-SAM-0283	One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0284	All Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0285	One Key Test FAIL and Only One Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0286	All Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0287	One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
* TC-INC-SAM-0288	All Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0289	Only One Key Test FAIL and Only One Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0290	Only One Key Test FAIL and All Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0291	Only One Key Test FAIL and All Non Key Test PASS Check the Sample Status FAIL
* TC-INC-SAM-0292	Only One Key Test FAIL and All Non Key Test FAIL Check the Sample Status FAIL
* TC-INC-SAM-0293	Only One Key Test FAIL and All Non Key Test NEW Check the Sample Status FAIL
* TC-INC-SAM-0294	Only One Key Test FAIL and Only One Non Key Test PROCESS Check the Sample Status FAIL
* TC-INC-SAM-0295	Only One Key Test FAIL and Only One Non Key Test FAIL Check the Sample Status FAIL
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

public class IncommingSampleFailKeyStatus extends DriverIntialization{
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
		SampleKeyTest.keyTest("Samples Module", "Incoming Sample", "TC-INC-SAM-0280",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 22, 16, 18);

		MultiSearchMethods.Logout();
	}
}
