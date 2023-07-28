//***********************************************************************************
//* Description
//*------------
//* PRODUCTION SAMPLE EDIT VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0012   19/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleEditValidation extends DriverIntialization {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static Logout logout = new Logout();

	@Test
	public static void function() throws InterruptedException, IOException {

		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, methods);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED", "02--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES", "03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES",
				productionsample.topnavfinishproduct, "01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES",
				productionsample.productionsampleLeftNav, "01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,
				"Production Sample", "03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* EDIT PRODUCTION SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- PRODUCTION SAMPLE EDIT ICON PROPERTIES");
		ActionCommonMethod.actionS(0, 24, ProductionSamplePage.productionSampleTable, "edit", "Samples Module.xlsx",
				"Production Sample", "TC-PRODUCT-SAM-0012-01", 3);

		/* Sample Date Validation */
		sampledatevalidation();

		/* Sample Code Validation */
		samplecodevalidation();

		/* LOGOUT FROM FINISH PRODUCT SAMPLE */
		logout.LogoutFunction();

	}

	/* Sample Date Validation */

	public static void sampledatevalidation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0012";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		testCase = extent.createTest("STEP-05--PRODUCTION SAMPLE EDIT VALIDATION");

		XSSFRow row = sheet.getRow(firstRow + 1);
		String data = (String) row.getCell(1).getStringCellValue().toString();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.cancelicon.click();
			productionsample.save.click();

			String ActualValidation = productionsample.editsampledatevalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("01-- EMPTY VALIDATION FOR SAMPLE DATE");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
	}

	/* Sample Code Validation */

	public static void samplecodevalidation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0012";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		XSSFRow row = sheet.getRow(firstRow + 2);
		String data = (String) row.getCell(1).getStringCellValue().toString();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.samplecode.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			productionsample.samplecode.sendKeys(data);
			productionsample.save.click();

			String ActualValidation = productionsample.editsamplecodevalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("02-- EMPTY VALIDATION FOR SAMPLE CODE");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		productionsample.cancelbtn.click();
	}

}
