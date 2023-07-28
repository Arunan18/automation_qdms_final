
//****************************************************************************************
//		DESCRIPTION
//------------------
//					SOURCE No Of PAGINATION PAGE TEST FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:03:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-SRC-0058			  10:03:2023     @SASIKALA     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SourceNoOFPaginationTest extends DriverIntialization {
	static SourcePage Sourcepg = new SourcePage();
	static boolean work = false;
	
	@Test
	public static void NoOfPage() throws InterruptedException, IOException {
	PageFactory.initElements(driver, Sourcepg);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	// Call Login Function
			LoginTest.Login();

			wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));
			
			if (LoginTest.login) {
				// Click Master Card
				SourceTest.CommonMethod(SourcePage.Master, "Master Card");
			}

			if(SourceTest.work) {
				// Click Material Top Bar
				SourceTest.CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
			}

			if(SourceTest.work) {
				// Source Side Button
				SourceTest.CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
			}
			
			if(SourceTest.work) {
				// Source Dropdown Box Click
				SourceTest.CommonMethod(SourcePage.DropdownBoxclick, "DropDown Box");
			}
			
			if(SourceTest.work) {	
				// Source DropDown 10 Number Count Click
				wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Dropdown10Pageclick));
				SourceTest.CommonMethod(SourcePage.Dropdown10Pageclick, "DropDown 10 page");
			}
			
			if(SourceTest.work) {
				// No Of Page Check Source
				NoOfPageCount();
			}
				
				// Logout Functionality
				if (LoginTest.login) {
				Logout.LogoutFunction();
				}
			
	
	}

//******************Checking Total No Of Page Count - Data per page************************************

 public static void NoOfPageCount() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Source";
		String testCaseId = "TC-SRC-0058";

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
					TestCasePrint("CONFIRM TEXT", CountExpected, String.valueOf(total));
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

//********************************THE METHOD IS FOR GENERATING REPORT ************************************

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
