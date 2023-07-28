//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Configure Test-"Material" Drop Down  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-360         13/07/2023    N.Karunya   Original Version                
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

public class Managetest_Editconfigure_Configuretest_Material_DropdownProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void materialDropdown() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-360");

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-360-01");

		// Fill the Data For Maincategory Dropdown
		fillmainCategorydropdown();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void fillmainCategorydropdown() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);

		ActionCommonMethod.dropdDown(ManageTestsPage.configuretestmaincategrydropdown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		fillsubCategorydropdown();

	}

	public static void fillsubCategorydropdown() throws InterruptedException {

		// Fill the Data For Subcategory Dropdown
		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);
		ActionCommonMethod.dropdDown(ManageTestsPage.configuretestSubcategrydropdown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(2));

		materialDropdownProps();

	}

	public static void materialDropdownProps() throws InterruptedException {

		// Checking Manage Test- Configuration Tab- "Edit Configure"- Configure
		// Test-"Material" Dropdown Properties
		PageFactory.initElements(driver, mtp);
		Thread.sleep(3000);
		ProCommonMethods.dropDownMulti("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-360-02",
				ManageTestsPage.configuretestMaterialdropdown,
				"Manage Test- Configuration Tab - Edit Configure Dropdown -Configure Test - Material Dropdown Properties",
				"2", 3);

	}

}
