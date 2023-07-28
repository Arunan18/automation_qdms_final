/***********************************************************************************
//* Description
//*------------
//* Manage Test Configure - Manage Test - "Accepted Condition Table" No Data Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 13/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-134           13/07/2023   K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedConditionTableNoDataProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	@Test
	public static void acceptedConditionTableNoDataProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11, "Description", "Test Configuration Properties","Group_Test", "MTC-GT-134");

		//Calling the method
		acceptedConditionTableNoData();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void acceptedConditionTableNoData() {	
		PageFactory.initElements(driver, GroupTestpg);

		//Check GroupTests Pagination Drop down Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-134-02", GroupTestsPage.acceptedConditionTable, "Accepted Condition Table No Data Properties");
	}
}



