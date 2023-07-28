//***********************************************************************************
//* Description
//*------------
//* PRODUCTION SAMPLE ADD VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 18/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0010   18/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddProductionSampleValidation extends DriverIntialization {
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
		methods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED", "02--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES", "03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		methods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
				"01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		methods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES", productionsample.productionsampleLeftNav,
				"01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,
				"Production Sample", "03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* ADD PRODUCTION SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
		methods.methodoneclick("STEP_04-- ADD PRODUCTION SAMPLE BUTTON PROPERTIES",
				productionsample.addproductionsample, "01-- ADD PRODUCTION SAMPLE BUTTON DISPLAYED",
				"02-- ADD PRODUCTION SAMPLE BUTTON ENABLED", productionsample.addproductionheading,
				"Add Production Sample",
				"03-- ON CLICK THE ADD PRODUCTION SAMPLE BUTTON IT'S SHOWES THE ADD PRODUCTION SAMPLE WINDOW");

		/* Finish Product Validation */
		validation();

		/* Mix Design Validation */
		validationmixdesign();

		/* Equipment Validation */
		equipmentvalidation();

		/* Sample Date Validation */
		sampledatevalidation();

		/* Sample Code Validation */
		samplecodevalidation();
		
	   /*Logout from Finish Product Sample*/
		logout.LogoutFunction();

	}

	public static void validation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		/* Finish Product Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		testCase = extent.createTest("Step-05--PRODUCTION SAMPLE ADD VALIDATION");

		XSSFRow row = sheet.getRow(firstRow);
		String valu = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.finishproduct.sendKeys(valu);
			productionsample.save.click();

			String ActualValidation = productionsample.finishproductvalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("01-- EMPTY VALIDATION FOR FINISH PRODUCT");
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

	/* Mix Design Validation */

	public static void validationmixdesign() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		XSSFRow row = sheet.getRow(firstRow + 1);
		String valu = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.mixdesign.click();
			productionsample.save.click();

			String ActualValidation = productionsample.mixdesignvalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("02-- EMPTY VALIDATION FOR MIX DESIGN");
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

	/* Equipment Validation */

	public static void equipmentvalidation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		XSSFRow row = sheet.getRow(firstRow + 2);
		String valu = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.equipment.click();
			productionsample.save.click();

			String ActualValidation = productionsample.equipmentvalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("03-- EMPTY VALIDATION FOR EQUIPMENT");
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

	/* Sample Date Validation */

	public static void sampledatevalidation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, productionsample);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		XSSFRow row = sheet.getRow(firstRow + 3);
		String valu = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.sampledate.click();
			productionsample.save.click();

			String ActualValidation = productionsample.sampledatevalidation.getText();

			String ExpectedValidation = validation;
			testCase = extent.createTest("04-- EMPTY VALIDATION FOR SAMPLE DATE");
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
		String testCaseId = "TC-PRODUCT-SAM-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Production Sample");

		XSSFRow row = sheet.getRow(firstRow + 4);
		String valu = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue().toString();

		Thread.sleep(2000);
		try {
			productionsample.samplecode.click();
			productionsample.samplecode.sendKeys(valu);
			String ActualValidation = productionsample.samplecodevalidation.getText();
			productionsample.save.click();

			String ExpectedValidation = validation;
			testCase = extent.createTest("05-- EMPTY VALIDATION FOR SAMPLE CODE");
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
