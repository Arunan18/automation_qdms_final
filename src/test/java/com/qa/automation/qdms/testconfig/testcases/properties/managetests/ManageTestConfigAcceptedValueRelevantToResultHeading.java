//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Relevant To Result" Heading UI Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-199             12/07/2023   BFH.Rakshana   Original Version                
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

public class ManageTestConfigAcceptedValueRelevantToResultHeading extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueRelevantToResultHeading() throws InterruptedException, IOException {
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-199");
			
			//search
	        relevantToResultHeading();
			
	        //REFRESH
	        driver.navigate().refresh();
	        
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void relevantToResultHeading() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-199-02", ManageTestsPage.RelevantToResultHeading,"RelevantToResult Heading UI Properties");
}

}
