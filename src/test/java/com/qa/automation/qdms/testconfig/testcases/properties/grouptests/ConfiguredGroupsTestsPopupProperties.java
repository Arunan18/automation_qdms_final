/***********************************************************************************
//* Description
//*------------
//* Config Group Tests- Configured Group Table- Tests Column Icon - Pop up Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 10/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-092        10/07/2023       K.Saranga     Original Version
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
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfiguredGroupsTestsPopupProperties  extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	static String codetype = null;
	@Test
	public static void testsPopupProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		testsPopupPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void testsPopupPropertiess() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-092");

		XSSFRow row = sheet.getRow(firstrow);
		code = (String) row.getCell(2).getStringCellValue();
		codetype = (String) row.getCell(3).getStringCellValue();

		try {
			// Locate the Edit Icon
			WebElement ActionColumnEditIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[6]//span[@class='anticon anticon-form']"));

			ActionColumnEditIcon.click();

			testCase = extent.createTest("Checking Action Column Edit Icon");
			testCase.log(Status.INFO, "Action Column Edit Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			try {

				WebElement ConfiguredGroupTableTestsColumnIcon  = driver.findElement(By.xpath("//td[text()='"+codetype+"']//following-sibling::td[2]//span[@class='anticon anticon-funnel-plot']"));

				ConfiguredGroupTableTestsColumnIcon.click();

				testCase = extent.createTest("Checking Configured Group Table Tests Column Icon Click");
				testCase.log(Status.INFO, "Configured Group Table Tests Column Icon is Clicked ");
				testCase.log(Status.PASS, "TEST PASS");

				configuredGroupsTestsPopupProperties();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Configured Group Table Tests Column Icon Click");
				testCase.log(Status.INFO, "Unable to Locate Configured Group Table Tests Column Icon");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking Configured Group Table Tests Column Icon Click");
				testCase.log(Status.INFO, "Configured Group Table Tests Column Icon is not Clicked");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (Exception e) {
				testCase = extent.createTest("Checking Configured Group Table Tests Column Icon Click");
				testCase.log(Status.INFO, "Configured Group Table Tests Column Icon Click is not Occured");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Action Column Edit Icon Click");
			testCase.log(Status.INFO, "Unable to Locate Action Column Edit Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Action Column Edit Icon Click");
			testCase.log(Status.INFO, "Action Column Edit Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Action Column Edit Icon Click");
			testCase.log(Status.INFO, "Action Column Edit Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void configuredGroupsTestsPopupProperties() {	
		PageFactory.initElements(driver, GroupTestpg);

		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-092-02", GroupTestsPage.testscolumnPopup, "Tests Column Icon Pop up Screen Properties");
	}
}



