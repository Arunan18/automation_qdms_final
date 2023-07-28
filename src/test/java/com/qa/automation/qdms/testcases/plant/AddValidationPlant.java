/***********************************************************************************
* Description
*------------
* ADD VALIDATION FOR PLANT
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 07/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLANT-0062          10/04/2023   RAHUL.S     MODIFIED
*                        17/04/2023   RAHUL.S     MODIFIED
*                        20/04/2023    RAHUL.S    MODIFIED
************************************************************************************/
package com.qa.automation.qdms.testcases.plant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantPage;

public class AddValidationPlant extends DriverIntialization {
	static boolean per = false;
	static String code = null;
	static String plant = null;
	static String address = null;
	static String contactNo = null;
	static String fax = null;
	static String description = null;
	static String sbu = null;
	static String exceptedValidCode = null;
	static String exceptedValidPlant = null;
	static String codeGenerate = null;
	static String plantGenerate = null;
	static String exceptedValidSbu = null;
	static String exceptedValidContact = null;
	static String exceptedValidFax = null;
	static String contactNoGenerate = null;
	static String sbuGenerate = null;
	static String faxGenerate = null;
	static String check = null;

// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT
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

	/*****************************************************************************************
	 * DATA GETTING FROM EXCEL EDIT VALIDATION
	 *****************************************************************************************/
	public static void excelcall() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Plant";
		String testCaseId = "TC-PLANT-0062";
		DataFormatter data = new DataFormatter();
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			check = data.formatCellValue(row.getCell(1));
			code = data.formatCellValue(row.getCell(2));
			plant = data.formatCellValue(row.getCell(3));
			address = data.formatCellValue(row.getCell(4));
			contactNo = data.formatCellValue(row.getCell(5));
			fax = data.formatCellValue(row.getCell(6));
			description = data.formatCellValue(row.getCell(8));
			sbu = data.formatCellValue(row.getCell(7));
			exceptedValidCode = data.formatCellValue(row.getCell(9));
			exceptedValidPlant = data.formatCellValue(row.getCell(10));
			exceptedValidSbu = data.formatCellValue(row.getCell(11));
			exceptedValidContact = data.formatCellValue(row.getCell(12));
			exceptedValidFax = data.formatCellValue(row.getCell(13));
			codeGenerate = data.formatCellValue(row.getCell(14));
			plantGenerate = data.formatCellValue(row.getCell(15));
			sbuGenerate = data.formatCellValue(row.getCell(16));
			contactNoGenerate = data.formatCellValue(row.getCell(17));
			faxGenerate = data.formatCellValue(row.getCell(18));

			// STEP-07--CODE FIELD IS DISPLAYED & STEP-08--CODE FIELD IS ENABLED
			sendValues(PlantPage.mandatory, code, "CODE FIELD IS DISPLAYED", "CODE FIELD IS ENABLED");

			// STEP-09--PLANT FIELD IS DISPLAYED & STEP-10--PLANT FIELD IS ENABLED
			sendValues(PlantPage.plantname, plant, "PLANT FIELD IS DISPLAYED", "PLANT FIELD IS ENABLED");

			// STEP-11--ADDRESS FIELD IS DISPLAYED & STEP-12--ADDRESS FIELD IS ENABLED
			sendValues(PlantPage.Address, address, "ADDRESS FIELD IS DISPLAYED", "ADDRESS FIELD IS ENABLED");

			// STEP-13--CONTACT FIELD IS DISPLAYED & STEP-14--CONTACT FIELD IS ENABLED
			sendValues(PlantPage.ContactNo, contactNo, "CONTACT FIELD IS DISPLAYED", "CONTACT FIELD IS ENABLED");

			// STEP-15--FAX FIELD IS DISPLAYED & STEP-16--FAX FIELD IS ENABLED
			sendValues(PlantPage.fax, fax, "FAX FIELD IS DISPLAYED", "FAX FIELD IS ENABLED");

