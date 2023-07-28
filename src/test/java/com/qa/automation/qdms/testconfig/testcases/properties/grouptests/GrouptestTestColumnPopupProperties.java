/***********************************************************************************
//* Description
//*------------
//* Manage Test "Tests" - Pop up Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 04/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-053         05/07/2023   K.Saranga     Original Version
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

public class GrouptestTestColumnPopupProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void testTablePopup() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		testTablePopupProperties();

		//REFRESH
		driver.navigate().refresh();

		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void testTablePopupProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-053");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(2).getStringCellValue();

		// Search Specific Tests Column Icon
		Searching.searchvalue(code, 1);

		try {
			// Locate the Tests Column Icon
			WebElement TestsColumnIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[5]//span[@class='anticon anticon-funnel-plot']"));

			TestsColumnIcon.click();

			testCase = extent.createTest("Checking Tests Column Icon");
			testCase.log(Status.INFO, "Tests Column Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			//Calling the method
			testTablePopupPropertiess();
		} 

		catch (NoSuchElementException e) {
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
	public static void testTablePopupPropertiess() {
		PageFactory.initElements(driver, GroupTestpg);

		//Check Tests Column Pop up Properties
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-053-02", GroupTestsPage.testcolumnpopup, "Tests Column Popup UI Properties");
	}
}










