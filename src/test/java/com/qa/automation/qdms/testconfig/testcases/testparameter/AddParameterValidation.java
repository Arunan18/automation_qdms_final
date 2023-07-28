//***********************************************************************************
//* Description
//*------------
//* ADD PARAMETER VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0044			 26/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AddParameterValidation extends DriverIntialization{

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestParameterPage testpage = new TestParameterPage();
	static Logout logout = new Logout();
	
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testpage);
		PageFactory.initElements(driver, logout);
		
		/* LOGIN */
		LoginTest.Login();
		
		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED",
				"02--TEST TOP NAVIGATION BUTTON ENABLED", testnav.testleftnav,
				testnav.testparameterleftnav,testnav.testconfigleftnav,testnav.configgrouptestleftnav,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
		/* TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST PARAMETER PROPERTIES", testnav.testparameterleftnav,
				"01--TEST PARAMETER LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST PARAMETER LEFT NAVIGATION BUTTON ENABLED", testpage.testparameterheadding,"Parameter",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		/* CLICK ON ADD PARAMETER BUTTON*/
		SampleCommonMethods.singleclick("STEP_04-- ADD PARAMETERS PROPERTIES", testpage.addparameter,"01--ADD PARAMETERS BUTTON DISPLAYED","02--ADD PARAMETERS BUTTON ENABLED");
		
		/* CHECK THE EMPTY VALIDATION FOR PARAMETER FIELD */
		parametervalidation(); 
		
		/* CHECK THE EMPTY VALIDATION FOR PARAMETER TYPE FIELD */
		parametertypevalidation();
		
		/* CHECK THE EMPTY VALIDATION FOR PARAMETER DATA TYPE FIELD */
		parameterdatatypevalidation();
		
		/* CHECK THE CHARECTERS LONG VALIDATION FOR PARAMETER FIELD */
		charecterslongvalidation();
		
		/* CHECK THE SPACE VALIDATION FOR PARAMETER FIELD */
		spacevalidation();
		
		/* CHECK THE INVALID CHARECTER VALIDATION FOR PARAMETER FIELD */
		invalidcharectervalidation();
		
		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}
	
	/* CHECK THE EMPTY VALIDATION FOR PARAMETER FIELD */
	
	public static void parametervalidation() throws InterruptedException, IOException
	{
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		testCase = extent.createTest("Step-05--ADD PARAMETER VALIDATION");

		XSSFRow row = sheet.getRow(firstRow);
		
		String parameter = (String) row.getCell(1).getStringCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(parameter);
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parametervalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("01-- EMPTY VALIDATION FOR PARAMETER FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
	
	/* CHECK THE EMPTY VALIDATION FOR PARAMETER TYPE FIELD */
	
	public static void parametertypevalidation() throws InterruptedException, IOException
	{

		testpage.addparameter.click();
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		XSSFRow row = sheet.getRow(firstRow+1); 
		
		String parameter = (String) row.getCell(1).getStringCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(parameter);
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parametertypevalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("02-- EMPTY VALIDATION FOR PARAMETER TYPE FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
	
	
/* CHECK THE EMPTY VALIDATION FOR PARAMETER DATA TYPE FIELD */
	
	public static void parameterdatatypevalidation() throws InterruptedException, IOException
	{

		testpage.addparameter.click();
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		XSSFRow row = sheet.getRow(firstRow+2);
		
		String parameter = (String) row.getCell(1).getStringCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(parameter);
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parameterdatatypevalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("03-- EMPTY VALIDATION FOR PARAMETER DATA TYPE FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
	
/* CHECK THE CHARECTERS LONG VALIDATION FOR PARAMETER FIELD */
	
	public static void charecterslongvalidation() throws InterruptedException, IOException
	{

		testpage.addparameter.click();
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		XSSFRow row = sheet.getRow(firstRow+3);
		
		String parameter = (String) row.getCell(1).getStringCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(parameter);
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parametervalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("04-- CHARECTERS LONG VALIDATION FOR PARAMETER FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
	
	
/* CHECK THE SPACE VALIDATION FOR PARAMETER FIELD */
	
	public static void spacevalidation() throws InterruptedException, IOException
	{

		testpage.addparameter.click();
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		XSSFRow row = sheet.getRow(firstRow+4);
		
		String parameter = (String) row.getCell(1).getStringCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(parameter);
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(2000);

			String ActualValidation = testpage.parametervalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("05-- SPACE VALIDATION FOR PARAMETER FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
	
/* CHECK THE INVALID CHARECTER VALIDATION FOR PARAMETER FIELD */
	
	public static void invalidcharectervalidation() throws InterruptedException, IOException
	{

		testpage.addparameter.click();
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0044";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");

		XSSFRow row = sheet.getRow(firstRow+5);
		
		int parameter = (int) row.getCell(1).getNumericCellValue();
		String parametertype = (String) row.getCell(2).getStringCellValue();
		String parameterdatatype = (String) row.getCell(3).getStringCellValue();
		String validationmsg = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(String.valueOf(parameter));
			
			/* Select the drop down for Parameter Type Field */
			Actions actions = new Actions(driver);
			if(parametertype != "")
			{
			boolean findthevalue = false;
              for(int i = 0; i < 20; i++) {
                  try {
                  	Thread.sleep(1000); 
                  	testpage.parametertype.click();
                  	driver.findElement(By.xpath("//div[@title='"+parametertype+"']")).click();
                       
	                  findthevalue = true; 
	                  break;
                      
                  } catch (Exception e) {
                      actions.sendKeys(Keys.ARROW_DOWN).perform();
                  }
              }
			}
              
              /* Select the drop down for Parameter Type Field */
			if(parameterdatatype != "")
			{
	  			Actions actionss = new Actions(driver);
	  			boolean findthevaluee = false;
	                for(int i = 0; i < 20; i++) {
	                    try {
	                    	Thread.sleep(1000); 
	                    	testpage.parameterdatatype.click();
	                    	driver.findElement(By.xpath("//div[@title='"+parameterdatatype+"']")).click();
	                         
	                        findthevaluee = true; 
	                        break;
	                        
	                    } catch (Exception e) {
	                        actionss.sendKeys(Keys.ARROW_DOWN).perform();
	                    }
	                }
			}
              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parametervalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("06-- INVALID CHARECTERS VALIDATION FOR PARAMETER FIELD");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		testpage.cancelbutton.click();
	}
}
