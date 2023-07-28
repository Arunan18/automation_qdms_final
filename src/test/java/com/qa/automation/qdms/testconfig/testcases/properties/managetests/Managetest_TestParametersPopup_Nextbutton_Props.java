//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- Pagination next button Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 17/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-182         17/07/2023    N.Karunya   Original Version                
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

public class Managetest_TestParametersPopup_Nextbutton_Props extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void actionDeletePopupNextbutton() throws InterruptedException, IOException {

		// MANAGE TEST - TEST PARAMETERS ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 7, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-182");

		Thread.sleep(1000);

		// Check Test Parameters Popup Screen Action Delete Popup Pagination Next button Properties
		actionDeletePopupNextbuttonProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	
	public static void actionDeletePopupNextbuttonProps() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-182-02", ManageTestsPage.testParametersdeletepopupNextlBtn,
				"Test Parameters - Action -Delete Icon -Popup Pagination Next button Properties");

	}

}
