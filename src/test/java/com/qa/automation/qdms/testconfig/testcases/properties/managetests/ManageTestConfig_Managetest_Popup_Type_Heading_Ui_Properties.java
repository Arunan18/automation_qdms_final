//******************************************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- "Type" Sub UI Heading Properties
//******************************************************************************************************************
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 27/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0167           27/06/2023    Priyanka       Original Version
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

public class ManageTestConfig_Managetest_Popup_Type_Heading_Ui_Properties extends DriverIntialization {

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testparPopuptAbbrivationUiProperties() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);

		// COMMON METHOD FOR SEARCH AND CLICK

		AddGroupKey.actionS(0, 7, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-167-01", 2);

		// CHECKING TEST PARAMETER POPUP TYPE HEADING PROPERTIES

		testparPopuptTypeHeadingUiProperties();

		driver.navigate().refresh();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void testparPopuptTypeHeadingUiProperties() {

		PageFactory.initElements(driver, managetest);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-167-02", ManageTestsPage.popuptabletypeheading,
				"Manage Test - Test Parameter Pop up Type Heading UI Properties");

	}

}