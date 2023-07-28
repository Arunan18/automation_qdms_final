//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation-  "Cancel" button Functionality   
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-272             07/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestconfigEquationCancelButtonFunctionality extends DriverIntialization{
	 @Test
	public static void manageTestconfigEquationCancelButtonFunctionality() throws InterruptedException, IOException {
        NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties",
	    "Manage_Tests", "MTC-MT-272");
		
		//search
		equationSearch();
		
		//REFRESH
        driver.navigate().refresh();
        Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();
		
}
public static void equationCancelButtonFunction() {
	try {
        if (ManageTestsPage.EquationCancelButton.isDisplayed()) {
            testCase = extent.createTest("STEP-01--Cancel Button IS DISPLAYED");
            testCase.log(Status.PASS, "TEST PASS ☑");
            if (ManageTestsPage.EquationCancelButton.isEnabled()) {
                testCase = extent.createTest("STEP-02--Cancel Button IS ENABLED");
                testCase.log(Status.PASS, "TEST PASS ☑");
                ManageTestsPage.EquationCancelButton.click();
            } else {
                testCase = extent.createTest("STEP-02--Cancel Button IS NOT ENABLED");
                testCase.log(Status.FAIL, "TEST FAIL ❎");
            }
        } else {
            testCase = extent.createTest("STEP-01--Cancel Button IS NOT DISPLAYED");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
}
public static void equationSearch() throws IOException, InterruptedException {
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Manage_Tests");

	int firstrow = CommonMethods.getFirstRowNum(
			System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
			"Manage_Tests", "MTC-MT-272");

	XSSFRow row = sheet.getRow(firstrow);

	String SearchData = (String) row.getCell(2).getStringCellValue();
	
    // Button UI Properties
	equationCancelButtonFunction();
}
}
