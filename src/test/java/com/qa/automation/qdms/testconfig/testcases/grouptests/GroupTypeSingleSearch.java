//***********************************************************************************
//* Description
//*------------
//* GROUP TYPE SINGLE SEARCH & RESET FOR GROUP TEST
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-014			 28/04/2023   Gobithan     Orginal Version
//* MTC-GT-015			 28/04/2023   Gobithan     RESET
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class GroupTypeSingleSearch extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static Logout logout = new Logout();
	static boolean testdata = true;

	static int aftersearch = 0;
	static int datacount = 0;
	static String searchvalue = null;

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, action);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				testnav.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* GROUP TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- GROUP TEST PROPERTIES", testnav.GroupTest,
				"01--GROUP TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--GROUP TEST LEFT NAVIGATION BUTTON ENABLED",
				grouptest.grouptestheading, "Group Tests",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */
		int beforedatacount = PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		System.out.println("step1:-" + beforedatacount);

		/* REFERESH THE PAGE */
		driver.navigate().refresh();

		/* DATA SEARCH */
		search();

		/* CHECK THE DATA COUNT IN TABLE AFTER RESET */
		Thread.sleep(3000);
		int aftercount = PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		System.out.println("After Reset Data Count:-" + aftercount);

		/* DATA COUNT EQUAL OR NOT */
		SampleCommonMethods.dataaddedmsg("BEFORE AND AFTER DATA COUNT", beforedatacount, aftercount);

		/* LOGOUT TO THE SYSTEM */
		Logout.LogoutFunction();

	}

	public static void search() throws InterruptedException, IOException {
		/* Excel Sheet Value Passing */
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Group_Tests";
		String testCaseId = "MTC-GT-014"; 

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Tests");

		XSSFRow row = sheet.getRow(firstRow);
		searchvalue = (String) row.getCell(1).getStringCellValue();
		datacount = (int) row.getCell(2).getNumericCellValue();

		grouptest.groupsearchicon.click();

		/* Select the drop down for Sub Category Field Field */
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		grouptest.groupsearchtextbox.click();
		boolean findthevalue = false;
		for (int j = 0; j < 20; j++) {
			try {
				Thread.sleep(1000);

				driver.findElement(By.xpath("//div[@title='" + searchvalue + "']")).click();

				findthevalue = true;
				break;

			} catch (Exception e) {
				action.sendKeys(Keys.ARROW_DOWN).perform();
			}
		}

		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */
		PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		aftersearch = PropertiesCommonMethods.countOfData;
		System.out.println(aftersearch + ":After Search Data count");

		/* DATA COUNT AFTER SEARCH */
		SampleCommonMethods.dataaddedmsg("ON SEARCH DATA COUNT", aftersearch, datacount);

		grouptest.groupsearchicon.click();

		Thread.sleep(2000);
		/* CHECK THE RESET BUTTON FUNCTIONALITY */
		SampleActionMethods.clicking(grouptest.resetbtn, 3000, "CHECK THE RESETBUTTON");

		/* Redirect the pagination to first page */
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//li[contains(@class, 'ant-pagination-item') and not(contains(@class, 'ant-pagination-item-74'))])[1]"))
				.click();

	}
}
