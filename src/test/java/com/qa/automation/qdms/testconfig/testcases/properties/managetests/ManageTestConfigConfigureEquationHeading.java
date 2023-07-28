//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab-Equation-"Configure Equation" Heading UI Properties   
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-247             11/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigConfigureEquationHeading extends DriverIntialization{
	 
@Test
public static void manageTestConfigConfigureEquationHeading() throws InterruptedException, IOException {
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-247");
			
			//search
	        configureEquationHeading();
			
	        //REFRESH
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void configureEquationHeading() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-247-02", ManageTestsPage.ConfigureEquationHeading,"ConfigureEquation Heading UI Properties");
}
}
