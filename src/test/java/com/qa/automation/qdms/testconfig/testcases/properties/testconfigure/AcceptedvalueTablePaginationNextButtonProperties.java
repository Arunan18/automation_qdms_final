//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value Table - Pagination next button Properties
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0704			23/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedvalueTablePaginationNextButtonProperties extends DriverIntialization {
	@Test
	public static void nextButtonProperties() throws InterruptedException, IOException {
		AcceptedvalueActionDeleteIconProperties iconproperty = new AcceptedvalueActionDeleteIconProperties();
		PageFactory.initElements(driver, iconproperty);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0704");

		if (NavigateManageTestFromLogin.clicked) {
			// ACCEPTED CRITERIA
			AcceptedvalueActionDeleteIconProperties.acceptedCriteria();
		}

		// ACCEPTED VALUE TABLE - PAGINATION NEXT BUTTON PROPERTIES
		paginationNextBtnProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED VALUE TABLE - PAGINATION NEXT BUTTON PROPERTIES
	public static void paginationNextBtnProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0704-02", TestConfigPage.testconfignextbtn,
				"Accepted criteria  - Accepted Value Table - Pagination next button Properties");

	}

}
