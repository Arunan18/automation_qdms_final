//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Accepted Condition" icon  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 04/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-318           04/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIconProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	static String testname = null;
	static String testtype = null;

	@Test
	public static void acceptedconditionIcon() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 11);

		// Check Accepted Condition Icon UI Properties
		acceptedconditionIconExcel();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void acceptedconditionIconExcel() throws IOException {

		// EXCEL METHOD
		DataFormatter data = new DataFormatter();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-318");

		XSSFRow row = sheet.getRow(firstrow);
		testname = data.formatCellValue(row.getCell(2));
		testtype = data.formatCellValue(row.getCell(3));

		acceptedconditionIconProperties(testname, testtype);

	}

	public static void acceptedconditionIconProperties(String Value1, String Value2) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-318-02",
				driver.findElement(By.xpath("//td[text()='" + Value1 + "']//following-sibling::td[text()='" + Value2 + "']//following-sibling::td[6]//span//span[1]")),
				"Manage Test - Accepted Condition Icon UI Properties");

	}

}
