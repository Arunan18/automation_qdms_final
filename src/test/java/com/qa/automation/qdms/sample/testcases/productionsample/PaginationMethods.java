/***********************************************************************************
* Description
*------------
* TC-PRODUCT-SAM-0216	Production Sample Raw Material Pagination


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 11/05/2023 
*
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PRODUCT-SAM-0216   11/05/2023     RAHUL.S       Original Version
*
************************************************************************************/ 
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;

public class PaginationMethods extends DriverIntialization{
	static ProductionSamplePage sc = new ProductionSamplePage();
	static boolean ExpectedVisiblePreviousButton = true;
	static boolean ExpectedVisibleNextButton= true;
	static boolean ExpectedDefaultPageIndex= true;
	static String Plant = null;
	static String finishproduct = null;
	static String mixdesign = null;
	static int pg = 0;
	/*Excel Sheet Value Passing*/	
	public  static void excel() throws InterruptedException,IOException{
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Production Sample";
	String testCaseId = "TC-PRODUCT-SAM-0216";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
	
	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Production Sample");
	DataFormatter data = new DataFormatter();
		XSSFRow row = sheet.getRow(firstRow);
		
			Plant = (String) row.getCell(1).getStringCellValue();
			finishproduct = (String) row.getCell(2).getStringCellValue();
			mixdesign = (String) row.getCell(3).getStringCellValue();
			pg = (int) row.getCell(4).getNumericCellValue();


	}
	//PAGINATION FUNCTIONALITY
public static void paginationFun() throws InterruptedException,IOException{
	
	try {
		boolean value1 =ProductionSamplePage.previousButtonForRawMaterial.isDisplayed();
		testCase = extent.createTest( "STEP-10--CHECKING PREVIOUS BUTTON DISPLAY");
		try {
			Assert.assertEquals(value1, ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "ActualElement :- " + value1);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualElement :- " + value1);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisiblePreviousButton);
			testCase.log(Status.INFO, "Element not available");
			testCase.log(Status.FAIL, "Not Visible Element");
		}
		
	} catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest("STEP-10--CHECKING PREVIOUS BUTTON DISPLAY IS FAILED BECAUSE OF NO ELEMENT");
		
	}
	try {boolean value2 = ProductionSamplePage.nextButtonForRawMaterial.isDisplayed();
	testCase = extent.createTest( "STEP-11--CHECKING NEXT BUTTON DISPLAY");
	try {
		Assert.assertEquals(value2, ExpectedVisibleNextButton);
		testCase.log(Status.INFO, "ActualElement :- " + value2);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
		testCase.log(Status.INFO, "Element Available");
		testCase.log(Status.PASS, "Correct element");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "ActualElement :- " + value2);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisibleNextButton);
		testCase.log(Status.INFO, "Element not available");
		testCase.log(Status.FAIL, "Not Visible Element");
	}
	} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
	testCase = extent.createTest("STEP-11--CHECKING NEXT BUTTON DISPLAY IS FAILED BECAUSE OF NO ELEMENT");

	}
	try {Thread.sleep(2000);
	boolean value3 = ProductionSamplePage.firstPage.isDisplayed();

	testCase = extent.createTest("STEP-12--CHECKING DEFAULT INDEX PAGE");
	try {
		Assert.assertEquals(value3, ExpectedDefaultPageIndex);
		testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
		testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedDefaultPageIndex);
		testCase.log(Status.PASS, "Correct Default Index Page");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Default Index Page :- " + value3);
		testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedDefaultPageIndex);
		testCase.log(Status.FAIL, "Wrong Default Index Page");

	}
	} catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
		testCase = extent.createTest("STEP-12--CHECKING DEFAULT INDEX PAGE FAILED BECAUSE OF NO ELEMENT");
	}
	try {

		ProductionSamplePage.nextButtonForRawMaterial.click();
		Thread.sleep(2000);
		boolean value4 = ProductionSamplePage.secondPage.isDisplayed();
		boolean ExpectedPageDirect = true;
		testCase = extent.createTest("STEP-13--CHECKING PAGE REDIRECT TO THE NEXT PAGE");
		try {
			Assert.assertEquals(value4, ExpectedPageDirect);
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
			testCase.log(Status.INFO, "Expected Default Index Page :- " + ExpectedPageDirect);
			testCase.log(Status.PASS, "Correct Default Index Page");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Default Index Page :- " + value4);
			testCase.log(Status.INFO, "Expected Default Index Page:- " + ExpectedPageDirect);
			testCase.log(Status.FAIL, "Wrong Default Index Page");
		}

	} catch (Exception e) {testCase.log(Status.FAIL, "No Element");
	testCase = extent
			.createTest(" STEP-13--CHECKING PAGE REDIRECT TO THE NEXT PAGE IS FAILED BECAUSE OF NO ELEMENT");

	}
	
}
//PAGINATION COUNT
public static void paginationCount() throws InterruptedException,IOException{
	// Find the elements using the provided XPaths
    String tableRowXPath = "//label[text()='Mix Design Proportion']/..//tbody/tr";
    String enabledXPath = "//label[text()='Mix Design Proportion']/..//span[@class='anticon anticon-right']";

    // Count the rows initially
    int count = driver.findElements(By.xpath(tableRowXPath)).size();

    // Loop until the enabledXPath element is disabled
    while (driver.findElements(By.xpath(enabledXPath)).size() > 0) {
        // Perform actions to enable the XPath
        WebElement enabledElement = driver.findElement(By.xpath(enabledXPath));
        enabledElement.click();
        
        // Update the count
        count += driver.findElements(By.xpath(tableRowXPath)).size();
        break;
    }
    try {
    int expectedCount = pg;
    int acutalCount = count;
    testCase = extent.createTest("STEP-09--CHECKING THE DATA COUNT");
    try {
		Assert.assertEquals(expectedCount, acutalCount);
		testCase.log(Status.INFO, "ACTUAL COUNT" + acutalCount);
		testCase.log(Status.INFO, "EXPECTED COUNT" + expectedCount);
		testCase.log(Status.PASS, "CORRECT PAGINATION COUNT");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "ACTUAL COUNT " + acutalCount);
		testCase.log(Status.INFO, "EXPECTED COUNT" + acutalCount);
		testCase.log(Status.FAIL, "WRONG PAGINATION COUNT");
	}
   
    ProductionSamplePage.firstPage.click();
    }catch (Exception e) {
		// TODO: handle exception
	}
   }
}
