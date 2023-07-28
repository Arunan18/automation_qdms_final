//***********************************************************************************
//* Description
//*------------
//*Add parameter in test config -under the test parameter tab
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0382        	01/06/2023     Saranka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class Add_Parameter_in_testConfig_Unter_theTestParameterTab extends DriverIntialization {
	static TestConfigPage catDueDay = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static SampleActionMethods action = new SampleActionMethods();
	static String Parmeter = null;
	static String DataType = null;
	DataFormatter dataValue = new DataFormatter();

	@Test
	public void AddParaMeter() throws IOException, InterruptedException {
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, catDueDay);
		PageFactory.initElements(driver, action);

//_______________________________		
// LOGIN TO THE SYSTEM
//_______________________________		

		LoginTest.Login();

//_______________________________        
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", catDueDay.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				catDueDay.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

//_______________________________       
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

		WebElement TestConFigure = driver.findElement(By.xpath("//div[contains(text(),'Test Configure')]"));
		SampleActionMethods.clicking(TestConFigure, 2, "TEST CONFIGURE");

//_______________________________        
//STEP1 :ADD  THE CONFIGURETEST  
// _______________________________

		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0382-first");
		Thread.sleep(2000);

//____________________________________
// EXCEL
//____________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-00382";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		XSSFRow row = sheet.getRow(firstRow);
		Parmeter = (String) row.getCell(1).getStringCellValue();
		row = sheet.getRow(firstRow);
		XSSFCell cell = row.getCell(2);
		String DataType = dataValue.formatCellValue(cell);

//____________________________________
//  STEP:2 ADD PARAMETER BUTTON
//____________________________________		

		WebElement addParameter = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		Thread.sleep(2000);

		addParameter.click();

//____________________________________	
// STEP:3 ADD PARAMETER DATA		
//____________________________________ 

		testCase = extent.createTest("STEP:3 ADD PARAMETR DATA");

		try {
			WebElement textBoxAddParameter = driver.findElement(By.xpath("//*[@id=\"parameter_name\"]"));
			Thread.sleep(2000);
			textBoxAddParameter.sendKeys(Parmeter);

			WebElement TextboxDataType = driver.findElement(By.xpath("//input[@id='parameterDataType']"));
			TextboxDataType.click();
			Thread.sleep(2000);
			String text = DataType;
			WebElement TextboxDataTypeNumber = driver
					.findElement(By.xpath("(//div[contains(text(),'" + text + "')])[2]"));
			Thread.sleep(2000);
			TextboxDataTypeNumber.click();

			testCase.log(Status.PASS, "data is added");
		} catch (AssertionError e) {
			// TODO: handle exception

			testCase.log(Status.FAIL, "data is added");
		}

		WebElement saveButton = driver.findElement(By.xpath("(//button[@type='button'])[10]"));
		saveButton.click();

//_________________________________________________
// AFTER ADD CHECK DATA IS THERE
//_________________________________________________
 
//	String text1 = Parmeter; 
		Thread.sleep(2000);
		WebElement editedDataAfterFinishValue = driver.findElement(By.xpath("//td[normalize-space()='"+Parmeter+"']"));
		SampleCommonMethods.firstrowdata("STEP 4: DATA ADDED IN FIRST ROW", editedDataAfterFinishValue, Parmeter);

// _______________________________
// LOGOUT TO THE SYSTEM
// _______________________________

		Logout.LogoutFunction();

	}

}
