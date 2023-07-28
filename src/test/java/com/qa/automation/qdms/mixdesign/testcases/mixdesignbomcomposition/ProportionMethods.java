/***********************************************************************************
* Description
*------------
* TC-MIX-DES-0064	Add Proportion in mix design screen
* TC-MIX-DES-0065	Add Proportion in mix design screen Validation
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-MIX-DES-0064     02/05/2023     RAHUL.S       Original Version
*TC-MIX-DES-0065	   02/05/2023     RAHUL.S       Original Version
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class ProportionMethods extends DriverIntialization {
	static Actions actions;
	static String proportion = null;
	static String raw = null;
	static XSSFCell quandity = null;
	static String da = null;
	static String unit = null;
	static String proportionV = null;
	static String rawV = null;
	static XSSFCell quandityV = null;
	static String daV = null;
	static String unitV = null;
	static XSSFCell validationMessage = null;
	static String validationMessageV = null;
	static String reportGenerate = null;

	/* Excel Sheet Value Passing */
	public static void excelProp() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0064";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		proportion = (String) row.getCell(1).getStringCellValue();
		raw = (String) row.getCell(2).getStringCellValue();

		quandity = row.getCell(3);
		da = data.formatCellValue(quandity);
		unit = (String) row.getCell(4).getStringCellValue();

	}

	// PICK A PLANT PROPORTION
	public static void plant() throws InterruptedException, IOException {
		if (driver
				.findElement(By.xpath(
						"//td[text()='" + proportion + "']//following-sibling::td[5]//span[@aria-label='plus-circle']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-03-CHECKING THE PLANT HAS THE PROPORTION ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//td[text()='" + proportion + "']//following-sibling::td[5]//span[@aria-label='plus-circle']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-04-CHECKING THE PLANT HAS THE PROPORTION ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath(
						"//td[text()='" + proportion + "']//following-sibling::td[5]//span[@aria-label='plus-circle']"))
						.click();
			} else {
				testCase = extent.createTest("STEP-04-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

//RAW MATERIAL
	public static void rawMaterialEdit() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//td[text()='" + proportion + "']//following-sibling::td[8]//a"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-11-CHECKING THE PLANT HAS THE PROPORTION ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//td[text()='" + proportion + "']//following-sibling::td[8]//a"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-12-CHECKING THE PLANT HAS THE PROPORTION ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='" + proportion + "']//following-sibling::td[8]//a")).click();
			} else {
				testCase = extent.createTest("STEP-12-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-11-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void rawMaterialChecbox() throws InterruptedException, IOException {
	//	Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//td[text()='" + raw + "']//preceding-sibling::td[3]//input"))
								.click();
						testCase = extent.createTest("STEP-05--RAW MATERIAL CHECK BOX IS DISPLAYED AND ENABLED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}

//CHECKING  QUANDITY
	public static void quandity() throws InterruptedException, IOException {

		if (driver.findElement(By.xpath("//td[text()='" + raw + "']//following-sibling::td[1]//input")).isEnabled()) {
			testCase = extent.createTest("STEP-06--QUANDITY TEXTBOX IS ENABLED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='" + raw + "']//following-sibling::td[1]//input")).sendKeys(da);
		} else {
			testCase = extent.createTest("STEP-06--QUANDITY TEXTBOX IS NOT ENABLED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		}

	}

	// CHECKING UNIT
	public static void unit() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath(
				"//td[text()='" + raw + "']//following-sibling::td[4]//span[@class='ant-select-selection-search']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-07--UNIT DROPDOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver
					.findElement(By.xpath("//td[text()='" + raw
							+ "']//following-sibling::td[4]//span[@class='ant-select-selection-search']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-08--UNIT DROPDOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='" + raw
						+ "']//following-sibling::td[4]//span[@class='ant-select-selection-search']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + unit + "']"))
						.click();
			} else {
				testCase = extent.createTest("STEP-08--UNIT DROPDOWN IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-07--UNIT DROPDOWN IS NOT DISPALYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	// SAVE BUTTON
	public static void submitButton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.proportionSubmitButton.isDisplayed()) {
				testCase = extent.createTest("STEP-09--PROPORTION SUBMIT BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.proportionSubmitButton.isEnabled()) {
					testCase = extent.createTest("STEP-10--PROPORTION SUBMIT BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.proportionSubmitButton.click();

				} else {
					testCase = extent.createTest("STEP-10--PROPORTION SUBMIT BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-09--PROPORTION SUBMIT BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// CONFRIM ADD PROPORTION
	public static void addConfirm() throws InterruptedException, IOException {
		testCase = extent.createTest("STEP-13--PROPORTION ADD FUNCTION CONFIRMATION");
		// CHECKING THE RAW MATERIAL
		try {

			String value = driver.findElement(By.xpath(
					"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[1]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE RAW MATERIAL FIELD", raw,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE QUANDITY
		try {

			String value = driver.findElement(By.xpath(
					"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE QUANDITY FIELD", da,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE UNIT
		try {

			String value = driver.findElement(By.xpath(
					"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr/td[3]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE QUANDITY FIELD", unit,
					String.valueOf(value));
		} catch (Exception e) {

		}
	}

	// SAVE BUTTON
	public static void closeButton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.rawMaterialCloseButton.isDisplayed()) {
				testCase = extent.createTest("STEP-14--CLOSE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.rawMaterialCloseButton.isEnabled()) {
					testCase = extent.createTest("STEP-15--CLOSE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.rawMaterialCloseButton.click();

				} else {
					testCase = extent.createTest("STEP-15--CLOSE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-14--CLOSE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* Excel Sheet Value Passing */
	public static void excelvalid() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0065";
Actions actions1=new Actions(driver);
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			proportionV = (String) row.getCell(1).getStringCellValue();
			rawV = (String) row.getCell(2).getStringCellValue();
			quandityV = row.getCell(3);
			daV = data.formatCellValue(quandityV);
			unitV = (String) row.getCell(4).getStringCellValue();
			validationMessage = row.getCell(5);
			validationMessageV = data.formatCellValue(validationMessage);
			reportGenerate = (String) row.getCell(6).getStringCellValue();
			Thread.sleep(2000);
		
			try {
				plantV();
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}
		
			
			
			try {
				rawMaterialChecboxV();
			} catch (NoSuchElementException e) {
				
			}
			Thread.sleep(2000);
			try {
				quandityV();
			} catch (NoSuchElementException e) {
				
			}
			Thread.sleep(2000);
			try {
				unitV();
			} catch (NoSuchElementException e) {

			}
			
			Thread.sleep(2000);
			MixDesignPage.proportionSubmitButton.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"rcDialogTitle0\"]")).click();
			actions1.sendKeys(Keys.ARROW_DOWN).perform();
//			actions1.sendKeys(Keys.ARROW_DOWN).perform();
//			actions1.sendKeys(Keys.ARROW_DOWN).perform();
		
		
			
			try {
				 testCase = extent.createTest(reportGenerate);
				String ActualValidation = MixDesignPage.propotionValidationMessage.getText();

				String ExpectedValidation = validationMessageV;

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
			Thread.sleep(2000);
			MixDesignPage.rawMaterialCloseButton.click();
			Thread.sleep(2000);

		}
	}

	// PICK A PLANT PROPORTION
	public static void plantV() throws InterruptedException, IOException {
		if (driver.findElement(By
				.xpath("//td[text()='" + proportionV + "']//following-sibling::td[3]//span[@aria-label='plus-circle']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-03-CHECKING THE PLANT HAS THE PROPORTION ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//td[text()='" + proportionV + "']//following-sibling::td[3]//span[@aria-label='plus-circle']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-04-CHECKING THE PLANT HAS THE PROPORTION ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='" + proportionV
						+ "']//following-sibling::td[3]//span[@aria-label='plus-circle']")).click();
			} else {
				testCase = extent.createTest("STEP-04-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03-CHECKING THE PLANT HAS THE PROPORTION ICON IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// FOR VALIDTION
	public static void rawMaterialChecboxV() throws InterruptedException, IOException {
	//	Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//td[text()='" + rawV + "']//preceding-sibling::td[3]//input"))
								.click();
						testCase = extent.createTest("STEP-05--RAW MATERIAL CHECK BOX IS DISPLAYED AND ENABLED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}

	public static void quandityV() throws InterruptedException, IOException {

		if (driver.findElement(By.xpath("//td[text()='"+rawV+"']//following-sibling::td[3]//input")).isEnabled()) {
			testCase = extent.createTest("STEP-06--QUANDITY TEXTBOX IS ENABLED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[text()='"+rawV+"']//following-sibling::td[3]//input")).sendKeys(daV);
		} else {
			testCase = extent.createTest("STEP-06--QUANDITY TEXTBOX IS NOT ENABLED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		}

	}

	// CHECKING UNIT
	public static void unitV() throws InterruptedException, IOException {

			if (driver
					.findElement(By.xpath("//td[text()='"+rawV+"']//following-sibling::td[4]//input"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-08--UNIT DROPDOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='"+rawV+"']//following-sibling::td[4]//input")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + unitV + "']"))
						.click();
			} else {
				testCase = extent.createTest("STEP-08--UNIT DROPDOWN IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}


	}
}
