/***********************************************************************************
* Description
*------------
*MASTER FUNCTIONS TEST
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-MC-0002           26/03/2023   RAHUL.S     Original Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.master;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MasterPage;


public class MassterFunction extends DriverIntialization {
	static MasterPage masterButn = new MasterPage();
	
	/*******************************************************************************
	 * MASTER BUTTON
	 ******************************************************************************/
	public static void masterButton() throws InterruptedException, IOException {
		if (MasterPage.masterBtn.isDisplayed()) {
			testCase = extent.createTest("STEP-01--MASTER BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (MasterPage.masterBtn.isEnabled()) {
				testCase = extent.createTest("STEP-02--MASTER BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MasterPage.masterBtn.click();
			} else {
				testCase = extent.createTest("STEP-02--MASTER BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--MASTER BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
	/*******************************************************************************
	 * HOME BUTTON
	 ******************************************************************************/
	public static void homeButton() throws InterruptedException, IOException {
		if (MasterPage.homeButton.isDisplayed()) {
			testCase = extent.createTest("STEP-03--HOME BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			testCase = extent.createTest("MASTER BUTTON FUNCTION IS PASSED");
			testCase.log(Status.PASS, "TEST PASS ☑");
				} else {
			testCase = extent.createTest("STEP-03--HOME BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
	/*******************************************************************************
	 * MASTER LOGO 
	 ******************************************************************************/
	public static void masterLogo() throws InterruptedException, IOException {
		if (MasterPage.masterLogo.isDisplayed()) {
			testCase = extent.createTest("STEP-04--MASTER IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			testCase = extent.createTest("MASTER BUTTON FUNCTION IS PASSED");
			testCase.log(Status.PASS, "TEST PASS ☑");
				} else {
			testCase = extent.createTest("STEP-04--MASTER IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
	

}
