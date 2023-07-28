//***********************************************************************************
//* Description
//*------------
//*Sigle Search Reset Function - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-009         26/04/2023       Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestSingleSearchResetFunction extends DriverIntialization {
	static TestConfigPage ResetButtonPage = new TestConfigPage();
	static String SearchData = null;
	static String ExpectedResult = null;

	@Test
	public void method() throws InterruptedException, IOException {
		
//________________________________________________________________
//  LOGIN
//_________________________________________________________________		

		LoginTest.Login();
		
//_________________________________________________________________
//  NAVIGATE TO MANAGE TEST
//________________________________________________________________
		
		TestSingleSearchResetFunction.navigateToMangeTest();
		
//_________________________________________________________________
// EXCEL METHOD
//_________________________________________________________________
		
		TestSingleSearchResetFunction.ExcelMethod();

//________________________________________________________________
// STEP:1 SEARCH ICON VISIBLE AND ENABLE
// STPE:2 SEARCH PLACEHOLDER VISIBLE AND ENABLE		
//__________________________________________________________________		
		TestSingleSearchResetFunction.SearchData();
		
//__________________________________________________________________
// STEP:3 RESET BUTTON ENABLE AND VISIBLE
// STEP:4 AFTER CLICK RESET BUTTON CHECK PAGINATION
//__________________________________________________________________		
		TestSingleSearchResetFunction.ResetButtonClickAfterValidate();

	}
//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	public static void navigateToMangeTest() {
		PageFactory.initElements(driver, ResetButtonPage);

		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO MANAGE TEST CONFIGURE
		SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", TestConfigPage.MANGECONFIGURE,
				"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", TestConfigPage.ParameterText,
				"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");
	}

//__________________________________________________________________________
//  EXCEL METHOD
//___________________________________________________________________________	
	public static void ExcelMethod() throws IOException {

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
			SearchData = (String) row.getCell(1).getStringCellValue();
			ExpectedResult = (String) row.getCell(1).getStringCellValue();

		}
	}

//___________________________________________________________________________
//   SERACH DATA 
//____________________________________________________________________________
	public static void SearchData() throws InterruptedException {

		SampleActionMethods.clicking(TestConfigPage.outSideSearchIcon, 2, " STEP:1 TEST SEARCH ICON");
		SampleActionMethods.clicking(TestConfigPage.SearchPlaceHolder, 2, " STEP:2 TEST SEARCH PLACE HOLDER");

		Thread.sleep(3000);
		TestConfigPage.SearchPlaceHolder.sendKeys(SearchData);

	}

//______________________________________________________________________________
//  CLCK RESET BUTTON  AND CHECK AFTER RESET BUTTON CLICK
//_______________________________________________________________________________
	public static void ResetButtonClickAfterValidate() throws InterruptedException {
		PageFactory.initElements(driver, ResetButtonPage);

		SampleActionMethods.clicking(TestConfigPage.ResetBtn, 2, "STEP:3 RESET BUTTON");

		boolean clickNextPage = true;
		int actualElementCount = 0;
		boolean passorfail = true;
		ArrayList<String> ActualList = new ArrayList<String>();
		ArrayList<String> ExpectedList = new ArrayList<String>();
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {
			for (int i = 2; i < 750; i++) {
				try {
					String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					if (!text.contains(SearchData)) {
						passorfail = false;
					}
					if (text.contains(SearchData)) {
						ExpectedList.add(text);
					}
					ActualList.add(text);
					actualElementCount = actualElementCount + 1;
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		try {
			int Value = actualElementCount;
			testCase = extent.createTest("STEP-4 AFTER CLICK RESET BUTTON CHECK PAGINATION", ExpectedResult);
		} catch (Exception e) {

		}

	}

//____________________________________________________________
//  LOGOUT
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
