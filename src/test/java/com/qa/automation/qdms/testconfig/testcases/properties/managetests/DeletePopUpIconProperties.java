
//***********************************************************************************
//* Description
//*------------
//* Manage Test Configuration Tab - Delete PopUp "?" Icon Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-MT-403          22/06/2023   Sasi     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class DeletePopUpIconProperties extends DriverIntialization {
	static ManageTestsPage Managepg = new ManageTestsPage();
	static String code = null;

	@Test
	public static void Popupicon() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Managepg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);

		// Check Relevant Test Question ? icon Properties
		DeleteQuentionIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Delete Icon
	public static void DeleteQuentionIcon() throws IOException, InterruptedException {

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-403");

		XSSFRow row = sheet.getRow(firstrow);
		code = (String) row.getCell(2).getStringCellValue();

		// Search Specific Delete Icon
		Searching.searchvalue(code, 1);

		try {
			// Locate the Relevant Icon
			WebElement ManageTestDeleteIcon = driver.findElement(By.xpath("//td[1][contains(text(),'" + code
					+ "')]/following-sibling::td[16]//span[contains(@class,'anticon-delete')]"));

			// Click on Relevant Icon
			ManageTestDeleteIcon.click();

			testCase = extent.createTest("Delete ?  Icon Click");
			testCase.log(Status.INFO, "Clicked on the element 'Relevant Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			QuestionIconProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Delete ? Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Delete ?  Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Delete ?  Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Delete ?  Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Delete ?  Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Delete ?  Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void QuestionIconProperties() {
		ManageTestsPage Managepg = new ManageTestsPage();
		PageFactory.initElements(driver, Managepg);

		// Check Relevant Test ? icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-403-02",
				ManageTestsPage.deleteQuestionIconMT, "Manage Test Delete Icon Properties");
	}
}
