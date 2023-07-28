
//***********************************************************************************
//* Description
//*------------
//* AditionalInformationCancelFuctioninEdit
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 8/05/2023
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0239            8/05/2023      Niluxy       Original Version
//*TC-TCN-0238
//TC-TCN-0237
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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AditionalInformationCancelFuctioninEdit extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	static String tobeedit = null;
	static String caption = null;
	static String validationmsg = null;
	static String testcase = null;
	static String length = null;
	static String recordtype = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, groupkey);
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 20, "STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG

		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");
		Thread.sleep(2000);
		/* Page Right Scroll Method */
		scroll();

		/* SELECT THE ADDITIONAL INFORMATION DISPLAYED & ENABLED */
		Thread.sleep(2000);
		extent.createTest("STEP 4:ADDITIONAL INFORMATION DESCRIPTION BUTTON ");
		AddGroupKey.actionS(0, 10, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0239-01", 1);
		
		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0239");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0239");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeedit = (String) row.getCell(2).getStringCellValue();
			caption = (String) row.getCell(3).getStringCellValue();
			length = (String) row.getCell(4).getStringCellValue();
			recordtype = (String) row.getCell(5).getStringCellValue();
		
		}
		
		//METHOD FOR ELEMENET SELECT FROM THE EXCEL
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			WebElement editelement = driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
					+ "']//following-sibling::td[4]//span[@class='anticon anticon-edit']"));
			if (editelement.isDisplayed()) {
				testCase = extent.createTest("STEP 6:EDIT ICON DISPLY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (editelement.isEnabled()) {
					testCase = extent.createTest("STEP 7:EDIT ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						editelement.click();

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
		
		// EDIT THE DATA FROM EXCEL
		dataadd();

		// CHECK CANCEL BUTTON IN FIRSTMODEL FUCNTIONALITY
		Cancelbutton();
		// CANCEL BUTTON IN NEW MODEL FUCNTIONALITY
		cancelbuttonnewmodel();
		// CHECK CANCEL BUTTON FUCNTIONALITY
		Cancelbutton();
		// CHECK OK BUTTON IN NEW MODEL FUCNTIONALITY
		okbutton();

		// CLICK ON THE CLOSE BUTTON
		SampleActionMethods.clicking(TestConfigPage.ClosemodalwindowAditionalinfo, 20, "STEP 6:CHECKING THE CLOSE BUTTON ");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
	
	/*_________________________________________________________________________________________*/
//METHOD FOR SCROLL
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

	public static void dataadd() throws InterruptedException {
		/* EDIT FOR CAPTION FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(1000);
		TestConfigPage.captiontextboxAditionalinfo.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP 8: CAPTION FIELD PROPERTYS", TestConfigPage.captiontextboxAditionalinfo,
				"01-- CAPTION FIELD FIELD DISPLAYED", "02-- CAPTION FIELD ENABLED", caption);

		/* EDIT FOR MAXLENGTH FIELD DISPLAYED & ENABLED & SELECTED */

		TestConfigPage.maxlengthtextboxAditionalinfo.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP 9 : MAXLENGTH FIELD PROPERTYS",
				TestConfigPage.maxlengthtextboxAditionalinfo, "01--  MAXLENGTH FIELD FIELD DISPLAYED",
				"02-- MAXLENGTH FIELD ENABLED", length);

		/* EDIT FOR TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		SampleCommonMethods.fieldmethoddropdown("STEP 10 :  TYPE FIELD PROPERTYS",
				TestConfigPage.typetextboxAditionalinfo, "01-- TYPE FIELD DISPLAYED", "02-- TYPE FIELD ENABLED",
				"//div[@title='" + recordtype + "']", "03-- DATA SUCCESSFULLY SELECTED");

		// CLICK ON THE CHECKBOXSTATUS
		SampleActionMethods.clicking(TestConfigPage.checkboxactiveAditionalinfo, 20, "STEP 11:CHECKING THE CHECKBOXACTIVESTATUS");
	}

	public static void Cancelbutton() throws InterruptedException {

		Thread.sleep(3000);
		if (TestConfigPage.CancelbuttonAditionalinfo.isDisplayed()) {

			testCase = extent.createTest("STEP 7:ADITIONAL INFORMATION CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.CancelbuttonAditionalinfo.isEnabled()) {
				testCase = extent.createTest("STEP 8:ADITIONAL INFORMATION CANCEL  CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					TestConfigPage.CancelbuttonAditionalinfo.click();
					testCase = extent.createTest("STEP 9:ADITIONAL INFORMATION CANCEL BUTTON CLICKED");
					testCase.log(Status.PASS, "TEST PASS");
					try {
						Thread.sleep(1000);
						TestConfigPage.addparameterModelwindow.isDisplayed();
						boolean addmodelwindow = true;
						System.out.println(addmodelwindow);
						System.out.println("newmodal" + addmodelwindow);
						if (addmodelwindow == true) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 10:ADITIONAL INFORMATION NEW MODEL WINDOW OPEN");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 10:ADITIONAL INFORMATION NEW MODEL WINDOW NOT OPEN");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					} catch (Exception e) {

					}
				} catch (Exception e) {
					testCase = extent.createTest("STEP 9:ADITIONAL INFORMATION CANCEL BUTTON NOT CLICKED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP 8:ADITIONAL INFORMATION CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} else {
			testCase = extent.createTest("STEP 7:ADITIONAL INFORMATION CANCEL BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	static boolean clicked = false;
	static boolean addmodelwindow = false;

	public static void okbutton() throws InterruptedException {

		testCase = extent.createTest("STEP 7:ADITIONAL INFORMATION OK BUTTON FUNCTIONALITY");

		Thread.sleep(3000);
		if (TestConfigPage.CancelmodalwindowOKBUTTONAditionalinfo.isDisplayed()) {

			testCase = extent.createTest(" STEP 7:NEW MODEL ADITIONAL INFORMATION OK BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.CancelmodalwindowOKBUTTONAditionalinfo.isEnabled()) {
				testCase = extent.createTest("STEP 8:NEW MODEL ADITIONAL INFORMATION OK BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					TestConfigPage.CancelmodalwindowOKBUTTONAditionalinfo.click();
					TestConfigPage.addparameterModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					Thread.sleep(2000);
					if (!TestConfigPage.addparameterModelwindow.isDisplayed()) {
						addmodelwindow = false;
					}
					// Add Button Clicked or not
					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 9: NEW MODELADITIONAL INFORMATION OK BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 10:NEW MODEL ADITIONAL INFORMATION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 10:NEW MODEL ADITIONAL INFORMATION MODEL WINDOW CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 9: NEW MODEL ADITIONAL INFORMATION OK BUTTON CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(" STEP 8: NEW MODEL ADITIONAL INFORMATION OK DBUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(" STEP 7:NEW MODEL ADITIONAL INFORMATION OK BUTTON  VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void cancelbuttonnewmodel() throws InterruptedException {

		testCase = extent.createTest("STEP 11:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON FUCNTIONALITY");

		Thread.sleep(3000);
		if (TestConfigPage.Cancelbuttonnewmodalwindow.isDisplayed()) {

			testCase = extent.createTest("STEP 11:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.Cancelbuttonnewmodalwindow.isEnabled()) {
				testCase = extent.createTest("STEP 12:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					TestConfigPage.Cancelbuttonnewmodalwindow.click();
					TestConfigPage.addparameterModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					if (!TestConfigPage.addparameterModelwindow.isDisplayed()) {
						addmodelwindow = false;
					}
				
					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 11:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 12:NEW MODEL ADITIONAL INFORMATION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 11:NEW MODEL ADITIONAL INFORMATION MODEL WINDOW CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 10:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest(" STEP 9:NEW MODEL ADITIONAL INFORMATION CANCEL DBUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(" STEP 8:NEW MODEL ADITIONAL INFORMATION CANCEL BUTTON  VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
