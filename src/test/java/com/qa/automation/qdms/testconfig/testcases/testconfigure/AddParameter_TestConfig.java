
//***********************************************************************************
//* Description
//*------------
//* ADD PARAMETER FUNCTIONALITY AND SAVE BUTTON FUNCTIONALITY -TEST CONFIGURE

//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 1/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0049            1/05/2023      Niluxy       Original Version
//*TC-TCN-0056
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddParameter_TestConfig extends DriverIntialization {
	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage managepage = new ManageTestsPage();

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	public static String pageName = "Test_Configure";

	static String succesnotification = "";
	static String parameter = "";
	static String parametertype = "";

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		extent.createTest("TC-TCN-0049:ADD PARAMETER FUNCTIONALITY");
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
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0049-01", 1);

		// CHECK THE TEST PARAMETER LEFT BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 20, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(3000);
		SampleActionMethods.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 20,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

		// CHECK THE TEST PARAMETER ADD BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.AddTestparameterButton, 20,
				"STEP 7:CHECKING THE ADD TEST PARAMETER");

		// SELECT AND ADD THE DATA FROM EXCEL
		String testCaseId = "TC-TCN-0049";
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

			String parameter = (String) row.getCell(2).getStringCellValue();
			System.out.println("parameter " + parameter);
			String parametertype = (String) row.getCell(3).getStringCellValue();
			System.out.println("parametertype " + parametertype);
			String succesnotification = (String) row.getCell(4).getStringCellValue();
			System.out.println("succesnotification" + succesnotification);

			// PARAMETER FIELD
			// ________________________________________________________________________
			try {
				Thread.sleep(2000);
				SampleActionMethods.clicking(TestConfigPage.parametertextbox, 2, "STEP 8:CHECK PARAMETER TEXBOX");
				TestConfigPage.parametertextbox.sendKeys(parameter);
				Thread.sleep(2000);
			} catch (Exception e) {

			}

			// PARAMETER DATA TYPE FIELD
			// ________________________________________________________________
			try {
				Thread.sleep(2000);
				SampleActionMethods.clicking(TestConfigPage.parameterTypetextbox, 2,
						"STEP 9:CHECK PARAMETER DATA TYPE TEXBOX");
				Thread.sleep(3000);
				TestConfigPage.parameterTypetextbox.sendKeys(parametertype);
				Thread.sleep(3000);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);

			} catch (Exception e) {

			}
			extent.createTest("TC-TCN-0056:Add parameter model  save button function_add parameter");
			// CHECK THE SAVE BUTTON TEST PARAMETER
			Thread.sleep(2000);
			SampleActionMethods.clicking(TestConfigPage.parametersavebutton, 20,
					"STEP 10:CHECKING THE SAVE BUTTON IN PARAMETER");

			/* DATA ADDED SUCCESS MESSAGE */
			SampleCommonMethods.dataaddedsuccessmsg("STEP 11: DATA ADDED SUCCESSFULLY", TestConfigPage.successMsg,
					succesnotification);

			/* CHECK FIRST DATA OF THE TABLE */
			SampleCommonMethods.firstrowdata("STEP 12: DATA ADDED IN FIRST ROW", TestConfigPage.Tablerowtestparameter,
					parameter);

			// LOGOUT TO THE SYSTEM
			Logout.LogoutFunction();
		}

	}

}
