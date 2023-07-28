/***********************************************************************************
//* Description
//*------------
//* Test - Config Group Test - "Configured Groups Table" No Data Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-133          17/07/2023   K.Saranga     Original Version
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
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;

public class ConfiguredGroupTableNoDataProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void configuredGroupTableNoData() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		//login the system
		LoginTest.Login();

		//click the main TestConfiguration
		TestConfigNavigation.TestConfigurationCard();

		//Calling the method
		configuredGroupTable();

		//REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void configuredGroupTable() throws IOException {

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-133");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(2).getStringCellValue();

		try {		
			GroupTestsPage.ConfigGroupTestBtn.click();

		} catch (NoSuchElementException e) {

			testCase = extent.createTest("Config Group Test Button is Not Found");
			testCase.log(Status.INFO, "Unable to Locate the element Config Group Test Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {

			testCase = extent.createTest("Config Group Test Button is Not Click");
			testCase.log(Status.INFO, "Unable to Locate the element Config Group Test Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {

			testCase = extent.createTest("Config Group Test Button is Not Found & Click");
			testCase.log(Status.INFO, "Unable to Locate the element Config Group Test Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		ActionCommonMethod.dropdDown(GroupTestsPage.MaterialMainCategorytextbox, code);

		//Calling the method
		configuredGroupTableProperties();
	}

	public static void configuredGroupTableProperties() {

		try {		

			GroupTestsPage.reporttypecheckbox.click();

			//Calling the method
			configuredGroupTableNoDataProperties();

		} catch (NoSuchElementException e) {

			testCase = extent.createTest("Report type check box is Not Found");
			testCase.log(Status.INFO, "Unable to Locate the element Report type check box");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {

			testCase = extent.createTest("Report type check box is Not Click");
			testCase.log(Status.INFO, "Unable to Locate the element Report type check box");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {

			testCase = extent.createTest("Report type check box is Not Found & Click");
			testCase.log(Status.INFO, "Unable to Locate the element Report type check box");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}
	public static void configuredGroupTableNoDataProperties() {	
		PageFactory.initElements(driver, GroupTestpg);

		//Check GroupTests Pagination Drop down Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-133-02", GroupTestsPage.ConfiguredGroupTableNoData, "Configured Group Table No Data Properties");
	}
}









