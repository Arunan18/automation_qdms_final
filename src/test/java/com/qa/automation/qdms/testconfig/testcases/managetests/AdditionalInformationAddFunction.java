//***********************************************************************************
//* Description
//*------------
//*Additional Information Add  more - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-084           18/05/2023     Saranka     Original Version
//*						 14/06/2023	    Arunan	  Updated Version
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AdditionalInformationAddFunction extends DriverIntialization {
	static ManageTestsPage Addinfo = new ManageTestsPage();
	static TestConfigPage AdditionalInform = new TestConfigPage();
	static String tobeSearchData = null;
	static String captionText = null;
	static String RecordType = null;
	static String Maxlength = null;
	static DataFormatter dataValue=new DataFormatter();
	static String SucessMessage = null;
	
//====================================================== M E T H O D ======================================================
	
	@Test
	public void methodCalling() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		AdditionalInformationAddFunction.addFunction();
		
		Logout.LogoutFunction();
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void addFunction() throws InterruptedException, IOException {
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
		String testCaseId = "MTC-MT-084";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			tobeSearchData = dataValue.formatCellValue(row.getCell(1));
			captionText = dataValue.formatCellValue(row.getCell(2));
			RecordType = dataValue.formatCellValue(row.getCell(3));
			Maxlength = dataValue.formatCellValue(row.getCell(4));
			SucessMessage = dataValue.formatCellValue(row.getCell(5));

		}
//__________________________________________
//  SEARCH DATA TO CLCIK
//__________________________________________
		
		WebElement table = driver.findElement(By.xpath("(//div[@class='ant-table-container'])[1]"));
		AddGroupKey.actionS(0, 10, table, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-084-01", 1);

//__________________________________________
//  ADD DATA 
//__________________________________________	
Thread.sleep(1500);
		testCase = extent.createTest("STEP:2 ALL VALUE SENDED CORRECTLY");
		try {

			WebElement CaptionPlaceHolder = driver.findElement(By.xpath("(//input[@id='caption'])[1]"));
			Thread.sleep(2000);
			CaptionPlaceHolder.sendKeys(captionText);

			WebElement recordType = driver.findElement(By.xpath("(//div[@name='recordType'])[1]"));
			recordType.click();

			String headertxt = RecordType;
			WebElement header = driver.findElement(By.xpath("//div[contains(text(),'" + headertxt + "')]"));
			Thread.sleep(2000);
			header.click();

			WebElement maximumLength = driver.findElement(By.xpath("(//input[@id='length'])[1]"));
			maximumLength.sendKeys(Maxlength);

			WebElement Active = driver.findElement(By.xpath("//input[@id='dynamic_form_nest_item_users_0_active']"));
			Active.click();

			WebElement add = driver.findElement(By.xpath("//button[@type='submit']"));
			Thread.sleep(2000);
			add.click();
			testCase.log(Status.PASS, "Data Added Sucessfully");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "Data  Not Added Sucessfully");
		}

//_______________________________________________
// AFTER ADD FUNCTION
//________________________________________________
Thread.sleep(1000);
		WebElement sucessValidation = driver
				.findElement(By.xpath("//div[contains(text(),'Test Records Added Sucessfully')]"));
		SampleCommonMethods.dataaddedsuccessmsg("STEP:3 CHECK ADDED SUCCESS MESSAGE", sucessValidation, SucessMessage);

		String text = captionText;
		WebElement tableData = driver.findElement(By.xpath("(//td[normalize-space()='" + text + "'])[1]"));
		
		
		boolean actualVisible = tableData.isDisplayed();
		System.out.println("Actual Visible Data:-"+actualVisible);
		boolean expectedVisible = true;
		testCase = extent.createTest("STEP:4 DATA IS THERE");
		try {
			Assert.assertEquals(actualVisible, expectedVisible);
			testCase.log(Status.PASS,"Data is there");
		}catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL,"Data is not there");
		}
		
		driver.navigate().refresh();
		

	}
}
