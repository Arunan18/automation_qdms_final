
//***********************************************************************************
//* Description
//*------------
//* Manage Test Configuration Tab - Reset All button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 03/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-MT-410          03/07/2023   Sasi     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ResetAllButtonProperties extends DriverIntialization {
	static ManageTestsPage Managepg = new ManageTestsPage();

	@Test
	public static void ResetAllButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Managepg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);

		// Search Test Icon
		ManageTestsearchiconProperties();

		// Excel & Search Data Calling Method
		ExcelMethod();

		// Reset All Button Properties
		ResetAllButtonProperties();

		// LogOut
		Logout.LogoutFunction();
	}

	// Manage Test Search icon Click Method

	public static void ManageTestsearchiconProperties() {
		try {
			ManageTestsPage.TestSearchicon.click();

			testCase = extent.createTest("Test Search Icon Click");
			testCase.log(Status.INFO, "Test Search Icon Clicked");
			testCase.log(Status.PASS, "Correct");

		} catch (NoSuchElementException e) {

			testCase = extent.createTest("NO Test Search Icon Element");
			testCase.log(Status.INFO, "Test Search Icon Not Clicked");
			testCase.log(Status.FAIL, "Wrong");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Not Test Search Icon Element CLicked");
			testCase.log(Status.INFO, "Test Search Icon Not Clicked");
			testCase.log(Status.FAIL, "Wrong");
		}

		catch (Exception e) {
			testCase = extent.createTest("Test Search Icon Element");
			testCase.log(Status.INFO, "Test Search Icon");
			testCase.log(Status.FAIL, "Wrong");

		}

	}

// Excel Method

	public static void ExcelMethod() throws IOException, InterruptedException {
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Manage_Tests");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
					"Manage_Tests", "MTC-MT-410");

			XSSFRow row = sheet.getRow(firstrow);

			String SearchData = (String) row.getCell(2).getStringCellValue();

			ManageTestsPage.TestTextBox.sendKeys(SearchData);
		} catch (Exception e) {
			testCase = extent.createTest("Excel Not Working");
			testCase.log(Status.INFO, "Excel Not Working");
			testCase.log(Status.FAIL, "Wrong");

		}
	}

	// Check Manage Test Next Arrow Button Properties
	public static void ResetAllButtonProperties() {
		ManageTestsPage Managepg = new ManageTestsPage();
		PageFactory.initElements(driver, Managepg);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-410-02", ManageTestsPage.ResetAllButton, "Manage Test Reset All Button Properties");
	}
}
