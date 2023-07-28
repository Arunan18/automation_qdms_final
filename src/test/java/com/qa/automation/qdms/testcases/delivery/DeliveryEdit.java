//***********************************************************************************
//* Description
//*------------
//* Delivery EditButton 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-DEL-0057          01/03/2023   Gobithan     Original Version
//* TC-DEL-0060			 01/03/2023   Gobithan
//*TC-DEL-0046           21/07/2023   RAHUL.S      Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class DeliveryEdit extends DriverIntialization {
	static DeliveryPage delivery = new DeliveryPage();
	static DeliveryTest DeliveryAdd = new DeliveryTest();
	static Logout logout = new Logout();
	static DataFormatter dataValue = new DataFormatter();
	static boolean per = false;
	static boolean clickeditButton = false;
	static String editdelivery = null;
	static String editProject = null;
	static String editDescription = null;
	static boolean searchValue1 = false;
	static boolean projectDE = true;
	static boolean deliveryDE = true;

	@Test
	public static void Editfunction() throws InterruptedException, IOException {

		PageFactory.initElements(driver, delivery);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateDelivery();

		}

		testCase = extent.createTest("DELIVERY EDIT FUNCTIONALITY-TC-DEL-0046");

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Delivery";
		String testCaseId = "TC-DEL-0046";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			editdelivery = dataValue.formatCellValue(row.getCell(1));
			editProject = dataValue.formatCellValue(row.getCell(2));
			editDescription = dataValue.formatCellValue(row.getCell(3));
			String delivery = dataValue.formatCellValue(row.getCell(4));
			String project = dataValue.formatCellValue(row.getCell(5));
			String description = dataValue.formatCellValue(row.getCell(6));
			String msg = dataValue.formatCellValue(row.getCell(7));

			if (MasterMainNavigationsTest.clickDelivery) {

				dataSearch();
				beforeEdit();

			}

			if (clickeditButton) {
				sendValues(DeliveryPage.DeliveryField, delivery, "DELIVERY FIELD IS DISPLAYED",
						"DELIVERY FIELD IS ENABLED");

				projectfield(project);

				sendValues(DeliveryPage.descriptionTextBox, description, "DESCRIPTION FIELD IS DISPLAYED",
						"DESCRIPTION FIELD IS ENABLED");

				DeliveryMethod.buttonClick(DeliveryPage.Savebtn, DeliveryPage.successmsg, "SAVE BUTTON IS DISPLAYED",
						"SAVE BUTTON IS ENABLED", "SAVE BUTTON", msg);
				Thread.sleep(2000);
			}
			if (DeliveryPage.Savebtn.isDisplayed()) {
				try {
					DeliveryPage.Savebtn.isDisplayed();
					materialMethodes.validationconfirm("2", project, "Edit Delivery Validation");
					per = true;
				} catch (Exception e) {

				}
			}
			if (per == false) {
				if (deliveryDE) {
					confirmEdit(delivery, DeliveryPage.tablecolumn);
				}
				if (projectDE) {
					confirmEdit(project, DeliveryPage.projectColoum);
				}

			}

			driver.navigate().refresh();

			Logout.LogoutFunction();

		}

	}

	public static boolean dataSearch() throws InterruptedException {

		boolean nextButtonEnabled = true;

		while (nextButtonEnabled) {
			// Wait for up to 5 seconds for the element to be present before throwing an
			// exception
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			try {
				// Find the delete button using XPath based on the provided material and prefix
				// values
				WebElement editButton = driver
						.findElement(By.xpath("//td[text()='" + editdelivery + "']/following-sibling::td[text()='"
								+ editProject + "']/following-sibling::td[3]//span[contains(@class,'anticon-edit')]"));
				// Set the searchValue1 flag to true and exit the loop
				editButton.click();
				clickeditButton = true;
				searchValue1 = true;
				break;
			} catch (Exception e) {
				// If the element is not found, set searchValue1 flag to false
				searchValue1 = false;

			}

			try {
				// Check if the next button is enabled by using

				nextButtonEnabled = driver.findElement(By.xpath("//button//span[contains(@class,'anticon-right')]"))
						.isEnabled();
			} catch (Exception e) {

			}

			if (nextButtonEnabled) {
				try {
					// Click the next button if it is enabled
					driver.findElement(By.xpath("//button//span[contains(@class,'anticon-right')]")).click();
				} catch (Exception e) {

				}
			}
		}

		// Return the searchValue1 flag's final value after the loop completes
		return searchValue1;
	}

	public static void sendValues(WebElement xpath, String excelData, String displayedReport, String enabledReport) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			if (xpath.isDisplayed()) {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (xpath.isEnabled()) {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(xpath));

					xpath.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

					xpath.sendKeys(excelData);
				} else {
					testCase = extent.createTest(enabledReport);
					testCase.log(Status.PASS, "TEST FAIL ❎");
					deliveryDE = false;
				}
			} else {
				testCase = extent.createTest(displayedReport);
				testCase.log(Status.PASS, "TEST FAIL ❎");
				deliveryDE = false;
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

	public static void projectfield(String colname) throws InterruptedException {
		try {

			PageFactory.initElements(driver, delivery);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(DeliveryPage.projectDropDownField));
			if (DeliveryPage.ProjectField.isDisplayed()) {
				testCase = extent.createTest("DROP DOWN IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				if (DeliveryPage.ProjectField.isEnabled()) {
					testCase = extent.createTest("DROP DOWN IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					wait.until(ExpectedConditions.elementToBeClickable(DeliveryPage.projectDropDownField));
					DeliveryPage.projectDropDownField.click();
					wait.until(ExpectedConditions.visibilityOf(DeliveryPage.ProjectField));
					DeliveryPage.ProjectField.sendKeys(colname);

					DeliveryPage.ProjectField.sendKeys(Keys.ENTER);

				} else {

					testCase = extent.createTest("DROP DOWN IS ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
					projectDE = false;
				}
			} else {
				testCase = extent.createTest("DROP DOWN IS DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
				projectDE = false;
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

	public static void beforeEdit() throws IOException, InterruptedException {
		// CONFIRM THE DELIVERY FILED BEFORE EDIT
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(DeliveryPage.DeliveryField));
			if (DeliveryPage.DeliveryField.isDisplayed()) {

				String actualDelivery = DeliveryPage.DeliveryField.getAttribute("value");
				String expectedDelivery = editdelivery;
				boolean position = true;
				ExtentTest testCase = extent.createTest("CONFIRM THE DELIVERY FIELD BEFORE EDIT");
				try {
					AssertJUnit.assertEquals(actualDelivery, expectedDelivery);
				} catch (AssertionError e) {
					position = false;
				}
				if (position) {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "Expectedvalue :- " + expectedDelivery);
					testCase.log(Status.INFO, "Correct value");
					testCase.log(Status.PASS, actualDelivery);
				} else {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "ExpectedValue :- " + expectedDelivery);
					testCase.log(Status.INFO, "wrong value");
					testCase.log(Status.FAIL, actualDelivery);
				}

			} else {

			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		// CONFIRM THE PROJECT FILED BEFORE EDIT
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(DeliveryPage.projectDropDownField));
			if (DeliveryPage.projectDropDownField.isDisplayed()) {

				String actualDelivery = driver.findElement(By.xpath("//input[@id = 'project']/../..//span[2]/span"))
						.getText();
				String expectedDelivery = editProject;
				boolean position = true;
				ExtentTest testCase = extent.createTest("CONFIRM THE PROJECT FIELD BEFORE EDIT");
				try {
					AssertJUnit.assertEquals(actualDelivery, expectedDelivery);
				} catch (AssertionError e) {
					position = false;
				}
				if (position) {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "Expectedvalue :- " + expectedDelivery);
					testCase.log(Status.INFO, "Correct value");
					testCase.log(Status.PASS, actualDelivery);
				} else {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "ExpectedValue :- " + expectedDelivery);
					testCase.log(Status.INFO, "wrong value");
					testCase.log(Status.FAIL, actualDelivery);
				}

			} else {

				testCase.log(Status.FAIL, "DELIVERY FIELD DATA DISPLAYED FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		// CONFIRM THE DESCRIPTION FILED BEFORE EDIT

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(DeliveryPage.descriptionTextBox));
			if (DeliveryPage.descriptionTextBox.isDisplayed()) {

				String actualDelivery = DeliveryPage.descriptionTextBox.getText();
				String expectedDelivery = editDescription;
				boolean position = true;
				ExtentTest testCase = extent.createTest("CONFIRM THE DESCRIPTION FIELD BEFORE EDIT");
				try {
					AssertJUnit.assertEquals(actualDelivery, expectedDelivery);
				} catch (AssertionError e) {
					position = false;
				}
				if (position) {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "Expectedvalue :- " + expectedDelivery);
					testCase.log(Status.INFO, "Correct value");
					testCase.log(Status.PASS, actualDelivery);
				} else {
					testCase.log(Status.INFO, "Actualvalue :- " + actualDelivery);
					testCase.log(Status.INFO, "ExpectedValue :- " + expectedDelivery);
					testCase.log(Status.INFO, "wrong value");
					testCase.log(Status.FAIL, actualDelivery);
				}

			} else {

				testCase.log(Status.FAIL, "DELIVERY FIELD DATA DISPLAYED FAIL ❎");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT IS NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void confirmEdit(String data1, WebElement xpath) throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST ROW OF THE TABLE");
		String actualdata = null;
		try {
			actualdata = xpath.getText();
		} catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "THERE IS NO FIELD TO GET TEXT");
		} catch (Exception e) {
			testCase.log(Status.FAIL, "THERE IS NO FIELD TO GET TEXT");
		}

		boolean firstdata = true;

		try {
			AssertJUnit.assertEquals(actualdata, data1);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + data1);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}

	}
}
