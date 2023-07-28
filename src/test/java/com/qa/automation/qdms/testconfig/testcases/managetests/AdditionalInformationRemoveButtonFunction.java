//***********************************************************************************
 //* Description
//*------------
//*Additional Information Add  Field Remove Button - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-090           19/05/2023     Saranka     Original Version
//*						 14/06/2023		kajan		modify version
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AdditionalInformationRemoveButtonFunction extends DriverIntialization {
	static ManageTestsPage Addinfo = new ManageTestsPage();
	static TestConfigPage AdditionalInform = new TestConfigPage();
	static String tobeSearchData = null;

	
//====================================================== M E T H O D =======================================================
	@Test
	public void methodCallingForAddFieldremoveButtonFunctionality() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		AdditionalInformationRemoveButtonFunction.addFieldremoveButtonFunction();
		
		Logout.LogoutFunction();
	}
	
//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void addFieldremoveButtonFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Addinfo);
		PageFactory.initElements(driver, AdditionalInform);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

		Thread.sleep(2000);
		TestConfigPage.manageTest.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[contains(text(),'Additional Information')])[1]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {

		}

//______________________________________
//  EXCEL METHOD
//_______________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-090";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			tobeSearchData = (String) row.getCell(1).getStringCellValue();

		}
//__________________________________________
//  SEARCH DATA TO CLCIK
//__________________________________________

		WebElement table = driver.findElement(By.xpath("(//div[@class='ant-table-container'])[1]"));
		AddGroupKey.actionS(0, 10, table, "Description", "Test Configuragtion Module.xlsx", "Manage_Tests",
				"MTC-MT-090-01", 1);

//________________________________________
// CLCIK ADD FIELD BUTTON
//________________________________________
Thread.sleep(5000);
		WebElement addFieldButton = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
		SampleActionMethods.clicking(addFieldButton, 2, "STEP:1 ADD FIELD FUNCTION");
		
//_______________________________________
// CLICK REMOVE BUTTON
//_______________________________________	
		Thread.sleep(5000);
		WebElement RemoveButton2 = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
		SampleActionMethods.clicking(RemoveButton2, 2, "STEP:2 REMOVE BUTTON 2");
		
//______________________________________
// AFTER CLICK REMOVE BUTTON
//______________________________________
		
		Thread.sleep(2000);
		WebElement removeButton1 = driver.findElement(By.xpath("(//button[@type='button'])[4]"));

		boolean actualVisible = removeButton1.isDisplayed();
		System.out.println("Remove Button -1 Visible:-" + actualVisible);
		boolean expectedVisible = true;
		testCase = extent.createTest("STEP:2 REOMVE BUTTON-01 VISIBLE");
		try {
			Assert.assertEquals(actualVisible, expectedVisible);
			testCase.log(Status.PASS, " Disiplay Correct");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, " Not Disiplay ");
		}
//___________________________________________________________________
// CHECK IF REMOVE BUTTON IS ENABLED AFTER CLICKING REMVOVE BUTTTON 2
//___________________________________________________________________		

		boolean actualEnableAfterClick = removeButton1.isEnabled();
		System.out.println("Remove Button -1 Enable after clicking remove2: " + actualEnableAfterClick);
		boolean expectedEnableAfterClick = false;

		testCase = extent.createTest("STEP:3 - REMOVE BUTTON NOT ENABLED");
		try {
		    Assert.assertEquals(actualEnableAfterClick, expectedEnableAfterClick);
		    testCase.log(Status.PASS, "Remove Button -1 is not enabled after clicking remove2");
		} catch (AssertionError e) {
		    testCase.log(Status.FAIL, "Remove Button -1 is enabled after clicking remove2");
		    // TODO: handle exception
		}
		
		driver.navigate().refresh();





		
	}
}
