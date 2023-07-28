//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- "Additional Information" Heading UI Properties   
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-275             07/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManagetestConfigAdditonalInformationHeading extends DriverIntialization{
	 
@Test
public static void managetestConfigAdditonalInformationHeading() throws InterruptedException, IOException {
			NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);
			
			//search
	        additonalInformationSearch();
			
			//REFRESH
	        driver.navigate().refresh();
	        Thread.sleep(2000);

			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void additonalInformationHeading() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-275-02", ManageTestsPage.AdditionalinformationHeading,"Additionalinformation Heading UI Properties");
}
	public static void additonalInformationSearch() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-275");

		XSSFRow row = sheet.getRow(firstrow);

		String SearchData = (String) row.getCell(2).getStringCellValue();
		
       // Button UI Properties
		additonalInformationHeading();
	}

}
