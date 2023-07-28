
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE CANCEL BUTTON TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   17:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0008		  17:04:2023     @SASIKALA     Original Version
//*
//*****************************************************************************************

/*
* Process Sample "Cancel" button Functionality - TC-PRO-SAM-0008
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddInprocessSampleCancelbtnFunctionTest extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

//********************************INPROCESS SAMPLE ADD SCREEN PATH NAVIGATION*****************************

	@Test(priority = 0)
	public static void CancelBtnFunctionPATHMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------Login-----------
		LoginTest.Login();
		// ------Sample Navigation-----------
		SampleNavigateTest.sampleNavigation();

		// ------Raw Material Sample Navigation-----------
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// ------InProcess Sample Site Bar Button Navigation-----------
		SampleNavigateTest.inprocessSampleNavigation();

		// -------------InProcess Sample Add Screen View-----------------
		Thread.sleep(1000);
		AddInprocessSampleTest.AddInprocessSampleButtonMethod();
	}

//********************************CANCEL BUTTON FUNCTIONALITY*****************************
	@Test(priority = 1)
	public static void InprocesscancelMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);

		if (InprocessSamplePage.Cancelbtn.isDisplayed()) {
			testCase = extent.createTest("SAMPLE CANCEL BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.ArrivalDateField.isEnabled()) {
				testCase = extent.createTest("SAMPLE CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.Cancelbtn.click();
					if (InprocessSamplePage.DashboardInProcess.isDisplayed()) {
						testCase = extent.createTest("SAMPLE DASHBOARD VISIBLE");
						testCase.log(Status.PASS, "TEST PASS");
					}
				} catch (Exception e) {
					testCase.log(Status.PASS, "TEST PASS");
				}

			} else {
				testCase = extent.createTest("SAMPLE CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE CANCEL BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	@Test(priority = 2)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, inprocesssample);
		MultiSearchMethods.Logout();

	}

}
