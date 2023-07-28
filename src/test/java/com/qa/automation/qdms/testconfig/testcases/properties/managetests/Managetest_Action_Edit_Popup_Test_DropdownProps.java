//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action - Edit Pop up Screen "Test" Drop Down  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 10/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-379         10/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_Action_Edit_Popup_Test_DropdownProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void testDropdown() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-379");

		Thread.sleep(1000);

		// Checking Action Edit Popup Test Dropdown UI Properties
		testDropdownProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	
	public static void testDropdownProps() throws InterruptedException {
		
		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-379-02", 
				ManageTestsPage.testDropdown, "Manage Test - Action - Edit Popup - Test Dropdown UI Properties");
		
	}

}
