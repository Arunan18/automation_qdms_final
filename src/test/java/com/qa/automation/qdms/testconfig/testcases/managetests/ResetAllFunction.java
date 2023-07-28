//***********************************************************************************
//* Description
//*------------
//*ResetAll Button Functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-007         27/04/2023      Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testcases.user.UserMainTests;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ResetAllFunction extends DriverIntialization {
	static TestConfigPage ResetallBtn = new TestConfigPage();

//============================================ M E T H O D S ===============================================================
	@Test
	public void methodCalling() throws InterruptedException, IOException {

//__________________________________________________________
// LOGIN
//__________________________________________________________		

		LoginTest.Login();

//__________________________________________________________
// NAVIGATE TO MANAGE TEST
//__________________________________________________________		

		ResetAllFunction.navigateMangeTest();

//_________________________________________________________

// STEP:1 TEST- SEARCH ICON UI PROPEERTIES

// STEP :2 TEST- SEARCH ICON  CLICK

// STEP :3 TEST - TEST SEARCH TEX BOX PROPERTIES	

// STEP :4 TEST TEST SEARCH BUTTON PROPERTIES	

// STEP :5 TEST - TEST INPUT DATA SEARCH	

// STEP:6 TEST - SEARCH BUTTON CLICK		

// STEP:7 TEST - AFTER SEARCH DATA

// STEP:8 RESET BUTTON PROPERTIES	

// STEP:9 RESET BUTTON CLICK

//____________________________________________________________		

		ResetAllFunction.SearchData();

//___________________________________________________________
//  AFTER CLICK RESET ALL BUTTON CHECK DISAPER OR NOT 
//___________________________________________________________
		
		ResetAllFunction.checkResetAllButtonDisapper();
		
		
//___________________________________________________________
//  LOGOUT
//___________________________________________________________
		
		MultiSearchMethods.Logout();
		
		
		
	}
	

//=============================================  T E S T C A S E S =========================================================	

//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	public static void navigateMangeTest() {
		PageFactory.initElements(driver, ResetallBtn);

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
//____________________________________________________________________________
//  SEARCH DATA
//_____________________________________________________________________________	

	public static void SearchData() throws InterruptedException, IOException {

		boolean CodeTableData = true;
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-007");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-007");

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			int DataSearch = (int) row.getCell(11).getNumericCellValue();
			int TotalDataRow = (int) row.getCell(12).getNumericCellValue();

			PageFactory.initElements(driver, ResetallBtn);

			// STEP:1 TEST- SEARCH ICON UI PROPEERTIES
			MultiSearchMethods.checkSearch(TestConfigPage.outSideSearchIcon, "STEPP:1 Test Search Icon");

			// STEP 2 : TEST- SEARCH ICON CLCIKPlant
			MultiSearchMethods.ClickSearch(TestConfigPage.outSideSearchIcon, TestConfigPage.SearchPlaceHolder,
					"Test Search");

			// STEP 3 : TEST - TEST SEARCH TEX BOX PROPERTIES
			MultiSearchMethods.SearchTextBox(TestConfigPage.SearchPlaceHolder, "STEP:3 Test Search");

			// STEP 4 : TEST TEST SEARCH BUTTON PROPERTIES
			MultiSearchMethods.SearchButton(TestConfigPage.SearchBtn, "STEP:4 Search Button");

			// STEP 5: TEST - TEST INPUT DATA SEARCH
			TestConfigPage.SearchPlaceHolder.sendKeys("t");

			// STEP:6 TEST - SEARCH BUTTON CLICK
			MultiSearchMethods.SearchButtonClick(TestConfigPage.SearchBtn, TestConfigPage.ResetAllBtn, "Test search");

			// STEP:7 TEST - AFTER SEARCH DATA
			MultiSearchMethods.checkAfterSearchData(TestConfigPage.testColoum, TestConfigPage.TestSearchColumnBefore,
					TestConfigPage.TestSearchColumnAfter, "STEP:7 Test Search", DataSearch, CodeTableData);

			// STEP:8 RESET BUTTON PROPERTIES
			MultiSearchMethods.Button(TestConfigPage.ResetAllBtn, "STEP:8 RESET ALL BUTTON ");

			// STEP:9 RESET BUTTON CLICK
			Thread.sleep(2000);
			MultiSearchMethods.ButtonClick(TestConfigPage.ResetAllBtn, "STEP:9 RESET ALL BUTTON",
					TestConfigPage.testColoum, TotalDataRow);

			

		}

	}

//_________________________________________________________________
//  RESET ALL BUTTON DISAPER
//_________________________________________________________________		
	public static void checkResetAllButtonDisapper() throws InterruptedException {
		PageFactory.initElements(driver, ResetallBtn);

		Thread.sleep(2000);
		//WebElement resetbtn = driver
			//	.findElement(By.xpath("//button[@class='ant-btn ant-btn-danger ant-btn-background-ghost']"));

		boolean actual = false; 
		try {
			boolean Acctualtra = TestConfigPage.ResetAllBtn.isDisplayed();
			actual = Acctualtra;
		} catch (NoSuchElementException e) {
			actual = false;
		}
		System.out.println("Reset all button status: " + actual);
		boolean Expectedetra = false;

		UserMainTests.TestCasePrint("RESET BUTTON IS NOT DISPLAYED", Expectedetra, actual);

	}

}
