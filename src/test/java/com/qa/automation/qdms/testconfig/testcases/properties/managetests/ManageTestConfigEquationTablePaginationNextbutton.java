//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation Table - Pagination Next button Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-268             07/07/2023   BFH.Rakshana   Original Version                
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
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigEquationTablePaginationNextbutton extends DriverIntialization{
	@Test
	public static void manageTestConfigEquationTablePaginationNextbutton() throws InterruptedException, IOException {
				NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);
				
				//click
				paginationNextButton();
				
				// LOGOUT
				Logout.LogoutFunction();
				
	}
	public static void paginationNextButton() {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
		"MTC-MT-268-02", ManageTestsPage.PaginationNextButton,"Pagination Next Button UI Properties");	
	}
	}

