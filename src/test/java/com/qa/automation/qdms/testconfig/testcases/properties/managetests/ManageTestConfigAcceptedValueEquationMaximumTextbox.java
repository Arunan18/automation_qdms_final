//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Equation" -"Maximum" Text Box Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-203             13/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigAcceptedValueEquationMaximumTextbox extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueTestParameterDropDown() throws InterruptedException, IOException {
			
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-203");
	        
			//search
	        maximumTextbox();
			
	        //REFRESH
	        driver.navigate().refresh();
	 
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void maximumTextbox() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-203-02", ManageTestsPage.MaximumTextbox,"Maximum Textbox UI Properties");
}

}
