/***********************************************************************************
//* Description
//*------------
//* Groups Tests - "Tests" Column Icon Pop up Screen- Delete Icon Pop up - Cancel Button Functionality
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 10/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-061         10/07/2023   K.Saranga     Original Version
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
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestsPopupScreenDeleteIconPopupCancelBtnFunctionality extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	static String codetype = null;
	@Test
	public static void deleteIconPopupCancelBtn() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		deleteIconPopupCancelBtnFunctionality();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void deleteIconPopupCancelBtnFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-061");

		XSSFRow row = sheet.getRow(firstrow);
		code = (String) row.getCell(2).getStringCellValue();
		codetype = (String) row.getCell(3).getStringCellValue();

		try {
			WebElement TestsColumnIcon  = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[5]//span[@class='anticon anticon-funnel-plot']"));

			TestsColumnIcon.click();

			testCase = extent.createTest("Checking Tests Column Icon Click");
			testCase.log(Status.INFO, "Tests Column Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			try {

				WebElement ActionColumnDeleteIcon  = driver.findElement(By.xpath("//td[text()='"+codetype+"']//following-sibling::td[1]//span[@class='anticon anticon-delete']"));

				ActionColumnDeleteIcon.click();

				testCase = extent.createTest("Checking Action Column Delete Icon Click");
				testCase.log(Status.INFO, "Action Column Delete Icon is Clicked ");
				testCase.log(Status.PASS, "TEST PASS");

				deletePopupCancelBtnFunctionality();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Tests Column Icon Click");
				testCase.log(Status.INFO, "Unable to Locate Tests Column Icon");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking Tests Column Icon Click");
				testCase.log(Status.INFO, "Tests Column Icon is not Clicked");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (Exception e) {
				testCase = extent.createTest("Checking Tests Column Icon Click");
				testCase.log(Status.INFO, "Tests Column Icon Click is not Occured");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon Click");
			testCase.log(Status.INFO, "Unable to Locate Action Column Delete Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon Click");
			testCase.log(Status.INFO, "Action Column Delete Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Action Column Delete Icon Click");
			testCase.log(Status.INFO, "Action Column Delete Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void deletePopupCancelBtnFunctionality() {	
		PageFactory.initElements(driver, GroupTestpg);

		//"Tests" Column Icon Pop up Screen- Delete Icon Pop up - Cancel Button Functionality
		functionality.ButtonAndIconunctionalityMtd("'Cancel' Button Functionality", GroupTestsPage.actionColumnDeleteIconPopupCancelBtn, "Button");	        
	}
}