			// STEP-17--DROP DOWN IS DISPLAYED & STEP-18--DROP DOWN IS ENABLED

			sbuDropDownSelect();

			// STEP-19--DESCRIPTION FIELD IS DISPLAYED & STEP-20--DESCRIPTION FIELD IS
			// ENABLED
			sendValues(PlantPage.Description, description, "DESCRIPTION FIELD IS DISPLAYED",
					"DESCRIPTION FIELD IS ENABLED");
			// ****************************************************************************************
			// STEP-21--SAVE BUTTON IS DISPLAYED AND STEP-22--SAVE BUTTON IS ENABLED
			// ****************************************************************************************
			buttonClick(PlantPage.saveButton, "SAVE BUTTON IS DISPLAYED", "SAVE BUTTON IS ENABLED", "SAVE BUTTON");
			Thread.sleep(2000);

			if (PlantPage.saveButton.isDisplayed()) {
				errorMessage();
				buttonClick(PlantPage.cancelbutton, "CANCEL BUTTON IS DISPLAYED", "CANCEL BUTTON IS DISPLAYED",
						"CANCEL BUTTON");
				per = true;

			}
			if (per == false) {
				confirmAdd();
				if (per == true) {
					tableConfirm();
				}
			}
			buttonClick(PlantPage.addPlantButton, "ADD BUTTON IS DISPLAYED", "ADD BUTTON IS ENABLED", "ADD PLANT");

		}
	}

	public static void sendValues(WebElement xpath, String excelData, String displayedReport, String enabledReport) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (xpath.isEnabled()) {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
					xpath.sendKeys(excelData);
				} else {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void sbuDropDownSelect() throws InterruptedException, IOException {
		ArrayList<String> sbulist = new ArrayList<String>();
// ****************************************************************************************
// STEP-15--DROP DOWN IS DISPLAYED AND STEP-16--DROP DOWN IS ENABLED
// ****************************************************************************************
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOf(PlantPage.ClickSubBusinessUnitDropDown));
		if (PlantPage.ClickSubBusinessUnitDropDown.isDisplayed()) {
			testCase = extent.createTest("SBU IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (PlantPage.ClickSubBusinessUnitDropDown.isEnabled()) {
				testCase = extent.createTest("SBU IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				Actions actions = new Actions(driver);
				wait.until(ExpectedConditions.visibilityOf(PlantPage.ClickSubBusinessUnitDropDown));
				PlantPage.ClickSubBusinessUnitDropDown.click();
				try {
					boolean pass = true;

					while (pass) {

						if (pass) {
							try {
								try {
									String gettigdata = null;
									try {
										wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
												"//div[@id='sub_business_unit_list']/../div[2]/div[1]/div/div/div[2]/div/span")));
									} catch (Exception e) {
										// TODO: handle exception
									}
									try {
										gettigdata = driver.findElement(By.xpath(
												"//div[@id='sub_business_unit_list']/../div[2]/div[1]/div/div/div[2]/div/span"))
												.getText();
									} catch (Exception e) {
										// TODO: handle exception
									}
									sbulist.add(gettigdata);

									int inb = sbulist.size();
									if (inb >= 11) {
										if (sbulist.get(9).equals(gettigdata)) {
											break;
										}
									}

								} catch (Exception e) {

								}
								WebElement list = driver.findElement(By.xpath("//span[text()='" + sbu + "']"));
								System.out.println(list);
								list.click();

								pass = false;
							} catch (Exception e) {
							}
						}
						if (pass) {
							actions.sendKeys(Keys.ARROW_DOWN).perform();

						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				testCase = extent.createTest("SBU IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("SBU IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void buttonClick(WebElement xpath, String reportDisplay, String reportEnable, String whichElement)
			throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(xpath));
		} catch (Exception e) {
			testCase = extent.createTest("THE " + whichElement + " IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");

		}

		if (xpath.isDisplayed()) {
			testCase = extent.createTest(reportDisplay);
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (xpath.isEnabled()) {
				testCase = extent.createTest(reportEnable);
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					wait.until(ExpectedConditions.elementToBeClickable(xpath));
					xpath.click();
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT FOUND");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (ElementClickInterceptedException e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.INFO, "ELEMENT IS NOT CLICKED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				} catch (Exception e) {
					testCase = extent.createTest("THERE IS NO ELEMENT");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// **********************************************************************************************************************
	// STEP-08-- CONFIRM THE ADDED WILL BE IN THE FIRST ROW
	// **********************************************************************************************************************
	public static void confirmAdd() throws InterruptedException, IOException {

		buttonClick(PlantPage.checkingFirstRow, "CHECKING FIRST ROW EDIT BUTTON DISPLAYED",
				"CHECKING FIRST ROW EDIT BUTTON ENABLED", "EDIT BUTTON");

		try {

			String Value = PlantPage.mandatory.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED CODE", code, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.plantname.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED PLANT", plant, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Address.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED ADDRESS", address, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.ContactNo.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED CONTACT NUMBER", contactNo, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.fax.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED FAX", fax, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.sbuValidation1.getText();

			TestCasePrint("CONFIRM THE ADDED SBU", sbu, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Description.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED DESCRIPTION", description, String.valueOf(Value));
		} catch (Exception e) {

		}
	}

	public static void errorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		if (check.contentEquals("code")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(PlantPage.plantCodeValidation));
				testCase = extent.createTest(codeGenerate);
				String ActualValidation = PlantPage.codeValidation.getText();

				String ExpectedValidation = exceptedValidCode;

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

			} catch (Exception e) {

			}
		}
		if (check.contentEquals("plant")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(PlantPage.plantNameValidation));
				testCase = extent.createTest(plantGenerate);
				String ActualValidation = PlantPage.plantNameValidation.getText();

				String ExpectedValidation = exceptedValidPlant;

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

			} catch (Exception e) {

			}
		}

		if (check.contentEquals("contactNo")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(PlantPage.contactNoValidation));
				testCase = extent.createTest(contactNoGenerate);
				String ActualValidation = PlantPage.contactNoValidation.getText();

				String ExpectedValidation = exceptedValidContact;

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

			} catch (Exception e) {

			}
		}
		if (check.contentEquals("fax")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(PlantPage.faxValidation));
				testCase = extent.createTest(faxGenerate);
				String ActualValidation = PlantPage.faxValidation.getText();

				String ExpectedValidation = exceptedValidFax;

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

			} catch (Exception e) {

			}
		}

	}

	public static void tableConfirm() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tr//td[text()='" + code
				+ "' and following-sibling::td[1][text()='" + plant + "'] and following-sibling::td[2][text()='" + sbu
				+ "'] and following-sibling::td[4][text()='" + address + "'] and following-sibling::td[5][text()='"
				+ contactNo + "'] and following-sibling::td[6][text()='" + fax
				+ "']]//following-sibling::td[8]//span[contains(@class,'anticon-edit')]"))));

		driver.findElement(By.xpath("//tr//td[text()='" + code + "' and following-sibling::td[1][text()='" + plant
				+ "'] and following-sibling::td[2][text()='" + sbu + "'] and following-sibling::td[4][text()='"
				+ address + "'] and following-sibling::td[5][text()='" + contactNo
				+ "'] and following-sibling::td[6][text()='" + fax
				+ "']]//following-sibling::td[8]//span[contains(@class,'anticon-edit')]")).click();

		try {

			String Value = PlantPage.mandatory.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED CODE ", code, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.plantname.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED PLANT", plant, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Address.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED ADDRESS", address, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.ContactNo.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED CONTACT NUMBER", contactNo, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.fax.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED FAX", fax, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.sbuValidation1.getText();

			TestCasePrint("CONFIRM THE ADDED SBU", sbu, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Description.getAttribute("value");
			TestCasePrint("CONFIRM THE ADDED DESCRIPTION", description, String.valueOf(Value));
		} catch (Exception e) {

		}
	}

}
