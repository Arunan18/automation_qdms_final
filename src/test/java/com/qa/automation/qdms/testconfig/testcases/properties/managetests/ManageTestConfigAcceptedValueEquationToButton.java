//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Equation" -"To" Text Box Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-204             13/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigAcceptedValueEquationToButton extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueTestParameterDropDown() throws InterruptedException, IOException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-204");
	        
			//search
	        toTextbox();
			
	        //REFRESH
	        driver.navigate().refresh();
	 
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void toTextbox() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-204-02", ManageTestsPage.ToTextbox,"To Textbox UI Properties");
}

}
