/***********************************************************************************
* Description
*------------
* EDIT VALIDATION FOR Plant-Lab Trial Sample(TC-P-LAB-SAM-0014)
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 18/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0014   18/04/2023   RAHUL.S    OrIginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class PlantLabTrailSampleEditValidationMethods extends DriverIntialization {
	static String tobepick = null;
	static String intermediateForPlant = null;
	static String intermediateForMixedDesign = null;
	static String intermediateForFinishProduct = null;
	static String sampleCode = null;
	static String validationForSampleCode = null;
	static String forReportGenerate = null;
	static String expDate = "Date can't be empty";

	/****************************************************************************
	 * DATA SEARCH AND CLICK THE EDIT BUTTON
	 ***************************************************************************/

	public static void dataPick() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0014-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			intermediateForPlant = (String) row.getCell(2).getStringCellValue();
			intermediateForFinishProduct = (String) row.getCell(3).getStringCellValue();
			intermediateForMixedDesign = (String) row.getCell(4).getStringCellValue();
			search();
		}

	}

	public static int search() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[15]/span/a[2]/span";
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(tobepick)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-04-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							System.out.println("disabled ************" + x);
							if (x == null) {
								testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL ❎");
								clickNextPage = false;
								a = 1;
								break;

							}
						}

						else {
							testCase.log(Status.FAIL, "TEST FAIL ❎");
							System.out.println("Button NOT Displayed");
						}

					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}
		return a;
	}

	// **********************************************************************************************************************
	// STEP-07-- CONFIRM BEFORE EDIT INTERMIATE
	// **********************************************************************************************************************
	public static void beforeEditForValidation() throws InterruptedException, IOException {
		try {
			String Value = PlantLabTrailSamplePage.plantTextBox.getText();

			TestCasePrint("STEP-06--CONFIRM THE INTERMEDIATE POINT FOR PLANT", intermediateForPlant,
					String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantLabTrailSamplePage.finishProductTextBox.getText();

			TestCasePrint("STEP-07--CONFIRM THE INTERMEDIATE POINT FOR FINISH PRODUCT", intermediateForFinishProduct,
					String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantLabTrailSamplePage.mixedDesignTextBox.getText();

			TestCasePrint("STEP-08--CONFIRM THE INTERMEDIATE POINT FOR MIXED DESIGN", intermediateForMixedDesign,
					String.valueOf(Value));
		} catch (Exception e) {

		}

	}

	// *****************************************************************************************************************************
	// STEP-03 -- CHECK THE PLANT,FINISH PRODUCT AND MIXED DESIGN FILEDS ARE
	// DISABLED
	// ***************************************************************************************************************************
	public static void checkDisabledField() throws InterruptedException, IOException {
		// test Enabled
		try {
			boolean value = PlantLabTrailSamplePage.plantForCheckDisabled.isEnabled();

			TestCasePrint("STEP-09 -- CHECK THE PLANT FILED IS DISABLED  ", "false", String.valueOf(value));
		} catch (Exception e) {

		}
		try {
			boolean value = PlantLabTrailSamplePage.finishProductForCheckDisabled.isEnabled();

			TestCasePrint("STEP-10 -- CHECK THE FINISH PRODUCT FILED IS DISABLED  ", "false", String.valueOf(value));
		} catch (Exception e) {

		}
		try {
			boolean value = PlantLabTrailSamplePage.mixedDesignForCheckDisabled.isEnabled();

			TestCasePrint("STEP-11 -- CHECK THE MIXED DESIGN FILED IS DISABLED  ", "false", String.valueOf(value));
		} catch (Exception e) {

		}
	}

	// *******************************************************************************************************
	public static void editValidationForPlant() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0014";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			sampleCode = (String) row.getCell(1).getStringCellValue();
			validationForSampleCode = (String) row.getCell(2).getStringCellValue();
			forReportGenerate = (String) row.getCell(3).getStringCellValue();
			Thread.sleep(2000);
			PlantLabTrailSamplePage.sampleCode.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

			PlantLabTrailSamplePage.sampleCode.sendKeys(sampleCode);

			PlantLabTrailSamplePage.UpdateButton.click();
			Thread.sleep(2000);
			try {
				if (PlantLabTrailSamplePage.UpdateButton.isDisplayed()) {
					testCase = extent.createTest(forReportGenerate);
					String ActualValidation = PlantLabTrailSamplePage.sampleCodeValidation.getText();
					String ExpectedValidation = validationForSampleCode;

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
				}
			} catch (NoSuchElementException e) {

			}
			Thread.sleep(2000);
			try {
				if (PlantLabTrailSamplePage.cancelButtonForEditValidation.isDisplayed()) {
					PlantLabTrailSamplePage.cancelButtonForEditValidation.click();
				}
			} catch (Exception e) {

			}

			dataPick();
		}

	}

	public static void emptyDropDownChecking() throws InterruptedException, IOException {
		PlantLabTrailSamplePage.SampleDateClearButton.click();
		PlantLabTrailSamplePage.UpdateButton.click();
		try {
			if (PlantLabTrailSamplePage.UpdateButton.isDisplayed()) {
				testCase = extent.createTest("STEP-14--CHECKING EMPTY SAMPLE DATE");
				String ActualValidation = PlantLabTrailSamplePage.validationForSampleDate.getText();
				String ExpectedValidation = expDate;

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
			}
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(2000);
		try {
			if (PlantLabTrailSamplePage.cancelButtonForEditValidation.isDisplayed()) {
				PlantLabTrailSamplePage.cancelButtonForEditValidation.click();
			}
		} catch (Exception e) {

		}
	}
	// *******************************************************************************************************

	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
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
}
