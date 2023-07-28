/***********************************************************************************
* Description
*------------
* Mix Design  Add Functionality(TC-MIX-DES-0009)
methods

Mix Design  Add Validation 
TC-MIX-DES-0010

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/04/2023
* Date Written     : 27/04/2023
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   26/04/2023     RAHUL.S       Original Version
*TC-MIX-DES-0010    27/04/2023     RAHUL.S       Original Version
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class AddmixedDesignMethods extends DriverIntialization {
	static String plant = null;
	static String subCatetory = null;
	static String finishProduct = null;
	static String date = null;
	static String status = null;
	static String rawMaterial = null;
	static XSSFCell quandity = null;
	static String da = null;
	static String unit = null;
	static String ProptionValidationMessage = null;
	static String PlantValidationMessage = null;
	static String FinishProductValidationMessage = null;
	static String DateValidationMessage = null;
	static String check = null;
	static String plantV = null;
	static String subCatetoryV = null;
	static String finishProductV = null;
	static String dateV = null;
	static String statusV = null;
	static String rawMaterialV = null;
	static XSSFCell quandityV = null;
	static String daV = null;
	static String unitV = null;
	static String forReportGenerateProption= null;
	static String forReportGenerateForAll= null;
	static String forReportGeneratePlant= null;
	static String forReportGenerateFinishProduct= null;
	static String forReportGenerateDate= null;

//CHECKING MIXED DESIGN CARD
	public static void mixedDesignCard() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.mixedDesignCard.isDisplayed()) {
				testCase = extent.createTest("STEP-01--MIXED DESIGN TAB IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.mixedDesignCard.isEnabled()) {
					testCase = extent.createTest("STEP-02--MIXED DESIGN TAB IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.mixedDesignCard.click();

				} else {
					testCase = extent.createTest("STEP-02--MIXED DESIGN TAB IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-01--MIXED DESIGN TAB IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ADD BUTTON
	public static void mixedDesignAddButton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.mixedDesignAddButton.isDisplayed()) {
				testCase = extent.createTest("STEP-03--MIXED DESIGN ADD BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.mixedDesignAddButton.isEnabled()) {
					testCase = extent.createTest("STEP-04--MIXED DESIGN ADD BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.mixedDesignAddButton.click();

				} else {
					testCase = extent.createTest("STEP-04--MIXED DESIGN ADD BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-03--MIXED DESIGN ADD BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* Excel Sheet Value Passing */
	public static void addexcel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0009";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		plant = (String) row.getCell(1).getStringCellValue();
		subCatetory = (String) row.getCell(2).getStringCellValue();
		finishProduct = (String) row.getCell(3).getStringCellValue();
		date = (String) row.getCell(4).getStringCellValue();
		status = (String) row.getCell(5).getStringCellValue();
		rawMaterial = (String) row.getCell(6).getStringCellValue();

		quandity = row.getCell(7);
		da = data.formatCellValue(quandity);
		unit = (String) row.getCell(8).getStringCellValue();
	}

	// CHECKING STATUS
	public static void status() throws InterruptedException, IOException {

		try {
			if (MixDesignPage.statusTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-09--STATUS IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.statusTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-10--STATUS IS ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");

				} else {
					testCase = extent.createTest("STEP-10--STATUS IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						String Value = driver.findElement(By.xpath("//span[@title='NEW']")).getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint(
								"STEP-11--CONFIRM THE STATUS TEXT IS CORRECT", status, String.valueOf(Value));
					} catch (Exception e) {

					}
				}
			} else {
				testCase = extent.createTest("STEP-09--STATUS IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// CHECKING SUBCATEGORY
	public static void subCategory() throws InterruptedException, IOException {

		try {
			if (MixDesignPage.subCategoryTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-01--SUBCATEGORY DROPDOWN TEXTBOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.subCategoryTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-02--SUBCATEGORY DROPDOWN TEXTBOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.subCategoryTextBox.click();
					MixDesignPage.subCategoryTextBox.sendKeys(subCatetory);

				} else {
					testCase = extent.createTest("STEP-02--SUBCATEGORY DROPDOWN TEXTBOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-01--SUBCATEGORY DROPDOWN TEXTBOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//CHECKING SUB CATEGORY
	public static void finishProduct() throws InterruptedException, IOException {

		try {

			if (MixDesignPage.rawMeterialTextBox.isEnabled()) {
				testCase = extent.createTest("STEP-07--FINISH PRODUCT DROPDOWN TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				MixDesignPage.rawMeterialTextBox.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[contains(@title,'" + finishProduct + "')]")).click();

			} else {
				testCase = extent.createTest("STEP-07--FINISH PRODUCT DROPDOWN TEXTBOX IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//CHECKING  PROPOTION
	public static void proption() throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//preceding-sibling::td[1]"))
								.click();
						testCase = extent.createTest("STEP-12--RAW MATERIAL CHECK BOX IS DISPLAYED AND ENABLED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					actions.sendKeys(Keys.ARROW_DOWN).perform();
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
		if (driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[2]//input"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-13--QUANDITY TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[2]//input"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-14--QUANDITY TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[2]//input"))
						.sendKeys(da);
			} else {
				testCase = extent.createTest("STEP-14--QUANDITY TEXTBOX IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
			}

		} else {
			testCase = extent.createTest("STEP-13--QUANDITY TEXTBOX IS NOT DISPALYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//CHECKING UNIT
	public static void unit() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[3]"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-15--UNIT DROPDOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[3]"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-16--UNIT DROPDOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='" + rawMaterial + "']//following-sibling::td[3]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + unit + "']"))
						.click();
			} else {
				testCase = extent.createTest("STEP-16--UNIT DROPDOWN IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-15--UNIT DROPDOWN IS NOT DISPALYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

//SAVE BUTTON
	public static void saveButtton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.mixedDesignSaveButton.isDisplayed()) {
				testCase = extent.createTest("STEP-17--MIXED DESIGN SAVE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.mixedDesignSaveButton.isEnabled()) {
					testCase = extent.createTest("STEP-18--MIXED DESIGN SAVE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.mixedDesignSaveButton.click();

				} else {
					testCase = extent.createTest("STEP-18--MIXED DESIGN SAVE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-17--MIXED DESIGN SAVE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//RETURN BUTTON
	public static void returnButtton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.mixedDesignReturnButton.isDisplayed()) {
				testCase = extent.createTest("STEP-20--MIXED DESIGN RETURN BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.mixedDesignReturnButton.isEnabled()) {
					testCase = extent.createTest("STEP-21--MIXED DESIGN RETURN BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.mixedDesignReturnButton.click();

				} else {
					testCase = extent.createTest("STEP-21--MIXED DESIGN RETURN BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-20--MIXED DESIGN RETURN BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//ADD CONFIRMATION
	public static void confirmAdd() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			// CLICK THE FIRST ROW
			MixDesignPage.firstRowEditIcon.click();
			Thread.sleep(2000);
			testCase = extent.createTest("STEP-19--MIXED DESIGN ADD FUNCTION CONFIRMATION");
			// CHECKING THE PLANT
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div[1]/div/div/div/span[2]"))
						.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE PLANT FIELD", plant,
						String.valueOf(value));
			} catch (Exception e) {

			}
			// CHECKING THE SUB CATEGORY
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div[1]/div/div[1]/div/span[2]"))
						.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUB CATEGORY FIELD", subCatetory,
						String.valueOf(value));
			} catch (Exception e) {

			}
			// CHECKING THE FINISH PRODUCT
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[3]/div/div/div[1]/div/span[2]"))
						.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE FINISH PRODUCT FIELD",
						finishProduct, String.valueOf(value));
			} catch (Exception e) {

			}
			// CHECKING THE RAW MATERIAL
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]"))
						.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE RAW MATERIAL", rawMaterial,
						String.valueOf(value));
			} catch (Exception e) {

			}
			// CHECKING THE QUANDITY
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/span/input"))
						.getAttribute("value");

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE QUANDITY FIELD", da,
						String.valueOf(value));
			} catch (Exception e) {

			}

			// CHECKING THE UNIT
			try {
				String value = driver.findElement(By.xpath(
						"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[5]/span/div/div/span[2]"))
						.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE UNIT FIELD", unit,
						String.valueOf(value));
			} catch (Exception e) {

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void forProptionvalid() throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//td[text()='material01']//preceding-sibling::td[1]"))
								.click();
						driver.findElement(
								By.xpath("//td[text()='material01']//preceding-sibling::td[2]//input")).sendKeys(daV);
						
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					actions.sendKeys(Keys.ARROW_DOWN).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}

	}

	
	
	public static void validexcel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			check = (String) row.getCell(1).getStringCellValue();
			plantV = (String) row.getCell(2).getStringCellValue();
			subCatetoryV = (String) row.getCell(3).getStringCellValue();
			finishProductV = (String) row.getCell(4).getStringCellValue();
			dateV = (String) row.getCell(5).getStringCellValue();
			rawMaterialV = (String) row.getCell(6).getStringCellValue();

			quandityV = row.getCell(7);
			daV = data.formatCellValue(quandityV);
			unitV = (String) row.getCell(8).getStringCellValue();
			ProptionValidationMessage = (String) row.getCell(9).getStringCellValue();
			DateValidationMessage = (String) row.getCell(10).getStringCellValue();
			FinishProductValidationMessage = (String) row.getCell(11).getStringCellValue();
			PlantValidationMessage = (String) row.getCell(12).getStringCellValue();
			
			forReportGenerateProption = (String) row.getCell(13).getStringCellValue();
			forReportGenerateDate = (String) row.getCell(14).getStringCellValue();
			forReportGenerateFinishProduct = (String) row.getCell(15).getStringCellValue();
			forReportGeneratePlant = (String) row.getCell(16).getStringCellValue();
			forReportGenerateForAll = (String) row.getCell(17).getStringCellValue();
			Thread.sleep(2000);
try {
			MixDesignPage.plantTextBoxR.sendKeys(plantV, Keys.ENTER);
}catch (NoSuchElementException e) {
	// TODO: handle exception
}
			Thread.sleep(2000);
			try {
			MixDesignPage.subCategoryTextBox.sendKeys(subCatetoryV,Keys.ENTER);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
			try {
			MixDesignPage.rawMeterialTextBox.click();
			Thread.sleep(2000);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(2000);
		WebElement fin = 	driver.findElement(By.xpath("(//div[@title='"+finishProductV+"'])[1]"));
			fin.click();
			}catch (NoSuchElementException e) {
				MixDesignPage.rawMeterialTextBox.click();
				
			}
			
			try {
				
			MixDesignPage.dateTextBox.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
			MixDesignPage.dateTextBox.sendKeys(dateV);
			Thread.sleep(2000);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			try {
			driver.findElement(By.xpath("//td[@title='" + dateV + "']")).click();
			Thread.sleep(2000);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			MixDesignPage.dateTextBox.sendKeys(Keys.ENTER);
			
	
			try {
			driver.findElement(By.xpath("//td[text()='"+rawMaterialV+"']//preceding-sibling::td[1]")).click();
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			try {
			driver.findElement(
					By.xpath("//td[text()='"+rawMaterialV+"']//following-sibling::td[2]//input")).sendKeys(daV);
			Thread.sleep(2000);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			try {
			driver.findElement(By.xpath("//td[text()='" + rawMaterialV + "']//following-sibling::td[3]")).click();
			Thread.sleep(2000);
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			try {
			driver.findElement(By.xpath(
					"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + unitV + "']"))
					.click();
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			MixDesignPage.mixedDesignSaveButton.click();

			if (check.contentEquals("unit")) {
				try {
					 testCase = extent.createTest(forReportGenerateProption);
					String ActualValidation = MixDesignPage.propotionValidationMessage.getText();

					String ExpectedValidation = ProptionValidationMessage;

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
			
			
			if (check.contentEquals("date")) {
				try {
					 testCase = extent.createTest(forReportGenerateDate);
					String ActualValidation = MixDesignPage.dateValidationMessage.getText();

					String ExpectedValidation = DateValidationMessage;

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

			if (check.contentEquals("finishProduct")) {
				try {
					 testCase = extent.createTest(forReportGenerateFinishProduct);
					String ActualValidation = MixDesignPage.finishProductValidationMessage.getText();

					String ExpectedValidation = FinishProductValidationMessage;

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
			if (check.contentEquals("plant")) {
				try {
					 testCase = extent.createTest(forReportGeneratePlant);
					String ActualValidation = MixDesignPage.plantValidationMessage.getText();

					String ExpectedValidation = PlantValidationMessage;

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
					 testCase = extent.createTest(forReportGenerateForAll);
					String ActualValidation = MixDesignPage.plantValidationMessage.getText();

					String ExpectedValidation = PlantValidationMessage;

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
					// testCase = extent.createTest(forReportGenerateForAll);
					String ActualValidation =  MixDesignPage.finishProductValidationMessage.getText();

					String ExpectedValidation = FinishProductValidationMessage;

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
				//	 testCase = extent.createTest(forReportGenerateForAll);
					String ActualValidation = MixDesignPage.dateValidationMessage.getText();

					String ExpectedValidation = DateValidationMessage;

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
			MixDesignPage.mixedDesignAddButton.click();
			
		}
	}

	
}
