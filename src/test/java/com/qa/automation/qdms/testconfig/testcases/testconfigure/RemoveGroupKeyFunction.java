
//***********************************************************************************
//* Description
//*------------
//*  REMOVE GROUP KEY TEXTBOX FUCNTIONALITY- GROUP KEYS
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 2/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-TCN-0082    2/05/2023  Niluxy       Orginal Version
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class RemoveGroupKeyFunction extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();

	// static Actions actions = new Actions(driver);
	// static AddParameter_Method method = new AddParameter_Method();

	// static ScrollRight scroll = new ScrollRight ();
	static boolean testdata = true;
	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
	public static String pageName = "Test_Configure";

	static String succesnotification = "";
	static String parameter = "";
	static String parametertype = "";

	@Test
	public static void groupkey() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		// PageFactory.initElements(driver, actions);
		// PageFactory.initElements(driver, scroll);
		// PageFactory.initElements(driver, method);
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK TEST CONFIGURATION

		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST CONFIG");
		Thread.sleep(2000);

		// CLICK MANAGE TEST LEFT BUTTON
		action.clicking(TestConfigPage.manageTest, 2000, "STEP 3:CHECKING THE MANAGE TEST CONFIG MODULE ");

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}

		Thread.sleep(3000);
		// ScrollRight.scroll(13);

		// CLICK EDITKEYICON IN MANAGE TEST
		action.clicking(TestConfigPage.Editkeyiconinmanagetest, 20, "STEP 4:CHECKING THE EDIT KEY ICON ");
		Thread.sleep(2000);
		// click test configure left button
		action.clicking(TestConfigPage.testconfigleftnav, 20, "STEP 5:CHECKING THE TEST CONFIGURE");

		// Click Test Button
		// action.clicking(TestConfigPage.testtopnav, 20, "STEP 2:CHECKING THE EST
		// MODULE ");
		// Click Test Configuration
		// action.clicking(TestConfigPage.testconfigleftnav, 20, "STEP 2:CHECKING THE
		// EST MODULE ");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(2000);
		action.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 20,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

		// CHECK THE TEST PARAMETER ADD GROUP BUTTON
		Thread.sleep(2000);
		action.clicking(TestConfigPage.Addgroupbuttonintc, 20, "STEP 7:CHECKING THE ADD GROUP TEST");

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

			String GroupKey = (String) row.getCell(1).getStringCellValue();
			System.out.println("GroupKey" + GroupKey);

			action.clicking(TestConfigPage.Groupkeytextbox, 20, "STEP 7:CHECKING THE GROUP KEY TEXTBOX");

			// CHECK THE GROUP KEY PLUS ADD TEXTBOX
			action.clicking(TestConfigPage.Groupkeytextbox, 2, "STEP 8:CHECK GROUP TEXBOX");
			TestConfigPage.Groupkeytextbox.sendKeys(GroupKey);

			Thread.sleep(2000);
			// CHECK THE GROUP KEY PLUS BUTTON
			action.clicking(TestConfigPage.Groupkeyplusicon, 20, "STEP 9:CHECKING THE GROUP KEY PLUS ICON ");

			Thread.sleep(3000);
			// CHECK THE GROUP KEY REMOVE BUTTON
			action.clicking(TestConfigPage.Groupkeyremovebutton, 20, "STEP 10:CHECKING THE GROUP KEY REMOVE BUTTON");

			// CHECK THE GROUP KEY PLUS ADD TEXTBOX

			String ActualData = TestConfigPage.Groupkeytextbox.getAttribute("value");
			System.out.println("TEXTBOX REMOVE DATA : " + ActualData);
			Thread.sleep(3000);
			String ExpectedData = GroupKey;
			System.out.println("TEXTBOX REMOVE DATA : " + ExpectedData);
			testCase = extent.createTest("STEP 11:VERIFY THE REMOVE FUCNTION");
			AssertJUnit.assertNotSame(ActualData, ExpectedData);
			try {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
				testCase.log(Status.INFO, "the value is not available");
				testCase.log(Status.PASS, ActualData);
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
				testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
				testCase.log(Status.INFO, "the value is available");
				testCase.log(Status.FAIL, ActualData);

			}

		}
		// CHECK THE GROUP KEY CLOSE BUTTON
		Thread.sleep(1000);
		action.clicking(TestConfigPage.GroupkeyCrossicon, 20, "STEP 12:CHECKING THE GROUP KEY CROSS ICON ");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}