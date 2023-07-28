/***********************************************************************************
* Description
*------------
* ADD INCOMING SAMPLE FUNCTIONALITY(TC-INC-SAM-0011)
*Incoming Sample Edit Functionality (Able to edit Incoming sample only for NEW Status)
(TC-INC-SAM-0013)
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   28/04/2023   RAHUL.S    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class IncomingSampleMethods extends DriverIntialization {

	static String supplierCategory = null;
	static String plant = null;
	static String supplier = null;
	static String rawMaterial = null;
	static String status = null;
	static String vehicleNo = null;
	static XSSFCell blLcNo = null;
	static String da = null;
	static String sampleCode = null;
	static String source = null;
	static String dateOfSampling = null;
	static String arrivalDate = null;
	static String sampleTime = null;
	static String grn = null;
	static String quandityAndBrandReceived = null;
	static String tobepick = null;
	static String supplierCategoryE = null;
	static String plantE = null;
	static String supplierE = null;
	static String rawMaterialE = null;
	static String statusE = null;
	static String vehicleNoE = null;
	static XSSFCell blLcNoE = null;
	static String daE = null;
	static String sampleCodeE = null;
	static String sourceE = null;
	static String dateOfSamplingE = null;
	static String arrivalDateE = null;
	static String sampleTimeE = null;
	static String grnE = null;
	static String quandityAndBrandReceivedE = null;

	// ADD BUTTON
	public static void incomingSampleAddButton() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addincomingsample.isDisplayed()) {
				testCase = extent.createTest("STEP-01--INCOMING SAMPLE ADD BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addincomingsample.isEnabled()) {
					testCase = extent.createTest("STEP-02--INCOMING SAMPLE ADD BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					IncomingSamplePage.addincomingsample.click();

				} else {
					testCase = extent.createTest("STEP-02--INCOMING SAMPLE ADD BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-01--INCOMING SAMPLE ADD BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/* Excel Sheet Value Passing */
	public static void addIncomingSampleexcel() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Incoming Sample";
		String testCaseId = "TC-INC-SAM-0011";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		supplierCategory = (String) row.getCell(1).getStringCellValue();
		plant = (String) row.getCell(2).getStringCellValue();
		supplier = (String) row.getCell(3).getStringCellValue();
		rawMaterial = (String) row.getCell(4).getStringCellValue();
		vehicleNo = (String) row.getCell(5).getStringCellValue();
		sampleCode = (String) row.getCell(6).getStringCellValue();
		source = (String) row.getCell(7).getStringCellValue();
		blLcNo = row.getCell(11);
		da = data.formatCellValue(blLcNo);

		dateOfSampling = (String) row.getCell(8).getStringCellValue();
		arrivalDate = (String) row.getCell(9).getStringCellValue();
		sampleTime = (String) row.getCell(10).getStringCellValue();

		grn = (String) row.getCell(12).getStringCellValue();
		quandityAndBrandReceived = (String) row.getCell(13).getStringCellValue();
		status = (String) row.getCell(14).getStringCellValue();

	}

	// CHECKING SUPPIER CATEGORY
	public static void supplierCategory() throws InterruptedException, IOException {

		try {

			if (IncomingSamplePage.suppliercattextbox.isEnabled()) {
				testCase = extent.createTest("STEP-03--SUPPLIER CATEGORY DROPDOWN TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				IncomingSamplePage.suppliercattextbox.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[contains(@title,'" + supplierCategory + "')]")).click();

			} else {
				testCase = extent.createTest("STEP-03--SUPPLIER CATEGORY DROPDOWN TEXTBOX IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// VEHICLE NUMBER
	public static void vehicleNO() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addVehicleNoTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-07--VEHICLE NO TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addVehicleNoTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-08--VEHICLE NO TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addVehicleNoTextBox.sendKeys(vehicleNo);

				} else {
					testCase = extent.createTest("STEP-08--VEHICLE NO TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-07--VEHICLE NO TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// SAMPLE CODE NUMBER
	public static void sampleCode() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.AddSampleCodeTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-09--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.AddSampleCodeTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-10--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.AddSampleCodeTextBox.sendKeys(sampleCode);

				} else {
					testCase = extent.createTest("STEP-10--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-09--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// SAMPLE TIME
	public static void sampleTime() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.sampleTime.isDisplayed()) {
				testCase = extent.createTest("STEP-14--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.sampleTime.isEnabled()) {
					testCase = extent.createTest("STEP-15--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.sampleTime.click();
					IncomingSamplePage.removeIcon.click();
					Thread.sleep(500);
					IncomingSamplePage.sampleTime.sendKeys(sampleTime);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER).perform();

				} else {
					testCase = extent.createTest("STEP-15--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-14--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// BL/LC NO
	public static void blLcNo() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.blLcNo.isDisplayed()) {
				testCase = extent.createTest("STEP-16--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.blLcNo.isEnabled()) {
					testCase = extent.createTest("STEP-17--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.blLcNo.sendKeys(da);

				} else {
					testCase = extent.createTest("STEP-17--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-16--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// GRN
	public static void grn() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addGRNTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-18--GRN TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addGRNTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-19--GRN TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addGRNTextBox.sendKeys(grn);

				} else {
					testCase = extent.createTest("STEP-19--GRN TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-18--GRN TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// QUANDITY AND BRAND RECEIVED
	public static void quandityAndBrand() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addQuandityAndBrandReceived.isDisplayed()) {
				testCase = extent.createTest("STEP-20--QUANDITY AND BRAND RECEIVED TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addQuandityAndBrandReceived.isEnabled()) {
					testCase = extent.createTest("STEP-21--QUANDITY AND BRAND RECEIVED TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addQuandityAndBrandReceived.sendKeys(quandityAndBrandReceived);

				} else {
					testCase = extent.createTest("STEP-21--QUANDITY AND BRAND RECEIVED TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-20--QUANDITY AND BRAND RECEIVED TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// SAVE BUTTON
	public static void addSaveButton() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.savebutton.isDisplayed()) {
				testCase = extent.createTest("STEP-22--SAVE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.savebutton.isEnabled()) {
					testCase = extent.createTest("STEP-23--SAVE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.savebutton.click();

				} else {
					testCase = extent.createTest("STEP-23--SAVE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-22--SAVE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void statusConfirmation() throws InterruptedException, IOException {
		// STATUS CHECKING
		try {
			testCase = extent.createTest("STEP-24--INCOMING SAMPLE ADD FUNCTION STATUS CONFIRM");
			String value = driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[16]/span/span/p"))
					.getText();
			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE STATUS", status, String.valueOf(value));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void addConfirmation() throws InterruptedException, IOException {
		IncomingSamplePage.tableFirstEditIcon.click();
		Thread.sleep(2000);

		testCase = extent.createTest("STEP-25--INCOMING SAMPLE ADD FUNCTION CONFIRM");
		// CHECKING THE SUPPLIER CATEGORY
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER CATEGORY FIELD",
					supplierCategory, String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE PLANT
		// ***********************************************************

		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE PLANT FIELD", plant,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.planttextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CHECK THE PLANT FILED IS DISABLED  ", "false",
					String.valueOf(value1));
		} catch (Exception e) {

		}

		// ***********************************************************

		// CHECKING THE SUPPLIER
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[3]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER FIELD", supplier,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE RAW MATERIAL
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE RAW MATERIAL FIELD", rawMaterial,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.rawmaterialtextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CHECK THE RAW MATERIAL FILED IS DISABLED  ",
					"false", String.valueOf(value1));
		} catch (Exception e) {

		}
		// CHECKING THE SUPPLIER CATEGORY
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER CATEGORY FIELD",
					supplierCategory, String.valueOf(value));
		} catch (Exception e) {

		}

		// CHECKING THE VEHICLE NUMBER
		try {
			String value = IncomingSamplePage.addVehicleNoTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE VEHICLE NUMBER FIELD", vehicleNo,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE CODE
		try {
			String value = IncomingSamplePage.AddSampleCodeTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE VEHICLE NUMBER FIELD", sampleCode,
					String.valueOf(value));
		} catch (Exception e) {

		}

		// CHECKING THE SOURCE
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SOURCE FIELD", source,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE DATE
		try {
			String value = IncomingSamplePage.samplingDate.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLING DATE FIELD", dateOfSampling,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE ARRIVAL DATE
		try {
			String value = IncomingSamplePage.arrivalDate.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE ARRIVAL DATE FIELD", arrivalDate,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE TIME
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div[1]/div/div[1]/div/input"))
					.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLE TIME FIELD", sampleTime,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE BL/LC NO
		try {
			String value = IncomingSamplePage.blLcNo.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE BL/LC NO FIELD", da,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE GRN
		try {
			String value = IncomingSamplePage.addGRNTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE ARRIVAL DATE FIELD", grn,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE QUANDITY AND BRAND RECEIVED
		try {
			String value = IncomingSamplePage.addQuandityAndBrandReceived.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE QUANDITY AND BRAND RECEIVED FIELD",
					quandityAndBrandReceived, String.valueOf(value));
		} catch (Exception e) {

		}
	}

	// CANCEL BUTTON
	public static void addCancelButton() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addCancelButton.isDisplayed()) {
				testCase = extent.createTest("STEP-26--CANCEL BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addCancelButton.isEnabled()) {
					testCase = extent.createTest("STEP-27--CANCEL BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addCancelButton.click();

				} else {
					testCase = extent.createTest("STEP-27--CANCEL BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-26--CANCEL BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// FOR EDIT

	/****************************************************************************
	 * DATA SEARCH AND CLICK THE EDIT BUTTON
	 ***************************************************************************/

	public static void dataPick() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Incoming Sample";
		String testCaseId = "TC-INC-SAM-0013";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			supplierCategoryE = (String) row.getCell(2).getStringCellValue();
			plantE = (String) row.getCell(3).getStringCellValue();
			supplierE = (String) row.getCell(4).getStringCellValue();
			rawMaterialE = (String) row.getCell(5).getStringCellValue();
			vehicleNoE = (String) row.getCell(6).getStringCellValue();
			sampleCodeE = (String) row.getCell(7).getStringCellValue();
			sourceE = (String) row.getCell(8).getStringCellValue();
			blLcNoE = row.getCell(12);
			daE = data.formatCellValue(blLcNoE);

			dateOfSamplingE = (String) row.getCell(9).getStringCellValue();
			arrivalDateE = (String) row.getCell(10).getStringCellValue();
			sampleTimeE = (String) row.getCell(11).getStringCellValue();

			grnE = (String) row.getCell(13).getStringCellValue();
			quandityAndBrandReceivedE = (String) row.getCell(14).getStringCellValue();
			statusE = (String) row.getCell(15).getStringCellValue();
			editSearch();
			editSupplierCategory();
			editPlant();
			editSupplier();
			editRawMaterial();
			editVehiccleNo();
			editSampleCode();
			editSource();
			editSampleDate();
			editArrivalDate();
			editSampleTime();
			editBlLcNo();
			editGrn();
			editQuandityAndBrand();

		}

	}

	public static void editSearch() throws InterruptedException, IOException {
		driver.findElement(
				By.xpath("//td[text()='" + tobepick + "']//following-sibling::td[22]//a//span[@aria-label='edit']"))
				.click();
		testCase = extent.createTest("STEP-01--SUCCESFULLY PICK THE EDIT DATA");
	}

	// CHECKING SUPPIER CATEGORY
	public static void editSupplierCategory() throws InterruptedException, IOException {

		SampleCommonMethods.fieldmethoddropdown("STEP-02-- SUPPLIER FIELD PROPERTIES ",
				IncomingSamplePage.editSupplierCatergory, "I--  SUPPLIER CATEGORY FIELD DISPLAYED",
				"II--  SUPPLIER CATEGORY FIELD ENABLED", "//div[contains(@title,'" + supplierCategoryE + "')]",
				"III--SUPPLIER CATEGORY DATA SUCCESSFULLY SELECTED");

	}

	// CHECKING THE PLANT
	// ***********************************************************
	public static void editPlant() throws InterruptedException, IOException {
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-03--CONFIRM THE PLANT FIELD", plantE,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.planttextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-04--CHECK THE PLANT FILED IS DISABLED  ", "false",
					String.valueOf(value1));
		} catch (Exception e) {

		}
	}

	public static void editSupplier() throws InterruptedException, IOException {
		/* SUPPLIER FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP-05-- SUPPLIER FIELD PROPERTIES ",
				IncomingSamplePage.suppliertextbox, "I--  SUPPLIER FIELD DISPLAYED", "II--  SUPPLIER FIELD ENABLED",
				supplierE, "III--SUPPLIER DATA SUCCESSFULLY SELECTED");
	}

	public static void editRawMaterial() throws InterruptedException, IOException {

		// CHECKING THE RAW MATERIAL
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-06--CONFIRM THE RAW MATERIAL FIELD", rawMaterialE,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.rawmaterialtextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-07--CHECK THE RAW MATERIAL FILED IS DISABLED  ",
					"false", String.valueOf(value1));
		} catch (Exception e) {

		}

	}

	public static void editVehiccleNo() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addVehicleNoTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-08--VEHICLE NO TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addVehicleNoTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-09--VEHICLE NO TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addVehicleNoTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					IncomingSamplePage.addVehicleNoTextBox.sendKeys(vehicleNoE);

				} else {
					testCase = extent.createTest("STEP-09--VEHICLE NO TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-08--VEHICLE NO TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void editSampleCode() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.AddSampleCodeTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-10--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.AddSampleCodeTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-11--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.AddSampleCodeTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					IncomingSamplePage.AddSampleCodeTextBox.sendKeys(sampleCodeE);

				} else {
					testCase = extent.createTest("STEP-11--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-10--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//SAMPLE TIME
	public static void editSampleTime() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.sampleTime.isDisplayed()) {
				testCase = extent.createTest("STEP-15--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.sampleTime.isEnabled()) {
					testCase = extent.createTest("STEP-16--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.sampleTime.click();
					IncomingSamplePage.removeIcon.click();
					Thread.sleep(500);
					IncomingSamplePage.sampleTime.sendKeys(sampleTimeE);
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ENTER).perform();

				} else {
					testCase = extent.createTest("STEP-16--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-15--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void editSource() throws InterruptedException, IOException {
		//CLOSE THE PREVIOUS DATA
		driver.findElement(By.xpath("//span[@class='ant-select-clear']//span[@aria-label='close-circle']")).click();
		Thread.sleep(2000);
		/* SOURCE FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_12-- SOURCE FIELD PROPERTIES ", IncomingSamplePage.AddSourceTextBox,
				"I--  SOURCE FIELD DISPLAYED", "II--  SOURCE FIELD ENABLED", sourceE,
				"III--SOURCE DATA SUCCESSFULLY SELECTED");
	}

	public static void editSampleDate() throws InterruptedException, IOException {
		// SAMPLING DATE VALUE
		try {
			SelectDate.dateSelectT("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0013-01", 9,
					IncomingSamplePage.samplingDate);
			testCase = extent.createTest("STEP-13--SAMPLING DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} catch (Exception e) {
			testCase = extent.createTest("STEP-13--SAMPLING DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void editArrivalDate() throws InterruptedException, IOException {
		// ARRIVAL DATE VALUE
		try {
			Thread.sleep(2000);
			SelectDate.dateSelect("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0013-01", 10,
					IncomingSamplePage.arrivalDate);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).perform();
			testCase = extent.createTest("STEP-14--ARRIVAL DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} catch (Exception e) {
			testCase = extent.createTest("STEP-14--ARRIVAL DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// BL/LC NO
	public static void editBlLcNo() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.blLcNo.isDisplayed()) {
				testCase = extent.createTest("STEP-17--SAMPLE CODE TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.blLcNo.isEnabled()) {
					testCase = extent.createTest("STEP-18--SAMPLE CODE TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.blLcNo.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					IncomingSamplePage.blLcNo.sendKeys(daE);

				} else {
					testCase = extent.createTest("STEP-18--SAMPLE CODE TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-17--SAMPLE CODE TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// GRN
	public static void editGrn() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addGRNTextBox.isDisplayed()) {
				testCase = extent.createTest("STEP-19--GRN TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addGRNTextBox.isEnabled()) {
					testCase = extent.createTest("STEP-20--GRN TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addGRNTextBox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					IncomingSamplePage.addGRNTextBox.sendKeys(grnE);

				} else {
					testCase = extent.createTest("STEP-20--GRN TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-19--GRN TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// QUANDITY AND BRAND RECEIVED
	public static void editQuandityAndBrand() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.addQuandityAndBrandReceived.isDisplayed()) {
				testCase = extent.createTest("STEP-21--QUANDITY AND BRAND RECEIVED TEXT BOX IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.addQuandityAndBrandReceived.isEnabled()) {
					testCase = extent.createTest("STEP-22--QUANDITY AND BRAND RECEIVED TEXT BOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.addQuandityAndBrandReceived.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					IncomingSamplePage.addQuandityAndBrandReceived.sendKeys(quandityAndBrandReceivedE);

				} else {
					testCase = extent.createTest("STEP-22--QUANDITY AND BRAND RECEIVED TEXT BOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-21--QUANDITY AND BRAND RECEIVED TEXT BOX IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void editStatusConfirmation() throws InterruptedException, IOException {
		// STATUS CHECKING
		try {
			testCase = extent.createTest("STEP-25--INCOMING SAMPLE ADD FUNCTION STATUS CONFIRM");
			String value = driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[16]/span/span/p"))
					.getText();
			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE STATUS", statusE, String.valueOf(value));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void editConfirmation() throws InterruptedException, IOException {
		IncomingSamplePage.tableFirstEditIcon.click();
		Thread.sleep(2000);

		testCase = extent.createTest("STEP-26--INCOMING SAMPLE ADD FUNCTION CONFIRM");
		// CHECKING THE SUPPLIER CATEGORY
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER CATEGORY FIELD",
					supplierCategoryE, String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE PLANT
		// ***********************************************************

		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE PLANT FIELD", plantE,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.planttextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CHECK THE PLANT FILED IS DISABLED  ", "false",
					String.valueOf(value1));
		} catch (Exception e) {

		}

		// ***********************************************************

		// CHECKING THE SUPPLIER
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[3]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER FIELD", supplierE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE RAW MATERIAL
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE RAW MATERIAL FIELD", rawMaterialE,
					String.valueOf(value));
			boolean value1 = IncomingSamplePage.rawmaterialtextbox.isEnabled();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CHECK THE RAW MATERIAL FILED IS DISABLED  ",
					"false", String.valueOf(value1));
		} catch (Exception e) {

		}
		// CHECKING THE SUPPLIER CATEGORY
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SUPPLIER CATEGORY FIELD",
					supplierCategoryE, String.valueOf(value));
		} catch (Exception e) {

		}

		// CHECKING THE VEHICLE NUMBER
		try {
			String value = IncomingSamplePage.addVehicleNoTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE VEHICLE NUMBER FIELD", vehicleNoE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE CODE
		try {
			String value = IncomingSamplePage.AddSampleCodeTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE VEHICLE NUMBER FIELD", sampleCodeE,
					String.valueOf(value));
		} catch (Exception e) {

		}

		// CHECKING THE SOURCE
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[3]/div[1]/div/div[1]/div/span[2]"))
					.getText();

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SOURCE FIELD", sourceE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE DATE
		try {
			String value = IncomingSamplePage.samplingDate.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLING DATE FIELD", dateOfSamplingE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE ARRIVAL DATE
		try {
			String value = IncomingSamplePage.arrivalDate.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE ARRIVAL DATE FIELD", arrivalDateE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE SAMPLE TIME
		try {
			String value = driver
					.findElement(By.xpath(
							"/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[4]/div[1]/div/div[1]/div/input"))
					.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLE TIME FIELD", sampleTimeE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE BL/LC NO
		try {
			String value = IncomingSamplePage.blLcNo.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE BL/LC NO FIELD", daE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE GRN
		try {
			String value = IncomingSamplePage.addGRNTextBox.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE ARRIVAL DATE FIELD", grnE,
					String.valueOf(value));
		} catch (Exception e) {

		}
		// CHECKING THE QUANDITY AND BRAND RECEIVED
		try {
			String value = IncomingSamplePage.addQuandityAndBrandReceived.getAttribute("value");

			PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE QUANDITY AND BRAND RECEIVED FIELD",
					quandityAndBrandReceivedE, String.valueOf(value));
		} catch (Exception e) {

		}
	}
	public static void editSaveButton() throws InterruptedException, IOException {
		try {
			if (IncomingSamplePage.savebutton.isDisplayed()) {
				testCase = extent.createTest("STEP-23--SAVE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (IncomingSamplePage.savebutton.isEnabled()) {
					testCase = extent.createTest("STEP-24--SAVE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					Thread.sleep(2000);
					IncomingSamplePage.savebutton.click();

				} else {
					testCase = extent.createTest("STEP-24--SAVE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-23--SAVE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
