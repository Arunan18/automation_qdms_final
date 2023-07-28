//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value - Action - Delete Pop up Screen- "Ok " button Properties  
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0701			22/06/2023    S.Gobithan   Original Version  
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

public class AcceptedvalueActionDeleteOkButtonProperties extends DriverIntialization {
	@Test
	public static void action() throws InterruptedException, IOException {
		AcceptedvalueActionDeleteIconProperties iconproperty = new AcceptedvalueActionDeleteIconProperties();
		PageFactory.initElements(driver, iconproperty);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0701");

		if (NavigateManageTestFromLogin.clicked) {
			// ACCEPTED CRITERIA
			AcceptedvalueActionDeleteIconProperties.acceptedCriteria();
		}

		// SELECT THE DELETE CONFIGURE DISPLAYED & ENABLED
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.managetexttablecontainer, "delete",
				"Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0701-01", 3);

		// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "OK " BUTTON PROPERTIES
		acceptedValueOkBtn();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "OK " BUTTON PROPERTIES
	public static void acceptedValueOkBtn() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0701-02", TestConfigPage.okbtn,
				"Accepted Value - Action - Delete Pop up Screen- Ok button Properties");
	}

}
