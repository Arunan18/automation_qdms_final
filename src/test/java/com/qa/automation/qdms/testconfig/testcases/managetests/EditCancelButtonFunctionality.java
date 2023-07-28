//***********************************************************************************
//* Description
//*------------
//*Edit Cancel  functions Manage test - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-009         08/05/2023   Saranka     Original Version
//*	   				 14/06/2023		Arunan		Updated Version
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class EditCancelButtonFunctionality extends DriverIntialization {
	static TestConfigPage EditPage = new TestConfigPage();
	static ManageTestsPage editCancelPage = new ManageTestsPage();
	static String toBeEdit = null;
	static String expectedResult = null;
	static DataFormatter dataValue=new DataFormatter();
//===================================================== M  E T H O D =======================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EditCancelButtonFunctionality.EditCancelButtonFunction();
		
		Logout.LogoutFunction();
		
	}
	

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void EditCancelButtonFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, EditPage);
		PageFactory.initElements(driver, editCancelPage);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

		Thread.sleep(2000);
		TestConfigPage.manageTest.click();

//______________________________________
//  EXCEL METHOD
//_______________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-009";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			toBeEdit = dataValue.formatCellValue(row.getCell(1));
			expectedResult =dataValue.formatCellValue(row.getCell(2));

		}

// __________________________________________
// SEARCH DATA TO EDIT
// __________________________________________

		AddGroupKey.actionS(0, 16, TestConfigPage.TableManageConfigure, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-009-01", 1);
// ________________________________________
// CANCEL BUTTON
// ________________________________________
Thread.sleep(2000);
		WebElement CancelButton = driver.findElement(By.xpath("//button[@class='ant-btn']"));

		SampleActionMethods.clicking(CancelButton, 2, "STEP:2 CANCEL BUTTON");
		
		
//________________________________________
// AFTER CLICK CANCEL BUTTON
//_______________________________________
		
		Thread.sleep(2000);
		String sp[]=toBeEdit.split(",");
		String text = sp[0];		
		System.err.println("//td[normalize-space()='"+text+"']");
			SampleCommonMethods.firstrowdataCancel("STEP 3: After click Cancel Button the data in First Row ", driver
					.findElement(By.xpath("//td[normalize-space()='"+text+"']")), expectedResult);
			
			 
			// Add more validations here based on your test scenario
				// For example, you can verify that the data is not editable after clicking the cancel button
			WebElement editButton = driver
					.findElement(By.xpath("(//span[@aria-label='edit'])[1]"));
			
				Assert.assertTrue(editButton.isEnabled(), "Edit button should not be enabled after clicking Cancel button");
				

	}
	
	
}
