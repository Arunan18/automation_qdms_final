//***********************************************************************************
//* Description
//*------------
//*  GROUP KEY TEXTBOX FUCNTIONALITY- GROUP KEYS CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 2/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0082           2/05/2023      Niluxy       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
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

public class AddGroupKeytTextboxButtonFunction extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	public static String pageName = "Test_Configure";

	@Test
	public static void groupkey() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, groupkey);
		extent.createTest("TC-TCN-0082:AddGroupKeyTextboxButtonFunction");

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

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  DESCRIPTION PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0082-01", 1);

		// CLICK TEST CONFIGE LEFT BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 20, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(3000);
		SampleActionMethods.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 20,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

		// CHECK THE TEST PARAMETER ADD GROUP BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.Addgroupbuttonintc, 20, "STEP 7:CHECKING THE ADD GROUP TEST");

		// SELECT AND ADD THE DATA FROM EXCEL
		String testCaseId = "TC-TCN-0082";
		int firstrow = CommonMethods.getFirstRowNum(excelpath, pageName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelpath, pageName, testCaseId);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet pageName = workbook.getSheet("Test_Configure");
		Thread.sleep(2000);
		for (int i = firstrow; i <= lastrow; i++) {
			Thread.sleep(2000);
			XSSFRow row = pageName.getRow(i);

			String GroupKey = (String) row.getCell(2).getStringCellValue();
			System.out.println("GroupKey" + GroupKey);
			String GroupKeysc = (String) row.getCell(3).getStringCellValue();
			System.out.println("GroupKeysc" + GroupKeysc);

			Thread.sleep(2000);
			// CHECK THE GROUP KEY PLUS ADD TEXTBOX
			SampleActionMethods.clicking(TestConfigPage.Groupkeytextbox, 2, "STEP 8:CHECK GROUP TEXBOX");
			TestConfigPage.Groupkeytextbox.sendKeys(GroupKey);

			Thread.sleep(2000);
			// CHECK THE GROUP KEY PLUS BUTTON
			SampleActionMethods.clicking(TestConfigPage.Groupkeyplusicon, 20,
					"STEP 9:CHECKING THE GROUP KEY PLUS ICON ");

			// CHECK THE GROUP KEY PLUS ADD TEXTBOX

			String ActualData = TestConfigPage.Groupkeytextbox.getAttribute("value");
			System.out.println("TEXTBOX ADD DATA : " + ActualData);
			Thread.sleep(3000);
			String ExpectedData = GroupKey;
			System.out.println("TEXTBOX ADD DATA : " + ExpectedData);
			testCase = extent.createTest("STEP 10:VERIFY THE ADD TEXTBOX FUCNTION");
			AssertJUnit.assertNotSame(ActualData, ExpectedData);
			try {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
				testCase.log(Status.INFO, "the value is available");
				testCase.log(Status.PASS, ActualData);
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
				testCase.log(Status.INFO, "the value is  not available");
				testCase.log(Status.FAIL, ActualData);

			}

			Thread.sleep(2000);
			// CHECK THE GROUP KEY CLOSE BUTTON
			action.clicking(TestConfigPage.GroupkeyCrossicon, 20, "STEP 11:CHECKING THE GROUP KEY CROSS ICON ");

			// LOGOUT TO THE SYSTEM
			Logout.LogoutFunction();
		}
	}
}