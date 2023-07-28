package com.qa.automation.qdms.sample.testcases.productionsample;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;

public class ProductionSampleCommonMethod extends DriverIntialization {

	// ********************************************************************************************************
	// THE METHOD IS FOR GENERATING REPORT
	// ********************************************************************************************************

	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean test = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			test = false;
		}
		if (test) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}

	}

	public static void SearchIcon(String colname, String colname1) {

		if (ProductionSamplePage.searchicon.isDisplayed()) {
			testCase = extent.createTest(colname + "PLANT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProductionSamplePage.searchicon.isEnabled()) {
				testCase = extent.createTest(colname1 + "PLANT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					ProductionSamplePage.searchicon.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest(colname1 + "PLANT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "PLANT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

}
