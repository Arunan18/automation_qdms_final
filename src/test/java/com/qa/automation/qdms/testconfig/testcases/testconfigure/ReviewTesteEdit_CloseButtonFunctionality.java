
//***********************************************************************************
//* Description
//*------------
//* ReviewTestParameterClose-EditFunction_BeforeDepend
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 8/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0125            8/05/2023     Niluxy       Original Version
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
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTesteEdit_CloseButtonFunctionality extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupKey = new AddGroupKey();
	static ReviewTestParameterCancelEditFunction relevent = new ReviewTestParameterCancelEditFunction();

	static String parameter = null;
	static String type = null;
	static String unit = null;
	static String abriviation = null;
	static String inputmethods = null;
	static boolean releventValue = false;
	static String decimaltype = null;
	static String tobeedit = "";
	static String expectedmessage = "";

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, relevent);
		PageFactory.initElements(driver, groupKey);
		extent.createTest("TC-TCN-0125:ReviewTestParameterClose-EditFunction_BeforeDepend");
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
		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  DESCRIPTION PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0125-01", 9);

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
				"Test_Configure", "TC-TCN-0125");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0125");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeedit = (String) row.getCell(1).getStringCellValue();
			parameter = (String) row.getCell(2).getStringCellValue();
			type = (String) row.getCell(3).getStringCellValue();
			unit = (String) row.getCell(4).getStringCellValue();
			abriviation = (String) row.getCell(5).getStringCellValue();
			inputmethods = (String) row.getCell(6).getStringCellValue();
			decimaltype = (String) row.getCell(7).getStringCellValue();
			releventValue = (Boolean) row.getCell(8).getBooleanCellValue();

		}
//FIND THE EDIT ICON ELEMENT FROM THE EXCEL
		Thread.sleep(3000);

		try {
			WebElement delete = driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
					+ "']//following-sibling::td[10]//span[@class='anticon anticon-edit']"));
			if (delete.isDisplayed()) {
				testCase = extent.createTest("STEP 7:EDIT ICON DISPLY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
						+ "']//following-sibling::td[10]//span[@class='anticon anticon-edit']")).isEnabled()) {
					testCase = extent.createTest("STEP 7:EDIT ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
								+ "']//following-sibling::td[10]//span[@class='anticon anticon-edit']")).click();

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

		/* EDIT PARAMETER FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		SampleCommonMethods.fieldmethoddropdown("STEP_8-- PARAMETER  FIELD PROPERTYS",
				TestConfigPage.parametertextboxreviewtest, "01-- PARAMETER FIELD DISPLAYED",
				"02-- PARAMETER  FIELD ENABLED", "//span[normalize-space()='" + parameter + "']",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethoddropdown("STEP_9--  TYPE FIELD PROPERTYS", TestConfigPage.typetextboxreviewtest,
				"01--  TYPE FIELD DISPLAYED", "02--  TYPE FIELD ENABLED", "//div[contains(@title,'" + type + "')]",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR UNIT TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		SampleCommonMethods.fieldmethoddropdown("STEP_10-- UNIT FIELD PROPERTYS", TestConfigPage.unittextboxreviewtest,
				"01-- UNIT FIELD DISPLAYED", "02-- UNIT FIELD ENABLED", "//div[contains(text(),'" + unit + "')]",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR ABBRIVIATION FIELD DISPLAYED & ENABLED & SELECTED */

		TestConfigPage.abbriviationtextboxreviewtest.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP_11-- ABBRIVIATION FIELD PROPERTYS",
				TestConfigPage.abbriviationtextboxreviewtest, "01-- ABBRIVIATION FIELD FIELD DISPLAYED",
				"02-- ABBRIVIATION FIELD ENABLED", abriviation);

		/* EDIT INPUT METHODS */
		SampleCommonMethods.fieldmethoddropdown("STEP_12-- INPUT METHODS FIELD PROPERTYS",
				TestConfigPage.inputmethodtextboxreviewtest, "01-- INPUT METHODS FIELD DISPLAYED",
				"02-- INPUT METHODS FIELD ENABLED", "//span[@title='" + inputmethods + "']",
				"03-- DATA SUCCESSFULLY SELECTED");

		// CLICK RELEVENT CHECKBOX ICON
		ReviewTestParameterCancelEditFunction.releventcheckbox();

		/* EDIT FOR DECIMAL TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		TestConfigPage.decimaaltextboxreviewtest.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		SampleCommonMethods.sendvalue("STEP_13-- DECIMAL TYPE FIELD PROPERTYS",
				TestConfigPage.decimaaltextboxreviewtest, "01-- DECIMAL TYPE FIELD DISPLAYED",
				"02-- DECIMAL TYPE FIELD ENABLED", decimaltype);

		// CLICK CLOSE ICON IN REVIEW TEST
		closebuttonreviewtestinedit();

		/* CHECK FIRST DATA OF THE TABLE */
		Thread.sleep(1000);
		SampleCommonMethods.firstrowdataCancel("STEP 17: EDITED DATA ADDED IN FIRST ROW", TestConfigPage.tablefirstrow,
				parameter);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	/*
	 * __________________________________________________________________________________________________________
	 */
	// METHOD FOR CLOSEBUTTON//
	public static void closebuttonreviewtestinedit() throws InterruptedException {

		Thread.sleep(2000);
		if (TestConfigPage.closebuttonreviewtest.isDisplayed()) {

			testCase = extent.createTest("STEP 14:REVIEWTEST EDITFUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.closebuttonreviewtest.isEnabled()) {
				testCase = extent.createTest("STEP 15:REVIEWTEST EDITFUNCTION- CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					TestConfigPage.closebuttonreviewtest.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 16:REVIEWTEST EDITFUNCTION- CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 17:REVIEWTEST EDITFUNCTION- MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 17:REVIEWTEST EDITFUNCTION- MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 16:REVIEWTEST EDITFUNCTION- CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 15:REVIEWTEST EDITFUNCTION- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 14:REVIEWTEST EDITFUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
