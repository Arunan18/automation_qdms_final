/***********************************************************************************
* Description
*------------
* 

Mix Design  Edit Validation
 
TC-MIX-DES-0012


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* 
* Date Written     : 01/05/2023
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* 
*TC-MIX-DES-0012      01/05/2023       RAHUL.S       Original Version
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditValidationFunction extends DriverIntialization {
	static String dateValidation = null;
	static String plant = null;
	static String forEmptyDateReport = null;
	static String check = null;

	static String forEmptyQuandityReport = null;
	static String rawMaterial = null;
	static XSSFCell quandityValidation = null;
	static String validationError = null;
	static MixDesignPage mixed = new MixDesignPage();

	@Test
	public static void editValid() throws InterruptedException, IOException {
		PageFactory.initElements(driver, mixed);

		try {
			/* LOGIN */
			LoginTest.Login();
			//CLICK THE MIXED DESIGN CARD
			AddmixedDesignMethods.mixedDesignCard();
			//SEARCH AND CLICK THE PARTICULAR NAME EDIT ICON
			pickData();
			Thread.sleep(2000);
			try {
			//CHECKING EDIT VALIDATION
			validation();
			}catch (Exception e) {
				
			}
			//LOGOUT
			Logout.LogoutFunction();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void dateTextBox() throws InterruptedException, IOException {
		if (MixDesignPage.dateTextBox.isDisplayed()) {
			testCase = extent.createTest("STEP-03--DATE TEXT BOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (MixDesignPage.dateTextBox.isEnabled()) {
				testCase = extent.createTest("STEP-04--DATE TEXT BOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MixDesignPage.dateRemoveIcon.click();
			} else {
				testCase = extent.createTest("STEP-04--DATE TEXT BOX IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--DATE TEXT BOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void pickData() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0012-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		XSSFRow row = sheet.getRow(firstRow);
		plant = (String) row.getCell(1).getStringCellValue();
		rawMaterial = (String) row.getCell(2).getStringCellValue();

		pickupForEditValidation();
	}

	public static void pickupForEditValidation() throws InterruptedException, IOException {
		if (driver
				.findElement(
						By.xpath("//td[text()='" + plant + "']//following-sibling::td[9]//a//span[@aria-label='edit']"))
				.isDisplayed()) {
			testCase = extent.createTest("PARTICULAR DATA EDIT ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver
					.findElement(By.xpath(
							"//td[text()='" + plant + "']//following-sibling::td[9]//a//span[@aria-label='edit']"))
					.isEnabled()) {
				testCase = extent.createTest("PARTICULAR DATA EDIT ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(
						By.xpath("//td[text()='" + plant + "']//following-sibling::td[9]//a//span[@aria-label='edit']"))
						.click();
			} else {
				testCase = extent.createTest("PARTICULAR DATA EDIT ICON IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} else {
			testCase = extent.createTest("PARTICULAR DATA EDIT ICON IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void validation() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0012";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
		XSSFRow row = sheet.getRow(i);
		check = (String) row.getCell(1).getStringCellValue();
		dateValidation = (String) row.getCell(2).getStringCellValue();
		forEmptyDateReport = (String) row.getCell(3).getStringCellValue();
		

		try {
			dateTextBox();
			Thread.sleep(2000);
			MixDesignPage.mixedDesignSaveButton.click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (check.contentEquals("date")) {
			try {
				testCase = extent.createTest(forEmptyDateReport);
				String ActualValidation = MixDesignPage.dateValidationMessage.getText();

				String ExpectedValidation = dateValidation;

				try {
					Assert.assertEquals(ActualValidation, ExpectedValidation);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.PASS, "ERROR MESSAGE IS CORRECT");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.FAIL, "ERROR MESSAGE IS NOT CORRECT");
				}
			} catch (NoSuchElementException e) {

			}
		}
		Thread.sleep(2000);
		MixDesignPage.mixedDesignReturnButton.click();
		Thread.sleep(2000);
		
		quandityValidation();
		Thread.sleep(2000);
		MixDesignPage.mixedDesignReturnButton.click();
	}
	}
	public static void quandityValidation() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0012-QD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
		XSSFRow row = sheet.getRow(i);
		check = (String) row.getCell(1).getStringCellValue();
		quandityValidation = row.getCell(4);
		validationError = data.formatCellValue(quandityValidation);
		//quandityValidation = (String) row.getCell(4).getStringCellValue();
		forEmptyQuandityReport = (String) row.getCell(5).getStringCellValue();
		pickData();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[2]//input"))
					.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			
			MixDesignPage.mixedDesignSaveButton.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		if (check.contentEquals("quandity")) {
			try {
				testCase = extent.createTest(forEmptyQuandityReport);
				String ActualValidation = MixDesignPage.propotionValidationMessage.getText();

				String ExpectedValidation = validationError;

				try {
					Assert.assertEquals(ActualValidation, ExpectedValidation);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.PASS, "ERROR MESSAGE IS CORRECT");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.FAIL, "ERROR MESSAGE IS NOT CORRECT");
				}
			} catch (NoSuchElementException e) {

			}
		}
		}
	}
}
