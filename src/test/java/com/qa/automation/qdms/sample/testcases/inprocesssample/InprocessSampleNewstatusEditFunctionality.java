//***********************************************************************************
//* Description
//*------------
//* Process Sample Edit Functionality (Able to edit Process sample only for NEW Status)
//***********************************************************************************
//*
//* Author           : Karunya Navanesan
//* Date Written     :08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-PRO-SAM-0011     08/04/2023   Karunya     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class InprocessSampleNewstatusEditFunctionality extends DriverIntialization {
	
	static  InprocessSamplePage sp = new InprocessSamplePage();
	
	
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
	public static void inprocesssampleEdit() throws InterruptedException, IOException {
		
		  LoginTest.Login();
	  	  Thread.sleep(3000);
	  	  SampleNavigateTest.sampleNavigation();
	  	  Thread.sleep(2000);
	  	  SampleNavigateTest.rawMaterialSampleMainNavigation();
	  	  Thread.sleep(2000);
	  	  SampleNavigateTest.inprocessSampleNavigation(); 
	  	  InprocessSampleNewstatusEditFunctionality.inprocesssampleEditiconfunction();
	  	  
	  	 InprocessSampleNewstatusEditFunctionality.afterEditdataCorrect();
		 
	  	Logout();
	}
	
	
	public static void inprocesssampleEditiconfunction() throws InterruptedException, IOException {
		
//****************************************************************************************
//    	STEP-01--INPROCESS SAMPLE EDIT  ICON IS DISPLAYED &	STEP-02--INPROCESS SAMPLE EDIT ICON IS ENABLED
//****************************************************************************************		
		 
		 PageFactory.initElements(driver, sp);
		 Thread.sleep(3000);
		
		 
		 if ( InprocessSamplePage.inprocessSampleEditicon.isDisplayed()) {
				testCase = extent.createTest("STEP-01--INPROCESS SAMPLE EDIT ICON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if ( InprocessSamplePage.inprocessSampleEditicon.isEnabled()) {
					testCase = extent.createTest("STEP-02--INPROCESS SAMPLE EDIT ICON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					InprocessSamplePage.inprocessSampleEditicon.click();

				} else {
					testCase = extent.createTest("STEP-02-INPROCESS SAMPLE EDIT ICON IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-01--INPROCESS SAMPLE EDIT ICON IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		 
//__________________________________________________________________________
//	     SEND DATA FROM EXCEL
//__________________________________________________________________________		

			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
			String excelSheetName = "Process Sample";
			String testCaseId = "TC-PRO-SAM-0011";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			for (int i = firstRow; i <= lastRow; i++) {
				XSSFRow row = sheet.getRow(i);
				Thread.sleep(2000);
				String samplecodeEditData = (String) row.getCell(1).getStringCellValue();
				
				

//________________________________________________________________________________		

							Thread.sleep(2000);
							testCase = extent.createTest("STEP:4 Edited data SucessFully");
							try {
								
								InprocessSamplePage.sampleCode.clear();
								Thread.sleep(3000);
								InprocessSamplePage.sampleCode.sendKeys(samplecodeEditData);
								

								// CLick Update save Button
								Thread.sleep(2000);
								InprocessSamplePage.Editsavebutton.click();
								testCase.log(Status.PASS, "Edited");
								
							} catch (AssertionError e) {
								// TODO: handle exception
								testCase.log(Status.FAIL, "Not Edited");

							}
						}

		//____________________________________________________________
		//  CHECK EDITED DATA (VISIBLE,SPELLING)
		//_____________________________________________________________

		
				
				Thread.sleep(3000);
				WebElement afterediteddata = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[11]"));
				boolean editData = afterediteddata.isDisplayed();
				if (editData) {
					boolean actualEditedDataVisible = afterediteddata.isDisplayed();
					System.out.println("Edited Data is visble:" + actualEditedDataVisible);
					boolean expectedEditedDataVisble = true;
					testCase = extent.createTest("STEP:5 Edited Data Vsible");
					try {
						Assert.assertEquals(actualEditedDataVisible, expectedEditedDataVisble);
						testCase.log(Status.INFO, "Actual Edited Data:" + actualEditedDataVisible);
						testCase.log(Status.INFO, "Expected Edited data:" + expectedEditedDataVisble);
						testCase.log(Status.PASS, "Visible Correct");

					} catch (AssertionError e) {
						// TODO: handle exception
						testCase.log(Status.INFO, "Actual Edited Data:" + actualEditedDataVisible);
						testCase.log(Status.INFO, "Expected Edited data:" + expectedEditedDataVisble);
						testCase.log(Status.FAIL, "Visible In correct");
					}
				} else {
					System.out.println(" no data");
				}
				
				
	}		
	
	
//_____________________________________________________________
//  AFTER EDIT DATA CORRECT AND CHECK EXPECTED RESULT AND ACTUAL RESULT
//_____________________________________________________________
		

	public static void afterEditdataCorrect() throws InterruptedException, IOException {
		

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Process Sample";
		String testCaseId = "TC-PRO-SAM-0011";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			Thread.sleep(2000);

			String expectedResultAfterEdit = (String) row.getCell(2).getStringCellValue();
			
		  PageFactory.initElements(driver, sp);
		  Thread.sleep(4000);
		  
		  WebElement afterediteddata = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[11]"));
				String actulaData = afterediteddata.getText();
				System.out.println("Edited Data:" + actulaData);
				String expectedData = expectedResultAfterEdit;
				testCase = extent.createTest("STEP:6 Edited data spelling");
				boolean editeddata = true;

				try {
					Assert.assertEquals(actulaData, expectedData);

				} catch (AssertionError e) {
					// TODO: handle exception

				}
				if (editeddata) {
					testCase.log(Status.INFO, "Actual Edited data:" + actulaData);
					testCase.log(Status.INFO, "Expected Edited data:" + expectedData);
					testCase.log(Status.PASS, "COrrect Data");
				} else {
					testCase.log(Status.INFO, "Actual Edited data:" + actulaData);
					testCase.log(Status.INFO, "Expected Edited data:" + expectedData);
					testCase.log(Status.FAIL, "In-COrrect Data");
				}
				
			}
	}
						
		
//____________________________________________________________
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

		
		
	



