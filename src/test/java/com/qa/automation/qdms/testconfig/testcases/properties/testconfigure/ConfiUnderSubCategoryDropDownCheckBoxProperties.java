//***************************************************************************************
//* Description
//*------------
//*Test Configure - Configure Test Table- Top Bar - Add Key Test Tab - Material icon - Under Sub Category Drop Down - "Check Box" Properties
//***************************************************************************************
//*
//* Author           : THAKSHILA
//* Date Written     : 14/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Name        Comments
//* ================       ====         =====        ========
//*  
//*TC-TCN-0723       14/07/2023    THAKSHILA    Modified Version                   
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfiUnderSubCategoryDropDownCheckBoxProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();
	static String test1 = null;
	static String test2 = null;

	@Test
	public static void addKeyTestProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0724");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			AddkeytestUIHeadingProperties.addKeyTest();
		}

		// ADD KEY TEST SUBCATEGORY ICON PROPERTIES
		addkeySubCategoryclickPlusIcon();

		// LOGOUT
		Logout.LogoutFunction();
	}

// ADD KEY TEST SUB CATEGORY ICON PROPERTIES
	public static void addkeySubCategoryclickPlusIcon() throws IOException {
		PageFactory.initElements(driver, testconfigpg);

		// Excel Method
		DataFormatter data = new DataFormatter();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0723");

		XSSFRow row = sheet.getRow(firstrow);
		test1 = data.formatCellValue(row.getCell(3));
		test2 = data.formatCellValue(row.getCell(4));

		PageFactory.initElements(driver, testconfigpg);

		try {

			TestConfigPage.materualRadioButton.click();

			// common method for select an item from a drop down
			ActionCommonMethod.dropdDown(TestConfigPage.selectForKeyDropDown, test1);

			// Get Properties
			addkeySubCategoryCheckBoxProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the Mateial Radio Button");
			testCase.log(Status.INFO, "Unable to Locate the Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Mateial Radio Button");
			testCase.log(Status.INFO, "Unable to Click on Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// ADD KEY TEST SUB CATEGORY ICON PROPERTIES
	public static void addkeySubCategoryCheckBoxProperties() {

		
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0723-02",
				driver.findElement(By.xpath("//th[text()='"+test2+"']/../th/div/label/span")),
				"Test Select Sub Category- After that View Search Material Text Box Properties");

	}

}
