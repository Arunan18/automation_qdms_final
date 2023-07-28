/*************************************************************************************************
* Description
*------------
* TC-PRODUCT-SAM-0302	Check Production Sample Trail Validation



* 
*************************************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 17/05/2023
* 
*
* 
* Test Case Number        Date         Intis        Comments
* ================        ====         =====        ========
* TC-PRODUCT-SAM-0302   17/05/2023   Rahul.S     Original Version
*  
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.DeleteAfterDependMethods;

public class ProductionSampleTrailFunction extends DriverIntialization {
	static String sampleCode = null;
	static String test = null;
	static String testDate = null;
	static String noOfTrail = null;
	static String noOfTrailValidation = null;
	static String dateValidation = null;
	static String check = null;
	static String forReportBoth = null;
	static String forReportnoOFTrail = null;
	static String forReportDate = null;

	public static void excel() throws InterruptedException, IOException {
		/* Excel Sheet Value Passing */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0302-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		sampleCode = (String) row.getCell(1).getStringCellValue();
		test = (String) row.getCell(2).getStringCellValue();
		DeleteAfterDependMethods.searchvalue(sampleCode, 5);
	}

	// CHECKING TEST AND RESULT ICON
	public static void testAndResultClick() throws InterruptedException, IOException {
		try {
			if (driver
					.findElement(By.xpath("//td[text()='" + sampleCode
							+ "']//following-sibling::td[17]//span[@class='anticon anticon-experiment']"))
					.isDisplayed()) {
				testCase = extent.createTest("STEP-01--THE TEST AND RESULT ICON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (driver
						.findElement(By.xpath("//td[text()='" + sampleCode
								+ "']//following-sibling::td[17]//span[@class='anticon anticon-experiment']"))
						.isEnabled()) {
					testCase = extent.createTest("STEP-02--THE TEST AND RESULT ICON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					driver.findElement(By.xpath("//td[text()='" + sampleCode
							+ "']//following-sibling::td[17]//span[@class='anticon anticon-experiment']")).click();
				} else {
					testCase = extent.createTest("STEP-02--THE TEST AND RESULT ICON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--THE TEST AND RESULT ICON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// CHECKING TEST AND RESULT
	public static void clickTest() throws InterruptedException, IOException {
		try {
			if (driver.findElement(By.xpath("//li[text()='" + test + "']")).isDisplayed()) {
				testCase = extent.createTest("STEP-03--THE TEST AND RESULT CARD IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (driver.findElement(By.xpath("//li[text()='" + test + "']")).isEnabled()) {
					testCase = extent.createTest("STEP-04--THE TEST AND RESULT CARD IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					driver.findElement(By.xpath("//li[text()='" + test + "']")).click();
				} else {
					testCase = extent.createTest("STEP-03--THE TEST AND RESULT CARD IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-04--THE TEST AND RESULT CARD IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// VALIDATION CHECKING
	public static void validation() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0302";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			check = (String) row.getCell(1).getStringCellValue();
			testDate = (String) row.getCell(2).getStringCellValue();
			noOfTrail = (String) row.getCell(3).getStringCellValue();
			dateValidation = (String) row.getCell(4).getStringCellValue();
			noOfTrailValidation = (String) row.getCell(5).getStringCellValue();
			forReportDate = (String) row.getCell(6).getStringCellValue();
			forReportnoOFTrail = (String) row.getCell(7).getStringCellValue();
			forReportBoth = (String) row.getCell(8).getStringCellValue();
			Thread.sleep(2000);
			try {

				if (ProductionSamplePage.testDate.isDisplayed()) {
					testCase = extent.createTest("THE TEST DATE IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");
					if (ProductionSamplePage.testDate.isEnabled()) {
						testCase = extent.createTest("THE TEST DATE IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						ProductionSamplePage.testDate.sendKeys(testDate);
						Thread.sleep(2000);
						ProductionSamplePage.testDate.sendKeys(Keys.ENTER);
					} else {
						testCase = extent.createTest("THE TEST DATE IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("THE TEST DATE IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
			try {
				if (ProductionSamplePage.noOfTrailTextBox.isDisplayed()) {
					testCase = extent.createTest("THE NO OF TRAIL IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");
					if (ProductionSamplePage.noOfTrailTextBox.isEnabled()) {
						testCase = extent.createTest("THE NO OF TRAIL IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");
						ProductionSamplePage.noOfTrailTextBox.click();
						Thread.sleep(2000);
						ProductionSamplePage.noOfTrailTextBox.sendKeys(noOfTrail, Keys.ENTER);
					} else {
						testCase = extent.createTest("THE NO OF TRAIL IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("THE NO OF TRAIL IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);

			ProductionSamplePage.submitButton.click();
			if (ProductionSamplePage.submitButton.isDisplayed()) {
				if (check.contentEquals("date")) {
					try {
						testCase = extent.createTest(forReportDate);
						String ActualValidation = ProductionSamplePage.testDateValidation.getText();

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

				if (check.contentEquals("number")) {
					try {
						testCase = extent.createTest(forReportnoOFTrail);
						String ActualValidation = ProductionSamplePage.noOfTrailValidation.getText();

						String ExpectedValidation = noOfTrailValidation;

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

				if (check.contentEquals("all")) {
					try {
						testCase = extent.createTest(forReportBoth);
						String ActualValidation = ProductionSamplePage.testDateValidation.getText();

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

					try {

						String ActualValidation = ProductionSamplePage.noOfTrailValidation.getText();

						String ExpectedValidation = noOfTrailValidation;

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
				driver.navigate().refresh();

			} else {
				testCase = extent.createTest("THE VALIDATION TEST HAS FAILED");
				testCase.log(Status.FAIL, "Test case fail");
			}
		}
	}
}
