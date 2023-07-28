//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- "Additional Information" Icon Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-276             07/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManagetestConfigAdditonalInformationIcon extends DriverIntialization {

	@Test
	public static void managetestConfigAdditonalInformationHeading() throws InterruptedException, IOException {
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);

		// search
		additonalInformationSearch();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void additonalInformationIcon(String SearchData) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-276-02",
				driver.findElement(By.xpath("//td[text()='" + SearchData + "']//following-sibling::td[10]/span/span")),
				"Additionalinformation Icon UI Properties");
	}

	public static void additonalInformationSearch() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-276");

		XSSFRow row = sheet.getRow(firstrow);

		String pro = (String) row.getCell(2).getStringCellValue();

		// Button UI Properties
		additonalInformationIcon(pro);
	}
}
