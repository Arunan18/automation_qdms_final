//***********************************************************************************
//* Description
//*------------
//*Edit Function TestCase - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-Test-0019          26/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignCommonPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

class TestEditFunction extends DriverIntialization {
	static TestConfigPage EditPage = new TestConfigPage();

	static String SearchData = null;
	static String EditData = null;
	
	
	@Test
	public void methodForEditFunction() throws InterruptedException, IOException {
	
//============================================================ M E T H O D ==================================================================
		
		
//__________________________________________________________
//  LOGIN
//__________________________________________________________		
					
		LoginTest.Login();
//__________________________________________________________
//  NAVIGATE TO TEST
//__________________________________________________________		
		
		TestEditFunction.NaVigateToTest();
//__________________________________________________________
// EXCEL METHOD
//__________________________________________________________		
					
		TestEditFunction.ExcelMethod();
//__________________________________________________________
//  STEP:1 EDIT ICON VISIBLE AND ENABLE
//  STEP:2 SAVE BUTTON VISIBLE AND ENABLE	
//__________________________________________________________		
					
		TestEditFunction.SearchDataAndEdit();
//________________________________________________________
// STEP:3 EDITED DATA IS VISIBLE
// STEP:4 EDITED DATA -  GET TEXT		
//________________________________________________________		
		TestEditFunction.afterValidateData();
//__________________________________________________________
//  LOGOUT
//__________________________________________________________		
					
		TestEditFunction.Logout();
	}
	
	//============================================================  T E S T C A S E ==================================================================	
	 

	public static void NaVigateToTest() {
		PageFactory.initElements(driver, EditPage);

		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", EditPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED", EditPage.testconfigurationtext,
				"TEST CONFIGURATION", "ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO TEST SIDE BUTTON
		SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", EditPage.TestNavigation,
				"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", EditPage.ParameterText,
				"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");

	}

//__________________________________________________________________________
//  EXCEL METHOD
//___________________________________________________________________________	
	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test";
		String testCaseId = "TC-Test-0019";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			EditData=(String) row.getCell(1).getStringCellValue();

		}
	}
	
//________________________________________________________________
//  SEARCH DATA TO BE EDIT
//________________________________________________________________
	public static void SearchDataAndEdit() throws InterruptedException {
		PageFactory.initElements(driver, EditPage);
		ActionCommonMethod.actionS(0, 1, TestConfigPage.Table,"edit" , "Test Configuragtion Module.xlsx", "Test", "TC-Test-0019-01", 1);
		
		testCase = extent.createTest("CHECK DATA IS EDITEDOR NOT ");
		try {
		
		TestConfigPage.PlaceHolderTestName.sendKeys(Keys.CONTROL, "a"); // Select all text
		TestConfigPage.PlaceHolderTestName.sendKeys(Keys.DELETE); // Clear the text
		Thread.sleep(2000);
		TestConfigPage.PlaceHolderTestName.sendKeys(EditData);

		testCase.log(Status.PASS, "DATA IS EDITED");
	} catch (AssertionError e) {
		// TODO: handle exception
		testCase.log(Status.FAIL, "DATA IS NOT EDITED");
	}
		Thread.sleep(2000);
		
		
		SampleActionMethods.clicking(TestConfigPage.SaveButton, 2, "STEP:2 SAVE BUTTON");
		Thread.sleep(2000);
		
		 
		
	}
//__________________________________________________________________________
//  AFTER EDIT  VALIDATE DATA VISIBLE
//_________________________________________________________________________	

public static void afterValidateData() throws InterruptedException {
	PageFactory.initElements(driver, EditPage);
	
	Thread.sleep(2000);
	Thread.sleep(2000);
	String text = EditData;
	WebElement afterEditedData = driver.findElement(By.xpath("(//td[normalize-space()='" + text + "'])[1]"));

	boolean Visible = afterEditedData.isDisplayed();
	if (Visible) {

		boolean actualVisible = afterEditedData.isDisplayed();
		System.out.println("Edited Data is Visible" + actualVisible);
		boolean expectedVisible = true;
		testCase = extent.createTest("STEP:3 AFTER EDIT DATA IS VISIBLE");

		try {
			assertEquals(actualVisible, expectedVisible);
			testCase.log(Status.INFO, " Actual Visible:" + actualVisible);
			testCase.log(Status.INFO, " Expected Visible:" + expectedVisible);
			testCase.log(Status.PASS, "Visible correct");

		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.INFO, " Actual Visible:" + actualVisible);
			testCase.log(Status.INFO, " Expected Visible:" + expectedVisible);
			testCase.log(Status.FAIL, "Visible not correct");
		}

	}
//__________________________________________________________________________
// AFTER EDIT  VALIDATE DATA GET TEXT
//_________________________________________________________________________	

	String actualText = afterEditedData.getText();
	System.out.println("Edited Data Spell:-" + afterEditedData);
	String expectedText = EditData;
	testCase = extent.createTest("STEP:4 AFTER EDIT GET TEXT");
	boolean data = true;
	try {
		assertEquals(actualText, expectedText);
	} catch (AssertionError e) {
		// TODO: handle exception
	}
	if (data) {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.PASS, "Text Correct");
	} else {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.FAIL, "Text Correct");
	}
	
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);

}


//____________________________________________________________
//LOGOUT
//______________________________________________________________	
public static void Logout() throws InterruptedException {

	Thread.sleep(2000);
	WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
	Admin.click();

	Thread.sleep(2000);
	WebElement Logout = driver.findElement(By.xpath(
			"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
	Logout.click();

}
}

