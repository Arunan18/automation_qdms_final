//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value Table - Pagination Previous button Properties
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0705			23/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedvalueTablePaginationPreviousButtonProperties extends DriverIntialization {

	@Test
	public static void previousButtonProperties() throws InterruptedException, IOException {
		AcceptedvalueActionDeleteIconProperties iconproperty = new AcceptedvalueActionDeleteIconProperties();
		PageFactory.initElements(driver, iconproperty);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0705");

		if (NavigateManageTestFromLogin.clicked) {
			// ACCEPTED CRITERIA
			AcceptedvalueActionDeleteIconProperties.acceptedCriteria();
		}

		// ACCEPTED VALUE TABLE - PAGINATION PREVIOUS BUTTON PROPERTIES
		paginationpreviousBtnProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED VALUE TABLE - PAGINATION PREVIOUS BUTTON PROPERTIES
	public static void paginationpreviousBtnProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0705-02", TestConfigPage.testconfignprerviousbtn,
				"Accepted criteria  - Accepted Value Table - Pagination Previous button Properties");
	}
}
