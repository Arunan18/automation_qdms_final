
//* Description
//*------------
//* TESTS FOR ADD THE SAMENAME ALREADY DELETED NAME IN ADDFUCNTION
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 24/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*   TC-SUPCAT-0046       24/03/2023   NILUXY     	Orginal Version
//*
//* ============

package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class AddAlreadyDeletedSameName extends DriverIntialization {

	static AddSupplierCategory add = new AddSupplierCategory();
	static SupplierCategoryPage page = new SupplierCategoryPage();
	static DeleteSupplierCategory delete = new DeleteSupplierCategory();

	@Test

	public static void callingSameNameaddFunction() throws InterruptedException, IOException {
		Thread.sleep(3000);

		// LOGIN TO THE SYSTEM
		Thread.sleep(1000);
		LoginTest.Login();
		// CLICK TO THE MASTER MODULE
		MasterTest.MasterCard();

		Thread.sleep(4000);
		// DELETE ONE SELECTED DATA
		DeleteSupplierCategory.supplierCategory();
		Thread.sleep(4000);
		// CALLING ADD FUCNTION TO ADD THE DATA AS SAME DELETED NAME
		callingaAddFunction();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

//THIS METHOD FOR CALLING THE DELETE FUNCTION FROM ANOTHER CLASS
	public static void callingDeleteFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delete);

//	   Thread.sleep(1000);
//	   LoginTest.Login();
//	   MasterTest.MasterCard();
//	   Thread.sleep(2000);
		callingaAddFunction();
	}

	// THIS METHOD FOR CALLING ADD FUNCTION FROM ANOTHER METHOD
	public static void callingaAddFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, add);

		Thread.sleep(2000);
		// STEP-04--ADD SUPPLIER CATEGORY BUTTON IS DISPLAYED & STEP-05--ADD SUPPLIER
		// CATEGORY BUTTON IS ENABLED
//		AddSupplierCategory.addButton();
		Thread.sleep(2000);
		// DATA FROM EXCEL
		// addFromExcel();
		Thread.sleep(2000);
//			STEP-06--SAVE BUTTON IS DISPLAYED & STEP-07--SAVE BUTTON IS ENABLED	
//		AddSupplierCategory.saveButton();
		Thread.sleep(2000);
		SupplierCategoryPage.tableFirstRow.click();

		addconfirm();
		Thread.sleep(2000);

		// search();
		Thread.sleep(2000);
		addconfirm();
		Thread.sleep(2000);

		//LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	static String tobedelete = "";

	public static void EditselectValidation() throws InterruptedException, IOException {

		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Supplier Category";
		String testCaseId = "TC-SUPCAT-0046";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		XSSFRow row = sheet.getRow(firstRow);

		tobedelete = (String) row.getCell(1).getStringCellValue();
		System.out.println("tobeEdit" + tobedelete);
		String addsuppliercat = (String) row.getCell(2).getStringCellValue();

	}

	public static void addconfirm() throws InterruptedException, IOException {

		try {

//			String Value = SupplierCategoryPage.supplierCategoryName.getAttribute("value");

//			TestCasePrint("STEP-09--CONFIRM THE ADDED SUPPLIER CATEGORY", "SameNameDeleted", String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-09--CONFIRM THE ADDED SUPPLIER CATEGORY", "SameNameDeleted", String.valueOf(e));
		}

	}

//********************************************************************************************************
//THE METHOD IS FOR GENERATING REPORT 
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

}
