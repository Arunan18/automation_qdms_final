package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.MaterialPage;

public class MaterialButtonFunctionMethods extends DriverIntialization {
	static MaterialPage material = new MaterialPage();

	public static void materialTab() throws InterruptedException, IOException {
		// ****************************************************************************************
//	STEP-01--MATERIAL TAB IS DISPLAYED   &	STEP-02--MATERIAL TAB IS ENABLED
//****************************************************************************************	
		if (MaterialPage.tabMaterial.isDisplayed()) {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (MaterialPage.tabMaterial.isEnabled()) {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MaterialPage.tabMaterial.click();

			} else {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void materialButton() throws InterruptedException, IOException {
//****************************************************************************************
//    	STEP-03--MATERIAL BUTTON IS DISPLAYED &	STEP-04--MATERIAL BUTTON IS ENABLED
//****************************************************************************************		

		if (MaterialPage.navigationMaterial.isDisplayed()) {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (MaterialPage.navigationMaterial.isEnabled()) {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MaterialPage.navigationMaterial.click();

			} else {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void materialTable() throws InterruptedException, IOException {
		// ****************************************************************************************
//		    	STEP-03--MATERIAL BUTTON IS DISPLAYED &	STEP-04--MATERIAL BUTTON IS ENABLED
		// ****************************************************************************************

		if (MaterialPage.table.isDisplayed()) {
			testCase = extent.createTest("STEP-05--MATERIAL TABLE IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase = extent.createTest("STEP-05--MATERIAL TABLE IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
}
