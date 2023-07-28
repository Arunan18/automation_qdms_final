//***********************************************************************************
//* Description
//*------------
//* PLANT ADD FUNCTIONALITY METHODS
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 08/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-PLANT-0061          08/03/2023   RAHUL.S    Original Version
//*                        05/07/2023   RAHUL.S    updated
//************************************************************************************
package com.qa.automation.qdms.testcases.plant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantPage;

public class AddPlant extends DriverIntialization {
	static String code = null;
	static String plant = null;
	static String address = null;
	static String contactNo = null;
	static String fax = null;
	static String description = null;
	static String sbu = null;

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
		String testCaseId = "TC-PLANT-0061";
		DataFormatter data = new DataFormatter();
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		XSSFRow row = sheet.getRow(firstRow);
		code = data.formatCellValue(row.getCell(1));
		plant = data.formatCellValue(row.getCell(2));
		address = data.formatCellValue(row.getCell(3));
		contactNo = data.formatCellValue(row.getCell(4));
		fax = data.formatCellValue(row.getCell(5));
		description = data.formatCellValue(row.getCell(7));
		sbu = data.formatCellValue(row.getCell(6));

		// STEP-07--CODE FIELD IS DISPLAYED & STEP-08--CODE FIELD IS ENABLED
		sendValues(PlantPage.mandatory, code, "STEP-07--CODE FIELD IS DISPLAYED", "STEP-08--CODE FIELD IS ENABLED");

		// STEP-09--PLANT FIELD IS DISPLAYED & STEP-10--PLANT FIELD IS ENABLED
		sendValues(PlantPage.plantname, plant, "STEP-09--PLANT FIELD IS DISPLAYED", "STEP-10--PLANT FIELD IS ENABLED");

		// STEP-11--ADDRESS FIELD IS DISPLAYED & STEP-12--ADDRESS FIELD IS ENABLED
		sendValues(PlantPage.Address, address, "STEP-11--ADDRESS FIELD IS DISPLAYED",
				"STEP-12--ADDRESS FIELD IS ENABLED");

		// STEP-13--CONTACT FIELD IS DISPLAYED & STEP-14--CONTACT FIELD IS ENABLED
		sendValues(PlantPage.ContactNo, contactNo, "STEP-13--CONTACT FIELD IS DISPLAYED",
				"STEP-14--CONTACT FIELD IS ENABLED");

		// STEP-15--FAX FIELD IS DISPLAYED & STEP-16--FAX FIELD IS ENABLED
		sendValues(PlantPage.fax, fax, "STEP-15--FAX FIELD IS DISPLAYED", "STEP-16--FAX FIELD IS ENABLED");

		// STEP-17--DROP DOWN IS DISPLAYED & STEP-18--DROP DOWN IS ENABLED

		sbuDropDownSelect();

		// STEP-19--DESCRIPTION FIELD IS DISPLAYED & STEP-20--DESCRIPTION FIELD IS
		// ENABLED
		sendValues(PlantPage.Description, description, "STEP-19--DESCRIPTION FIELD IS DISPLAYED",
				"STEP-20--DESCRIPTION FIELD IS ENABLED");
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
			testCase = extent.createTest("STEP-17--DROP DOWN IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (PlantPage.ClickSubBusinessUnitDropDown.isEnabled()) {
				testCase = extent.createTest("STEP-18--DROP DOWN IS ENABLED");
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
				testCase = extent.createTest("STEP-18--DROP DOWN IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-17--DROP DOWN IS DISPLAYED");
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
				testCase = extent.createTest("STEP-19--SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-18--SAVE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

	}

	// **********************************************************************************************************************
	// STEP-08-- CONFIRM THE ADDED WILL BE IN THE FIRST ROW
	// **********************************************************************************************************************
	public static void confirmAdd() throws InterruptedException, IOException {

		buttonClick(PlantPage.checkingFirstRow, "STEP-23-CHECKING FIRST ROW EDIT BUTTON DISPLAYED",
				"STEP-24-CHECKING FIRST ROW EDIT BUTTON ENABLED", "EDIT BUTTON");

		try {

			String Value = PlantPage.mandatory.getAttribute("value");
			TestCasePrint("STEP-25--CONFIRM THE ADDED CODE", code, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.plantname.getAttribute("value");
			TestCasePrint("STEP-26--CONFIRM THE ADDED PLANT", plant, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Address.getAttribute("value");
			TestCasePrint("STEP-27--CONFIRM THE ADDED ADDRESS", address, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.ContactNo.getAttribute("value");
			TestCasePrint("STEP-28--CONFIRM THE ADDED CONTACT NUMBER", contactNo, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.fax.getAttribute("value");
			TestCasePrint("STEP-29--CONFIRM THE ADDED FAX", fax, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.sbuValidation1.getText();

			TestCasePrint("STEP-30--CONFIRM THE ADDED SBU", sbu, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Description.getAttribute("value");
			TestCasePrint("STEP-31--CONFIRM THE ADDED DESCRIPTION", description, String.valueOf(Value));
		} catch (Exception e) {

		}
	}

	public static void errorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PlantPage.plantCodeValidation));
		String errme = PlantPage.plantCodeValidation.getText();

		if (errme == "") {
			wait.until(ExpectedConditions.visibilityOf(PlantPage.plantNameValidation));
			errme = PlantPage.plantNameValidation.getText();
			if (errme == "") {
				wait.until(ExpectedConditions.visibilityOf(PlantPage.contactNoValidation));
				errme = PlantPage.contactNoValidation.getText();
				if (errme == "") {
					wait.until(ExpectedConditions.visibilityOf(PlantPage.faxValidation));
					errme = PlantPage.faxValidation.getText();
					if (errme == "") {
						wait.until(ExpectedConditions.visibilityOf(PlantPage.sbuValidation));
						errme = PlantPage.sbuValidation.getText();
					}
				}
			}
		}
		testCase = extent.createTest("THE VALIDATION MESSAGE IS APPEAR");
		testCase.log(Status.INFO, "THE VALIDATION MESSAGE IS : " + errme);
		testCase.log(Status.FAIL, "TEST FAIL ❎");
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
			TestCasePrint("STEP-23-CONFIRM THE ADDED CODE ", code, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.plantname.getAttribute("value");
			TestCasePrint("STEP-24-CONFIRM THE ADDED PLANT", plant, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Address.getAttribute("value");
			TestCasePrint("STEP-25--CONFIRM THE ADDED ADDRESS", address, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.ContactNo.getAttribute("value");
			TestCasePrint("STEP-26--CONFIRM THE ADDED CONTACT NUMBER", contactNo, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.fax.getAttribute("value");
			TestCasePrint("STEP-27--CONFIRM THE ADDED FAX", fax, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.sbuValidation1.getText();

			TestCasePrint("STEP-28--CONFIRM THE ADDED SBU", sbu, String.valueOf(Value));
		} catch (Exception e) {

		}
		try {
			String Value = PlantPage.Description.getAttribute("value");
			TestCasePrint("STEP-29--CONFIRM THE ADDED DESCRIPTION", description, String.valueOf(Value));
		} catch (Exception e) {

		}
	}
}
