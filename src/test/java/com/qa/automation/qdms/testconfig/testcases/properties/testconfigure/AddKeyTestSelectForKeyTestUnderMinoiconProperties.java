//***************************************************************************************
//* Description
//*------------
//*Test Configure - Configure Test Table-  Top Bar "Add Key Test" - Select For Key Test Under- "-" icon  Properties
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
//* TC-TCN-0719        14/07/2023    THAKSHILA    Modified Version                   
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
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AddKeyTestSelectForKeyTestUnderMinoiconProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();
	static String test1 =null;

	@Test
	public static void addKeyTestProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0719");

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
		"Test_Configure", "TC-TCN-0719");
		          
		XSSFRow row = sheet.getRow(firstrow);
		 test1 = data.formatCellValue(row.getCell(3));

		PageFactory.initElements(driver, testconfigpg);

		try {

			TestConfigPage.selectForKeyTestPlusIconOne.click();

			// Get Properties
			addkeySubCategoryIconProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the Plus Icon");
			testCase.log(Status.INFO, "Unable to Locate the Plus Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Plus Icon");
			testCase.log(Status.INFO, "Unable to Click on Plus Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check Plus Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// ADD KEY TEST SUB CATEGORY ICON PROPERTIES
	public static void addkeySubCategoryIconProperties() {

		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0719-02",
				driver.findElement(By.xpath("//td[text()='"+test1+"']/../td[1]/label")),
				"Test Configure - Configure Test Table-  Top Bar Add Key Test - Select For Key Test Under- + icon  Properties");

	}

}
