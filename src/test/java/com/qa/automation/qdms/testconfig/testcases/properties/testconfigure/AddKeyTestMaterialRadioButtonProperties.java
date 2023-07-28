//***************************************************************************************
//* Description
//*------------
//*Test Configure - Configure Test Table-  Top Bar "Add Key Test" - "Material" - Radio Button Properties
//***************************************************************************************
//*
//* Author           : THAKSHILA
//* Date Written     : 14/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Name        Comments
//* ================       ====         =====        ========
//*  
//* TC-TCN-0714        14/07/2023    THAKSHILA    Modified Version                   
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AddKeyTestMaterialRadioButtonProperties extends DriverIntialization {

	@Test
	public static void addKeyTestRadioButtonProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0714");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			AddkeytestUIHeadingProperties.addKeyTest();
		}

		// ADD KEY TEST SUBCATEGORY RADIO ICON PROPERTIES
		addkeySubCategoryRadioIconProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ADD KEY TEST SUB CATEGORY RADIO ICON PROPERTIES
	public static void addkeySubCategoryRadioIconProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0714-02",
				TestConfigPage.materualRadioButton, "Material Radio Button properties");

	}

}
