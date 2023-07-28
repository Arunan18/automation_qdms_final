
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER UPDATE (MIDDLE PAGE)  TEST FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   09.03.2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0093             09.03.2023   @SASIKALA     Original Version
//*	 
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CustomerEditMiddlePage extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();

	static String CustomerEmail = "";
	static String updatesuccessmsg = "";
	static String VerifyCustomerName = "";

	@Test(priority = 0)
	public static void CustomerEditway() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customerfunpg);

//-----------------------------------------------------------------------------------------
//						LOGIN FUNCTION & BASIC SELECTION EDIT ICON CODE
//-----------------------------------------------------------------------------------------	
		CustomerMethods.custombasicway();

//***************************************************************************************
//------------------------------------Customer Menu Method------------------------------			
//****************************************************************************************************
		CustomerMethods.customerMenuMethod();

//***************************************************************************************
//----------------------------------Customer Site Bar Method-----------------------------------
//****************************************************************************************
		CustomerMethods.custombarsitebuttonMethod();

	}
//-----------------------------------------------------------------------------------------
//						EDIT DATA FIELD SELECT
//-----------------------------------------------------------------------------------------

	@Test(priority = 1)
	public static void Editcustomerselect() throws InterruptedException, IOException {

		PageFactory.initElements(driver, customerfunpg);

		// XPATH CUSTOMER EDIT
		Thread.sleep(3000);

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Customer";
		String testCaseId = "TC-CUS-0093";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int j = firstRow; j <= lastRow; j++) {

			XSSFRow row = sheet.getRow(j);

			String CustomerToBeEdit = (String) row.getCell(1).getStringCellValue();
			CustomerEmail = (String) row.getCell(2).getStringCellValue();
			updatesuccessmsg = (String) row.getCell(3).getStringCellValue();
			VerifyCustomerName = (String) row.getCell(4).getStringCellValue();

			String Name = CustomerToBeEdit;
			String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
			String NameXpath_lastPart = "]/td[1]";
			String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
			String EditXpath_lastPart = "]/td[7]/span/a[1]/span";

//*****************************************************************************************   
			// EDIT BASIC LOOP FUNCTIONS
//*****************************************************************************************

			boolean clickNextPage = true;
			boolean customerExist = false;
			while (clickNextPage) {
				for (int i = 2; i < 103; i++) {
					try {
						String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
								.getText();
						System.out.println(text);
						if (text.equals(Name)) {
							customerExist = true;
							driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
							Thread.sleep(2000);
							clickNextPage = false;
							break;
						}
					} catch (Exception e) {
					}
				}
				if (clickNextPage == true) {
					clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
							.isEnabled();
					if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {

						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
						Thread.sleep(2000);
					} else {
						System.out.println("Button is Disabled");
					}
				} else {
					break;
				}
			}
			if (customerExist = false) {
				System.out.println("No such Element" + customerExist);
			}
		}
	}

//*************************************************************************************
//							EDIT DATA FIELD SELECT
//*************************************************************************************

	@Test(priority = 2)
	public static void CustomerEditFunction() throws InterruptedException {
		CustomerPage customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, customerfunpg);

//---------------------------------------------------------------------------------------
		// Call Method form the EnableDisabled Test Page
//---------------------------------------------------------------------------------------

		Thread.sleep(2000);
		if (CustomerPage.CustomerFiled.isDisplayed()) {
			testCase = extent.createTest("CUSTOMER EMIAL FIELD VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.CustomerFiled.isEnabled()) {
				testCase = extent.createTest("CUSTOMER EMAIL FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.CustomerEmailFiled.click();
					Thread.sleep(2000);

					CustomerPage.CustomerEmailFiled.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					CustomerPage.CustomerEmailFiled.sendKeys(CustomerEmail);
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("CUSTOMER FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("CUSTOMER FIELD VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//-------------------------------------------------------------------------------------

		Thread.sleep(2000);
		if (CustomerPage.Updatebtn.isDisplayed()) {
			testCase = extent.createTest("CUSTOMER UPDATE BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (CustomerPage.Updatebtn.isEnabled()) {
				testCase = extent.createTest("CUSTOMER UPDATE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					CustomerPage.Updatebtn.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("CUSTOMER UPDATE IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("CUSTOMER UPDATE BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//---------------------------------------------------------------------------------------	

		Thread.sleep(1000);
		String UpdateSuccessMessage = CustomerPage.UpdateCustomersuccessmsg.getText();
		System.out.println(UpdateSuccessMessage);
		String expectedatamsg = updatesuccessmsg;

		testCase = extent.createTest("Data Update Success Message");
		try {
			Assert.assertEquals(UpdateSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + UpdateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");
		} catch (AssertionError e) {

			testCase.log(Status.INFO, "Actual Data :- " + UpdateSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}
	}

//-----------------------------------------------------------------------------------------
	// CHECK THE EDITED VALUE HAS SAVED IN FIRST OF THE TABLE
//-----------------------------------------------------------------------------------------	
	@Test(priority = 3)
	public static void checkLastAddvalue() throws InterruptedException, IOException {
		CustomerPage customerEditpg = new CustomerPage();
		PageFactory.initElements(driver, customerEditpg);

// 	CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
		driver.navigate().refresh();
		Thread.sleep(2000);
		String actualdata = CustomerPage.EditCustomerfirstdata.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = VerifyCustomerName;

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}
	}

// ***********************************LOG OUT BUTTON******************************
	@Test(priority = 4)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		CustomerPage customerpg = new CustomerPage();
		PageFactory.initElements(driver, customerpg);
		MultiSearchMethods.Logout();
	}

}
