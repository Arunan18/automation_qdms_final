/***********************************************************************************
//* Description
//*------------
//* Manage Test "Tests" - Pop up Screen Action Heading Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 04/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-055         05/07/2023   K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestsPopupScreenActionHeadingProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void testsPopupActionHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		actionheadingProperties();

		//REFRESH
		driver.navigate().refresh();
		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void actionheadingProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-055");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(2).getStringCellValue();

		// Search Specific Tests Column Icon
		Searching.searchvalue(code, 1);

		try {
			// Locate the Tests Column Icon
			WebElement TestColumnIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[5]//span[@class='anticon anticon-funnel-plot']"));

			TestColumnIcon.click();

			testCase = extent.createTest("Checking Tests Column Icon");
			testCase.log(Status.INFO, "Tests Column Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			//Calling the method
			testPopupActionHeadingPropertiess();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Tests Column Icon");
			testCase.log(Status.INFO, "Unable to Locate Tests Column Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Tests Column Icon");
			testCase.log(Status.INFO, "Tests Column Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Tests Column Icon");
			testCase.log(Status.INFO, "Tests Column Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void testPopupActionHeadingPropertiess() {
		PageFactory.initElements(driver, GroupTestpg);

		//Check Tests Column Pop up Screen Action Heading UI Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-055-02", GroupTestsPage.testcolumnpopupactionheading, "Tests Column Popup Screen Action Heading UI Properties");
	}
}

