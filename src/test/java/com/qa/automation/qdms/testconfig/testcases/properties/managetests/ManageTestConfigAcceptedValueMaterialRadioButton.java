//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Material" Radio ButtonProperties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-198             12/07/2023   BFH.Rakshana   Original Version                
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

public class ManageTestConfigAcceptedValueMaterialRadioButton extends DriverIntialization{
	 
@Test
public static void manageTestConfigAcceptedValueMaterialRadioButton() throws InterruptedException, IOException {
	        NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
		    "Manage_Tests", "MTC-MT-198");
			
			//search
	        materialRadioButton();
			
	        //REFRESH
	        driver.navigate().refresh();
	        
			// LOGOUT
			Logout.LogoutFunction();
			
}
public static void materialRadioButton() {
	ManageTestsPage mtp = new ManageTestsPage();
	PageFactory.initElements(driver, mtp);
	
	PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
	"MTC-MT-198-02", ManageTestsPage.MaterialRadioButton,"MaterialRadio Button UI Properties");
}

}
