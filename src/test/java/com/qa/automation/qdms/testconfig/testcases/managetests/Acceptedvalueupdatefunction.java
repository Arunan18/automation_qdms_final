//***********************************************************************************
//* Description
//*------------
//*  Accepted value update function
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     :18/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-069			 18/05/2023    MATHUSAN     Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class Acceptedvalueupdatefunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	static TestConfigNavigation TCN = new TestConfigNavigation();
	 static AddGroupKey AGK =new AddGroupKey();
	@Test

	public static void AcceptedvalueupdateFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ACM);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// Click the Manage Configure Scorall Page
		managetestconfigurationscorallpage();

		// Click the Select Accepted Value
		selectacceptedcondtion();

		// Click Edit Accepted Value
		EditAcceptedValue();

		// Click Refresh Button
		driver.navigate().refresh();

		// Click Logout Button
		Logout.LogoutFunction();
	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() {
		PageFactory.initElements(driver, TCN);
		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//div[@class='ant-table-body']", "//thead//th[9]");
	}

	// Click the Select Accepted Value
	public static void selectacceptedcondtion() throws InterruptedException {

		PageFactory.initElements(driver, AGK);

		// SELECT THE ACCEPTED VALUE TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED VALUE BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-069-01", 1);

	}

	static String Selectparameter1 = null;
	static String Selectparameter2 = null;
	static String Selectparameter3 = null;
	static String value = null;
	static String value1 = null;
	static String SearchData2 = null;
	static boolean updatebutton = false;
	static String value2 = null;

	public static void EditAcceptedValue() throws IOException, InterruptedException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-069";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		testCase = extent.createTest("Step-06--ACCPTED VALUE VALIDATION");
		for (int i = firstRow; i <= lastRow; i++) {
			DataFormatter gh = new DataFormatter();
			XSSFRow row = sheet.getRow(i);

			Selectparameter1 = (String) row.getCell(2).getStringCellValue();
			SearchData2 = (String) row.getCell(3).getStringCellValue();
			Selectparameter2 = (String) row.getCell(4).getStringCellValue();
			Selectparameter3 = (String) row.getCell(5).getStringCellValue();

			XSSFCell cell6 = row.getCell(6);
			value = gh.formatCellValue(cell6);

			XSSFCell cell7 = row.getCell(7);
			value1 = gh.formatCellValue(cell7);

			XSSFCell cell8 = row.getCell(8);
			value2 = gh.formatCellValue(cell8);

			/* SELECT THE EDIT ACCEPTED VALUE DROP DOWN 1 FOR PARAMETER TYPE FEILD */
			Thread.sleep(1500);

			try {
				ManageTestsPage.editAcceptedvalueparameterdropdown.click();
				driver.findElement(By.xpath("//div[text()='" + Selectparameter1 + "']/..")).click();
				testCase = extent.createTest("ACCEPTED VALUE PARAMETER DROPDOWN 1 CLICK");
				testCase.log(Status.PASS, "TEST PASS");

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE PARAMETER DROPDOWN 1 NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE PARAMETER DROPDOWN 1 NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// Select the Test Radio Button

			try {
				Boolean isVisible1 = ManageTestsPage.acceptedvaluetestradiobuttonspan.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.acceptedvaluetestradiobuttonspan.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.acceptedvaluetestradiobuttoninput.click();
						testCase = extent.createTest("ACCEPTED VALUE TEST RADIO BUTTON CLICK");
						testCase.log(Status.PASS, "TEST PASS");

					}
				}
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST RADIO BUTTON NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST RADIO BUTTON NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// Click the Save Button

			try {
				Boolean isVisible2 = ManageTestsPage.acceptedvaluesavebutton.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible2, "definition");
				if (isVisible2 == true) {

					Boolean isEnabled2 = ManageTestsPage.acceptedvaluesavebutton.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled2, "definition");

					if (isEnabled2 == true) {

						ManageTestsPage.acceptedvaluesavebutton.click();
						testCase = extent.createTest("ACCEPTED VALUE TEST SAVE BUTTON CLICK");
						testCase.log(Status.PASS, "TEST PASS");
					}
				}
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST SAVE BUTTON NOT  CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST SAVE BUTTON NOT  CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// Click the Accepted value Edit Button
			Thread.sleep(1000);

			try {
				Boolean isVisible3 = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']//td[text() ='"
						+ SearchData2 + "']/following-sibling::td[4]/span/a[1]")).isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible3, "definition");
				if (isVisible3 == true) {

					Boolean isEnabled3 = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']//td[text() ='"
							+ SearchData2 + "']/following-sibling::td[4]/span/a[1]")).isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled3, "definition");

					if (isEnabled3 == true) {

						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']//td[text() ='" + SearchData2
								+ "']/following-sibling::td[4]/span/a[1]")).click();
						testCase = extent.createTest("ACCEPTED VALUE TEST EDIT BUTTON CLICK");
						testCase.log(Status.PASS, "TEST PASS");

					}

				}
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST EDIT BUTTON NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST EDIT BUTTON NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");

			}

			/* SELECT THE EDIT ACCEPTED VALUE DROP DOWN 2 FOR PARAMETER TYPE FEILD */
			Thread.sleep(5000);

			try {
				ManageTestsPage.editAcceptedvalueparameterdropdown2.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='" + Selectparameter2 + "'])[2]")).click();
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 2 CLICK");
				testCase.log(Status.PASS, "TEST PASS");

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 2 CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 2 CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			/* SELECT THE EDIT ACCEPTED VALUE DROP DOWN 3 FOR PARAMETER TYPE FEILD */
			Thread.sleep(1000);
			try {
				ManageTestsPage.editacceptedvaluedropdown3.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[text()='" + Selectparameter3 + "']")).click();
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 3 CLICK");
				testCase.log(Status.PASS, "TEST PASS");

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 3 NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("ACCEPTED VALUE TEST DROPDOWN 2 NOT CLICK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE

			try {
				Boolean isVisible5 = ManageTestsPage.textboxeditacceptevalue.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible5, "definition");
				if (isVisible5 == true) {

					Boolean isEnabled5 = ManageTestsPage.textboxeditacceptevalue.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled5, "definition");

					if (isEnabled5 == true) {

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue.click();

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue.clear();

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue.sendKeys(value);
						testCase = extent.createTest("SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE");
						testCase.log(Status.PASS, "TEST PASS");
					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE1

			try {
				Boolean isVisible6 = ManageTestsPage.textboxeditacceptevalue1.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible6, "definition");
				if (isVisible6 == true) {

					Boolean isEnabled6 = ManageTestsPage.textboxeditacceptevalue1.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled6, "definition");

					if (isEnabled6 == true) {

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue1.click();

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue1.clear();

						Thread.sleep(1000);
						ManageTestsPage.textboxeditacceptevalue1.sendKeys(value1);
						
						testCase = extent.createTest("SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE1");
						testCase.log(Status.PASS, "TEST PASS");

					}
				} 
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE1");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT SEND THE DATA FOR TEXTBOX EDIT ACCEPTED VALUE1");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
				
					
			//CLICK THE RELEVENT BOX
			
			Thread.sleep(3000);

					if (value2.equals("true")) {
						boolean relevent=true;
						try {
							relevent = ManageTestsPage.editacceptreleventbox.isSelected();
							
						} catch (NoSuchElementException E) {
							testCase = extent.createTest("EDIT ACCEPTED RELEVENT BOX SELECTED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					
						if (relevent == false) {
							
							try {
								ManageTestsPage.editacceptreleventbox.click();
							} catch (ElementClickInterceptedException E) {
								testCase = extent.createTest("EDIT ACCEPTED RELEVENT BOX CLICK");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("Edit Relevent Accepted Box Not Click");
							testCase.log(Status.FAIL, "Test FAIL");

						}

					}
				
			
				
			
			
			
			// CLICK THE UPDATE BUTTON//

				try {
					Boolean isVisible7 = ManageTestsPage.editacceptedvalueupdatebutton.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible7, "definition");
					if (isVisible7 == true) {

						Boolean isEnabled7 = ManageTestsPage.editacceptedvalueupdatebutton.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled7, "definition");

						if (isEnabled7 == true) {

							ManageTestsPage.editacceptedvalueupdatebutton.click();
							updatebutton = true;
							testCase = extent.createTest("CLICK THE UPDATE BUTTON");
							testCase.log(Status.PASS, "TEST PASS");
						}

					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK THE UPDATE BUTTON");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK THE UPDATE BUTTON");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				
				
				if (updatebutton = true) {
				
					try {
						ManageTestsPage.acceptedvalueupdatebuttonmessage.isDisplayed();

						testCase = extent.createTest("ACCEPTED VALUE UPDATE BUTTON MESSAGE");
						testCase.log(Status.PASS, "TEST PASS");
						
						testCase = extent.createTest("ACCEPTED VALUE UPDATE SUCCESSFULLY");
						testCase.log(Status.PASS, "TEST PASS");
						
					} catch (NoSuchElementException E) {
						testCase = extent.createTest("ACCEPTED VALUE UPDATE BUTTON MESSAGE");
						testCase.log(Status.FAIL, "TEST FAIL");
						
					
					}
				} else {
					testCase = extent.createTest("ACCEPTED VALUE UPDATE NOT SUCCESSFULLY");
					testCase.log(Status.FAIL, "Test FAIL");

				}

			}

		}
	}

