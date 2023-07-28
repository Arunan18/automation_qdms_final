//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation Table - Pagination Previous button Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-269             07/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigEquationTablePaginationPreviousbutton extends DriverIntialization{
	@Test
	public static void manageTestConfigEquationTablePaginationPreviousbutton() throws InterruptedException, IOException {
				NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);
				
				//click
				paginationClick();
				
				// LOGOUT
				Logout.LogoutFunction();
				
	}
	public static void paginationDropdown() {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
		"MTC-MT-269-02", ManageTestsPage.PaginationPreviousButton,"Pagination Previous Button UI Properties");
	}
	public static void paginationClick() {
		try {
		ManageTestsPage.PaginationNextButton.click();
		
		//search
		paginationDropdown();	
	}
		catch (NoSuchElementException e) {
            testCase = extent.createTest("Checking The PaginationNextButton");
            testCase.log(Status.INFO, "Unable to Click on the element 'PaginationNextButton'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (ElementClickInterceptedException e) {
        	testCase = extent.createTest("Checking The PaginationNextButton");
            testCase.log(Status.INFO, "Unable to Click on the element 'PaginationNextButton'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (Exception e) {
        	testCase = extent.createTest("Checking The PaginationNextButton");
            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
        }
}
}