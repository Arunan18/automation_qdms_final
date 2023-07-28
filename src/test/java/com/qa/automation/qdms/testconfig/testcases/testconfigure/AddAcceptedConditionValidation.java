//***********************************************************************************
//* Description
//*------------
//* Add Accepted Condition Validation
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 09/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0198        	09/06/2023     Gobithan     Original Version
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class AddAcceptedConditionValidation extends DriverIntialization {

	static TestConfigPage addPage = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static TestParameterStep testparameter = new TestParameterStep();
	static configureEquationStep configure = new configureEquationStep();
	static AcceptCondition accepted = new AcceptCondition();
	static Addaditionalinformation additionalinformation = new Addaditionalinformation();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage manage = new ManageTestsPage();

	@Test
	public static void configuretest() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, testparameter);
		PageFactory.initElements(driver, accepted);
		PageFactory.initElements(driver, additionalinformation);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// TESTCASE REPORT
		extent.createTest("TC-TCN-0198-Add Accepted Condition Validation");

		// TOP NAVIGATION
		action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");

		// NAVIGATE TO TEST CONFIGURATION
		Thread.sleep(2000);
		action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");

		// CONFIGURE TEST FIELD
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-first");

		// TEST PARAMETER FIELD
		Thread.sleep(2000);
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-second");

		// ADD PARAMETER FIELD
		Thread.sleep(3000);
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-second");

		// CONFIGURE EQUATION FIELD
		Thread.sleep(2000);
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-third");

		// CLICK ON NEXT BUTTON
		Thread.sleep(3000);
		TestConfigPage.nextBtn.click();

		// ACCEPTED CRITERIA FIELD
		Thread.sleep(3000);
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-fourth");

		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		// ACCEPTED CRITERIA FIELD
		Thread.sleep(3000);
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198-fifth");

		Thread.sleep(3000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		// EMPTY VALIDATIION CHECK
		Thread.sleep(1000);
		emptyvalidation();

		// WRONG EQUATION VALIDATIION CHECK
		Thread.sleep(1000);
		wrongequationvalidation();

	}

	// EMPTY VALIDATION CHECK
	public static void emptyvalidation() throws IOException, InterruptedException {
		PageFactory.initElements(driver, manage);
		Actions action = new Actions(driver);

		if (ManageTestsPage.conditionsavebtn.isDisplayed()) {
			testCase = extent.createTest("CONDITION IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.conditionsavebtn.isEnabled()) {
				testCase = extent.createTest("CONDITION IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					action.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(500);
					ManageTestsPage.conditionsavebtn.click();
					String Actualvalue = ManageTestsPage.addconditionvalidation.getText();
					String expecteddata = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198", 0, 2);
					try {
						Assert.assertEquals(Actualvalue, expecteddata);
						testCase = extent.createTest("ACCEPTED CONDITION EMPTY VALIDATION");
						testCase.log(Status.PASS, "TEST PASS");
						testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED CONDITION EMPTY VALIDATION ARE CORRECT");
					} catch (AssertionError e) {
						testCase = extent.createTest("ACCEPTED CONDITION EMPTY VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
						testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
						testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						testCase.log(Status.INFO,
								"EXPECTED & ACTUAL ACCEPTED CONDITION EMPTY VALIDATION ARE NOT CORRECT");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("EMPTY VALIDATION SAVE BUTTON NOT CLICK");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest("CONDITION IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("CONDITION IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	public static void wrongequationvalidation() throws InterruptedException, IOException {
		PageFactory.initElements(driver, accepted);

		try {
			// driver.findElement(By.xpath("//div[@class='ant-table-container']//table/tbody/tr"))
			for (int i = 2; i <= 3; i++) {
				Thread.sleep(500);
				driver.findElement(By
						.xpath("//div[@class='ant-col ant-col-10']//div[@class='ant-table-container']//table/tbody/tr["
								+ i + "]//input[@id='relevant_check']"))
						.click();
			}
			String sendvalue = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198", 1, 1);
			driver.findElement(By.xpath("//div[@class='ant-col ant-col-14']//textarea")).sendKeys(sendvalue);
			ManageTestsPage.conditionsavebtn.click();
			String Actualvalue = ManageTestsPage.addconditionvalidation.getText();
			String expecteddata = excel("Test Configuragtion Module", "Test_Configure", "TC-TCN-0198", 1, 2);
			try {
				Assert.assertEquals(Actualvalue, expecteddata);
				testCase = extent.createTest("ACCEPTED CONDITION WRONG EQUATION VALIDATION");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED CONDITION WRONG EQUATION VALIDATION ARE CORRECT");
			} catch (AssertionError e) {
				testCase = extent.createTest("ACCEPTED CONDITION WRONG EQUATION VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO,
						"EXPECTED & ACTUAL ACCEPTED CONDITION WRONG EQUATION VALIDATION ARE NOT CORRECT");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
