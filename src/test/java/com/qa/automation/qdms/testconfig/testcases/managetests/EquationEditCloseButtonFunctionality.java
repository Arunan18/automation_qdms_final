//***********************************************************************************
//* Description
//*------------
//*Equation edit close icon function - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-080          18/05/2023     Saranka     Original Version
//*
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

public class EquationEditCloseButtonFunctionality extends DriverIntialization {
	static ManageTestsPage deleteBeforeDepend = new ManageTestsPage();
	static TestConfigPage beforeependPage = new TestConfigPage();
	static String tobeSearchData = null;
	static String expectedValue = null;
//==================================================== M E T H O D =========================================================
	
	@Test
	public void methodCallingForeditCloseButtonFun() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EquationEditCloseButtonFunctionality.editCloseButtonFunc();
		
		Logout.LogoutFunction();
		
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	
	public static void editCloseButtonFunc() throws InterruptedException, IOException {
		PageFactory.initElements(driver, deleteBeforeDepend);
		PageFactory.initElements(driver, beforeependPage);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[contains(text(),'Equation')])[1]")).click();
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

//_________________________________________________
// EXCEL
//_________________________________________________			
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-080";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			tobeSearchData = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();

		}
 
// ______________________________________________
// DATA SEARCH TO CLICK
// ______________________________________________

		AddGroupKey.actionS(0, 9, TestConfigPage.TableManageConfigure, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-080-01", 1);

// ___________________________________________
// CLOSE BUTTON FUNCTIONLAITY
// ____________________________________________
Thread.sleep(1000);
		WebElement edit = driver.findElement(By.xpath("(//span[@aria-label='edit'])[11]"));
		Thread.sleep(1000);
		SampleActionMethods.clicking(edit, 2, "STEP:1 EDIT BUTTON ");
		
		Thread.sleep(1000);
		WebElement EditCloseButton = driver.findElement(By.xpath("(//span[@aria-label='close'])[2]"));
		Thread.sleep(2000);
		SampleActionMethods.clicking(EditCloseButton, 2, "STEP:2 EDIT CLOSE BUTTON");

//___________________________________________________
//   AFTER CLCIK COSE BUTTON
//___________________________________________________	

		String expectedDataText = expectedValue;
	
		WebElement DATA = driver.findElement(By.xpath("//td[normalize-space()='" + expectedDataText + "']"));

		Thread.sleep(2000);
		boolean actualVisible = DATA.isDisplayed();
		System.out.println("Actual Visible Data:-" + actualVisible);
		boolean expecteVisible = true;
		testCase = extent.createTest("STEP:3 DATA IS DISPLAY");
		try {
			Assert.assertEquals(actualVisible, expecteVisible);
			testCase.log(Status.PASS, "data is display");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "data is not there");

		}
		
		driver.navigate().refresh();

	}
}
