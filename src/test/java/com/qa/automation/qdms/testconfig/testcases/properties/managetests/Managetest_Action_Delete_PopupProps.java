//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action -"Delete Icon" - Pop up Screen Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 10/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-402        10/07/2023    N.Karunya     Original Version                
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

public class Managetest_Action_Delete_PopupProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void deletePopup() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "delete", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-402");
	

		// Checking Action Delete Popup UI Properties
		deletePopupProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void deletePopupProps() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);

		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-402-02",
				ManageTestsPage.actionDeletepopup, "Manage Test - Action - Delete Popup UI Properties");

	}

}
