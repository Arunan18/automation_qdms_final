//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -"Close" Button Properties 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 04/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-316           04/07/2023    N.Karunya   Original Version                
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

public class Managetest_Additionalinformationpopup_ClosebuttonProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void additionalinformationPopupscreencloseButton() throws InterruptedException, IOException {

		// Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-316");

		// Check Additional Information Close Button UI Properties
		if (NavigateManageTestFromLogin.clicked) {

			closeButtonProperties();
		}

		// Refresh
		driver.navigate().refresh();

		// Logout
		Logout.LogoutFunction();

	}

	public static void closeButtonProperties() {

		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-316-02", ManageTestsPage.additonalinfopopupscreencloseButton,
				"Checking Additional Inormation Popup Screen Close Button UI Properties");

	}

}
