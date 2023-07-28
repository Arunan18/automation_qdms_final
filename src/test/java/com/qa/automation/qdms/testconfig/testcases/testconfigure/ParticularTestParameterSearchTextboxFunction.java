//***********************************************************************************
//* Description
//*------------
//*Test Parameter search TextBox function- Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0091         01/05/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

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
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ParticularTestParameterSearchTextboxFunction  extends DriverIntialization{
	static TestConfigPage SearchTextBoxFunction  = new TestConfigPage();
	static String Searchdata = null;
	
	

	@Test
	public static void method() throws InterruptedException, IOException {
		
//____________________________________________________________________________
// LOGIN 
//___________________________________________________________________________	
		
		LoginTest.Login();
		
//____________________________________________________________________________
//  NAVIAGATE TO PARAMETER TEST
//___________________________________________________________________________
		
		ParticularTestParameterSearchTextboxFunction.naviagteToTestConfigurationParameter();
		
//____________________________________________________________________________
//  EXCEL METHOD
//_____________________________________________________________________________
		
		ParticularTestParameterSearchTextboxFunction.ExcelMethod();
		
//___________________________________________________________________________
//      STEP: 1 PARAMETER SEARCH ICON VISIBLE AND ENABLE,
//		STEP:2 PARAMETER SEARCH TEXTBOX VISIBLE ANE ENABLE 
//      STEP:3  CHECK SEND DATA OR NOT SEARCH TEXTBOX	
//      "STEP:4 CHECK DATA IN TEXT BOX 		
//______________________________________________________________________________	
		
		ParticularTestParameterSearchTextboxFunction.SaearchTextBoxFunctionality();
		
//_______________________________________________________________________________
//  LOGOUT
//________________________________________________________________________________
		
		MultiSearchMethods.Logout();
	}
	
	
	
	
//==================================  T E S T C A S E =============================
	
//_________________________________________________________________
//  NAVIGATE TO TEST CONFIGURATION PARAMETER
//_________________________________________________________________ 
	
	
	public static void naviagteToTestConfigurationParameter() throws InterruptedException {
		PageFactory.initElements(driver, SearchTextBoxFunction);
		
		// NAVIGATE TO TEST CONFIGURATION

				SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
				
				
		        Thread.sleep(2000);
		        TestConfigPage.ManageCofigureMenuBar.click();
		        
		        Actions actions = new Actions(driver);
		        driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		        try {
		            boolean pass = false;
		            Thread.sleep(1000);
		            for (int i = 0; i < 1000; i++) {
		                if (!pass) {
		                    try {
		                        driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
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
		        TestConfigPage.Editconfi.click();	
		         
				//NAVIGATE TO PARAMETER
				Thread.sleep(2000);
				SampleActionMethods.clicking(TestConfigPage.TestParameterStepTwo, 2, "TEST PARAMETER STEP TWO");		
				
				WebElement AddGroup = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
				Thread.sleep(2000);
				AddGroup.click();
			
		     
		        
		        
				
			}
//____________________________________________________________________________________________________
//  EXCEL METHOD
//____________________________________________________________________________________________________	
	
		public static void ExcelMethod() throws IOException {
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
			String excelSheetName = "Test_Configure";
			String testCaseId = "TC-TCN-0091";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			for (int i = firstRow; i <= lastRow; i++) {
				
				XSSFRow row = sheet.getRow(i);
				Searchdata= (String) row.getCell(1).getStringCellValue();
				
			}
		}
		
	
//__________________________________________________________________________________________________________
//   STEP: 1 PARAMETER SEARCH ICON VISIBLE AND ENABLE, STEP:2 PARAMETER SEARCH TEXTBOX VISIBLE ANE ENABLE 
//_________________________________________________________________________________________________________
	
	public static void SaearchTextBoxFunctionality () throws InterruptedException {
		PageFactory.initElements(driver, SearchTextBoxFunction);
			
		
// PARAMETER SEARCH ICON VISIBLE AND ENABLE	
		
		SampleActionMethods.clicking(TestConfigPage.ParameterSearchIcon, 2, "STEP:1 PARAMETER SEARCH ICON ");
		
//PARAMETER SEARCH TEXTBOX VISIBLE ANE ENABLE 	
		
		SampleActionMethods.clicking(TestConfigPage.ParameterTextBox, 2, "STEP:2 PARAMETER SEARCH TEXT BOX");
		
// TEXT BOX FUNCTIONALITY
		testCase = extent.createTest("STEP:3 CHECK ABLE TO SEND DATA-IN SEARCH BOX");
		try {
			TestConfigPage.ParameterTextBox.sendKeys(Searchdata);
			testCase.log(Status.PASS, "DATA SEND");
		}catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "  DATA NOT SEND");
		}
		
// GET THE TEXT FROM THE TEXT BOX
		
		testCase = extent.createTest("STEP:4 CHECK DATA IN TEXT BOX ");
		String textBoxText = TestConfigPage.ParameterTextBox.getAttribute("value");

		if (textBoxText.equals(Searchdata)) {
		    // If the text box value matches the expected input, log a pass status
		    testCase.log(Status.PASS, "The text box value matches the expected input.");
		} else {
		    // If the text box value does not match the expected input, log a fail status
		    testCase.log(Status.FAIL, "The text box value does not match the expected input.");
		}
		
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
