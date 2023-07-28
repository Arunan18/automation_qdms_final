//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action-"Edit"- Pop up Screen Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 10/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-376         10/07/2023    N.Karunya   Original Version                
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

public class Managetest_Action_Edit_PopupProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	

	@Test
	public static void editPopup() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-376");
		Thread.sleep(500);

		// Checking Action Edit Popup UI Properties
		editPopupProperties();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}


	public static void editPopupProperties() {

		PageFactory.initElements(driver, mtp);

		ProCommonMethods.modal("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-376-02",
				ManageTestsPage.actionEditpopup, "Manage Test - Action - Edit Popup UI Properties");

	}

}
