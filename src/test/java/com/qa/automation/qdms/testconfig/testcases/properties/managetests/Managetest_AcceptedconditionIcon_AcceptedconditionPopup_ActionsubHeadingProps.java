//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition -Add Condition- "Action" UI Sub Heading  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 05/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-331          05/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIcon_AcceptedconditionPopup_ActionsubHeadingProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	static String testname = null;
	static String testtype = null;

	@Test
	public static void actionsubHeading() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 11);

		// Check Accepted Condition Popup Action Heading UI Properties
		actionsubHeadingExcel();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void actionsubHeadingExcel() throws IOException {

		// EXCEL METHOD
		DataFormatter data = new DataFormatter();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-331");

		XSSFRow row = sheet.getRow(firstrow);
		testname = data.formatCellValue(row.getCell(2));
		testtype = data.formatCellValue(row.getCell(3));

		// Find the Visibility of Accepted Condition Icon
		try {

			WebElement acceptedcondition = driver.findElement(By.xpath("//td[text()='" + testname
					+ "']//following-sibling::td[text()='" + testtype + "']//following-sibling::td[6]//span//span[1]"));

			acceptedcondition.click();

			testCase = extent.createTest("Checking The Accepted Condition Icon Click");
			testCase.log(Status.INFO, "Accepted Condition Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			actionsubHeadingProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Accepted Condition Icon Click");
			testCase.log(Status.INFO, "Unable to Locate Accepted Condition Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Accepted Condition Icon Click");
			testCase.log(Status.INFO, "Accepted Condition Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Accepted Condition Icon Click");
			testCase.log(Status.INFO, "Accepted Condition Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void actionsubHeadingProperties() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-331-02", ManageTestsPage.actionheading,
				"Manage Test - Accepted Condition Popup Screen Action Heading Properties");

	}

}
