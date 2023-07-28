/***********************************************************************************
* Description
*------------
* SAMPLE CARD BUTTON FUNCTIONALITY AND DEFAULT INCOMING SAMPLE MENU SELECTION 

***********************************************************************************
*
* Author           : KARUNYA NAVANESAN
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SC-0002           02/05/2023   KARUNYA.N    Original Version
* TC-SC-0003
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class SampleCardButtonFunctionality extends DriverIntialization {
	static  IncomingSamplePage sp = new IncomingSamplePage();
	static String getData = null;
	
// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************		
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}
	}
	
	@Test
	public static void sampleCard() throws InterruptedException, IOException {
		
		// LOGIN
		LoginTest.Login();
		
		// CLICK SAMPLE CARD BUTTON
		SampleCardButtonFunctionality.sampleCardbuttonFunctionality();
		
		SampleCardButtonFunctionality.incomingsampleDefaultSelect();
		
		Logout();
		
		
	}
	
	public static void sampleCardbuttonFunctionality() throws InterruptedException {
		
//****************************************************************************************
//    	STEP-01--SAMPLE BUTTON IS DISPLAYED & 	STEP-02--SAMPLE BUTTON  IS ENABLED 
//****************************************************************************************		
		 
		 PageFactory.initElements(driver, sp);
		 Thread.sleep(3000);
		
		 
		 if (IncomingSamplePage.sampleCardButton.isDisplayed()) {
				testCase = extent.createTest("STEP-01--SAMPLE BUTTON  IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if (IncomingSamplePage.sampleCardButton.isEnabled()) {
					testCase = extent.createTest("STEP-02--SAMPLE BUTTON  IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					IncomingSamplePage.sampleCardButton.click();
					testCase = extent.createTest("STEP-03--SAMPLE BUTTON  IS CLICKED");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("STEP-02-SAMPLE BUTTON  IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--SAMPLE BUTTON  IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		
	}
	
	
// ____________________________________________________________
//  DEFAULT INCOMING SAMPLE MENU SELECTION 
//______________________________________________________________	
	public static void incomingsampleDefaultSelect() throws InterruptedException, IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("Incoming Sample");
	    int rowcount = sheet.getLastRowNum();
	    
	    int firstrow = CommonMethods.getFirstRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx","Incoming Sample","TC-SC-0003");
	    int lastrow = CommonMethods.getLastRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Incoming Sample", "TC-SC-0003");
	    
	    for (int i = firstrow; i <= lastrow; i++) {
	        XSSFRow row = sheet.getRow(i);
	        getData = (String) row.getCell(1).getStringCellValue();
			
	    }
	 Thread.sleep(3000);
		
			 try {
				 String actualtableHeadingtext =IncomingSamplePage.incomingsampletableHeadingtext.getText();
				 System.out.println(actualtableHeadingtext);
					TestCasePrint("STEP-04-- DEFAULT INCOMING SAMPLE SELECTION IS TRUE", getData, String.valueOf(actualtableHeadingtext));
				} catch (Exception e) {

				}

			
		}
		
	
// ____________________________________________________________
//  LOGOUT
//______________________________________________________________	
	public static void Logout() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
		Admin.click();

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.xpath(
				"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
		Logout.click();

	}


}
	
