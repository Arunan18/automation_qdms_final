//*************************************************************************************************
//* Description
//*------------
//* Add Customer Pop up cancle Button Functionality 
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-CUS-0074          26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddCustomerCancleButtonFunctionality extends DriverIntialization {

	static CustomerPage customerpage = new CustomerPage();
	static boolean addbutton = false;

	@Test
	public static void addCancleButton() {

		PageFactory.initElements(driver, customerpage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateCustomer();

		}

		if (MasterMainNavigationsTest.clickCustomer) {

			try {
				CustomerPage.AddCustomerbtn.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Customer' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Customer' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Customer' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Customer' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Customer' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(CustomerPage.cancelButton, CustomerPage.editpopup,
					"ADD CUSTOMER CANCLE BUTTON", "ADD CUSTOMER POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
