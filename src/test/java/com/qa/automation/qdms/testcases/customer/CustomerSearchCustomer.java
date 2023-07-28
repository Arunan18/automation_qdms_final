//***********************************************************************************
//* Description
//*------------
//* TC-CUS-0015  Check Customer "Search" TextBox Functionality (Input)
//* TC-CUS-0017  Check Customer "Search" Button Functionality
//* TC-CUS-0019  Check Customer "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        30/03/2023   Sayan        Orginal Version
//* TC-CUS-0015            13/07/2023   Priyanka     Updated 
//* TC-CUS-0017            13/07/2023   Priyanka     Updated
//* TC-CUS-0019            13/07/2023   Priyanka     Updated
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class CustomerSearchCustomer extends DriverIntialization {

	static CustomerPage customer = new CustomerPage();

	@Test
	public static void function() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, customer);

			SingleSearch.singleSearchMethod(1, CustomerPage.SearchTextBox, "Master Module", "Customer", "TC-CUS-0015",
					1, 2);

		}

		Logout.LogoutFunction();

	}

}
