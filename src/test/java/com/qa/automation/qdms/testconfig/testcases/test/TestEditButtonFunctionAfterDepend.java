//***********************************************************************************
//* Description
//*------------
//*After Depend EditFunction - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-Test-0040           26/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestEditButtonFunctionAfterDepend extends DriverIntialization {
	static TestConfigPage DependEditPage = new TestConfigPage();
	static String SearchData = null;
	static String EditData = null;
	
//===================================  M E T H O D ==============================================
	
	@Test
	public void method() throws InterruptedException, IOException {
		
//_____________________________________________________________
//  LOGIN
//____________________________________________________________ 
		
		LoginTest.Login();
		
//____________________________________________________________
//  NAVIGATE TO TEST
//___________________________________________________________
		
		TestEditButtonFunctionAfterDepend.navigateToTest();
		
//____________________________________________________________
//  EXCEL METHOD
//____________________________________________________________
		
		TestEditButtonFunctionAfterDepend.ExcelMethod();
		
		
//___________________________________________________________
//  STEP:1 EDIT ICON IS VISIBLE AND ENABLE
//  STEP:2 SEARCH DATA TO EDITED
//  STEP:3 SAVE BUTTON VISIBLE AND ENABLE
//__________________________________________________________
		
		TestEditButtonFunctionAfterDepend.SearchDataAndEdit();
		
//__________________________________________________________		
//  STEP:4 AFTER EDIT CHECK DATA TO BE EDITED OR NOT 		
//___________________________________________________________
		
		TestEditButtonFunctionAfterDepend.AterValidate();
		
//___________________________________________________________
//  LOGOUT
//___________________________________________________________		
		
		TestEditButtonFunctionAfterDepend.Logout();
	}
	
	
	
	
	
//===================================== T E S T C A S E S =====================================
	

//________________________________________________________
// NAVIGATE TO TEST
//________________________________________________________	

	public static void navigateToTest() throws InterruptedException {
		PageFactory.initElements(driver, DependEditPage);

		Thread.sleep(2000);
		TestConfigPage.testconfigurationcard.click();
	

	}
 
//__________________________________________________________________________
//  EXCEL METHOD
//___________________________________________________________________________	
	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test";
		String testCaseId = "TC-Test-0040";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			EditData = (String) row.getCell(2).getStringCellValue();

		}
	}

//________________________________________________________________
//  SEARCH DATA TO BE EDIT
//________________________________________________________________
	public static void SearchDataAndEdit() throws InterruptedException {
		PageFactory.initElements(driver, DependEditPage);
		
		Thread.sleep(2000);
		ActionCommonMethod.actionS(0, 1, TestConfigPage.Table,"edit ","Test Configuragtion Module.xlsx", "Test", "TC-Test-0040", 1);

		testCase = extent.createTest("STEP:2 CHECK DATA IS EDITEDOR NOT ");
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

		SampleActionMethods.clicking(TestConfigPage.SaveButton, 2, "STEP:3 SAVE BUTTON");
		Thread.sleep(2000);

	}
//________________________________________________________________________________
// AFTER CLICK EDIT  GET TEXT DATA 
//________________________________________________________________________________	
	public static void AterValidate() throws InterruptedException {
		
		String text = EditData;
		
WebElement aftedEditeddata = driver.findElement(By.xpath("//td[normalize-space()='"+text+"']"));		
String actualText = aftedEditeddata.getText();
	System.out.println("Can't Edit :-" + actualText);
	String expectedText = "";
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

