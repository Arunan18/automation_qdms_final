//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Equation" -"Minimum" Text Box Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-202             13/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigAcceptedValueEquationMinimumTextbox extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueEquationMinimumTextbox() throws InterruptedException, IOException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-202");
	        
			//search
	        minimumTextbox();
			
	        //REFRESH
	        driver.navigate().refresh();
	 
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void minimumTextbox() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-202-02", ManageTestsPage.MinimumTextbox,"Minimum Textbox UI Properties");
}

}
