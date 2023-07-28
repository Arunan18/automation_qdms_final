/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0068	Add Plant Lab Trial Sample Through the Mix Design	

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :03.05.2023
* 
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0068      03.05.2023     RAHUL.S       Original Version
*					   07.07.2023     SASIKALA.A    Modified
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class AddPlantLabTrailThroughMixedDesignMethods extends DriverIntialization {
	static String plant = null;
	static String finishProduct = null;
	static String mixedDesign = null;
	static String plantEquipment = null;
	static String sampleDate = null;
	static String SampleCode = null;
	static String creationDate = null;
	static boolean exceldata = false;

// ************************ Excel Sheet Value Passing *************************
	public static void excel() throws InterruptedException, IOException {
		exceldata = false;
		/* Excel Sheet Value Passing */
		try {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
			String excelSheetName = "Mix Design";
			String testCaseId = "TC-MIX-DES-0068";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);
			DataFormatter data = new DataFormatter();

			XSSFRow row = sheet.getRow(firstRow);

			plant =data.formatCellValue(row.getCell(1));
			finishProduct = (String) row.getCell(2).getStringCellValue();
			mixedDesign = (String) row.getCell(3).getStringCellValue();
			plantEquipment = (String) row.getCell(4).getStringCellValue();
			sampleDate = (String) row.getCell(5).getStringCellValue();
			SampleCode = (String) row.getCell(6).getStringCellValue();
			creationDate = (String) row.getCell(7).getStringCellValue();

			exceldata = true;
		} catch (Exception e) {
			testCase = extent.createTest("EXCEL FILES OR DATA NOT WORKING");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// *****************Click Plant Trail icon*************************** 
	static boolean planttrailicon = false;

	public static void clickPlantLabtrail() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//td[text()='" + plant + "' and following-sibling::td[1][text()='"
								+ finishProduct + "'] and following-sibling::td[2][text()='" + mixedDesign
								+ "']]//following-sibling::td[3]/span"))));
			} catch (Exception e) {

			}
			planttrailicon = false;
			Thread.sleep(1000);
			driver.findElement(By.xpath("//td[text()='" + plant + "' and following-sibling::td[1][text()='"
					+ finishProduct + "'] and following-sibling::td[2][text()='" + mixedDesign
					+ "']]//following-sibling::td[3]/span")).isDisplayed();
			testCase = extent.createTest("CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS DISPLAYED");
			testCase.log(Status.INFO, "Expected value:-Icon Displayed ");
			testCase.log(Status.PASS, "TEST PASS");

			driver.findElement(By.xpath("//td[text()='" + plant + "' and following-sibling::td[1][text()='"
					+ finishProduct + "'] and following-sibling::td[2][text()='" + mixedDesign
					+ "']]//following-sibling::td[3]/span")).click();
			planttrailicon = true;
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS NOT DISPLAYED");
			testCase.log(Status.INFO, "Expected value:-Icon not Displayed ");
			testCase.log(Status.FAIL, "TEST PASS");
		}
	}

// PLANT EQUIPMENT FIELD DISPLAYED & ENABLED & SELECTED 
	static boolean plantequ = false;

	public static void plantEquipment() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		plantequ = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MixDesignPage.plantEquipmentTextBox));
		} catch (Exception e) {

		}
		try {
			SampleCommonMethods.fieldmethodselect("PLANT EQUIPMENT TEXT BOX FIELD PROPERTIES ",
					MixDesignPage.plantEquipmentTextBox, "PLANT EQUIPMENT FIELD DISPLAYED",
					"PLANT EQUIPMENT FIELD ENABLED", plantEquipment, "PLANT DATA SUCCESSFULLY SELECTED");
			Thread.sleep(2000);
			plantequ = true;
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("PLANT EQUIPMENT TEXT BOX FIELD UNABLE TO");
			testCase.log(Status.INFO, "Expected value:-Icon not Displayed ");
			testCase.log(Status.FAIL, "TEST PASS");

		}
	}

// SENDING DATA TO SAMPLE CODE
	static boolean samplecode = false;

	public static void sampleCode() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MixDesignPage.sampleCode));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			samplecode = false;
			if (MixDesignPage.sampleCode.isDisplayed()) {
				testCase = extent.createTest("SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				if (MixDesignPage.sampleCode.isEnabled()) {
					testCase = extent.createTest("SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS â˜‘");
					MixDesignPage.sampleCode.sendKeys(SampleCode);
					samplecode = true;
				} else {
					testCase = extent.createTest("SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL â�Ž");
				}
			} else {
				testCase = extent.createTest("SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL â�Ž");
			}

		} catch (Exception e) {

		}
	}

	// SENDING DATA TO SAMPLE DATE
	static boolean sampledate = false;

	public static void sampleDate() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MixDesignPage.sampleDate));
			sampledate = false;
			SelectDate.dateSelect("Samples Module.xlsx", "Mix Design", "TC-MIX-DES-0068-01", 5,
					MixDesignPage.sampleDate);
			testCase = extent.createTest("SAMPLE DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");
			sampledate = true;
		} catch (Exception e) {
			testCase = extent.createTest("SAMPLE DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}
	}

	// SENDING DATA TO CREATION DATE
	public static void creationDate() throws InterruptedException, IOException {
		try {

			MixDesignPage.creationDate.sendKeys(creationDate + Keys.ENTER);
			testCase = extent.createTest("SAMPLE DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");
		} catch (Exception e) {
			testCase = extent.createTest("SAMPLE DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}
	}

//************************ SAVE BUTTON ********************************
	public static void saveButtton() throws InterruptedException, IOException {
		try {
			if (MixDesignPage.saveButtonPlantLabTrail.isDisplayed()) {
				testCase = extent.createTest("MIXED DESIGN SAVE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				if (MixDesignPage.saveButtonPlantLabTrail.isEnabled()) {
					testCase = extent.createTest("MIXED DESIGN SAVE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS â˜‘");
					MixDesignPage.saveButtonPlantLabTrail.click();

				} else {
					testCase = extent.createTest("MIXED DESIGN SAVE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL â�Ž");
				}
			} else {
				testCase = extent.createTest("MIXED DESIGN SAVE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL â�Ž");
			}

		} catch (Exception e) {

		}
	}

//**************************** ADD CONFIRM *******************************************
	
	public static void addConfirm() throws InterruptedException, IOException {
		testCase = extent.createTest("MIXED DESIGN PLANT LAB TRAIL SAMPLE ADD FUNCTION CONFIRMATION");
		// PLANT
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE PLANT FIELD", plant,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// FINISH PRODUCT
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE FINISH PRODUCT FIELD", finishProduct,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// MIXED DESIGN
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE MIXED DESIGN FIELD", mixedDesign,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// SAMPLE CODE
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLE CODE FIELD", SampleCode,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// SAMPLE DATE
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[6]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLE DATE FIELD", sampleDate,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CREATION DATE
		try {
			String value = driver.findElement(By.xpath("//tbody/tr[2]/td[7]")).getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE CREATION DATE FIELD", creationDate,
					String.valueOf(value));
		} catch (Exception e) {

		}
	}

}
