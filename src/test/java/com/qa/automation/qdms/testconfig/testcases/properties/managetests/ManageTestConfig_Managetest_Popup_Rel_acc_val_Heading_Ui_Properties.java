//*************************************************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- "Relevant To Accepted Criteria" Sub UI Heading Properties
//*************************************************************************************************************************
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 27/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0173         27/06/2023    Priyanka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfig_Managetest_Popup_Rel_acc_val_Heading_Ui_Properties extends DriverIntialization {

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testparPopuptRelAccValUiProperties() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);

		// COMMON METHOD FOR SEARCH AND CLICK

		AddGroupKey.actionS(0, 7, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-173-01", 2);

		// CHECKING TEST PARAMETER POPUP RELEVANT TO ACCEPTED VALUE HEADING PROPERTIES

		testparPopuptRelAcccValHeadingUiProperties();

		driver.navigate().refresh();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void testparPopuptRelAcccValHeadingUiProperties() {

		PageFactory.initElements(driver, managetest);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-173-02", ManageTestsPage.popuptablereltoaccvalueheading,
				"Manage Test - Test Parameter Pop up Relevant to Accepted Value Heading UI Properties");

	}

}
