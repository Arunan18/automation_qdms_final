/***********************************************************************************
//* Description
//*------------
//* Manage Tests Configure - Group Tests - ResetAll Button Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 12/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-118         12/07/2023   K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupTestsResetAllButtonProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void groupTestsResetAll() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		groupTestsResetAllProperties();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOU
		Logout.LogoutFunction();
	}

	public static void groupTestsResetAllProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-118");

		XSSFRow row = sheet.getRow(firstrow);
		code = (String) row.getCell(2).getStringCellValue();

		try {

			GroupTestsPage.groupNameSearchIcon.click();
			testCase = extent.createTest("GroupTests Table Group Name Search Icon Found and Click");
			testCase.log(Status.INFO, "Click the GroupTests Table Group Name Search Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");
			try {
				Thread.sleep(2000);
				GroupTestsPage.groupNameTextBoxx.sendKeys(code);
				testCase = extent.createTest("GroupName TextBox is Found");
				testCase.log(Status.INFO, "GroupName TextBox is Found");
				testCase.log(Status.PASS, "TEST PASS ☑");

				//Calling the method
				ResetAllButtonProps();

			} catch (Exception e) {

				testCase = extent.createTest("GroupName TextBox is Not Found");
				testCase.log(Status.INFO, "Unable to Locate the element GroupName TextBox");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (NoSuchElementException e) {

			testCase = extent.createTest("GroupTests Table Group Name Search Icon is Not Found");
			testCase.log(Status.INFO, "Unable to Locate the element GroupTests Table Group Name Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {

			testCase = extent.createTest("GroupTests Table Group Name Search Icon is Not Click");
			testCase.log(Status.INFO, "Unable to Locate the element GroupTests Table Group Name Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {

			testCase = extent.createTest("GroupTests Table Group Name Search Icon is Not Found & Click");
			testCase.log(Status.INFO, "Unable to Locate the element GroupTests Table Group Name Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
	public static void ResetAllButtonProps() {
		PageFactory.initElements(driver, GroupTestpg);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-118-02", GroupTestsPage.groupNameResetAllBtn, "Reset All Button Properties");
	}
}




