
//***********************************************************************************
//* Description
//*------------
//* ReviewTestParameterDeleteCancelButtonFunction
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 12/05/2023
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0114             12/05/2023   Niluxy       Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTestParameterDeleteCancelButtonFunction extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	static String tobedelete = null;
	static String message = null;

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, groupkey);
		extent.createTest("TC-TCN-0114:ReviewTestParameterDeleteCancelButtonFunction");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK TEST CONFIGURATION
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST CONFIG");
		Thread.sleep(2000);

		// CLICK MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 2000, "STEP 3:CHECKING THE MANAGE TEST CONFIG MODULE ");

		// PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		// SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED
		extent.createTest("STEP_04-- EDIT CONFIGURE  DESCRIPTION PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0114-01", 2);
	
		// CLICK TEST CONFIGURE LEFT BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 200, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 200,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0114");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0114");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobedelete = (String) row.getCell(1).getStringCellValue();
			System.out.println("tobedelete" + tobedelete);

		}

		// FIND THE DELETE ELEMENT FROM THE EXCEL
		Thread.sleep(3000);

		try {
			WebElement delete = driver.findElement(By.xpath("//td[text()='" + tobedelete + "  "
					+ "']//following-sibling::td[10]//span[@class='anticon anticon-delete']"));
			if (delete.isDisplayed()) {

				testCase = extent.createTest("STEP 7:DELETE ICON DISPLY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (delete.isEnabled()) {
					testCase = extent.createTest("STEP 7:DELETE ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						delete.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("ELEMENT IS NOT ENABLE");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("ELEMENT IS NOT DISPLY");
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		// DELETE CANCEL BUTTON;
		Thread.sleep(3000);
		Cancelbuttonreviewtestincancel();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

//METHOD CANCELBUTTON FUNCTION
	public static void Cancelbuttonreviewtestincancel() throws InterruptedException {

		Thread.sleep(3000);
		if (TestConfigPage.cancelbuttonreviewtest.isDisplayed()) {

			testCase = extent.createTest("STEP 14:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.cancelbuttonreviewtest.isEnabled()) {
				testCase = extent.createTest("STEP 15:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div[3]/div/div/div")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					TestConfigPage.cancelbuttonreviewtest.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("/html/body/div[3]/div/div/div")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 16:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 17:REVIEWTEST DELETEFUNCTION- MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 17:REVIEWTEST DELETEFUNCTION- MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 16:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 15:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 14:REVIEWTEST DELETEFUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
