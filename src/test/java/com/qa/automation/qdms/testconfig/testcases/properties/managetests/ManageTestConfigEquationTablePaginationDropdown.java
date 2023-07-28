//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation Table - Pagination Drop down Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-270             07/07/2023   BFH.Rakshana   Original Version                
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigEquationTablePaginationDropdown extends DriverIntialization{
	@Test
	public static void manageTestConfigEquationTablePaginationDropdown() throws InterruptedException, IOException {
				NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);
				
				//search
				paginationDropdown();
				
				//REFRESH
		        driver.navigate().refresh();
		        Thread.sleep(2000);

				// LOGOUT
				Logout.LogoutFunction();
				
	}
	public static void paginationDropdown() {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests",
		"MTC-MT-270-02", ManageTestsPage.PaginationDropdown,"Pagination Dropdown UI Properties","1");
	}
}
