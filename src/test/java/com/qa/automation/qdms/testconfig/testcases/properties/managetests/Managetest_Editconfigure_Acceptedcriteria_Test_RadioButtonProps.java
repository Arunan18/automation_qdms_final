//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Accepted criteria -"Test" Radio Button Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-369         07/07/2023    N.Karunya   Original Version                
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
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfigMethods;

public class Managetest_Editconfigure_Acceptedcriteria_Test_RadioButtonProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void testRadioButton() throws InterruptedException, IOException {

		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-369");
		
		if (NavigateManageTestFromLogin.clicked) {
            // CLICK THE ACCEPTED CRITERIA
            TestConfigMethods.clickButton(3);
		}

		Thread.sleep(500);

		// Checking Accepted criteria -"Test" Radio Button Properties
		testRadioButtonProperties();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void testRadioButtonProperties() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-369-02", ManageTestsPage.testRadioButton,
				"Manage Test - Accepted criteria - Test - Radio Button UI Properties");

	}

}
