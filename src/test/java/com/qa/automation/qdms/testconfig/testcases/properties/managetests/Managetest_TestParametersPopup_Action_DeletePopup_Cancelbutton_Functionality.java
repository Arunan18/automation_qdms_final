//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- Action - Delete Pop up Screen  "Cancel" button Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 17/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-181         17/07/2023    N.Karunya   Original Version                
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

public class Managetest_TestParametersPopup_Action_DeletePopup_Cancelbutton_Functionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void actionDeletePopupCancelbuttonFunction() throws InterruptedException, IOException {

		// MANAGE TEST - TEST PARAMETERS ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 7, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-181");

		Thread.sleep(1000);

		// Check Test Parameters Popup Screen Action Delete Popup Cancel button Functionality
		deleteIcon(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void deleteIcon(String Value1) {

		WebElement deleteicon = driver.findElement(By.xpath(
				"//td[text()='" + Value1 + "']//following-sibling::td[9]//span[@class='anticon anticon-delete']"));

		try {

			Thread.sleep(1000);
			deleteicon.click();
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");

			actionDeletePopupCancelbuttonFunctionality();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Unable to Locate Delete Action icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void actionDeletePopupCancelbuttonFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);

		try {
			if (ManageTestsPage.testParametersdeletepopupCancelBtn.isDisplayed()) {
				testCase = extent.createTest("Test Parameters Action Edit Popup Cancel Button is Displayed");
				testCase.log(Status.INFO, "Test Parameters Action Edit Popup Cancel Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.testParametersdeletepopupCancelBtn.isEnabled()) {
					testCase = extent.createTest("Test Parameters Action Edit Popup Cancel Button is Enabled");
					testCase.log(Status.INFO, "Test Parameters Action Edit Popup Cancel Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Test Parameters Action Edit Popup Cancel Button is not Enabled");
					testCase.log(Status.INFO, "Test Parameters Action Edit Popup Cancel Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Test Parameters Action Edit Popup Cancel Button is not Displayed");
				testCase.log(Status.INFO, "Test Parameters Action Edit Popup Cancel Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Test Parameters Action Edit Popup Cancel Button");
			testCase.log(Status.INFO, "Test Parameters Action Edit Popup Cancel Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Test Parameters Action Edit Popup Cancel Button");
			testCase.log(Status.INFO, "Unable to check the functionality of Test Parameters Action Edit Popup Cancel Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
