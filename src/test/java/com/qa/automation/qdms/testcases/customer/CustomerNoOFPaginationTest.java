
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER NO OF PAGINATION FUNCTIONAL PAGE
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0096             10.03.2023   @SASIKALA     Original Version
//*	 
//****************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CustomerNoOFPaginationTest extends DriverIntialization {
//*************************************************************************************
//									LOGIN FUNCTION
//*************************************************************************************	

	@Test(priority = 0)
	public static void CustomerPagination() throws InterruptedException {

		CustomerPage Customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, Customerfunpg);
		Thread.sleep(1000);

		CustomerPage.username.sendKeys("Admin");
		CustomerPage.password.sendKeys("tokyo@admin");
		CustomerPage.login.click();

		Thread.sleep(2000);
		CustomerPage.Master.click();

	}

//********************************Customer-Menu-Method*********************************************	
	@Test(priority = 1)
	public static void CustomerMenuMaterialMethod() throws InterruptedException {

		Thread.sleep(1000);
//******************CUSTOMER-TOP-MENU-VISIBLE*********************
		CustomerPage Customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, Customerfunpg);

		boolean ExpectedTextVisible = true;
		System.out.println("CustomerTopMenuVisible");
		boolean ActualTextVisible = CustomerPage.Customertopmenu.isDisplayed();
		testCase = extent.createTest("CUSTOMER-TOP-MENU-VISIBLE");

		if (CustomerPage.Customertopmenu.isDisplayed()) {
			CustomerPage.Customertopmenu.click();

			Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
			testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.PASS, " Correct");

		} else {
			System.out.println("Not Visible Customer");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.FAIL, "Wrong");
		}
	}

//*********************************Customer-Site-Button-Method****************************

	@Test(priority = 2)
	public static void CustomerSiteButtonMethod() throws InterruptedException {
		Thread.sleep(1000);
		CustomerPage Customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, Customerfunpg);

		boolean ExpectedTextVisible = true;
		System.out.println("CUSTOMER-SITE-BUTTON-Visible");
		boolean ActualTextVisible = CustomerPage.Customersitebutton.isDisplayed();
		testCase = extent.createTest("CUSTOMER-SITE-BUTTON-VISIBLE");

		if (CustomerPage.Customersitebutton.isDisplayed()) {
			CustomerPage.Customersitebutton.click();

			Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
			testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.PASS, " Correct");

		} else {
			System.out.println("Not Visible Customer");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
			testCase.log(Status.FAIL, "Wrong");
		}
	}

//*************************************************************************************
//						CUSTOMER-PAGINATION-FUNCTIONALITY
//*************************************************************************************

//**---------------------------**************-----------------------------------------
//							Select DropDown Field 
//**************************------------------****************************************

	@Test(priority = 3)

	public static void dropdownselectionMethod() throws InterruptedException {
		CustomerPage Customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, Customerfunpg);

		CustomerPage.DropdownBoxclick.click();
		Thread.sleep(1000);
		CustomerPage.Dropdown10Pageclick.click();

	}

//*********************************************************************************
//				Checking Total No Of Page Count - Data per page
//*********************************************************************************

	@Test(priority = 4)
	public static void NoOfPageCount() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Customer";
		String testCaseId = "TC-CUS-0096";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String CountExpected = (String) row.getCell(1).getStringCellValue();

			int oldPageCount = 0;
			try {
				String total = "";
				String[] parts;
				String elementCount = null;
				int expectedElementCount = 0;
				try {
					total = driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']")).getText();
					TestCasePrint("CONFIRM Text", CountExpected, String.valueOf(total));
					Thread.sleep(2000);
					parts = total.split(" ");
					System.out.println("parts" + Arrays.toString(parts));
					elementCount = parts[0];
					parts = elementCount.split("-");
					System.out.println("parts" + Arrays.toString(parts));
					elementCount = parts[1];

					expectedElementCount = Integer.parseInt(elementCount);
					System.out.println(expectedElementCount);
					oldPageCount = expectedElementCount;
				} catch (Exception e) {
				}
			} catch (Exception e) {
			}
		}
	}

//***********************************LOG OUT BUTTON******************************
	@Test(priority = 5)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		CustomerPage Customerfunpg = new CustomerPage();
		PageFactory.initElements(driver, Customerfunpg);
		MultiSearchMethods.Logout();
	}

//********************************************************************************************************
//							THE METHOD IS FOR GENERATING REPORT 
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
			testCase.log(Status.PASS, "TEST PASS â˜‘");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}
	}

}
