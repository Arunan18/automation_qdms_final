//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Equation" Drop Down Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-201             12/07/2023   BFH.Rakshana   Original Version                
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

public class ManageTestConfigAcceptedValueEquationDropDown extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueEquationDropDown() throws InterruptedException, IOException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-201");
	        
			//search
	        Thread.sleep(1500);
	        equationDropDown();
			
	        //REFRESH
	        driver.navigate().refresh();
	 
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void equationDropDown() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-201-02", ManageTestsPage.EquationDropDown,"Equation DropDown UI Properties","");
}

}
