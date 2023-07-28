//*******************************************************************************
//* Description
//*------------
//*Edit Equation Save Button functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 03/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0141        03/05/2023   Saranka     Original Version
//*
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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationSaveButtonFunctionality extends DriverIntialization {
	static ManageTestsPage cancelBtn = new ManageTestsPage();
	static TestConfigPage canceButton = new TestConfigPage();
	static String TobeSearchData = null;
	static String ValidationMessage =null;
	static String editData = null;
//===================================================== M E T H O D ==========================================================	
	
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EditEquationSaveButtonFunctionality.SaveButtonFunctionality();
		
		Logout.LogoutFunction();
		
		
		
		
	}
	
//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

		public static void SaveButtonFunctionality() throws InterruptedException, IOException {
			PageFactory.initElements(driver, cancelBtn);
			PageFactory.initElements(driver, canceButton);

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
			String excelSheetName = "Test_Configure";
			String testCaseId = "TC-TCN-0141";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			for (int i = firstRow; i <= lastRow; i++) {

				XSSFRow row = sheet.getRow(i);
				TobeSearchData = (String) row.getCell(1).getStringCellValue();
				
				ValidationMessage = (String) row.getCell(2).getStringCellValue();
				
				editData = (String) row.getCell(3).getStringCellValue();
			}
			
//______________________________________________
//  DATA SEARCH TO CLICK
//______________________________________________
			

			ActionCommonMethod.actionS(0, 9, TestConfigPage.TableManageConfigure, "Description",
					"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0141-01", 1);
			
//____________________________________________
// SAVE BUTTON FUNCTIONLAITY
//____________________________________________		

			SampleActionMethods.clicking(ManageTestsPage.editBtnPopup, 2, "STEP:1 EDIT BUTTON VISIBLE");
			
			WebElement editEquationPlaceHolder = driver.findElement(By.xpath("//input[@id='equation_formula']"));
			editEquationPlaceHolder.sendKeys(Keys.CONTROL, "a");
			editEquationPlaceHolder.sendKeys(Keys.DELETE);
			editEquationPlaceHolder.sendKeys(editData); 
			
			Thread.sleep(2000);
			 
			SampleActionMethods.clicking(ManageTestsPage.SaveBtnPopup, 2, "STEP:2 SAVE BUTTON");
//________________________________________________
// AFTER CLICK SAVE BUTTON
//________________________________________________
			
			WebElement validationMessage = driver.findElement(By.xpath("//div[contains(text(),'Equation Updated Successfully')]"));
			SampleCommonMethods.dataaddedsuccessmsg("STEP :3 DATA IS SAVED VALIDATION MESSAGE",
					validationMessage, ValidationMessage);
			
			
}
		}
		

