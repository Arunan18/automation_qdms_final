//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Accepted Value" UI Heading Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-192             11/07/2023   BFH.Rakshana   Original Version                
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

public class ManageTestConfigAcceptedValueHeading extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueHeading() throws InterruptedException, IOException {
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-192");
			
			//search
	        acceptedValueHeading();
			
	        //REFRESH
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	        
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void acceptedValueHeading() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-192-02", ManageTestsPage.AcceptedValueHeading,"AcceptedValue Heading UI Properties");
}

}
