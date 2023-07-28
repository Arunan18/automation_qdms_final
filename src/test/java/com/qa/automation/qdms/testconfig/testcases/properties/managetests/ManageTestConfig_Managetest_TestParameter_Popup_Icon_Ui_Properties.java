//*************************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Test Parameters" icon Properties
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-162             23/06/2023   Priyanka     Orginal Version
//*                        26/06/2023   Priyanka     Removed Pagefactory
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

public class ManageTestConfig_Managetest_TestParameter_Popup_Icon_Ui_Properties extends DriverIntialization {

	static String testname = null;
	static String type = null;

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testParameterPopupUiProperties() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 7);

		// CHECKING TEST PARAMETER POP UP ICON UI PROPERTIES

		testParameterPopupUIwithExcel();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void testParameterPopupUIwithExcel() throws IOException, InterruptedException {

		// EXCEL METHOD
		DataFormatter data = new DataFormatter();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-162");

		XSSFRow row = sheet.getRow(firstrow);
		testname = data.formatCellValue(row.getCell(2));
		type = data.formatCellValue(row.getCell(3));

		testParameterPopupUI(testname, type);

	}

	public static void testParameterPopupUI(String Value1, String Value2) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-162-02",
				driver.findElement(By.xpath("//td[text()='" + Value1 + "']/following-sibling::td[text()='" + Value2
						+ "']/following-sibling::td[2]//span//span[1]")),
				"Manage Test -  Test Parameter Pop up Icon UI Properties");

	}

}
