/***********************************************************************************
//* Description
//*------------
//* Manage Test "Action" Column Delete Icon Pop up Screen Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 05/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-109          05/07/2023   K.Saranga     Original Version
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

public class ActionColumnDeleteIconPopupProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void actionDeleteIconPopup() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		deleteIconPopupProperties();

		//REFRESH
		driver.navigate().refresh();
		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void deleteIconPopupProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-109");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(2).getStringCellValue();

		// Search Specific Delete Icon
		Searching.searchvalue(code, 1);

		try {
			// Locate the Action Column Delete Icon
			WebElement ActionColumnDeleteIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[6]//span[@class='anticon anticon-delete']"));
			ActionColumnDeleteIcon.click();

			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			//Calling the method
			actionColumnDeleteIconPopup();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Unable to Locate Action Column Delete Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void actionColumnDeleteIconPopup() {
		PageFactory.initElements(driver, GroupTestpg);

		//Check Action Column Pop up Screen Properties
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-109-02", GroupTestsPage.actioncolumnpopup, "Action Column Popup Screen Properties");
	}
}






