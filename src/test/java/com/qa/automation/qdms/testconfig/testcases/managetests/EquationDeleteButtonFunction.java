//*******************************************************************************
//* Description
//*------------
//* Equation  Delete Button functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-075           16/05/2023   Saranka     Original Version
//*						14/06/2023		kajan		modify version
//************************************************************************************

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
import org.testng.annotations.Test;

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

public class EquationDeleteButtonFunction extends DriverIntialization {
	static TestConfigPage DeleteFunction = new TestConfigPage();
	static ManageTestsPage DeleteFun = new ManageTestsPage();
	static String tobeSearchData = null;
	static String SucessMessage = null;
	
//====================================================== M E T H O D =======================================================
	@Test
	public void methodCalling() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EquationDeleteButtonFunction.editButtonFunctionality();
		
		Logout.LogoutFunction();
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void editButtonFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, DeleteFunction);
		PageFactory.initElements(driver, DeleteFun);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		try {
			TestConfigPage.ManageCofigureMenuBar.click();
			
		} catch (Exception e) {
			SampleCommonMethods.TestCasePrint("MANAGE CONFIG MAIN BAR", "true", String.valueOf(""),
					String.valueOf(e));
		}
		

		
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
		String testCaseId = "MTC-MT-075";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
System.err.println(firstRow + " !! " +lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			tobeSearchData = (String) row.getCell(1).getStringCellValue();
			
			SucessMessage = (String) row.getCell(2).getStringCellValue();

		}

// ______________________________________________
// DATA SEARCH TO CLICK
// ______________________________________________

		AddGroupKey.actionS(0, 9, TestConfigPage.TableManageConfigure, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-075-01", 1);

// ____________________________________________
// DELETE BUTTON FUNCTIONLAITY
// ____________________________________________

		WebElement Delete = driver.findElement(By.xpath("(//span[@aria-label='delete'])[11]"));
		
		SampleActionMethods.clicking(Delete, 2, "STEP:1 DELETE BUTTON ");
		
		WebElement DeleteOkButton = driver.findElement(By.xpath("(//span[contains(text(),'OK')])[2]"));
		DeleteOkButton.click();
		
		
		WebElement validationMessage = driver.findElement(By.xpath("//div[@role='alert']//div[1]"));
		SampleCommonMethods.dataaddedsuccessmsg("STEP:2 DELETED SUCESSFULL MESSAGE", validationMessage, SucessMessage);

	
	}
}
