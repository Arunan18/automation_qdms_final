//***********************************************************************************
//* Description
//*------------
//* Add Accepted Criteria Validation Test Wise
//***********************************************************************************
//*
//* Author           : SRIHARAN GOBITHAN
//* Date Written     : 07/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0156		    07/06/2023     Gobithan    Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AddAcceptedCriteriaValidation_testwise extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	static TestConfigNavigation TCN = new TestConfigNavigation();

	@Test
	public static void TestEquationDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);
		PageFactory.initElements(driver, ACM);
		PageFactory.initElements(driver, TCN);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// PAGE SCROLL UNTIL ACCEPTED VALUE COLUMN
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "//th[normalize-space()='Accepted Value']");

		// SELECT THE ACCEPTED VALUE BUTTON DISPLAYED & ENABLED
		AddAcceptedvalue();

		// CHECK EMPTY VALIDATION
		Thread.sleep(1000);
		extent.createTest("STEP_05--ACCEPTED VALUE VALIDATION");
		validationempty();

		// ALREADY EXIST VALIDATION
		alreadyexistsvalidation();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// SELECT THE ACCEPTED VALUE BUTTON DISPLAYED & ENABLED
	public static void AddAcceptedvalue() {
		extent.createTest("STEP_04--ACCEPTED VALUE  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0156-01", 1);
	}

	public static void validationempty() throws IOException {
		try {
			if (ManageTestsPage.acceptedvalueSaveButton.isDisplayed()) {
				if (ManageTestsPage.acceptedvalueSaveButton.isEnabled()) {
					ManageTestsPage.acceptedvalueSaveButton.click();
				} else {
					testCase = extent.createTest("SAVE BUTTON IS NOT ENABLED IN EMPTY VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("SAVE BUTTON IS NOT DISPLAYED IN EMPTY VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
			String Actualvalue = ManageTestsPage.emptyvalidation.getText();
			String expecteddata = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0156", 0, 3);

			try {
				Assert.assertEquals(Actualvalue, expecteddata);
				testCase = extent.createTest("1.TEST PARAMETER EMPTY VALIDATION");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL EMPTY VALIDATION ARE CORRECT");
			} catch (AssertionError e) {
				testCase = extent.createTest("1.TEST PARAMETER EMPTY VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL EMPTY VALIDATION ARE NOT CORRECT");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("EMPTY VALIDATION SAVE BUTTON NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	public static void alreadyexistsvalidation() throws IOException, InterruptedException {
		try {

			try {
				int rowcount = ManageTestsPage.tablerowcount.size();
				// Delete the already added records
				for (int i = 2; i <= rowcount; i++) {
					ManageTestsPage.tabledeletebtn.click();
					Thread.sleep(500);
					ManageTestsPage.confirmokbtn.click();
				}
			} catch (NoSuchElementException e) {

			}
			try {
				if (ManageTestsPage.testradiobtn.isDisplayed()) {
					if (ManageTestsPage.testradiobtn.isEnabled()) {
						if (!ManageTestsPage.testradiobtn.isSelected()) {
							ManageTestsPage.testradiobtn.click();
						}
					} else {
						testCase = extent.createTest("TEST RADIO BUTTON IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("TEST RADIO BUTTON IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {

			}

			WebElement aa = driver.findElement(By.xpath(
					"//form[@class='ant-legacy-form ant-legacy-form-horizontal sc-gqjmRU jKPlV']/div[1]/div[1]/div[1]/div/div[1]/div"));
			aa.click();
			List<WebElement> bb = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div"));
			int count = bb.size();

			try {
				// ADD DATA 2 TIMES FOR CHECK THE ALREADY EXIST VALIDATION
				for (int j = 0; j <= 2; j++) {
					String selecttypeparameter = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0156", 1,
							2);

					/* SELECT THE DROP DOWN FOR PARAMETER TYPE FEILD */
					Actions actions = new Actions(driver);
					try {
						if (ManageTestsPage.selecttextparameter.isDisplayed()) {
							if (ManageTestsPage.selecttextparameter.isEnabled()) {
								if (selecttypeparameter != "") {
									for (int i = 0; i < count; i++) {
										try {
											Thread.sleep(500);
											aa.click();
											Thread.sleep(500);
											driver.findElement(By.xpath("//div[text()='" + selecttypeparameter + "']"))
													.click();
											break;

										} catch (Exception e) {
											actions.sendKeys(Keys.ARROW_DOWN).perform();
										}
									}
								}
							} else {
								testCase = extent.createTest("SELECT PARAMETER TYPE IS NOT ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("SELECT PARAMETER TYPE IS NOT DISPLAYED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} catch (Exception e) {
					}
					try {
						if (ManageTestsPage.acceptedvalueSaveButton.isDisplayed()) {
							if (ManageTestsPage.acceptedvalueSaveButton.isEnabled()) {
								ManageTestsPage.acceptedvalueSaveButton.click();
							} else {
								testCase = extent.createTest("ACCEPTED VALUE SAVE BUTTON IS NOT ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("ACCEPTED VALUE SAVE BUTTON IS NOT DISPLAYED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} catch (Exception e) {
					}
					Thread.sleep(500);
				
				}

				// REPORT FOR ALREADY EXIST VALIDATION
				String Actualvalue = ManageTestsPage.emptyvalidation.getText();
				String expecteddata = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0156", 1, 3);
				try {
					Assert.assertEquals(Actualvalue, expecteddata);
					testCase = extent.createTest("2.TEST PARAMETER ACCEPTED VALUE VALIDATION");
					testCase.log(Status.PASS, "TEST PASS");
					testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED VALUE VALIDATION ARE CORRECT");
				} catch (AssertionError e) {
					testCase = extent.createTest("2.TEST PARAMETER ACCEPTED VALUE VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
					testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED VALUE VALIDATION ARE NOT CORRECT");
				}

			} catch (Exception e) {

			}
			try {
				if (ManageTestsPage.acceptedvalueclosebutton.isDisplayed()) {
					if (ManageTestsPage.acceptedvalueclosebutton.isEnabled()) {
						ManageTestsPage.acceptedvalueclosebutton.click();
					} else {
						testCase = extent.createTest("ACCEPTED VALUE CLOSE BUTTON IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("ACCEPTED VALUE CLOSE BUTTON IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("ALREADY EXIT VALIDATION NOT WORKED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {

		}
	}

	/* Get the return value from Excel sheet */
	public static String excel(String Sheet_Name, String Page_Name, String TestCase_Id, int excelrow, int i)
			throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + Sheet_Name + ".xlsx";
		String excelSheetName = Page_Name;
		String testCaseId = TestCase_Id;

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(Page_Name);

		XSSFRow row = sheet.getRow(firstRow + excelrow);
		String value = (String) row.getCell(i).getStringCellValue();
		return value;
	}
}
