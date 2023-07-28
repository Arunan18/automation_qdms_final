package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;

import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EdittestConfigValidationInTestConfigtest extends DriverIntialization {

	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage managetest = new ManageTestsPage();
	static Logout logout = new Logout();
	static String test = null;
	static String testtype = null;
	static String dueday = null;
	static String edit = null;
	static String testname = null;
	static String type = null;
	static String message = null;
	static String validationmsg = null;
	static DataFormatter dataValue = new DataFormatter();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managetest);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		PageFactory.initElements(driver, managetest);

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0396-data";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			testname = dataValue.formatCellValue(row.getCell(1));
			type = dataValue.formatCellValue(row.getCell(2));
			dueday = dataValue.formatCellValue(row.getCell(3));
			validationmsg = dataValue.formatCellValue(row.getCell(4));
			message = dataValue.formatCellValue(row.getCell(5));

			Thread.sleep(4000);
			Boolean rept = true;
			while (rept.equals(true)) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {

				}

				try {
					rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				} catch (Exception e) {
					rept = false;
				}
				try {
					SampleActionMethods
							.clicking(
									driver.findElement(
											By.xpath("//td[text()='" + testname + "']/following-sibling::td[text()='" + type
													+ "']/following-sibling::td[11]/span/a[1]")),
									3, "TEST CONFIG EDIT ICON ");
					break;
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (rept.equals(true)) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				}
				
				
			}

			
			ManageTestsPage.duedayedittextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

			ManageTestsPage.duedayedittextbox.sendKeys(dueday);
			ManageTestsPage.updatebtn.click();
			Thread.sleep(1000);
			String ActualValidation = ManageTestsPage.duedatevalidationmessage.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validationmsg;
			testCase = extent.createTest("Check " + message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(1000);
			ManageTestsPage.cancelbtn.click();
		}

//		/* LOGOUT FROM TEST PARAMETER */
		Logout.LogoutFunction();

	}

}
