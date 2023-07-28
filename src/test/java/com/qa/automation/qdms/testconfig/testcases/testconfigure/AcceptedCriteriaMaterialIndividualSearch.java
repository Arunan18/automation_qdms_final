//***********************************************************************************
//* Description
//*------------
//* Accepted Criteria Material Individual Search
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 04/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0168	 		 04/05/2023    Gobithan     Original Version
//* TC-TCN-0170			 04/05/2023
//* TC-TCN-0172			 04/05/2023
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.SingleSearchMethods;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AcceptedCriteriaMaterialIndividualSearch extends DriverIntialization {

	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();
	static PropertiesCommonMethods property = new PropertiesCommonMethods();
	static SingleSearchMethods search = new SingleSearchMethods();

	static int onsearchcount_expected = 0;

	@Test
	public static void action() throws InterruptedException, IOException {

		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testconfig);
		PageFactory.initElements(driver, mangetest);
		PageFactory.initElements(driver, property);
		PageFactory.initElements(driver, search);

		/* LOGIN */
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES",
				testnav.ManageCofigureMenuBar, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,
				"Manage Tests Configure", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		/* SELECT THE VALUE */
		AddGroupKey.actionS(0, 14, mangetest.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0168-01", 1);

		/* CLICK THE ACCEPTED CRITERIA FORM */
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'ant-steps-item-icon')])[4]")).click();

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0168";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow);
		String dropdown = (String) row.getCell(2).getStringCellValue();
		onsearchcount_expected = (int) row.getCell(3).getNumericCellValue();

		/* SELECT DROPDOWN */
		SampleCommonMethods.fieldmethoddropdown("STEP_07-- MATERIAL RADIO BUTTON PROPERTIES",
				testnav.individualdropdown, "01--MATERIAL RADIO BUTTON DISPLAYED", "02--MATERIAL RADIO BUTTON ENABLED",
				"//div[contains(@title,'" + dropdown + "')]//div[1]", "03--DROPDOWN FIELD SELECTED");

		/* CLICK THE MATERIAL RADIO BUTTON */
		SampleCommonMethods.singleclick("STEP_05-- MATERIAL RADIO BUTTON PROPERTIES", testnav.materialradiobtn,
				"01--MATERIAL RADIO BUTTON DISPLAYED", "02--MATERIAL RADIO BUTTON ENABLED");

		/* CLICK THE INDIVIDUAL RADIO BUTTON */
		SampleCommonMethods.singleclick("STEP_06-- MATERIAL INDIVIDUAL RADIO BUTTON PROPERTIES",
				testnav.individualradiobtn, "01--MATERIAL INDIVIDUAL RADIO BUTTON DISPLAYED",
				"02--MATERIAL INDIVIDUAL RADIO BUTTON ENABLED");

		/* MATERIAL SEARCH */
		materialsearch();

		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}

	static int onsearchcount = 0;
	static int afterserach = 0;
	static int beforesearch = 0;

	public static void materialsearch() throws InterruptedException {
		PageFactory.initElements(driver, property);
		PageFactory.initElements(driver, testnav);

		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */
		List<WebElement> beforedata = driver.findElements(By.cssSelector(".ant-table-row.ant-table-row-level-0"));
		beforesearch = beforedata.size();
		System.out.println("beforesearch" + beforesearch);
		System.out.println(beforedata.size());

		/* CLICK THE MATERIAL SEARCH ICON */
		SampleCommonMethods.singleclick("STEP_07-- MATERIAL SEARCH ICON PROPERTIES", testnav.searchicon,
				"01--MATERIAL SEARCH ICON DISPLAYED", "02--MATERIAL SEARCH ICON ENABLED");

		/* Material Search Box Property */
		SampleCommonMethods.sendvalue("STEP_08-- MATERIAL SEARCH BOX PROPERTIES", testnav.materialsearchbox,
				"01--MATERIAL SEARCH BOX FIELD DISPLAYED", "02--MATERIAL SEARCH BOX FIELD ENABLED", "parametr1 (C)");

		/* CLICK THE MATERIAL SEARCH BUTTON */
		SampleCommonMethods.singleclick("STEP_09-- MATERIAL SEARCH BUTTON PROPERTIES", testnav.searchbtn,
				"01--MATERIAL SEARCH BUTTON DISPLAYED", "02--MATERIAL SEARCH BUTTON ENABLED");

		/* BEFORE SEARCH COUNT THE DATA */
		Thread.sleep(2000);
		List<WebElement> onsearchdatacount = driver
				.findElements(By.cssSelector(".ant-table-row.ant-table-row-level-0"));
		onsearchcount = onsearchdatacount.size();

		/* ON SEARCH DATA COUNT CHECKING */
		onserchdatacountmsg();

		testnav.searchicon.click(); 

		driver.findElement(By.xpath("//div[contains(@class,'ant-space-item')]//span[contains(text(),'Reset')]"))
				.click();
		/* CLICK THE RESET BUTTON */
		SampleCommonMethods.singleclick("STEP_11-- RESET BUTTON PROPERTIES", testnav.resetbtn,
				"01--MATERIAL SEARCH RESET BUTTON DISPLAYED", "02--MATERIAL SEARCH RESET BUTTON ENABLED");

		/* AFTER SEARCH COUNT THE DATA */
		List<WebElement> afterdata = driver.findElements(By.cssSelector(".ant-table-row.ant-table-row-level-0"));
		afterserach = afterdata.size();

		/* BEFORE AND AFTER SERACH DATA COUNT */
		SampleCommonMethods.dataaddedmsg("STEP_12-- BEFORE AND AFTER SERACH DATA COUNT", beforesearch, afterserach);

	}

	public static void onserchdatacountmsg() throws InterruptedException {

		Thread.sleep(1000);
		testCase = extent.createTest("STEP_10-- ON SERACH FILTER DATA COUNT IS EQUAL");
		try {
			Assert.assertEquals(onsearchcount, onsearchcount_expected);
			testCase.log(Status.INFO, "Actual Data :- " + onsearchcount);
			testCase.log(Status.INFO, "Expected Data :- " + onsearchcount_expected);
			testCase.log(Status.PASS, "ON SERCH DATA COUNT IS EQUAL");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + onsearchcount);
			testCase.log(Status.INFO, "Expected Data :- " + onsearchcount_expected);
			testCase.log(Status.FAIL, "ON SERCH DATA COUNT IS  NOT EQUAL");
		}

	}
}
