//***********************************************************************************
//* Description
//*------------
//*Delete Cancel Button Functionality Manage test - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-010           08/05/2023     Saranka     Original Version
//*						 14/06/2023		Arunan		Updated Version
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class DeleteTestCancelButtonFunctionality extends DriverIntialization {
	static TestConfigPage EditPage = new TestConfigPage();
	static ManageTestsPage DeletePage = new ManageTestsPage();
	static String toBeDelete = null;
	static String ExpectedResult = null;
	
//=====================================================  M E T H O D ========================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		DeleteTestCancelButtonFunctionality.deleteCancelButtonFunction();
		
		Logout.LogoutFunction();
		
	}
//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void deleteCancelButtonFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, EditPage);
		PageFactory.initElements(driver, DeletePage);

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
		String testCaseId = "MTC-MT-010";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			toBeDelete = (String) row.getCell(1).getStringCellValue();
			ExpectedResult = (String) row.getCell(2).getStringCellValue();

		}

//__________________________________________
//  SEARCH DATA TO DELETE
//__________________________________________

		AddGroupKey.actionS(0, 16, TestConfigPage.TableManageConfigure, "delete",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-010-01", 1);

		Thread.sleep(2000);
		WebElement DeleteCancelButton = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));

		Thread.sleep(2000);
		SampleActionMethods.clicking(DeleteCancelButton, 2, "STEP:2  DELETE CANCEL BUTTON");
		
		
//___________________________________________
//  AFTER CLICK CANCEL BUTTON 
//___________________________________________
		String sp[]=toBeDelete.split(",");
		String text = sp[0];	
System.out.println();
		SampleCommonMethods.firstrowdataCancel("STEP 3: After click Cancel Button the data Not in First Row ", driver
				.findElement(By.xpath("(//td[normalize-space()='" + text + "'])[1]")), ExpectedResult
				 );

		
		
		
		
	


}}
