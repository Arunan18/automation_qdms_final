//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action - Edit Pop up Screen "Procedure"  Text Box  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-395         11/07/2023    N.Karunya   Original Version                
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

public class Managetest_Action_Edit_Popup_Procedure_TextboxProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void procedureTextbox() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-395");

		// Checking Action Edit Popup Procedure Textbox UI Properties
		procedureTextboxProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void procedureTextboxProps() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-395-02",
				ManageTestsPage.proceduretextbox,
				"Manage Test - Action - Edit Popup - Procedure Textbox UI Properties");

	}

}
