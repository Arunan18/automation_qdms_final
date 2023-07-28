
//***********************************************************************************
//* Description
//*------------
//TC-TCN-0111-ReviewTestParameterDeleteFunction_BeforeDepend
//TC-TCN-0113-Review Test Parameter delete ok button function under Test Configure
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 3/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0111    3/05/2023  Niluxy       Orginal Version
//*TC-TCN-0113
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
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTestParameterDeleteFunction_BeforeDepend extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage managepage = new ManageTestsPage();

	static String tobedelete = null;
	static String message = null;

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		
		extent.createTest("TC-TCN-0111-ReviewTestParameterDeleteFunction_BeforeDepend");
	
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

		Actions actions = new Actions(driver);
		// PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN 
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		// SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED 
		extent.createTest("STEP_04-- EDIT CONFIGURE  DESCRIPTION PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0111-01", 1);

		// CLICK TEST CONFIGURE LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 200, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 200,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

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
				"Test_Configure", "TC-TCN-0111");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0111");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobedelete = (String) row.getCell(2).getStringCellValue();
			System.out.println("tobedelete" + tobedelete);
			message = (String) row.getCell(3).getStringCellValue();

		}

		// FIND THE DELETE ELEMENT FROM THE EXCEL
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
		extent.createTest("TC-TCN-0113-Review Test Parameter delete ok button function under Test Configure");
		// CLICK OK BUTTON IN DELETE
		Thread.sleep(3000);
		okbutton();
		
		/* DATA DELETED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 9: CHECK DATA IS DELETED", TestConfigPage.successMsg, message);
		
		// LOGOUT TO THE SYSTEM
		Thread.sleep(1000);
		Logout.LogoutFunction();

	}

//METHOD FOR OK BUTTON FUNCTION//
	public static void okbutton() throws InterruptedException {

		testCase = extent.createTest("STEP_08:DELETE OK BUTTON");

		Thread.sleep(3000);
		if (TestConfigPage.Reviewtestdeleteok.isDisplayed()) {

			testCase = extent.createTest(" DELETE OK BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.Reviewtestdeleteok.isEnabled()) {
				testCase = extent.createTest("DELETE OK BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					boolean addmodelwindow = true;				
					TestConfigPage.Reviewtestdeleteok.click();
				if (!driver.findElement(By.xpath("//div[@class='ant-popover-message-title']")).isDisplayed()) {
					addmodelwindow = false;
			}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("DELETE OK BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("DELETE MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("DELETE MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("DELETE OK BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("DEELTE OK DBUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("DEELTE OK BUTTON  VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}