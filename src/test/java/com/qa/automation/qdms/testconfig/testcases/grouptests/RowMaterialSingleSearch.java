//***********************************************************************************
//* Description
//*------------
//* RAW MATERIAL SINGLE SEARCH & RESET FOR GROUP TEST
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-012			 28/04/2023   Gobithan     Orginal Version
//* MTC-GT-013			 28/04/2023   Gobithan     RESET
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class RowMaterialSingleSearch extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static Logout logout = new Logout();
	static boolean testdata = true;
	
	@Test
	public static void action() throws InterruptedException, IOException
	{
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, action);
		
		/* LOGIN */
		LoginTest.Login();
		
		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES", testnav.MANGECONFIGURE,
				"01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest,
				testnav.managetest,"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");
		
		/* GROUP TEST  PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- GROUP TEST PROPERTIES", testnav.GroupTest,
				"01--GROUP TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--GROUP TEST LEFT NAVIGATION BUTTON ENABLED", grouptest.grouptestheading,"Group Tests",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */
		int beforedatacount = PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		
		/* REFERESH THE PAGE */
		driver.navigate().refresh(); 
		
		/* COMMEN METHOD FOR SINGLE SEARCH */
		SampleSingleSearchMethods.newSingleSearch(grouptest.rawmatsearchicon, grouptest.rawmatsearchtextbox,
				grouptest.maincatsearchbutton, "RAW MATERIAL SINGLE SEARCH",
				"Test Configuragtion Module", "Group_Tests", "MTC-GT-012", 1, 2, grouptest.tableColoumnorawmaterial,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[4]", testdata);
		
		/*  AFTER SEARCH DATA COUNT*/
		aftersearchdatacount();
		
		/* CHECK THE RESET BUTTON FUNCTIONALITY */
		SampleActionMethods.clicking(grouptest.resetbtn, 3000, "CHECK THE RESETBUTTON");
		
		/* CHECK THE DATA COUNT IN TABLE AFTER RESET */
		int aftercount = PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		
		
		 /* DATA COUNT EQUAL OR NOT */
		SampleCommonMethods.dataaddedmsg("BEFORE AND AFTER DATA COUNT",  beforedatacount, aftercount);
		
		/* LOGOUT TO THE SYSTEM */
		Logout.LogoutFunction();
		
	}
	
	
	static int datacount = 0;
	public static void aftersearchdatacount() throws IOException, InterruptedException
	{
		
		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */
		int aftersearch = PropertiesCommonMethods.CountOfData2(grouptest.tablecontainer);
		
/*Excel Sheet Value Passing*/	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Group_Tests";
		String testCaseId = "MTC-GT-012";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Tests");
			 
			XSSFRow row = sheet.getRow(firstRow);
			
				datacount = (int) row.getCell(2).getNumericCellValue();
		
		 /* DATA COUNT AFTER SEARCH */
			SampleCommonMethods.dataaddedmsg("AFTER SEARCH DATA COUNT",  aftersearch, datacount);
		
	}
	
}
