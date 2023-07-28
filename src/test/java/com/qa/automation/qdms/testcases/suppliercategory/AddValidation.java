/***********************************************************************************
* Description
*------------
* ADD SUPPLIER CATEGORY VALIDATION
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 10/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SUPCAT-0025         10/03/2023   RAHUL.S    OrIginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;

public class AddValidation extends DriverIntialization {
	static SupplierCategoryPage add = new SupplierCategoryPage();

// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************	
	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
//*****************************************************************************************************
//STEP-05--ADD SUPPLIER CATEGORY BUTTON IS DISPLAYED & STEP-06--ADD SUPPLIER CATEGORY BUTTON IS ENABLED
//*****************************************************************************************************
	public static void addButton() throws InterruptedException, IOException {
		if (SupplierCategoryPage.addSuppilerCategotyButton.isDisplayed()) {
			testCase = extent.createTest("STEP-05--ADD SUPPLIER CATEGORY BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (SupplierCategoryPage.addSuppilerCategotyButton.isEnabled()) {
				testCase = extent.createTest("STEP-06--ADD SUPPLIER CATEGORY BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SupplierCategoryPage.addSuppilerCategotyButton.click();
				Thread.sleep(2000);
			} else {
				testCase = extent.createTest("STEP-06--ADD SUPPLIER CATEGORY BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-05--ADD SUPPLIER CATEGORY BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void addFromExcel() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Supplier Category";
		String testCaseId = "TC-SUPCAT-0025";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			

			String data = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();
			String message = (String) row.getCell(3).getStringCellValue();

			SupplierCategoryPage.supplierCategorytextBox.sendKeys(data);
			Thread.sleep(2000);
			saveButton();
			Thread.sleep(2000);
			String ActualValidation = SupplierCategoryPage.validation.getText();
			System.out.println("$$$$ " + ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("STEP 9 : INPUT TEST DATA AND CHECK VALIDATION, Check " + message + " Script");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
			}
			Thread.sleep(1000);
			SupplierCategoryPage.supplierCategorytextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(1000);
		}

	}

//***************************************************************************************
//STEP-07--SAVE BUTTON IS DISPLAYED & STEP-08--SAVE BUTTON IS ENABLED
//***************************************************************************************
	public static void saveButton() throws InterruptedException, IOException {
		if (SupplierCategoryPage.saveButton.isDisplayed()) {
			testCase = extent.createTest("STEP-07--SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SupplierCategoryPage.saveButton.isEnabled()) {
				testCase = extent.createTest("STEP-08--SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SupplierCategoryPage.saveButton.click();
				Thread.sleep(2000);
			} else {
				testCase = extent.createTest("STEP-08--SAVE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-07--SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void supplierCategory() throws InterruptedException, IOException {

		// ****************************************************************************************
//		STEP-01--SUPPLIER TAB IS DISPLAYED   &	STEP-02--SUPPLIER TAB IS ENABLED
		// ****************************************************************************************
		if (SupplierCategoryPage.clickSupplier.isDisplayed()) {
			testCase = extent.createTest("STEP-01--SUPPLIER TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SupplierCategoryPage.clickSupplier.isEnabled()) {
				testCase = extent.createTest("STEP-02--SUPPLIER TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SupplierCategoryPage.clickSupplier.click();

			} else {
				testCase = extent.createTest("STEP-02--SUPPLIER TAB IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--SUPPLIER TAB IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		// ****************************************************************************************
//	    	STEP-03--SUPPLIER CATEGORY BUTTON IS DISPLAYED  &	 STEP-04--SUPPLIER CATEGORY BUTTON IS ENABLED
		// ****************************************************************************************

		if (SupplierCategoryPage.clickSupplierCategory.isDisplayed()) {
			testCase = extent.createTest("STEP-03--SUPPLIER CATEGORY BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SupplierCategoryPage.clickSupplierCategory.isEnabled()) {
				testCase = extent.createTest("STEP-04--SUPPLIER CATEGORY BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SupplierCategoryPage.clickSupplierCategory.click();
				Thread.sleep(2000);

			} else {
				testCase = extent.createTest("STEP-04--SUPPLIER CATEGORY BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--SUPPLIER CATEGORY BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
}
