/***********************************************************************************
//* Description
//*------------
//* Test - Test Configure - "Configure Test" Default Screen Functionality
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 11/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-119         12/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;

public class TestConfigureConfigureTestDefaultScreenFunctionality extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void configureTestDefaultScreenFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// login the system
		LoginTest.Login();

		//click the main TestConfiguration
		TestConfigNavigation.TestConfigurationCard();

		//Calling the method
		testConfigureProperties();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void testConfigureProperties() throws InterruptedException, IOException {	
		PageFactory.initElements(driver, GroupTestpg);

		Thread.sleep(1000);

		try {
			GroupTestsPage.testconfiguresub.click();

			testCase = extent.createTest("Checking Sub Testconfigure Button");
			testCase.log(Status.INFO, "Sub Testconfigure Button is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			//Calling the method
			defaultScreenFunctionality();

		}
		catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Sub Testconfigure Button");
			testCase.log(Status.INFO, "Unable to Locate Sub Testconfigure Button");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Sub Testconfigure Button");
			testCase.log(Status.INFO, "Sub Testconfigure Button is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Sub Testconfigure Button");
			testCase.log(Status.INFO, "Sub Testconfigure Button Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void defaultScreenFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		Thread.sleep(3000);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Test");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Group_Test", "MTC-GT-119");

		XSSFRow row = sheet.getRow(firstrow);
		code = (String) row.getCell(2).getStringCellValue();

		try {
			//	String ActualData = GroupTestsPage.configuretest.getText();
			String ActualData = GroupTestsPage.configuretest.getText();
			String ExpectedData = "Configure Test";

			testCase = extent.createTest("verify the default screen functionality");

			if (ActualData.equals("Configure Test")) {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
				testCase.log(Status.INFO, "Correct value");
				testCase.log(Status.PASS, ActualData);
			} else {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
				testCase.log(Status.INFO, "wrong value");
				testCase.log(Status.FAIL, ActualData);
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Configure Test default screen");
			testCase.log(Status.INFO, "Unable to Locate Configure Test default screen");
			testCase.log(Status.FAIL, "TEST FAIL");

		}
		catch (Exception e) {
			testCase = extent.createTest("Checking The Configure Test default screen");
			testCase.log(Status.INFO, "Configure Test default screen is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		}
	}
}









