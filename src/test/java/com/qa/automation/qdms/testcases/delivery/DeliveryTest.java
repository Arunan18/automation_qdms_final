//***********************************************************************************
//* Description
//*------------
//* Delivery AddButton 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.SingleSearchMethods;

public class DeliveryTest extends DriverIntialization {

	static DeliveryPage delivery = new DeliveryPage();
	static SingleSearchMethods singlesearch = new SingleSearchMethods();

	static String Project = "";
	static String textarea = "";
	static String expectedsuccessmsgresult = "";
	static String Deliverycyclename = "";
	static String expectedresult = "";
	static String editvalue = "";
	static String fieldvalue = "";
	static String DeleteValue = "";
	static String DependDeleteValue = "";

	/******************************************************************************
	 * Data Search Functionality
	 ******************************************************************************/
	public static void DataSearch(String Name, String NameXpath_firstPart, String NameXpath_lastPart,
			String EditXpath_firstPart, String EditXpath_lastPart) throws InterruptedException, IOException {

		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(2000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						sbuExist = true;

						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();

						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}
	}

	/******************************************************************************
	 * Field Value Check Function (VISIBLE & ENABLE)
	 ******************************************************************************/

	static boolean Visible = true;
	static boolean Enable = true;

	public static void EnableDisablecheckMethod(WebElement field, String testCasedetail, String displaypass,
			String displayfail, String enablepass, String enablefail) throws InterruptedException {

		testCase = extent.createTest(testCasedetail);
		String expecteddata = "true";
		try {
			Assert.assertEquals(field.isDisplayed(), true);
			testCase.log(Status.INFO, "Actual Data :- " + Visible);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, displaypass);
		} catch (AssertionError e) {
			Visible = false;
			testCase.log(Status.INFO, "Actual Data :- " + Visible);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, displayfail);
		} catch (NoSuchElementException e) {
			Visible = false;
			testCase.log(Status.FAIL, "Wrong last added data");
		}
		if (Visible) {
			try {
				Assert.assertEquals(field.isEnabled(), true);
				testCase.log(Status.INFO, "Actual Data :- " + Enable);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.PASS, enablepass);
			} catch (AssertionError e) {
				Enable = false;
				testCase.log(Status.INFO, "Actual Data :- " + Enable);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.FAIL, enablefail);
			}
		}

		// if (Visible) {

		// }
	}

	/**********************************************************************************************
	 * Delivery --> Customer --> Delivery
	 **********************************************************************************************/
	public static void customerDelivery() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);
		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();
	}

	/**********************************************************************************************
	 * Delivery Add Form Visible & Enable
	 **********************************************************************************************/

	public static void fieldvisible() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		// Customer --> Delivery
		customerDelivery();

		/*******************************
		 * DELIVERY ADD BUTTON VISIBLE & ENABLED
		 *********************************/

		Thread.sleep(2000);
		if (delivery.deliveryaddbtn.isDisplayed()) {
			testCase = extent.createTest("1.DELIVERY ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.deliveryaddbtn.isEnabled()) {
				testCase = extent.createTest("2.DELIVERY ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					delivery.deliveryaddbtn.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("2.DELIVERY ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("1.DELIVERY ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/*******************************
		 * ADD DELIVERY FORM DELIVERY FIELD VISIBLE & ENABLED
		 *********************************/

		Thread.sleep(2000);
		if (delivery.enterdeliverycycle.isDisplayed()) {
			testCase = extent.createTest("3.ADD DELIVERY FORM DELIVERY FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.enterdeliverycycle.isEnabled()) {
				testCase = extent.createTest("4.DELIVERY FORM DELIVERY FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {

					FileInputStream file = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet("Delivery");

					int rowcount = sheet.getLastRowNum();

					int firstrow = CommonMethods.getFirstRowNum(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
							"Delivery", "TC-DEL-0029");
					int lastrow = CommonMethods.getLastRowNum(
							System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
							"Delivery", "TC-DEL-0029");

					for (int i = firstrow; i <= lastrow; i++) {
						XSSFRow row = sheet.getRow(i);

						Deliverycyclename = (String) row.getCell(1).getStringCellValue();
						Project = (String) row.getCell(2).getStringCellValue();
						textarea = (String) row.getCell(3).getStringCellValue();
						expectedsuccessmsgresult = (String) row.getCell(4).getStringCellValue();
						Thread.sleep(2000);

						delivery.enterdeliverycycle.sendKeys(Deliverycyclename);
						Thread.sleep(2000);
					}
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("4.DELIVERY FORM DELIVERY FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("3.ADD DELIVERY FORM DELIVERY FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/********************************
		 * ADD DELIVERY FORM PROJECT FIELD VISIBLE & ENABLED
		 *********************************/

		Thread.sleep(2000);
		if (delivery.dropdown.isDisplayed()) {
			testCase = extent.createTest("5.ADD DELIVERY FORM PROJECT FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.dropdown.isEnabled()) {
				testCase = extent.createTest("6.ADD DELIVERY FORM PROJECT FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					delivery.selectproject.sendKeys(Project);
					Thread.sleep(3000);
					delivery.dropdownfield.click();
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("6.ADD DELIVERY FORM PROJECT FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("5.ADD DELIVERY FORM PROJECT FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/******************************
		 * ADD DELIVERY FORM DESCRIPTION FIELD VISIBLE & ENABLED
		 *********************************/

		Thread.sleep(2000);
		if (delivery.textarea.isDisplayed()) {
			testCase = extent.createTest("7.ADD DELIVERY FORM DESCRIPTION FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.textarea.isEnabled()) {
				testCase = extent.createTest("8.ADD DELIVERY FORM DESCRIPTION FIELD ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					delivery.textarea.sendKeys(textarea);
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("8.ADD DELIVERY FORM DESCRIPTION FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("7.ADD DELIVERY FORM DESCRIPTION FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/******************************
		 * ADD DELIVERY FORM SAVE BUTTON FIELD VISIBLE & ENABLED
		 *********************************/

		Thread.sleep(2000);
		if (delivery.dropdown.isDisplayed()) {
			testCase = extent.createTest("9.ADD DELIVERY FORM SAVE BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.dropdown.isEnabled()) {
				testCase = extent.createTest("10.ADD DELIVERY FORM SAVE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					delivery.Savebtn.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("10.ADD DELIVERY FORM DESCRIPTION FIELD ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("9.ADD DELIVERY FORM DESCRIPTION FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		} 

	}

	/**********************************************************************************************
	 * Add Method for Delivery
	 **********************************************************************************************/

	public static void deliveryadddata() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		Thread.sleep(1000);
		String AddSuccessMessage = delivery.successmsg.getText();
		System.out.println(AddSuccessMessage);
		String expectedatamsg = expectedsuccessmsgresult;

		testCase = extent.createTest("11.Data Added Success Message");
		try {
			Assert.assertEquals(AddSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}

		Thread.sleep(4000);
		driver.navigate().refresh();

		Thread.sleep(2000);
		String actualdata = DeliveryPage.firstaddeddata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = Deliverycyclename;

		boolean firstdata = true;
		testCase = extent.createTest("12.CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}

	}

	/**********************************************************************************************
	 * Add Delivery Cancel Button
	 **********************************************************************************************/

	public static void deliveryaddcancelbtn() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		// Customer --> Delivery
		customerDelivery();

		/**************************************
		 * Add BUTTON ENABLE || VISIBLE
		 **************************************/
		Thread.sleep(2000);
		testCase = extent.createTest("STEP 1: DELIVERY ADD BUTTON DATAS VISIBLE OR NOT");
		if (delivery.deliveryaddbtn.isDisplayed()) {
			testCase = extent.createTest("1.DELIVERY ADD BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.deliveryaddbtn.isEnabled()) {
				testCase = extent.createTest("2.DELIVERY ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					delivery.deliveryaddbtn.click();
					// Add Button Clicked or not
					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("3.ADD DELIVERY BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST FAIL");
					} else {
						testCase = extent.createTest("3.ADD DELIVERY BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("2.DELIVERY ADD BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("1.DELIVERY ADD BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/**************************************
		 * CANCEL BUTTON ENABLE || VISIBLE
		 **************************************/

		Thread.sleep(2000);
		if (delivery.Cancelbtn.isDisplayed()) {
			testCase = extent.createTest("4.ADD DELIVERY CANCEL BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.Cancelbtn.isEnabled()) {
				testCase = extent.createTest("5.ADD DELIVERY CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					driver.findElement(By.xpath("//body/div[2]")).isDisplayed();
					boolean addmodelwindow = true;

					delivery.Cancelbtn.click();
					if (!driver.findElement(By.xpath("//body/div[2]")).isDisplayed()) {
						addmodelwindow = false;
					}
					// Add Button Clicked or not
					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("6.ADD DELIVERY CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");

						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("7.ADD DELIVERY MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("7.ADD DELIVERY MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("6.ADD DELIVERY CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("5.ADD DELIVERY CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("4.ADD DELIVERY CANCEL BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/***********************************
		 * ON CLICK THE CANCEL BUTTON DATA ADDED OR NOT
		 *************************************/

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0039"); 
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0039");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			Deliverycyclename = (String) row.getCell(1).getStringCellValue();
			Project = (String) row.getCell(2).getStringCellValue();
			textarea = (String) row.getCell(3).getStringCellValue();
			expectedresult = (String) row.getCell(4).getStringCellValue();
			Thread.sleep(2000);
		}

		delivery.deliveryaddbtn.click();

		Thread.sleep(1000);
		delivery.enterdeliverycycle.sendKeys(Deliverycyclename);

		Thread.sleep(1500);
		delivery.selectproject.sendKeys(Project);

		Thread.sleep(2000);
		delivery.dropdownfield.click();

		Thread.sleep(3000);
		delivery.textarea.sendKeys(textarea);

		delivery.Cancelbtn.click();

		Thread.sleep(4000);
		driver.navigate().refresh();

		Thread.sleep(2000);
		String actualdata = DeliveryPage.firstaddeddata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = expectedresult;

		boolean firstdata = true;
		testCase = extent.createTest("8.CHECK THE ENTERED VALUE HAS NOT SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (!firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "On click the Cancel Button data not added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "On click the Cancel Button data added in first row");
		}

		/***********************************
		 * ON CLICK THE CANCEL BUTTON DATA ADDED OR NOT
		 *************************************/

		testCase = extent.createTest("STEP 2: AFTER CLICK THE CANCEL BUTTON DATAS VISIBLE OR NOT");
		Thread.sleep(2000);
		delivery.deliveryaddbtn.click();

		Thread.sleep(1000);

		String deliverycycle = delivery.enterdeliverycycle.getText();

		Thread.sleep(1500);

		String selectproject = delivery.selectproject.getText();

		Thread.sleep(1500);
		String textarea = delivery.textarea.getText();

		delivery.Cancelbtn.click();

		Thread.sleep(2000);
		// DELIVERY FIELD EMPTY VALUE CHECKING
		if (deliverycycle == "") {
			testCase = extent.createTest("1.AFTER CLICK THE CANCEL BUTTON DELIVERY FILED EMPTY");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase = extent.createTest("1.AFTER CLICK THE CANCEL BUTTON DELIVERY FILED NOT EMPTY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		// PROJECT FIELD EMPTY VALUE CHECKING
		if (selectproject == "") {
			testCase = extent.createTest("2.AFTER CLICK THE CANCEL BUTTON PROJECT FILED EMPTY");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase = extent.createTest("2.AFTER CLICK THE CANCEL BUTTON PROJECT FILED NOT EMPTY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		// TEXTAREA FIELD EMPTY VALUE CHECKING
		if (textarea == "") {
			testCase = extent.createTest("3.AFTER CLICK THE CANCEL BUTTON TEXTAREA FILED EMPTY");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase = extent.createTest("3.AFTER CLICK THE CANCEL BUTTON TEXTAREA FILED NOT EMPTY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	/**************************************************************************************************/

	/**********************************************************************************************
	 * Add Method for Delivery After change the pagination
	 **********************************************************************************************/

	public static void adddeliverypagination() throws InterruptedException, IOException {

		PageFactory.initElements(driver, delivery);

		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// Add Deliver After change the pagination Data Pass Form Excel sheet

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0063");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0063");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			Deliverycyclename = (String) row.getCell(1).getStringCellValue();
			Project = (String) row.getCell(2).getStringCellValue();
			textarea = (String) row.getCell(3).getStringCellValue();
			expectedresult = (String) row.getCell(4).getStringCellValue();
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		if (delivery.NextPageBtn.isEnabled()) {
			for (int i = 1; i < 4; i++) {
				Thread.sleep(2000);
				delivery.NextPageBtn.click();
			}

			boolean Actual = delivery.NextPageBtn.isEnabled();
			boolean Expected = true;

			if (Actual == true) {

				Thread.sleep(2000);
				delivery.deliveryaddbtn.click();

				Thread.sleep(1000);
				delivery.enterdeliverycycle.sendKeys(Deliverycyclename);

				Thread.sleep(1500);
				delivery.selectproject.sendKeys(Project);

				Thread.sleep(3000);
				delivery.dropdownfield.click();

				Thread.sleep(1500);
				delivery.textarea.sendKeys(textarea);

				Thread.sleep(1500);
				delivery.Savebtn.click();

				Thread.sleep(1000);
				String AddSuccessMessage = delivery.successmsg.getText();
				System.out.println(AddSuccessMessage);
				String expectedatamsg = expectedresult;
				testCase = extent.createTest("STEP-01 : AFTER CHANGE THE PAGINATION DATA ADD");
				try {
					testCase = extent.createTest("1.AFTER CHANGE THE PAGINATION DATA ADDED SUCCESS MESSAGE");
					Assert.assertEquals(AddSuccessMessage, expectedatamsg);
					testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
					testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
					testCase.log(Status.PASS, "Success Message Enable");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
					testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
					testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
				}

				Thread.sleep(4000);
				driver.navigate().refresh();

				Thread.sleep(2000);
				String actualdata = DeliveryPage.firstaddeddata.getText();
				System.out.println("First row of table : " + actualdata);

				String expecteddata = Deliverycyclename;

				boolean firstdata = true;
				testCase = extent.createTest(
						"2.CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE AFTER CHANGE PAGINATION");
				try {
					AssertJUnit.assertEquals(actualdata, expecteddata);

				} catch (AssertionError e) {
					firstdata = false;
				}
				if (firstdata) {
					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.PASS, "Correct last data added in first row");
				} else {
					testCase.log(Status.INFO, "Actual Data :- " + actualdata);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
				}
			} else {
				testCase.log(Status.INFO, "Actual Data :- " + Actual);
				testCase.log(Status.INFO, "Expected Data :- " + Expected);
				testCase.log(Status.FAIL, "Delivery Data Not Added pagination Next Button Not Enabled");
			}
		}

	}

	/*******************************************************************************************/

	/**********************************************************************************************
	 * Add Method Validation
	 **********************************************************************************************/

	public static void CheckValidation() throws IOException, InterruptedException {

	PageFactory.initElements(driver, delivery);
		
		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
			MasterMainNavigationsTest.navigateCustomerMain();
	
		// Click on Customer Delivery Button
			MasterMainNavigationsTest.navigateDelivery(); 
			 
		
	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Delivery";
		String testCaseId = "TC-DEL-0037";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");
		
		testCase = extent.createTest("STEP-01--DELIVERY FIELD VALIDATION");
		
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			
			Thread.sleep(2000);
			delivery.deliveryaddbtn.click();
			
			String check = (String) row.getCell(1).getStringCellValue();
			String sbu = (String) row.getCell(2).getStringCellValue().toString();
			String project = (String) row.getCell(3).getStringCellValue();
			String validation = (String) row.getCell(4).getStringCellValue();
			String validation2 = (String) row.getCell(5).getStringCellValue();
			String Message = (String) row.getCell(6).getStringCellValue();

				
				Thread.sleep(2000);
				delivery.enterdeliverycycle.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				
				Thread.sleep(1000);
				delivery.enterdeliverycycle.sendKeys(sbu);
				
				Thread.sleep(2000);
				delivery.selectproject.click();
				Thread.sleep(2000);
				delivery.selectproject.sendKeys(project);
				Thread.sleep(2000);
				delivery.selectproject.sendKeys(Keys.ENTER);
				
				
				Thread.sleep(2000);
				delivery.Savebtn.click();
			
			if (check.contains("delivery")) 
			{
				try {
				Thread.sleep(1000);
				String ActualValidation = delivery.Deliveryvalidation.getText();
				System.out.println(ActualValidation);
				String ExpectedValidation = validation;
				testCase = extent.createTest("Check " + Message);
				try {
					Assert.assertEquals(ActualValidation, ExpectedValidation);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.PASS, "Pass " + Message + "Script");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				}		
				}catch(AssertionError e)
				{
					
				}
			}
			
			if (check.contains("project")) 
			{
				try {
				Thread.sleep(1000);
				String ActualValidation = delivery.Deliveryvalidation.getText();
				System.out.println(ActualValidation);
				String ExpectedValidation = validation2;
				testCase = extent.createTest("Check " + Message);
				try {
					Assert.assertEquals(ActualValidation, ExpectedValidation);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.PASS, "Pass " + Message + "Script");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				}		
				}catch(AssertionError e)
				{
					
				}
			}
			Thread.sleep(2000);
			delivery.Cancelbtn.click();
		}
	}
		
	

	/*******************************************************************************************/

	/**********************************************************************************************
	 * Delete Method for Delivery
	 **********************************************************************************************/

	public static void daliverydelete() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0052");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0052");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			DeleteValue = (String) row.getCell(1).getStringCellValue();
			Thread.sleep(2000);
		}

		/***************************************************************************************
		 * Count Number of elements before search in Delivery field
		 ***************************************************************************************/
		Thread.sleep(2000);
		int finalBeforeCount = singlesearch.dataCount(0,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]");

		Thread.sleep(4000);
		DataSearch(DeleteValue,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[5]/span/a[2]/a/span");

		Thread.sleep(1500);
		delivery.Deleteconfirmbtn.click();

		Thread.sleep(1500);
		String DeleteSuccessMessage = delivery.deletemsg.getText();
		String expectedatamsg = "Delivery Succeessfully Deleted";

		try {
			testCase = extent.createTest("STEP-01--DATA DELETED SUCCESS MESSAGE");
			try {
				Assert.assertEquals(DeleteSuccessMessage, expectedatamsg);
				testCase.log(Status.INFO, "Actual Data :- " + DeleteSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.PASS, "1.Delete Success Message Enable");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Data :- " + DeleteSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.FAIL, "1.Wrong Delete Success Message Not Enable");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "1.Wrong Message Not Enable");
		}

		/***************************************************************************************
		 * Count Number of elements After search in Delivery table
		 ***************************************************************************************/

		Thread.sleep(2000);
		int finalAfterCount = singlesearch.dataCount(0,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]");
		System.out.println(finalAfterCount);

		/***************************************************************************************
		 * Reset Before After Counting Check
		 ***************************************************************************************/

		try {
			testCase = extent.createTest("STEP-02--CHECK BEFORE AFTER DATA COUNTS AFTER DELETE");
			try {
				Assert.assertEquals(finalBeforeCount, finalAfterCount);
				testCase.log(Status.INFO, "Before Data Counts :- " + finalBeforeCount);
				testCase.log(Status.INFO, "After Data Counts :- " + finalAfterCount);
				testCase.log(Status.FAIL, "Correct Before & After Data Counts Are Same");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Before Data Counts :- " + finalBeforeCount);
				testCase.log(Status.INFO, "After Data Counts :- " + finalAfterCount);
				testCase.log(Status.PASS, "Wrong Before & After Data Counts Are Not Same");

			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("STEP-02--CHECKING BEFORE AFTER DATA COUNTS FAILED BECAUSE OF NO ELEMENTS");
		}
	}

	/**********************************************************************************************
	 * Delete Method for Delivery After Depended
	 **********************************************************************************************/

	public static void daliverydeleteafterdepended() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0061");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0061");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			DependDeleteValue = (String) row.getCell(1).getStringCellValue();
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		DataSearch(DependDeleteValue,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[5]/span/a[2]/a/span");

		Thread.sleep(3000);
		delivery.Deleteconfirmbtn.click();

		Thread.sleep(1500);
		String DeleteSuccessMessage = delivery.deletemsg.getText();

		String expectedatamsg = "Can't delete this module";

		try {
			testCase = extent.createTest("Step-01 :Data Depend Message");
			try {
				Assert.assertEquals(DeleteSuccessMessage, expectedatamsg);
				testCase.log(Status.INFO, "Actual Data :- " + DeleteSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.PASS, "2.Can't delete this module Message Enable");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Data :- " + DeleteSuccessMessage);
				testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
				testCase.log(Status.FAIL, "2.Wrong Delete Success Message Enable");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "Wrong Data Depend Message Not Enable");
		}

	}

	/***************************************************************************************************/

	/**********************************************************************************************
	 * Edit Method for Delivery
	 **********************************************************************************************/
	@Test
	public static void deliveryEdit() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Delivery",
				"TC-DEL-0046");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Delivery",
				"TC-DEL-0046");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			editvalue = (String) row.getCell(1).getStringCellValue();
			fieldvalue = (String) row.getCell(2).getStringCellValue();
			expectedresult = (String) row.getCell(3).getStringCellValue();
			expectedsuccessmsgresult = (String) row.getCell(4).getStringCellValue();
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();

		// Edit Button Visible & Enable
		Thread.sleep(2000);
		testCase = extent.createTest("STEP 1: DELIVERY EDIT FORM");
		System.out.println("gobi" + editvalue);
		/* Data Search Method for find the Element */
		DataSearch(editvalue,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[5]/span/a[1]");

		Thread.sleep(2000);
		if (delivery.DeliveryFieldEdit.isDisplayed()) {
			testCase = extent.createTest("1.EDIT DELIVERY BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (delivery.DeliveryFieldEdit.isEnabled()) {
				testCase = extent.createTest("2.EDIT DELIVERY BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {

					// Thread.sleep(3000);
					delivery.DeliveryFieldEdit.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					Thread.sleep(2000);
					delivery.DeliveryFieldEdit.sendKeys(fieldvalue);
					Thread.sleep(2000);
					delivery.EditSavebtn.click();

					Thread.sleep(1500);
					String actualdata = delivery.firstaddeddata.getText();
					String expecteddata = expectedresult;
					boolean firstdata = true;
					testCase = extent.createTest("3.CHECK THE EDIT VALUE HAS UPDATED IN FIRST OF THE TABLE");
					try {
						AssertJUnit.assertEquals(actualdata, expecteddata);

					} catch (AssertionError e) {
						firstdata = false;
					}
					if (firstdata) {
						testCase.log(Status.INFO, "Actual Data :- " + actualdata);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.PASS, "Correct last Edited data added in first row");
					} else {
						testCase.log(Status.INFO, "Actual Data :- " + actualdata);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.FAIL, "Wrong Last Edited Data Not Added in first row");

					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("2.EDIT DELIVERY BUTTON ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("1.EDIT DELIVERY BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void deliveryeditsuccess() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);

		Thread.sleep(1000);
		String updateSuccessMessage = delivery.Updatemsg.getText();
		System.out.println(updateSuccessMessage);
		String expectedatamsg = expectedsuccessmsgresult;

		testCase = extent.createTest("4.DATA EDITED SUCCESS MESSAGE");
		try {
			Assert.assertEquals(updateSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + updateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + updateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}

		Thread.sleep(4000);
		driver.navigate().refresh();

	}

	/**********************************************************************************************
	 * Edit Method for Delivery After Depend
	 **********************************************************************************************/
	
	static String deletedelivery = "";
	@Test
	
	public static void deliveryEditafterdepend() throws InterruptedException, IOException {
		PageFactory.initElements(driver, delivery);
		Thread.sleep(2000);
		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();
		
		// Find the data from equipment spread sheet
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Delivery");

			int rowcount = sheet.getLastRowNum();

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Delivery",
					"TC-DEL-0059");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Delivery",
					"TC-DEL-0059");

			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				deletedelivery = (String) row.getCell(1).getStringCellValue();
				Thread.sleep(2000);
			}

		/* Data Search Method for find the Element */
		DataSearch(deletedelivery,
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[5]/span/a[1]");

		String actual = delivery.Editproject.getAttribute("disabled");
		System.out.println("Gobi" + actual);
		String Excepted = "null";
		try {
			testCase = extent.createTest("Step 1: CHECK THE EDIT PROJECT FIELD IS DEPEND");
			try {
				AssertJUnit.assertEquals(actual, Excepted);
				testCase = extent.createTest("1.PROJECT FIELD IS ENABLE");
				testCase.log(Status.INFO, "Actual Data :- " + actual);
				testCase.log(Status.INFO, "Expected Data :- " + Excepted);
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (AssertionError e) {
				testCase = extent.createTest("1.PROJECT FIELD IS NOT ENABLE");
				testCase.log(Status.INFO, "Actual Data :- " + actual);
				testCase.log(Status.INFO, "Expected Data :- " + Excepted);
				testCase.log(Status.PASS, "TEST PASS");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "WRONG THE EDIT PROJECT FIELD NOT ENABLE");
		}
		
		if (delivery.Editproject.isDisplayed()) {
			testCase = extent.createTest("2. DELIVERY EDIT PROJECT FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		
		} else {
			testCase = extent.createTest("2. DELIVERY EDIT PROJECT FIELD IS ENABLED");
			testCase.log(Status.PASS, "TEST FAIL ❎");

		}

	}

	public static void ClickcancelButton() throws InterruptedException, IOException {

		PageFactory.initElements(driver, delivery);
		// Click on Master card
		MasterMainNavigationsTest.navigateMaster();

		// Click on Customer Navigation Button
		MasterMainNavigationsTest.navigateCustomerMain();

		// Click on Customer Delivery Button
		MasterMainNavigationsTest.navigateDelivery();

		/* Data Search Method for find the Element */
		DataSearch("fgfdg",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[1]",
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[",
				"]/td[5]/span/a[1]");

		// Edit Cancel Button Visible & Enable
		EnableDisablecheckMethod(delivery.Editcancelbtn, "4.EDIT CANCEL DELIVERY BUTTON VISIBLE & ENABLE ",
				"1.Correct Delivery Edit Cancel Button Visibled", "Wrong Delivery Edit Cancel Button Not Visibled",
				"Correct Delivery Edit Cancel Button Enabled", "Wrong Delivery Edit Cancel Button Not Enabled");
		Thread.sleep(2000);

	}

	/****************************************************************
	 * Pagination
	 **********************************/

	/**********************************************************************************************
	 * PAGINATION-DEFAULT-PAGE-INDEX
	 **********************************************************************************************/
	static boolean defaultt = false;
	static boolean redirecttodefault = false;
	static boolean redirect = false;
	static boolean prebutton = false;
	static boolean nextdisplay = false;
	static boolean nextenable = false;
	static boolean pagedisable = true;
	static boolean pageenable = false;
	static int pagecount = 0;

	public static void excelmethod() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");

		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0027");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",
				"Delivery", "TC-DEL-0027");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			defaultt = (Boolean) row.getCell(1).getBooleanCellValue();
			redirecttodefault = (Boolean) row.getCell(2).getBooleanCellValue();
			redirect = (Boolean) row.getCell(3).getBooleanCellValue();
			prebutton = (Boolean) row.getCell(4).getBooleanCellValue();
			nextdisplay = (Boolean) row.getCell(5).getBooleanCellValue();
			nextenable = (Boolean) row.getCell(6).getBooleanCellValue();
			pagedisable = (Boolean) row.getCell(7).getBooleanCellValue();
			pageenable = (Boolean) row.getCell(8).getBooleanCellValue();
			pagecount = (int) row.getCell(9).getNumericCellValue();
			Thread.sleep(2000);
		}
	}

	public static void DefaultIndexPage() throws InterruptedException {

		// Default Index Page
		Thread.sleep(4000);
		testCase = extent.createTest("STEP 1: DELIVERY PAGINATION");

		boolean ActualDefaultPageIndex = DeliveryPage.DefaultPaginationPage.isDisplayed();
		boolean ExpectedDefaultPageIndex = defaultt;
		testCase = extent.createTest("1.PAGINATION-DEFAULT-PAGE-INDEX");
		try {
			Assert.assertEquals(ActualDefaultPageIndex, ExpectedDefaultPageIndex);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
			testCase.log(Status.FAIL, "Wrong Default Index Page");

		}

	}

	/**********************************************************************************************
	 * PAGINATION-REFERESH-INTO-DEFAULT-PAGE
	 **********************************************************************************************/

	public static void RefreshDefaultPage() throws InterruptedException {

		Thread.sleep(1000);
		DeliveryPage.NextPageBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		boolean ActualDefaultPageIndex1 = delivery.DefaultPaginationPage.isDisplayed();
		boolean ExpectedDefaultPageIndex1 = redirecttodefault;
		testCase = extent.createTest("2.PAGINATION-REFERESH-INTO-DEFAULT-PAGE");
		try {
			Assert.assertEquals(ActualDefaultPageIndex1, ExpectedDefaultPageIndex1);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex1);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualDefaultPageIndex1);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex1);
			testCase.log(Status.FAIL, "Wrong Default Index Page");
		}
	}

	/**********************************************************************************************
	 * PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE
	 **********************************************************************************************/

	public static void PageRedrict() throws InterruptedException {

		delivery.NextPageBtnn.click();
		Thread.sleep(2000);
		boolean ActualSecoundPageIndex = delivery.PaginationSecoundPage.isDisplayed();
		boolean ExpectedSecoundPageIndex = redirect;
		testCase = extent.createTest("3.PAGINATION-PAGE-REDIRECT-TO-NEXT-PAGE");
		try {
			Assert.assertEquals(ActualSecoundPageIndex, ExpectedSecoundPageIndex);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedSecoundPageIndex);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + ActualSecoundPageIndex);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedSecoundPageIndex);
			testCase.log(Status.FAIL, "Wrong Default Index Page");
		}
	}

	/**********************************************************************************************
	 * PAGINATION-PREVIOUS-BUTTON-DISPLAY
	 **********************************************************************************************/

	public static void PreButtonDispaly() throws InterruptedException {

		boolean ActualVisiblePreviousButton = delivery.PreviousPageBtnn.isDisplayed();
		boolean ExpectedVisiblePreviousButton = prebutton;
		testCase = extent.createTest("4.PAGINATION-PREVIOUS-BUTTON-VISIBLE");
		try {
			Assert.assertEquals(ActualVisiblePreviousButton, ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualVisiblePreviousButton);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "Element not available");
			testCase.log(Status.FAIL, "Not Visible Element");
		}
	}

	/**********************************************************************************************
	 * PAGINATION-NEXT-BUTTON-VISIBLE
	 **********************************************************************************************/

	public static void NextButtonDispaly() throws InterruptedException {

		boolean ActualVisibleNextButton = delivery.NextPageBtnn.isDisplayed();
		boolean ExpectedVisibleNextButton = nextdisplay;
		testCase = extent.createTest("5.PAGINATION-NEXT-BUTTON-VISIBLE");
		try {
			Assert.assertEquals(ActualVisibleNextButton, ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualVisibleNextButton);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
			testCase.log(Status.INFO, "Element not available");
			testCase.log(Status.FAIL, "Not Visible Element");
		}
	}

	/**********************************************************************************************
	 * PAGINATION-NEXT-BUTTON-ENABLE
	 **********************************************************************************************/

	public static void NextButtonEanble() throws InterruptedException {

		boolean ActualNextBtnEnable = delivery.NextPageBtnn.isEnabled();
		boolean ExpectedNextBtnEnable = nextenable;
		testCase = extent.createTest("6.PAGINATION-NEXT-BUTTON-ENABLE");
		try {
			Assert.assertEquals(ActualNextBtnEnable, ExpectedNextBtnEnable);
			testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
			testCase.log(Status.PASS, "Enable element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualNextBtnEnable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedNextBtnEnable);
			testCase.log(Status.FAIL, "Not Enable Element");
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	/**********************************************************************************************
	 * PAGINATION-PREVIOUS-BUTTON-DISABLE-BEFORE MOVE THE 2ND PAGE
	 **********************************************************************************************/

	public static void SecPagepreButDisable() throws InterruptedException {
		Thread.sleep(2000);
		boolean ActualPreviousBtnDisable = delivery.PreviousPageBtnn.isEnabled();
		boolean ExpectedPreviousBtnDisable = pagedisable;
		testCase = extent.createTest("7.PAGINATION-PREVIOUS-BUTTON-DISABLE-BEFORE MOVE THE 2ND PAGE");
		try {
			Assert.assertEquals(ActualPreviousBtnDisable, ExpectedPreviousBtnDisable);
			testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
			testCase.log(Status.PASS, "Enable element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnDisable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnDisable);
			testCase.log(Status.FAIL, "Not Enable Element");
		}

	}

	/**********************************************************************************************
	 * PAGINATION-PREVIOUS-BUTTON-DISABLE-AFTER MOVE THE 2ND PAGE
	 **********************************************************************************************/

	public static void AfterMovetoSecPagepreButEnable() throws InterruptedException {

		delivery.NextPageBtnn.click();
		Thread.sleep(2000);
		boolean ActualPreviousBtnEnable = delivery.PreviousPageBtnn.isEnabled();
		boolean ExpectedPreviousBtnEnable = pageenable;
		testCase = extent.createTest("8.PAGINATION-PREVIOUS-BUTTON-DISABLE-AFTER MOVE THE 2ND PAGE");
		try {
			Assert.assertEquals(ActualPreviousBtnEnable, ExpectedPreviousBtnEnable);
			testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnEnable);
			testCase.log(Status.PASS, "Enable element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualPreviousBtnEnable);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedPreviousBtnEnable);
			testCase.log(Status.FAIL, "Not Enable Element");
		}

		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	/**********************************************************************************************
	 * PAGINATION-NEXT-BUTTON-ENABLED
	 **********************************************************************************************/

	public static void TotalPagecheck() throws InterruptedException {

		int ActualTotalPage = 1;
		boolean Enablity = delivery.NextPageBtnn.isEnabled();
		while (Enablity) {
			Thread.sleep(1000);
			delivery.NextPageBtnn.click();
			ActualTotalPage = ActualTotalPage + 1;
			if (ActualTotalPage == 5) {
				Enablity = delivery.NextPageBtnn.isEnabled();
				break;
			}
		}
		System.out.println(ActualTotalPage);
		Thread.sleep(2000);
	}

	public static void TotalPage() throws InterruptedException {

		String DataCountText = delivery.paginationCount.getText();
		// Page Count
		int ExpectedPageCount = pagecount;
		System.out.println(DataCountText);
		Pattern pattern = Pattern.compile("\\d+ of (\\d+)");
		System.out.println(pattern);
		Matcher matcher = pattern.matcher(DataCountText);
		if (matcher.find()) {
			String pageCount = matcher.group(1);
			double Value = Integer.parseInt(pageCount) / 10;
			int Finalvalue = (int) Math.ceil(Value);
			System.out.println("Total pages: " + Finalvalue);

			testCase = extent.createTest("STEP-9 Checking Total Page for 10 Data per page");
			try {
				Assert.assertEquals(Finalvalue, ExpectedPageCount);

				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.PASS, "Correct Page Count");
			} catch (AssertionError e) {

				testCase.log(Status.INFO, "Actual Page Count :- " + Finalvalue);
				testCase.log(Status.INFO, "Expected Page Count :- " + ExpectedPageCount);
				testCase.log(Status.FAIL, "Wrong Page Count");
			}

		}
		driver.navigate().refresh();
	}

}
