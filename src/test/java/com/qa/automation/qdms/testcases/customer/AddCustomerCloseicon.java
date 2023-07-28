//***********************************************************************************
//* Description
//*------------
//* Add Customer Close Icon Functionality
//***********************************************************************************
//*
//* Author           : Sasikala Amabalavanar
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-CUS-0049           17/07/2023    Sasi      Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class AddCustomerCloseicon extends DriverIntialization {

	static CustomerPage customer = new CustomerPage();
	static boolean work = false;

	@Test
	public static void Closebutton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customer);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Login Functional
		LoginTest.Login();

		// Click Master Card
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.Master));
		if (LoginTest.login) {
			SourceTest.CommonMethod(CustomerPage.Master, "Master Card");
		}

		// Click Customer Top Menu
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customertopmenu, "Customer Top Menu Card");
		}

		// Customer Site Button
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customersitebutton, "Customer Site Bar Button");
		}

		// Add Customer Button
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.AddCustomerbtn, "Add Customer Button");
		}

		// Add Customer Screen Close Icon Button
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.closeicon));
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.closeicon, "Add Customer Screen Close Icon");
		}

		// Driver Refresh
		driver.navigate().refresh();

		// Logout Functional
		if (LoginTest.login) {
			Logout.LogoutFunction();
		}
	}
}
