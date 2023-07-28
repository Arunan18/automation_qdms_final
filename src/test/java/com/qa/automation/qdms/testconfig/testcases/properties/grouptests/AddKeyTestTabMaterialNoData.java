/***********************************************************************************
//* Description
//*------------
//* Test - Manage Test Configure - "Add Key Test Tab" -Material Table No Data Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 13/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-136           13/07/2023   K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfigMethods;

public class AddKeyTestTabMaterialNoData extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	@Test
	public static void addKeyTestTabMaterialNoDataProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Group_Test", "MTC-GT-136");

		TestConfigMethods.navigate_TestConfigureTabs(5);

		//Calling the method
		addKeyTestTabMaterialPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void addKeyTestTabMaterialPropertiess() throws InterruptedException {	
		PageFactory.initElements(driver, GroupTestpg);

		Thread.sleep(2000);
		try {
			GroupTestsPage.materialtext.click();


			//Calling the method
			addKeyTestTabMaterialNoDataPropertiess();

		}
		catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Material Button");
			testCase.log(Status.INFO, "Unable to Locate Material Button");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Material Button");
			testCase.log(Status.INFO, "Material Button is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Material Button");
			testCase.log(Status.INFO, "Material Button Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void addKeyTestTabMaterialNoDataPropertiess() {	
		PageFactory.initElements(driver, GroupTestpg);

		//Check GroupTests Pagination Drop down Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-136-02", GroupTestsPage.materialnodataicon, "Add Key Test Tab Material Table No Data Properties");
	}
}
