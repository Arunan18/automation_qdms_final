//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Configure Test-"Sub Category" Drop Down  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-359         12/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class Managetest_Editconfigure_Configuretest_SubCategory_DropdownProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void subCategoryDropdown() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-359");

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-359-01");

		// Fill the Data For Maincategory Dropdown
		fillDropdown();


		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void fillDropdown() throws InterruptedException {

		PageFactory.initElements(driver, mtp);

		ActionCommonMethod.dropdDown(ManageTestsPage.configuretestmaincategrydropdown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));
		
		subCategoryDropdownProps();

	}

	public static void subCategoryDropdownProps() throws InterruptedException {

		// Checking Manage Test- Configuration Tab- "Edit Configure"- Configure Test-"Sub Category" Dropdown Properties
		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);
		ProCommonMethods.dropDownMulti("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-359-02",
				ManageTestsPage.configuretestSubcategrydropdown,
				"Manage Test- Configuration Tab - Edit Configure Dropdown -Configure Test - Sub Category Dropdown Properties",
				"1", 2);

	}

}

