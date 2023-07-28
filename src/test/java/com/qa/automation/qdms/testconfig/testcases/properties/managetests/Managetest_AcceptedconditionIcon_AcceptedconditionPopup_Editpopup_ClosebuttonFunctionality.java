//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition -Add Condition - Action - Edit Pop up Screen - "Close" Button Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 06/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-340         06/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIcon_AcceptedconditionPopup_Editpopup_ClosebuttonFunctionality
		extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void editpopupCloseButton() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACCEPTED CONDITION ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-340");

		Thread.sleep(500);

		// Checking Action Edit Popup Close Button Functionality
		editIconClick(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void editIconClick(String Value1) {

		WebElement editicon = driver.findElement(By
				.xpath("//td[text()='" + Value1 + "']//following-sibling::td[1]//span[@class='anticon anticon-edit']"));

		try {

			editicon.click();
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");

			editpopupCloseButtonFunctionality();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Unable to Locate Edit Action icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void editpopupCloseButtonFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);

		try {
			if (ManageTestsPage.editConditionclosebutton.isDisplayed()) {
				testCase = extent.createTest("Add condition Action Edit Popup Screen Close Button is Displayed");
				testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Close Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.editConditionclosebutton.isEnabled()) {
					testCase = extent.createTest("Add condition Action Edit Popup Screen Close Button is Enabled");
					testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Close Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Add condition Action Edit Popup Screen Close Button is not Enabled");
					testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Close Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Add condition Action Edit Popup Screen Close Button is not Displayed");
				testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Close Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Add condition Action Edit Popup Screen Close Button");
			testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Close Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Add condition Action Edit Popup Screen Close Button");
			testCase.log(Status.INFO, "Unable to check the functionality of Add condition Action Edit Popup Screen Close Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}
