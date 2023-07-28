//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Select Test Parameter" Drop down Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-193             11/07/2023   BFH.Rakshana   Original Version                
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

public class ManageTestConfigAcceptedValueTestParameterDropDown extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueTestParameterDropDown() throws InterruptedException, IOException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-193");
	        
			//search
	        testParameterDropDown();
			
	        //REFRESH
	        driver.navigate().refresh();
	 
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void testParameterDropDown() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-193-02", ManageTestsPage.TestParameterDropDown,"TestParameter DropDown UI Properties","1");
}

}
