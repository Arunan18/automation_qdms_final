
//***********************************************************************************
//* Description
//*------------
//* AditionalInformation-Edit fucntion and AditionalInformationSaveFuction
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 8/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//TC-TCN-0224           8/05/2023        Niluxy       Original Version
//TC-TCN-0234 
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
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantFieldSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AditionalInformationEditFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();	
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	
	static String tobeeditAd_info = null;
	static String tobeedit = null;
	static String caption = null;
	static String expectedmessage = null;
	static String validationmsg = null;
	static String testcase = null;
	static String length = null;
	static String recordtype = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, managepage);
        PageFactory.initElements(driver, groupkey);
        
		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0224");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0224");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeeditAd_info = (String) row.getCell(2).getStringCellValue();
			tobeedit = (String) row.getCell(3).getStringCellValue();
			caption = (String) row.getCell(4).getStringCellValue();
			length = (String) row.getCell(5).getStringCellValue();
			recordtype = (String) row.getCell(6).getStringCellValue();
			expectedmessage = (String) row.getCell(7).getStringCellValue();

		}

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		// CLICK ON THE TEST CONFIGURATION CARD
		action.clicking(page.testconfigurationcard, 20, "STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG

		action.clicking(page.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		action.clicking(page.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");
		Thread.sleep(2000);
		/* Page Right Scroll Method */
		scroll();

		/* SELECT THE ADDITIONAL INFORMATION DISPLAYED & ENABLED */
		Thread.sleep(3000);
		extent.createTest("STEP_04-- ADITIONAL INFORMATION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 10, managepage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0224-01", 1);

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		action.clicking(page.editiconAditionalinfo, 20, "STEP 5:CHECKING THE EDIT ICON");

		// elementselect();
		dataadd();
		// CLICK ON THE SAVE BUTTON

		action.clicking(page.SavebuttonAditionalinfo, 20, "STEP 6:CHECKING THE SAVE BUTTON ");

		/* DATA ADDED SUCCESS MESSAGE */
		Thread.sleep(2000);
		SampleCommonMethods.dataaddedsuccessmsg("STEP_7-- DATA UPDATED SUCCESSFULLY", TestConfigPage.successMsg,
				expectedmessage);

		// CLICK ON THE CLOSE BUTTON

		action.clicking(page.ClosemodalwindowAditionalinfo, 20, "STEP 8:CHECKING THE CLOSE BUTTON ");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	public static void scroll() {
		driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Additional Information']")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}

	public static void elementselect() throws InterruptedException {

		try {
			Thread.sleep(2000);
			WebElement delete = driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
					+ "']//following-sibling::td[4]//span[@class='anticon anticon-edit']"));
			if (delete.isDisplayed()) {
				System.out.println(delete + "{{{{{{{{{{");
				testCase = extent.createTest("STEP 4:EDIT ICON DISPLY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
						+ "']//following-sibling::td[4]//span[@class='anticon anticon-edit']")).isEnabled()) {
					testCase = extent.createTest("STEP 4:EDIT ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
								+ "']//following-sibling::td[4]//span[@class='anticon anticon-edit']")).click();

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
	}

	public static void dataadd() throws InterruptedException {
		/* EDIT FOR CAPTION FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(1000);
		TestConfigPage.captiontextboxAditionalinfo.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP 5: CAPTION FIELD PROPERTYS", TestConfigPage.captiontextboxAditionalinfo,
				"01-- CAPTION FIELD FIELD DISPLAYED", "02-- CAPTION FIELD ENABLED", caption);

		/* EDIT FOR MAXLENGTH FIELD DISPLAYED & ENABLED & SELECTED */

		TestConfigPage.maxlengthtextboxAditionalinfo.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP 5 : MAXLENGTH FIELD PROPERTYS",
				TestConfigPage.maxlengthtextboxAditionalinfo, "01--  MAXLENGTH FIELD FIELD DISPLAYED",
				"02-- MAXLENGTH FIELD ENABLED", length);

		/* EDIT FOR TYPE FIELD DISPLAYED & ENABLED & SELECTED */

		SampleCommonMethods.fieldmethoddropdown("STEP 6 :  TYPE FIELD PROPERTYS",
				TestConfigPage.typetextboxAditionalinfo, "01-- TYPE FIELD DISPLAYED", "02-- TYPE FIELD ENABLED",
				"//div[@title='"+recordtype+"']", "03-- DATA SUCCESSFULLY SELECTED");

		// CLICK ON THE CHECKBOXSTATUS
		action.clicking(page.checkboxactiveAditionalinfo, 20, "STEP 11:CHECKING THE CHECKBOXACTIVESTATUS");

	}

}
