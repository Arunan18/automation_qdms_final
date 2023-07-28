//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value - Action - Delete Pop up Screen- "Cancel" button Properties  
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0702			23/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedvalueActionDeleteCancelButtonProperties extends DriverIntialization {
	@Test
	public static void action() throws InterruptedException, IOException {
		AcceptedvalueActionDeleteIconProperties iconproperty = new AcceptedvalueActionDeleteIconProperties();
		PageFactory.initElements(driver, iconproperty);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0702");

		if (NavigateManageTestFromLogin.clicked) {
			// ACCEPTED CRITERIA
			AcceptedvalueActionDeleteIconProperties.acceptedCriteria();
		}

		// SELECT THE DELETE CONFIGURE DISPLAYED & ENABLED
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.managetexttablecontainer, "delete",
				"Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0702-01", 3);

		// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "CANCEL" BUTTON PROPERTIES
		deleteCancelBtnProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "CANCEL" BUTTON PROPERTIES
	public static void deleteCancelBtnProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0702-02", TestConfigPage.questionicon,
				"Accepted Value - Action - Delete Pop up Screen- Cancel button Properties");
	}
}
